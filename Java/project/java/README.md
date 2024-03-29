# JVM、JRE和JDK的关系

JVM
Java Virtual Machine是Java虚拟机，Java程序需要运行在虚拟机上，不同的平台有自己的虚拟机，因此Java语言可以实现跨平台。

JRE
Java Runtime Environment包括Java虚拟机和Java程序所需的核心类库等。核心类库主要是java.lang包：包含了运行Java程序必不可少的系统类，如基本数据类型、基本数学函数、字符串处理、线程、异常处理类等，系统缺省加载这个包

如果想要运行一个开发好的Java程序，计算机中只需要安装JRE即可。

JDK
Java Development Kit是提供给Java开发人员使用的，其中包含了Java的开发工具，也包括了JRE。所以安装了JDK，就无需再单独安装JRE了。其中的开发工具：编译工具(javac.exe)，打包工具(jar.exe)等

JRE = JVM + 核心类库
JDK = JRE + 开发工具，编译工具


# 什么是字节码？采用字节码的最大好处是什么

字节码：Java源代码经过虚拟机编译器编译后产生的文件（即扩展为.class的文件），它不面向任何特定的处理器，只面向虚拟机。

# 采用字节码的好处：

Java语言通过字节码的方式，在一定程度上解决了传统解释型语言执行效率低的问题，同时又保留了解释型语言可移植的特点。所以Java程序运行时比较高效，而且，由于字节码并不专对一种特定的机器，因此，Java程序无须重新编译便可在多种不同的计算机上运行。
# Java源代码---->编译器---->jvm可执行的Java字节码(即虚拟指令)---->jvm---->jvm中解释器----->机器可执行的二进制机器码---->程序运行。
# 什么是Java程序的主类？应用程序和小程序的主类有何不同？

一个程序中可以有多个类，但只能有一个类是主类。在Java应用程序中，这个主类是指包含main()方法的类。而在Java小程序中，这个主类是一个继承自系统类JApplet或Applet的子类。应用程序的主类不一定要求是public类，但小程序的主类要求必须是public类。主类是Java程序执行的入口点。
# Java应用程序与小程序之间有那些差别？

简单说应用程序是从主线程启动(也就是main()方法)。applet小程序没有main方法，主要是嵌在浏览器页面上运行(调用init()线程或者run()来启动)，嵌入浏览器这点跟flash的小游戏类似。


# yield 和 sleep 的异同

 
1）yield, sleep 都能暂停当前线程，sleep 可以指定具体休眠的时间，而 yield 则依赖 CPU 的时间片划分。

 
2）yield, sleep 两个在暂停过程中，如已经持有锁，则都不会释放锁资源。

 
3）yield 不能被中断，而 sleep 则可以接受中断。


# 公司网络中心有的服务器不配备光驱,有的服务器USB端口损坏,网络管理员根据不同的环境可以使用不同的linux 操作系统安装方式,一般支持以下方式（      ）
	CDROM 	NFS 	Hard drive
# java类    它的整个生命周期包括：加载（把代码数据加载到内存中）、验证（JVM规范校验， 代码逻辑校验。）、准备（static修饰0，final static修饰3, 内存初始化， 初始化的类型。在准备阶段，JVM 会为类变量分配内存，并为其初始化。但是这里的初始化指的是为变量赋予 Java 语言中该数据类型的零值，而不是用户代码里初始化的值。）、解析（这个阶段的主要任务是将其在常量池中的符号引用替换成直接其在内存中的直接引用。）、初始化、使用和卸载七个阶段。
# 类初始化是类加载过程的最后一个阶段，到初始化阶段，才真正开始执行类中的Java程序代码。虚拟机规范严格规定了有且只有5种情况必须立即对类进行初始化：
1. 第一种：遇到new、getstatic、putstatic、invokestatic这四条字节码指令时,使用new关键字实例化对象的时候、读取或设置一个类的静态字段（被final修饰、已在编译器把结果放入常量池的静态字段除外）的时候，以及调用一个类的静态方法的时候。
2. 第二种：使用Java.lang.refect包的方法对类进行反射调用时，
3. 第三种：当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化。
4. 第四种：当虚拟机启动时，用户需要指定一个要执行的主类，虚拟机会先执行该主类。
5. 第五种：当使用JDK1.5支持时，如果一个java.langl.incoke.MethodHandle实例最后的解析结果REF_getStatic、
# Class.forName 如果调用成功后：
将一个Java类被有效得加载到内存中；
类默认会被初始化(initialize 这个参数传的是true)，即执行内部的静态块代码以及保证静态属性被初始化；
默认会使用当前的类加载器来加载对应的类。
# ClassLoader.loadClass方式，类不会被初始化，只有显式调用才会进行初始化。综上所述，ClassLoader.loadClass 如果调用成功后：
将一个java类加载到内存中；
类不会被初始化，只有在之后被第一次调用时类才会被初始化；因为虚拟机规范规定了，当遇到new、getstatic、putstatic或invokestatic这4条字节码指令是，如果没有进行过初始化则需要先触发初始化。


