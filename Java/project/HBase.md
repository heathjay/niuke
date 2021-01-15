http://www.nosqlnotes.com/technotes/hbase/hbase-overview-concepts/


Apache HBase™ is the Hadoop database, a distributed, scalable, big data store.
Apache HBase是基于Hadoop构建的一个分布式的、可伸缩的海量数据存储系统。



        HBase meta Region在哪里提供服务？

        HBase是否可以保证单行操作的原子性？

        Region中写WAL与写MemStore的顺序是怎样的？

        你是否遇到过Region长时间处于RIT的状态？ 你认为旧版本中Assignment Manager的主要问题是什么？

        在面对Full GC问题时，你尝试做过哪些优化？

        你是否深究过HBase Compaction带来的“写放大”有多严重？

        HBase的RPC框架存在什么问题？

        导致查询时延毛刺的原因有哪些？

# 数据模型
## RowKey

用来表示唯一一行记录的主键，HBase的数据是按照RowKey的字典顺序进行全局排序的，所有的查询都只能依赖于这一个排序维度。

## 稀疏矩阵
每一行中，列的组成都是灵活的，行与行之间并不需要遵循相同的列定义， 也就是HBase数据表”schema-less“的特点。

## Region
HBase中采用了”Range分区”，将Key的完整区间切割成一个个的”Key Range” ，每一个”Key Range”称之为一个Region。
Region是HBase中负载均衡的基本单元，当一个Region增长到一定大小以后，会自动分裂成两个。

## Column Family

如果将Region看成是一个表的横向切割，那么，一个Region中的数据列的纵向切割，称之为一个Column Family。每一个列，都必须归属于一个Column Family，这个归属关系是在写数据时指定的，而不是建表时预先定义。

## KeyValue
每一行中的每一列数据，都被包装成独立的拥有特定结构的KeyValue，KeyValue中包含了丰富的自我描述信息
看的出来，KeyValue是支撑”稀疏矩阵”设计的一个关键点：一些Key相同的任意数量的独立KeyValue就可以构成一行数据。但这种设计带来的一个显而易见的缺点：每一个KeyValue所携带的自我描述信息，会带来显著的数据膨胀。

# 适用场景
数据按照RowKey排序存放，适合HBase存储的数据，可以简单总结如下
## 以实体为中心的数据
实体可以包括但不限于如下几种：

    自然人／账户／手机号／车辆相关数据

    用户画像数据（含标签类数据）

    图数据（关系类数据）

描述这些实体的，可以有基础属性信息、实体关系(图数据)、所发生的事件(如交易记录、车辆轨迹点)等等。
## 以事件为中心的数据
上面所描述的这些数据，有的是结构化数据，有的是半结构化或非结构化数据。HBase的“稀疏矩阵”设计，使其应对非结构化数据存储时能够得心应手，但在我们的实际用户场景中，结构化数据存储依然占据了比较重的比例。由于HBase仅提供了基于RowKey的单维度索引能力，在应对一些具体的场景时，依然还需要基于HBase之上构建一些专业的能力，如：



    OpenTSDB 时序数据存储，提供基于Metrics+时间+标签的一些组合维度查询与聚合能力

    GeoMesa 时空数据存储，提供基于时间+空间范围的索引能力

    JanusGraph 图数据存储，提供基于属性、关系的图索引能力

HBase擅长于存储结构简单的海量数据但索引能力有限，而Oracle等传统关系型数据库(RDBMS)能够提供丰富的查询能力，但却疲于应对TB级别的海量数据存储，HBase对传统的RDBMS并不是取代关系，而是一种补充。


# HBase与HDFS
HBase的数据是存储于HDFS里面的，相信大家也都有这么的认知：
HBase是一个分布式数据库，HDFS是一个分布式文件系统



    HBase中的数据为何不直接存放于HDFS之上？

HBase中存储的海量数据记录，通常在几百Bytes到KB级别，如果将这些数据直接存储于HDFS之上，会导致大量的小文件产生，为HDFS的元数据管理节点(NameNode)带来沉重的压力。



    文件能否直接存储于HBase里面？

