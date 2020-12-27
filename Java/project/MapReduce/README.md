最详细的 Hadoop 入门教程

第二部分：Hadoop本地模式安装

Hadoop 本地模式只是用于本地开发调试，或者快速安装体验 Hadoop，这部分做简单的介绍。
第三部分：Hadoop伪分布式模式安装

学习 Hadoop 一般是在伪分布式模式下进行。这种模式是在一台机器上各个进程上运行 Hadoop 的各个模块，伪分布式的意思是虽然各个模块是在各个进程上分开运行的，但是只是运行在一个操作系统上的，并不是真正的分布式。

第四部分：完全分布式安装

完全分布式模式才是生产环境采用的模式，Hadoop 运行在服务器集群上，生产环境一般都会做HA，以实现高可用。

Hadoop 部署模式有：本地模式、伪分布模式、完全分布式模式、HA完全分布式模式。

区分的依据是 NameNode、DataNode、ResourceManager、NodeManager等模块运行在几个JVM进程、几个机器。

模式名称 	各个模块占用的JVM进程数 	各个模块运行在几个机器数上
本地模式 	    1个 	1个
伪分布式模式 	N个 	1个
完全分布式模式 	N个 	N个
HA完全分布式 	N个 	N个



链接：https://www.nowcoder.com/questionTerminal/4403a2c92e5641649671e2394056da33
来源：牛客网

Hadoop的shuffle过程：
    Hadoop的shuffle分为map端和reduce端的shuffle。map端的shuffle：
     map对输入的数据进行处理之后生成的输出数据首先存储在环形缓存区中，当容量达到了设定的阈值后，向磁盘溢出即spill，在向磁盘溢出之前，先对输出数据按key进行分区，分区数量与reduce个数对应，分区之后再对将数据key进行排序，如果有conbiner，会对分区内的数据进行聚合，每个map任务会产生多个spill文件，在map任务结束之前，通过多路归并算法将这些spill文件归并成一个文件；
    reduce端shuffle：
    reduce端会定期向resourcemanager获取map的输出位置，复制map输出数据中对应的partition到本地。在复制map输出的同时就进行合并即将从各个map的输出进行排序并合并，最后将整合的文件交给reduce处理。