# TCP拥塞控制
1. 慢开始： 不要一开始就发送大量的数据，先探测一下网络的拥塞程度，也就是说由小到大逐渐增加拥塞窗口的大小。发送方一开始传输的时候采用慢开始，按照指数的增长， 当cwnd>ssthresh时就开始采用拥塞避免算法
2. 拥塞避免：
 防止过多的数据注入网络中，这样可以使网络中的路由器或链路不致过载。
3. 快重传： 是指当接收方收到一个失序的数据，可以立刻向发送方发送重复确认信息。当发送方连续收到了3个重复的确认响应的时候，就判断为传输失败，报文丢失，这个时候就利用快重传算法立即进行信息的重传。
4. 快恢复：  与快重传配合使用，当发送方接收到连续三个重复确认请求，为了避免网络拥塞，执行拥塞避免算法

# 值类型
值类型数据是在栈上分配内存空间，它的变量直接包含变量的实例，使用效率相对较高。而引用类型数据是分配在堆上，引用类型的变量通常包含一个指向实例的指针，变量通过指针来引用实例。	
B、	值类型的变量赋值只是进行数据复制，创建一个同值的新对象，而引用类型变量赋值，仅仅是把对象的引用的指针赋值给变量，使它们共用一个内存地址。	
C、	引用类型一般都具有继承性，但是值类型一般都是封装的，因此值类型不能作为其他任何类型的基类。

# 一台客户端有三百个客户与三百个客户端有三百个客户对服务器施压，有什么区别?
300个用户在一个客户端上，需要更大的带宽。
	线程之间可能发生干扰，而产生一些异常。
    所有用户在一个客户端上，不必考虑分布式管理的问题。

# 三 "2>&1 file"和 "> file 2>&1"区别

1）cat food 2>&1 >file ：错误输出到终端，标准输出被重定向到文件file。
2）cat food >file 2>&1 ：标准输出被重定向到文件file，然后错误输出也重定向到和标准输出一样，所以也错误输出到文件file。 

# 不过拿无损压缩效率最高的哈夫曼编码的举例来说，频率越低，需要的编码位越多，
# tcp，udp都是传输层的协议

# 可能引起进程挂起的原因有（）
（1）终端用户的请求。当终端用户在自己的程序运行期间发现有可疑问题时，希望暂停使自己的程序静止下来。亦即，使正在执行的进程暂停执行；若此时用户进 程正处于就绪状态而未执行，则该进程暂不接受调度，以便用户研究其执行情况或对程序进行修改。我们把这种静止状态称为“挂起状态”。
（2）父进程的请求。有时父进程希望挂起自己的某个子进程，以便考察和修改子进程，或者协调各子进程间的活动。
（3）负荷调节的需要。当实时系统中的工作负荷较重，已可能影响到对实时任务的控制时，可由系统把一些不重要的进程挂起，以保证系统能正常运行。
（4）操作系统的需要。操作系统有时希望挂起某些进程，以便检查运行中的资源使用情况或进行记账

# A 原子性 要么都执行，要么都不执行 C 一致性 事物执行前后数据库保持一致的正确状态 I 隔离性 不同事务之间互不干扰 D 持久性 事务一旦提交，对数据库中数据的变更是永久的

# 候选码概述 
若关系中的某一属性或属性组的值能唯一的标识一个元组，而其任何、子集都不能再标识，则称该属性组为（超级码）候选码。