如果是几MB的文件，其实也可以直接存储于HBase里面，我们暂且将这类文件称之为小文件，HBase提供了一个名为MOB的特性来应对这类小文件的存储。但如果是更大的文件，强烈不建议用HBase来存储，关于这里更多的原因，希望你在详细读完本文所有内容之后能够自己解答。


# 集群角色

## ZooKeeper
利用ZooKeeper就可以非常简单的实现这类”仲裁”需求，ZooKeeper还提供了基础的事件通知机制，所有的数据都以 ZNode的形式存在，它也称得上是一个”微型数据库”。
## NameNode
HDFS作为一个分布式文件系统，自然需要文件目录树的元数据信息，另外，在HDFS中每一个文件都是按照Block存储的，文件与Block的关联也通过元数据信息来描述。NameNode提供了这些元数据信息的存储。

## DataNode
HDFS的数据存放节点。
## RegionServer
HBase的数据服务节点。
## Master


负责管理所有的RegionServer

建表/修改表/删除表等DDL操作请求的服务端执行主体

管理所有的数据分片(Region)到RegionServer的分配

如果一个RegionServer宕机或进程故障，由Master负责将它原来所负责的Regions转移到其它的RegionServer上继续提供服务

Master自身也可以作为一个RegionServer提供服务，该能力是可配置的
# 集群部署建议
## RegionServer与DataNode联合部署，RegionServer与DataNode按1:1比例设置。
这种部署的优势在于，RegionServer中的数据文件可以存储一个副本于本机的DataNode节点中，从而在读取时可以利用HDFS中的”短路径读取(Short Circuit)“来绕过网络请求，降低读取时延。
## 管理节点独立于数据节点部署
如果是基于物理机部署，每一台物理机节点上可以设置几个RegionServers/DataNodes来提升资源使用率。
也可以选择基于容器来部署，如在HBaseCon Asia 2017大会知乎的演讲主题中，就提到了知乎基于Kubernetes部署HBase服务的实践。
对于公有云HBase服务而言，为了降低总体拥有成本(TCO)，通常选择”计算与存储物理分离“的方式，从架构上来说，可能导致平均时延略有下降，但可以借助于共享存储底层的IO优化来做一些”弥补”。
HBase集群中的RegionServers可以按逻辑划分为多个Groups，一个表可以与一个指定的Group绑定，可以将RegionServer Group理解成将一个大的集群划分成了多个逻辑子集群，借此可以实现多租户间的隔离，这就是HBase中的RegionServer Group特性。


# 写数据之前：建立连接
## Login
在启用了安全特性的前提下，Login阶段是为了完成用户认证(确定用户的合法身份)，这是后续一切安全访问控制的基础。当前Hadoop/HBase仅支持基于Kerberos的用户认证，ZooKeeper除了Kerberos认证，还能支持简单的用户名/密码认证，但都基于静态的配置，无法动态新增用户。如果要支持其它第三方认证，需要对现有的安全框架做出比较大的改动。

## 创建Connection
Connection可以理解为一个HBase集群连接的抽象，建议使用ConnectionFactory提供的工具方法来创建。因为HBase当前提供了两种连接模式：同步连接，异步连接，这两种连接模式下所创建的Connection也是不同的。我们给出ConnectionFactory中关于获取这两种连接的典型方法定义：
    CompletableFuture<AsyncConnection> createAsyncConnection(Configuration conf,
                    User user);
    ​
    Connection createConnection(Configuration conf, ExecutorService pool, User user)
        throws IOException;
Connection中主要维护着两类共享的资源：

线程池

Socket连接

这些资源都是在真正使用的时候才会被创建，因此，此时的连接还只是一个”虚拟连接”。
## 写数据之前：创建数据表
### DDL操作的抽象接口 – Admin

    Admin定义了常规的DDL接口，列举几个典型的接口：

    void createNamespace(final NamespaceDescriptor descriptor) throws IOException;
    ​
    void createTable(final HTableDescriptor desc, byte[][] splitKeys) throws IOException;
    ​
    TableName[] listTableNames() throws IOException;
