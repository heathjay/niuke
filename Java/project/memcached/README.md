1.Memcached 是什么

Memcached 是一套高性能的、分布式内存对象缓存系统。设计用于加速动态应用程序（比如 Web），减轻数据库负载。

它由 C 写成,它以 key/value 的方式将数据储存在内存中, 熟悉 C 又喜欢钻研源码的童鞋可以好好看看。

协议简单

    Memcached 的服务端客户端通信使用简单的文本协议，而不是笨重的 XML 等格式，因此，通过 telnet 也能在 memcached 上存取数据。官方文本协议
    官方还提供二进制协议（Binary Protocol），不需要解析文本，还能减少文本协议的漏洞，使得原本高速的 memcached 的性能更上一层楼。官方二进制协议
基于 libevent 的事件处理

    libevent 是个程序库，它将 Linux 的 epoll、BSD 类操作系统的 kqueue 等事件处理功能封装成统一的接口。即使对服务器的连接数增加，也能发挥 O(1)的性能。Memcached 使用这个 libevent 库，因此能在 Linux、BSD、Solaris 等操作系统上发挥其高性能。libevent 官网


内置内存存储方式

    Memcached 中保存的数据都存储在 Memcached 内置的内存存储空间中。由于数据仅存在于内存中，因此重启 Memcached、重启操作系统会导致全部数据丢失。另外，内容容量达到指定值（启动时可通过-m 参数配置）之后，就基于 LRU(Least Recently Used，顾名思义：最近最少使用)算法自动删除不使用的缓存，不用担心，这个功能是可以配置的，Memcached 启动时通过“-M”参数可以禁止 LRU。不过，Memcached 本身是为缓存而设计的，建议开启 LRU。


Memcached 不互相通信的分布式

    Memcached 虽然称为“分布式”缓存服务器，但服务器端并没有“分布式”功能。互不通信，怎么实现分布式？事实上，Memcached 的分布式是完全由客户端程序库实现的。这种分布式是 Memcached 的最大特点。通过这种方式，Memcached server 之间的数据不需要同步，也就不需要互相通信了。
    函数库通过与数据保存时相同的算法（一种是求余 Hash，另一种是 Consistent Hashing)，根据“键”选择服务器。使用的算法相同，就能选中与保存时相同的服务器。只要数据还在，就能获得之前保存的值。
    上述两种算法各有千秋，求余 Hash 分布式算法会导致 Cache 命中率（这个是缓存很重要的指标之一）降低，而 consistent hash 算法，会影响新加入的 server 逆时针方向的 server 节点的命中率
    这样，Memcached 服务器增多后，键就会分散，即使一台 Memcached 服务器发生故障无法连接，也不会影响其他的缓存，系统依然能继续运行，cool！

3. Memcached 能做什么

看它自己怎么说，Memcached is an in-memory key-value store for small chunks of arbitrary data (strings, objects) from results of database calls, API calls, or page rendering.

做缓存系统，具体可以缓存哪些数据呢？Memcached 可以存储各种格式的数据，包括图像、视频、文件等。要知道各种数据在存储设备（如磁盘）上都长一样，都是 0 和 1 组成的二进制数序列。

哦，那这么说它是万能的哦? 金无赤足，人无完人!

软件也一样，都有优缺点。绝大多数大型项目都是由多种技术，多种软件融合而成，取长补短，当然可能我们自己练手的小项目就不一定了。


适用场景

    网站包含了访问量很大（什么叫很大，那是多大？）的动态网页，因而数据库的负载将会很高, 且大部分数据库请求都是读操作；
    数据库服务器的负载比较低，CPU 使用率却很高；
    小型需要共享的数据，如 session 等临时数据；
    缓存一些很小但是被频繁访问的文件。图片这种大点儿的文件就由 CDN（内容分发网络）来处理了。

不适用场景

    缓存对象的大小大于 1 MB, Memcached 本身就不是为了处理庞大的多媒体和巨大的二进制块而设计的，如果你任性，要存这么大的数据，可以自己修改源代码，它是开源的，不过请慎改；
    key 的长度大于 250 字符（硬性要求）；
    环境不允许运行 memcached 服务，如虚拟主机；
    应用运行在不安全的环境中，Memcached 未提供任何安全策略，仅仅通过 telnet 就可以访问到 memcached。数据安全越来越重要了，so，请把它放在防火墙后；
    业务需要的是持久化数据时请使用数据库。