# 当执行a/b的时候就会被范围更小且位于最前面的ArithmeticException异常捕获，因此try不会再打印，下面范围更大的Exception块也不会再执行
# 反射获取类本身所有的属性成员getDeclaredField(),getField()获取public属性
# 给文本框增加文本监视器的方法是（）addTextListener（TextListener）
# 接口中的属性默认是哪些修饰符修饰（  public final abstract    ）
# 递归的时间复杂度就是 递归次数*每次递归操作数 或者将计算递归树的节点
# inline是C++关键字，在函数声明或定义中，函数返回类型前加上关键字inline，即可以把函数指定为内联函数。 这样可以解决一些频繁调用的函数大量消耗栈空间（栈内存）的问题。 关键字inline必须与函数定义放在一起才能使函数成为内联函数，仅仅将inline放在函数声明前面不起任何作用。
    -  inline函数应该简洁，如果语句较多，不适合定义为内联函数
    -  inline函数中，一般不建议有循环、if或switch语句，否则，函数定义时即使有inline关键字，编译器也可能会把该函数作为非内联函数处理。
    -  inline函数要在函数被调用之前声明。
# 进程和线程的区别
地址空间：
线程共享本进程的地址空间，而进程之间是独立的地址空间。
资源：
线程共享本进程的资源如内存、I/O、cpu等，不利于资源的管理和保护，而进程之间的资源是独立的，能很好的进行资源管理和保护。
健壮性：
多进程要比多线程健壮，一个进程崩溃后，在保护模式下不会对其他进程产生影响，但是一个线程崩溃整个进程都死掉。
执行过程：
每个独立的进程有一个程序运行的入口、顺序执行序列和程序入口，执行开销大。
但是线程不能独立执行，必须依存在应用程序中，由应用程序提供多个线程执行控制，执行开销小。
可并发性：两者均可并发执行。
切换时的资源消耗：
进程切换时，消耗的资源大，效率高。所以涉及到频繁的切换时，使用线程要好于进程。同样如果要求同时进行并且又要共享某些变量的并发操作，只能用线程不能用进程。
基本单位：
线程是处理器调度的基本单位，进程是系统进行资源分配和调度的基本单位。
进程是资源分配的最小单位，线程是运行调度的最小单位。
# c++对齐避免
加上__attribute__((packed))，可以防止编译器对结构进行字节对齐优化。
使用__attribute__((aligned(0)))(0为对齐字节数)，强制编译器按照0字节对齐。