###  预设合理的数据分片 – Region

分片数量会给读写吞吐量带来直接的影响，因此，建表时通常建议由用户主动指定划分Region分割点，来设定Region的数量。
HBase中数据是按照RowKey的字典顺序排列的，为了能够划分出合理的Region分割点，需要依据如下几点信息：
    Key的组成结构
    Key的数据分布预估-如果不能基于Key的组成结构来预估数据分布的话，可能会导致数据在Region间的分布不均匀
    读写并发度需求- 依据读写并发度需求，设置合理的Region数量

## 为表定义合理的Schema
既然HBase号称”schema-less”的数据存储系统，那何来的是schema? 的确，在数据库范式的支持上，HBase非常弱，这里的Schema，主要指如下一些信息的设置：
NameSpace设置
Column Family的数量
每一个Column Family中所关联的一些关键配置：
        Compression
            HBase当前可以支持Snappy，GZ，LZO，LZ4，Bzip2以及ZSTD压缩算法
        DataBlock Encoding
            HBase针对自身的特殊数据模型所做的一种压缩编码
        BloomFilter
            可用来协助快速判断一条记录是否存在
        TTL
            指定数据的过期时间
        StoragePolicy
            指定Column Family的存储策略，可选配置有：
            “ALL_SSD”，”ONE_SSD”，”HOT”，”WARM”，”COLD”，”LAZY_PERSIST”
    HBase中并不需要预先设置Column定义信息，这就是HBase schema-less设计的核心。
## Client发送建表请求到Master
    建表的请求是通过RPC的方式由Client发送到Master:
        RPC接口基于Protocol Buffer定义
        建表相关的描述参数，也由Protocol Buffer进行定义及序列化
    Client端侧调用了Master服务的什么接口，参数是什么，这些信息都被通过RPC通信传输到Master侧，Master再依据这些接口\参数描述信息决定要执行的操作。2.0版本中，HBase目前已经支持基于Netty的异步RPC框架。
Master侧接收到Client侧的建表请求以后，一些主要操作包括：
    生成每一个Region的描述信息对象HRegionInfo，这些描述信息包括：Region ID, Region名称，Key范围，表名称等信息
    生成每一个Region在HDFS中的文件目录
    将HRegionInfo信息写入到记录元数据的hbase:meta表中。meta表位于名为”hbase”的namespace中，因此，它的全称为”hbase:meta”。整个过程中，新表的状态也是记录在hbase:meta表中的，而不用再存储在ZooKeeper中。
如果建表执行了一半，Master进程挂掉了，如何处理？这里是由HBase自身提供的一个名为Procedure(V2)的框架来保障操作的事务性的，备Master接管服务以后，将会继续完成整个建表操作。

一个被创建成功的表，还可以被执行如下操作：
    Disable 将所有的Region下线，该表暂停读写服务
    Enable 将一个Disable过的表重新Enable，也就是上线所有的Region来正常提供读写服务
    Alter 更改表或列族的描述信息

# Master分配Regions到各个RegionServers
新创建的所有的Regions，通过AssignmentManager将这些Region按照轮询(Round-Robin)的方式分配到每一个RegionServer中，具体的分配计划是由LoadBalancer来提供的。
AssignmentManager负责所有Regions的分配/迁移操作，Master中有一个定时运行的线程，来检查集群中的Regions在各个RegionServer之间的负载是否是均衡的，如果不均衡，则通过LoadBalancer生成相应的Region迁移计划，HBase中支持多种负载均衡算法，有最简单的仅考虑各RegionServer上的Regions数目的负载均衡算法，有基于迁移代价的负载均衡算法，也有数据本地化率优先的负载均衡算法，因为这一部分已经提供了插件化机制，用户也可以自定义负载均衡算法。


# 写数据
# 可选接口
    Java Client API 
        HBase的基础API，应用最为广泛。
    HBase Shell
        基于Shell的命令行操作接口，基于Java Client API实现。
    Restful API
        Rest Server侧基于Java Client API实现。
    Thrift API
        Thrift Server侧基于Java Client API实现。
    MapReduce Based Batch Manipulation API
        基于MapReduce的批量数据读写API。
    除了上述主要的API，HBase还提供了基于Spark的批量操作接口以及C++ Client接口，但这两个特性都被规划在了3.0版本中，当前尚在开发中。

# 关于表服务接口的抽象
    同步连接与异步连接，分别提供了不同的表服务接口抽象：
    Table 同步连接中的表服务接口定义
    AsyncTable 异步连接中的表服务接口定义
异步连接AsyncConnection获取AsyncTable实例的接口默认实现：
default AsyncTable<AdvancedScanResultConsumer> getTable(TableName tableName) {
    return getTableBuilder(tableName).build();
}
同步连接ClusterConnection的实现类ConnectionImplementation中获取Table实例的接口实现：
@Override
public Table getTable(TableName tableName) throws IOException {
    return getTable(tableName, getBatchPool());
}

# 写数据的几种方式
Single Put
    单条记录单条记录的随机put操作。Single Put所对应的接口定义如下：
    在AsyncTable接口中的定义：
        CompletableFuture<Void> put(Put put);
    在Table接口中的定义：
        void put(Put put) throws IOException;
Batch Put
    汇聚了几十条甚至是几百上千条记录之后的小批次随机put操作。
    Batch Put只是本文对该类型操作的称法，实际的接口名称如下所示：
    在AsyncTable接口中的定义：
        List<CompletableFuture<Void>> put(List<Put> puts);
    在Table接口中的定义：
        void put(List<Put> puts) throws IOException;
Bulkload
    基于MapReduce API提供的数据批量导入能力，导入数据量通常在GB级别以上，Bulkload能够绕过Java Client API直接生成HBase的底层数据文件(HFile)。

## 构建Put对象
### 设计合理的RowKey
RowKey通常是一个或若干个字段的直接组合或经一定处理后的信息，因为一个表中所有的数据都是基于RowKey排序的，RowKey的设计对读写都会有直接的性能影响。
RowKey Format 1： Mobile1 + StartTime
    为了方便读者理解，我们在两个字段之间添加了连接符”^”。
RowKey Format 2： StartTime + Mobile1
从上面两个表格可以看出来，不同的字段组合顺序设计，带来截然不同的排序结果，我们将RowKey中的第一个字段称之为“先导字段”。第一种设计，有利于查询”手机号码XXX的在某时间范围内的数据记录”，但不利于查询”某段时间范围内有哪些手机号码拨出了电话？”，而第二种设计却恰好相反。
上面是两种设计都是两个字段的直接组合，这种设计在实际应用中，会带来读写热点问题，难以保障数据读写请求在所有Regions之间的负载均衡。

### Reversing
如果先导字段本身会带来热点问题，但该字段尾部的信息却具备良好的随机性，此时，可以考虑将先导字段做反转处理，将尾部几位直接提前到前面，或者直接将整个字段完全反转。
将先导字段Mobile1翻转后，就具备非常好的随机性。
将先导字段Mobile1反转后的RowKey变为：13400001111^201803010800  - > 11110000431^201803010800
### Salting
Salting的原理是在RowKey的前面添加固定长度的随机Bytes，随机Bytes能保障数据在所有Regions间的负载均衡。
Salting能很好的保障写入时将数据均匀分散到各个Region中，但对于读取却是不友好的，例如，如果读取Mobile1为”13400001111″在20180301这一天的数据记录时，因为Salting Bytes信息是随机选择添加的，查询时并不知道前面添加的Salting Bytes是”A”，因此{“A”, “B”, “C”}所关联的Regions都得去查看一下。
### Hashing
Hashing是将一个RowKey通过一个Hash函数生成一组固定长度的bytes，Hash函数能保障所生成的随机bytes具备良好的离散度，从而也能够均匀打散到各个Region中。Hashing既有利于随机写入，又利于基于知道RowKey各字段的确切信息之后的随机读取操作，但如果是基于RowKey范围的Scan或者是RowKey的模糊信息进行查询的话，就会带来显著的性能问题，因为原来在字典顺序相邻的RowKey列表，通过Hashing打散后导致这些数据被分散到了多个Region中。