# delete 只会调用一次析构函数，而delete[]会调用每一个成员的析构函数
# 在Java中抽象类之间不允许出现继承关系，所有的抽象类都相互独立
# 错误 可以使用System.gc()来显式进行垃圾回收，但是不保证能够执行，（命令一定执行）
# java switch可以byte short int char 枚举，string(1.7)
# C 语言中，static关键字说法正确的有：（）用static修饰的全局变量可以在运行时修改； 用static修饰的函数，其内部变量可以传递给其他函数
# 下列运算符中，在C++语言中不能重载的是：（）
不能重载的运算符只有5个：
1、.  (成员访问运算符)
2、.*  (成员指针访问运算符)
3、::  (域运算符)
4、sizeof
(长度运算符)
5、?:  (条件运算符）

# 127.0.0.1是回送地址，可以测试本地TCP/IP协议是否可用
#  E类地址范围：240.0.0.0 - 255.255.255.255。其中240.0.0.0-255.255.255.254作为保留地址，主要用于Internet试验和开发
#  关系中候选码的诸属性称为（）主属性
# SQL Server中系统默认的事务管理模式是 自动提交事务模式
# 在java语言的异常处理中，finally经常被用在需要释放资源的情况下，无论出现什么情况，finally块里面的代码一定会被执行。（除了两种情况，一种是在程序进入try语句块之前就出现异常，会直接结束，不会执行finally块里面的代码。第二种是程序在try语句块中强制退出时也不会去执行finally块里面的代码。）。由于程序执行return就意味着结束对当前函数的调用并跳出这个函数体。因此任何语句要执行都只能在return前执行(除非碰到exit函数), 因此 finally块里的代码也是在return前执行的。此外,如果try-finally或者catch- finally中都有return，那么 finally块中的return语句将会覆盖别处的return语句,最终返回到调用者那里的是 finally中return的值。
# System.out.println('1'+1+1);注意第一个1是单引号，所以是字符对应的ascii码49，所以结果是51；如果是双引号就当字符串处理结果是111

# 调用Thread类的哪些方法可以终止当前进程的执行（      ）sleep() yield()

首先A选项不对，这个类连个无参构造器都没有。Person p = new Person()根本不可能编译通过。
用反射获取class对象的话，常用的有三种方法：
1. Class clazz = Person.class;
2. Person p = new Person("NiuKeWoShiNiDaYe");
   Class clazz = str.getClass();
3. Class clazz = Class.forName("cn.test.Person");
再加的话顶多还有一种用类加载器的方法来获取：
ClassLoader classLoader = Person.class.getClassLoader();
classLoader.loadClass("cn.test.Person");
C选项.Class  C不应该是大写的
D选项，人家forName里面的参数应该是包名.类名，答案里面只写到了包名
总之我觉得应该选B

# 联合索引（a,b,c）,只有查询a, ab,abc时索引才会生效，查b或者c失效，最左匹配原则
# volatile 不保证原子性线程不安全
# 在执行速度上，Statement 对象快于PreparedStatement 对象 错误
JDBC提供了Statement、PreparedStatement 和 CallableStatement三种方式来执行查询语句，其中 Statement 用于通用查询， PreparedStatement 用于执行参数化查询，而 CallableStatement则是用于存储过程
PreparedStatement可以阻止常见的SQL注入式攻击
PreparedStatement中，“?” 叫做占位符，有多少个占位符就需要有多少个对应的值
 # java object默认的基本方法中没有copy()方法，但是有clone()
 # 二分查找树里查询一个关键字的最坏时间复杂度是O(n) 不平衡的极端情况是二叉查找树退化为单链表
 #  C选项 无修饰符 此处默认应该为 public
 #  List有哪些实现类: ArrayList, LinkedList Vector
 #  Java中哪些集合是Collection派生出来的？List Queue Set
# 最多只允许一个线程拥有这把锁,当消费者线程试图执行以带有synchronized(this)标记的代码块时,消费者线程必需先获得this关键字引用的Stack对象的锁.
# 1，这两个方法来自不同的类分别是Thread和Object
  2，最主要是sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。
  3，wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在
    任何地方使用
   synchronized(x){
      x.notify()
     //或者wait()
   }
   4,sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常

# dd if=/dev/zero of=sun.txt bs=1M count=1
该命令创建了一个1M大小的文件sun.txt，其中参数解释：
• if 代表输入文件。如果不指定if，默认就会从stdin中读取输入。
• of 代表输出文件。如果不指定of，默认就会将stdout作为默认输出。
• bs 代表字节为单位的块大小。
• count 代表被复制的块数。
• /dev/zero 是一个字符设备，会不断返回0值字节（\0）
# 在Linux系统下，查看进程占用的端口的命令是什么? netstat –apn

# 软硬连接
硬链接：新建的文件是已经存在的文件的一个别名，当原文件删除时，新建的文件仍然可以使用.

软链接：也称为符号链接，新建的文件以“路径”的形式来表示另一个文件，新建的软链接可以指向不存在的文件.软链接可以对目录进行链接
1.硬链接和原来的文件没有什么区别，而且共享一个 inode 号（文件在文件系统上的唯一标识）；而软链接不共享 inode，也可以说是个特殊的 inode，所以和原来的 inode 有区别。
硬链接不能对目录建立硬链接！
2.若原文件删除了，则该软连接则不可以访问，而硬连接则是可以的。

3.由于符号链接的特性，导致其可以跨越磁盘分区，但硬链接不具备这个特性.

# linux地址排布
Linux进程内存空间有以下几个部分:
1.stack 
2.heap
3.bss segment
4.code segment/text segment
5.data segment
它们从高地址到低地址的分布顺序为()12354 stack heap bss data code

# 以下哪三个中有不属于Unix系统调用? open lseek fseek

# 以下算法不可以使用贪心算法的是? Floyd-Warshall算法

# 二叉排序树 我们构建如下的二叉排序树，其左子树小于根结点的值，右子树大于根结点的值：

 # 有一个算法的递推关系式为：T(N) = T(2N/3) + 1，则该算法的时间复杂度为（）(^符号是幂的意思) O(logN)
# 下面模板的声明中，哪个是正确的? template&lt;class C1, typename C2&gt;class C3{};

# 关于迭代器失效，下面说法错误的有? 当vector容器erase一个元素后，仅指向删除点的迭代器失效
# 大表1000万条数据， 小表1000条数据， 为提高查询效率两行表关联时通常做法是 大表在前

# free命令可以显示当前系统未使用的和已使用的内存数目，还可以显示被内核使用的内存缓冲区。

语法

free(选项)

选项

-b：以Byte为单位显示内存使用情况；
-k：以KB为单位显示内存使用情况；
-m：以MB为单位显示内存使用情况；
-o：不显示缓冲区调节列；
-s<间隔秒数>：持续观察内存使用状况；
-t：显示内存总和列；
-V：显示版本信息。

实例

free -m
total used free shared buffers ***d
Mem: 2016 1973 42 0 163 1497
-/+ buffers/***: 312 1703
Swap: 4094 0 4094

第一部分Mem行解释：
total：内存总数；
used：已经使用的内存数；
free：空闲的内存数；
shared：当前已经废弃不用；
buffers Buffer：缓存内存数；
***d Page：缓存内存数。

关系：total = used + free

第二部分(-/+ buffers/***)解释:
(-buffers/***) used内存数：第一部分Mem行中的 used – buffers – ***d
(+buffers/***) free内存数: 第一部分Mem行中的 free + buffers + ***d

可见-buffers/***反映的是被程序实实在在吃掉的内存，而+buffers/***反映的是可以挪用的内存总数。

第三部分是指交换分区。

# 在线算法、离线算法
选择排序是离线算法，而插入排序是在线算法。

# 什么是进程？是什么线程？ * * *
线程是处理器任务调度和执行的基本单位，进程是操作系统资源分配的基本单位。

进程是程序的一次执行过程，是系统运行的基本单位。线程是一个比进程更小的执行单位，一个进程可以包含多个线程。

# 进程和线程的关系？（区别） * * *
定义：线程是处理器任务调度和执行的基本单位；进程是操作系统资源分配的基本单位。

包含关系：一个进程可以包含多个线程。

从Java虚拟机的角度来理解：Java虚拟机的运行时数据区包含堆、方法区、虚拟机栈、本地方法栈、程序计数器。各个进程之间是相互独立的，每个进程会包含多个线程，每个进程所包含的多个线程并不是相互独立的，这个线程会共享进程的堆和方法区，但这些线程不会共享虚拟机栈、本地方法栈、程序计数器。即每个进程所包含的多个线程共享进程的堆和方法区，并且具备私有的虚拟机栈、本地方法栈、程序计数器，如图所示，假设某个进程包含三个线程。

# 并行和并发的区别？ *
并行：单位时间多个处理器同时处理多个任务。

并发：一个处理器处理多个任务，按时间片轮流处理多个任务。

# 多线程的优缺点（为什么使用多线程、多线程会引发什么问题
优点：当一个线程进入等待状态或者阻塞时，CPU可以先去执行其他线程，提高CPU的利用率。

缺点：

上下文切换：频繁的上下文切换会影响多线程的执行速度。
死锁
资源限制：在进行并发编程时，程序的执行速度受限于计算机的硬件或软件资源。在并发编程中，程序执行变快的原因是将程序中串行执行的部分变成并发执行，如果因为资源限制，并发执行的部分仍在串行执行，程序执行将会变得更慢，因为程序并发需要上下文切换和资源调度。

# 线程的上下文切换 *
即便是单核的处理器也会支持多线程，处理器会给每个线程分配CPU时间片来实现这个机制。时间片是CPU分配给每个线程的执行时间，一般来说时间片非常的短，所以处理器会不停地切换线程。

CPU会通过时间片分配算法来循环执行任务，当前任务执行完一个时间片后会切换到下一个任务，但切换前会保存上一个任务的状态，因为下次切换回这个任务时还要加载这个任务的状态继续执行，从任务保存到在加载的过程就是一次上下文切换。


# Java中守护线程和用户线程的区别？ *
任何线程都可以设置为守护线程和用户线程，通过方法Thread.setDaemon(bool on) 设置，true则是将该线程设置为守护线程，false则是将该线程设置为用户线程。同时，Thread.setDaemon()必须在Thread.start()之前调用，否则运行时会抛出异常。
用户线程：平时使用到的线程均为用户线程。

守护线程：用来服务用户线程的线程，例如垃圾回收线程。

守护线程和用户线程的区别主要在于Java虚拟机是后存活。

用户线程：当任何一个用户线程未结束，Java虚拟机是不会结束的。

守护线程：如何只剩守护线程未结束，Java虚拟机结束。



# 线程死锁是如何产生的，如何避免 * * *


# shell
        $0    脚本启动名(包括路径)
        $n    第n个参数,n=1,2,…9
        $*     所有参数列表(不包括脚本本身)
        $@   所有参数列表(独立字符串)
        $#    参数个数(不包括脚本本身)
        $$    当前程式的PID
        $!     执行上一个指令的PID
        $?    执行上一个指令的返回值

# 不稳定的排序方法
冒泡排序，插入排序，归并排序，基数排序。
常见的不稳定排序有：
选择排序，堆排序，希尔排序，快速排序。

# 编译性语言和解释性语言
就将程序源代码“翻译”成目标代码(机器语言)，因此其目标程序可以脱离其语言环境独立执行，使用比较 方便、效率较高。但应用程序一旦需要修改，必须先修改源代码，再重新编译生成新的目标文件(＊ .OBJ)才能执行，只有目标文件而没有源代码，修改很不方便。现在大多数的编程语言都是编译型的。编译程序将源程序翻译成目标程序后保存在另一个文件 中，该目标程序可脱离编译程序直接在计算机上多次运行。大多数软件产品都是以目标程序形式发行给用户的，不仅便于直接运行，同时又使他人难于盗用其中的技 术C、C++、Fortran、Visual Foxpro、Pascal、Delphi、Ada都是编译实现的。

解释型语言的实现中，翻译器并不产生目标机器代码，而是产生易于执行的中间代码，这种中间代码与机器代码是不同的，中间代码的解释是由软件支持的，不能直
接使用硬件，软件解释器通常会导致执行效率较低。用解释型语言编写的程序是由另一个可以理解中间代码的解释程序执行的。与编译程序不同的是，解释程序的任
务是逐一将源程序的语句解释成可执行的机器指令，不需要将源程序翻译成目标代码后再执行。解释程序的优点是当语句出现语法错误时，可以立即引起程序员注
意，而程序员在程序开发期间就能进行校正。对于解释型Basic语言，需要一个专门的解释器解释执行

# c语言
#include<>  :表示只从从标准库文件目录下搜索，对于标准库文件搜索效率快。
#include""    :表示首先从用户工作目录下开始搜索，对于自定义文件搜索比较快，然后搜索整个磁盘。

# 中断响应时间
从发出中断请求到中断处理结束所用的时间

# 协议
ICMP是 TCP/IP协议 族的一个子协议，属于网络层协议，主要用于在主机与路由器之间传递控制信息，包括报告错误、交换受限控制和状态信息等。当遇到IP数据无法访问目标、IP 路由器 无法按当前的传输速率转发 数据包 等情况时，会自动发送ICMP消息。ICMP报文在IP帧结构的首部协议类型字段（Protocol 8bit)的值=1.
网络层： IP, ICMP, IGMP, RARP, ARP
网路群组管理协议（英语：Internet Group Management Protocol，缩写：IGMP）是用于管理网路协议多播组成员的一种通信协议。

# C++ template
class用于定义类，在模板引入c++后，最初定义模板的方法为：template<class T>，这里class关键字表明T是一个类型，后来为了避免class在这两个地方的使用可能给人带来混淆，所以引入了typename这个关键字，它的作用同class一样表明后面的符号为一个类型，这样在定义模板的时候就可以使用下面的方式了： template<typename T>.在模板定义语法中关键字class与typename的作用完全一样。