RowKey的设计，需要充分考虑业务的读写特点。
    本文内容假设RowKey设计：reversing(Mobile1) +StartTime
    RowKey应该为： 66660000431^201803011300
因为创建表时预设的Region与RowKey强相关，我们现在才可以给出本文样例所需要创建的表的”Region分割点“信息：
    假设，Region分割点为“1,2,3,4,5,6,7,8,9”，基于这9个分割点，可以预先创建10个Region，这10个Region的StartKey和StopKey如下所示：
## 定义列
每一个列在HBase中体现为一个KeyValue，而每一个KeyValue拥有特定的组成结构，
所谓的定义列，就是需要定义出每一个列要存放的列族(Column Family)以及列标识(Qualifier)信息。
存放样例数据的这个表名称为”TelRecords” ，为了简单起见，仅仅设置了1个名为”I”的列族。
因为Mobile1与StartTime都已经被包含在RowKey中，所以，不需要再在列中存储一份。关于列族名称与列标识名称，建议应该简短一些，因为这些信息都会被包含在KeyValue里面，过长的名称会导致数据膨胀。
基于RowKey和列定义信息，就可以组建HBase的Put对象，一个Put对象用来描述待写入的一行数据，一个Put可以理解成与某个RowKey关联的1个或多个KeyValue的集合。

## 数据路由
### 初始化ZooKeeper Session
因为meta Region的路由信息存放于ZooKeeper中，在第一次从ZooKeeper中读取META Region的地址时，需要先初始化一个ZooKeeper Session。ZooKeeper Session是ZooKeeper Client与ZooKeeper Server端所建立的一个会话，通过心跳机制保持长连接。
### 获取Region路由信息
    通过前面建立的连接，从ZooKeeper中读取meta Region所在的RegionServer，这个读取流程，当前已经是异步的。获取了meta Region的路由信息以后，再从meta Region中定位要读写的RowKey所关联的Region信息。如下图所示：

    因为每一个用户表Region都是一个RowKey Range，meta Region中记录了每一个用户表Region的路由以及状态信息，以RegionName(包含表名，Region StartKey，Region ID，副本ID等信息)作为RowKey。基于一条用户数据RowKey，快速查询该RowKey所属的Region的方法其实很简单：只需要基于表名以及该用户数据RowKey，构建一个虚拟的Region Key，然后通过Reverse Scan的方式，读到的第一条Region记录就是该数据所关联的Region。如下图所示：


    Region只要不被迁移，那么获取的该Region的路由信息就是一直有效的，因此，HBase Client有一个Cache机制来缓存Region的路由信息，避免每次读写都要去访问ZooKeeper或者meta Region。

        进阶内容1：meta Region究竟在哪里？

    meta Region的路由信息存放在ZooKeeper中，但meta Region究竟在哪个RegionServer中提供读写服务？

    在1.0版本中，引入了一个新特性，使得Master可以”兼任”一个RegionServer角色(可参考HBASE-5487, HBASE-10569)，从而可以将一些系统表的Region分配到Master的这个RegionServer中，这种设计的初衷是为了简化/优化Region Assign的流程，但这依然带来了一系列复杂的问题，尤其是Master初始化和RegionServer初始化之间的Race，因此，在2.0版本中将这个特性暂时关闭了。详细信息可以参考：HBASE-16367，HBASE-18511，HBASE-19694，HBASE-19785，HBASE-19828


### 客户端侧的数据分组“打包”
如果这条待写入的数据采用的是Single Put的方式，那么，该步骤可以略过（事实上，单条Put操作的流程相对简单，就是先定位该RowKey所对应的Region以及RegionServer信息后，Client直接发送写请求到RegionServer侧即可）。
但如果这条数据被混杂在其它的数据列表中，采用Batch Put的方式，那么，客户端在将所有的数据写到对应的RegionServer之前，会先分组”打包”，流程如下：
1. 按Region分组：遍历每一条数据的RowKey，然后，依据meta表中记录的Region信息，确定每一条数据所属的Region。此步骤可以获取到Region到RowKey列表的映射关系。
2. 按RegionServer”打包”：因为Region一定归属于某一个RegionServer（注：本文内容中如无特殊说明，都未考虑Region Replica特性），那属于同一个RegionServer的多个Regions的写入请求，被打包成一个MultiAction对象，这样可以一并发送到每一个RegionServer中。

### Client发送写数据请求到RegionServer
类似于Client发送建表到Master的流程，Client发送写数据请求到RegionServer，也是通过RPC的方式。只是，Client到Master以及Client到RegionServer，采用了不同的RPC服务接口。
single put请求与batch put请求，两者所调用的RPC服务接口方法是不同的，如下是Client.proto中的定义：
    service ClientService {
        // single Put请求所涉及的RPC服务接口方法
        rpc Mutate(MutateRequest)
            returns(MutateResponse);
        ​
        // batch put请求所涉及的RPC服务接口方法
        rpc Multi(MultiRequest)
            returns(MultiResponse);
        }

# 安全访问控制
如何保障UserA只能写数据到UserA的表中，以及禁止UserA改写其它User的表的数据，HBase提供了ACL机制。ACL通常需要与Kerberos认证配合一起使用，Kerberos能够确保一个用户的合法性，而ACL确保该用户仅能执行权限范围内的操作。
权限：
    READ
    WRITE
    EXEC
    CREATE
    ADMIN
可以为一个用户/用户组定义整库级别的权限集合，也可以定义Namespace、表、列族甚至是列级别的权限集合。
## RegionServer端处理：Region分发
RegionServer的RPC Server侧，接收到来自Client端的RPC请求以后，将该请求交给Handler线程处理。
如果是single put，则该步骤比较简单，因为在发送过来的请求参数MutateRequest中，已经携带了这条记录所关联的Region，那么直接将该请求转发给对应的Region即可。
如果是batch puts，则接收到的请求参数为MultiRequest，在MultiRequest中，混合了这个RegionServer所持有的多个Region的写入请求，每一个Region的写入请求都被包装成了一个RegionAction对象。RegionServer接收到MultiRequest请求以后，遍历所有的RegionAction，而后写入到每一个Region中，此过程是串行的

# Region内部处理：写WAL
HBase也采用了LSM-Tree的架构设计：LSM-Tree利用了传统机械硬盘的“顺序读写速度远高于随机读写速度”的特点。随机写入的数据，如果直接去改写每一个Region上的数据文件，那么吞吐量是非常差的。因此，每一个Region中随机写入的数据，都暂时先缓存在内存中(HBase中存放这部分内存数据的模块称之为MemStore，这里仅仅引出概念，下一章节详细介绍)，为了保障数据可靠性，将这些随机写入的数据顺序写入到一个称之为WAL(Write-Ahead-Log)的日志文件中，WAL中的数据按时间顺序组织
如果位于内存中的数据尚未持久化，而且突然遇到了机器断电，只需要将WAL中的数据回放到Region中即可:
在HBase中，默认一个RegionServer只有一个可写的WAL文件。WAL中写入的记录，以Entry为基本单元，而一个Entry中，包含：
    WALKey 包含{Encoded Region Name，Table Name，Sequence ID，Timestamp}等关键信息，其中，Sequence ID在维持数据一致性方面起到了关键作用，可以理解为一个事务ID。
    WALEdit WALEdit中直接保存待写入数据的所有的KeyValues，而这些KeyValues可能来自一个Region中的多行数据。
也就是说，通常，一个Region中的一个batch put请求，会被组装成一个Entry，写入到WAL中：
将Entry写到文件中时是支持压缩的，但该特性默认未开启。

## WAL进阶内容
### WAL Roll and Archive
当正在写的WAL文件达到一定大小以后，会创建一个新的WAL文件，上一个WAL文件依然需要被保留，因为这个WAL文件中所关联的Region中的数据，尚未被持久化存储，因此，该WAL可能会被用来回放数据。
如果一个WAL中所关联的所有的Region中的数据，都已经被持久化存储了，那么，这个WAL文件会被暂时归档到另外一个目录中：
注意，这里不是直接将WAL文件删除掉，这是一种稳妥且合理的做法，原因如下：
    避免因为逻辑实现上的问题导致WAL被误删，暂时归档到另外一个目录，为错误发现预留了一定的时间窗口
    按时间维度组织的WAL数据文件还可以被用于其它用途，如增量备份，跨集群容灾等等，因此，这些WAL文件通常不允许直接被删除，至于何时可以被清理，还需要额外的控制逻辑
另外，如果对写入HBase中的数据的可靠性要求不高，那么，HBase允许通过配置跳过写WAL操作。
### 利用Disruptor提升写并发性能
    在高并发随机写入场景下，会带来大量的WAL Sync操作，HBase中采用了Disruptor的RingBuffer来减少竞争，思路是这样：如果将瞬间并发写入WAL中的数据，合并执行Sync操作，可以有效降低Sync操作的次数，来提升写吞吐量。
### Multi-WAL
    默认情形下，一个RegionServer只有一个被写入的WAL Writer，尽管WAL Writer依靠顺序写提升写吞吐量，在基于普通机械硬盘的配置下，此时只能有单块盘发挥作用，其它盘的IOPS能力并没有被充分利用起来，这是Multi-WAL设计的初衷。Multi-WAL可以在一个RegionServer中同时启动几个WAL Writer，可按照一定的策略，将一个Region与其中某一个WAL Writer绑定，这样可以充分发挥多块盘的性能优势。
#### 关于WAL的未来
    WAL是基于机械硬盘的IO模型设计的，而对于新兴的非易失性介质，如3D XPoint，WAL未来可能会失去存在的意义，关于这部分内容，请参考文章《从HBase中移除WAL？3D XPoint技术带来的变革》。
## Region内部处理：写MemStore
每一个Column Family，在Region内部被抽象为了一个HStore对象，而每一个HStore拥有自身的MemStore，用来缓存一批最近被随机写入的数据，这是LSM-Tree核心设计的一部分。
MemStore中用来存放所有的KeyValue的数据结构，称之为CellSet，而CellSet的核心是一个ConcurrentSkipListMap，我们知道，ConcurrentSkipListMap是Java的跳表实现，数据按照Key值有序存放，而且在高并发写入时，性能远高于ConcurrentHashMap。
因此，写MemStore的过程，事实上是将batch put提交过来的所有的KeyValue列表，写入到MemStore的以ConcurrentSkipListMap为组成核心的CellSet中：
MemStore因为涉及到大量的随机写入操作，会带来大量Java小对象的创建与消亡，会导致大量的内存碎片，给GC带来比较重的压力，HBase为了优化这里的机制，借鉴了操作系统的内存分页的技术，增加了一个名为MSLab的特性，通过分配一些固定大小的Chunk，来存储MemStore中的数据，这样可以有效减少内存碎片问题，降低GC的压力。当然，ConcurrentSkipListMap本身也会创建大量的对象，这里也有很大的优化空间，去年阿里的一篇文章透露了阿里如何通过优化ConcurrentSkipListMap的结构来有效减少GC时间。
    进阶内容3：关于行级别的ACID

    在之前的版本中，行级别的任何并发写入/更新都是互斥的，由一个行锁控制。但在2.0版本中，这一点行为发生了变化，多个线程可以同时更新一行数据，这里的考虑点为：

        如果多个线程写入同一行的不同列族，是不需要互斥的

        多个线程写同一行的相同列族，也不需要互斥，即使是写相同的列，也完全可以通过HBase的MVCC机制来控制数据的一致性

        当然，CAS操作(如checkAndPut)或increment操作，依然需要独占的行锁

    更多详细信息，可以参考HBASE-12751。