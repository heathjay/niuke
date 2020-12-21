有时候某些对象我们只需要一个，如：线程池、缓存、对话框等等，对于这类对象我们只能有一个实例，如果我

们制造出多个实例，就会导致很多问题产生。

        但是我们怎样才能保证一个类只有一个实例并且能够便于访问？这里我们想到了全局变量，全局变量确实是可以

保证该类可以随时访问，但是它很难解决只有一个实例问题。最好的办法就是让该自身来负责保存它的唯一实例。这

个类必须要保证没有其他类来创建它。这里我们可以将其构造方法私有化。即

含有私有化构造器的类就能保证它不能被其他类实例化了。但是我们如何来获取这个实例化类呢？提供一个方法

用于返回该类的实例对象即可实现。



        从上面可以看出单例模式有如下几个特点：

           一、它只有一个实例。

           二、它必须要自行实例化。

           三、它必须自行想整个系统提供访问点。


在《Head  First》有这样一个场景，就是说有两个线程都要执行这段代码，很有可能会产生两个实例对象。
这里有三种解决方案。

           第一、  使用synchronized来处理。也就是说将getInstance()方法变成同步方法即可。
public class Singleton {
    //利用静态变量来记录Singleton的唯一实例
    private static Singleton uniqueInstance;

    /*
     * 构造器私有化，只有Singleton类内才可以调用构造器
     */
    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }
}
  第二、  直接初始化静态变量。这样就保证了线程安全。
public class Singleton {
    /*
     * 利用静态变量来记录Singleton的唯一实例
     * 直接初始化静态变量，这样就可以确保线程安全了
     */
    private static Singleton uniqueInstance = new Singleton();

    /*
     * 构造器私有化，只有Singleton类内才可以调用构造器
     */
    private Singleton(){

    }

    public static Singleton getInstance(){
        return uniqueInstance;
    }

}

 第三、  用“双重检查加锁”，在getInstance()中减少使用同步。

public class Singleton {
    /*
     * 利用静态变量来记录Singleton的唯一实例
     * volatile 关键字确保：当uniqueInstance变量被初始化成Singleton实例时，
     * 多个线程正确地处理uniqueInstance变量
     *
     */
    private volatile static Singleton uniqueInstance;

    /*
     * 构造器私有化，只有Singleton类内才可以调用构造器
     */
    private Singleton(){

    }

    /*
     *
     * 检查实例，如果不存在，就进入同步区域
     */
    public static Singleton getInstance(){
        if(uniqueInstance == null){
            synchronized(Singleton.class){    //进入同步区域
                if(uniqueInstance == null){     //在检查一次，如果为null，则创建
                    uniqueInstance  = new Singleton();
                }
            }
        }

        return uniqueInstance;
    }

}






           四、模式优缺点                                                                                                     

           优点

              一、节约了系统资源。由于系统中只存在一个实例对象，对与一些需要频繁创建和销毁对象的系统而言，单

例模式无疑节约了系统资源和提高了系统的性能。

             二、因为单例类封装了它的唯一实例，所以它可以严格控制客户怎样以及何时访问它。

         缺点

             一、由于单例模式中没有抽象层，因此单例类的扩展有很大的困难。

             二、单例类的职责过重，在一定程度上违背了“单一职责原则”。

 

           五、模式使用场景                                                                                             

           下列几种情况可以使用单例模式。

              一、系统只需要一个实例对象，如系统要求提供一个唯一的序列号生成器，或者需要考虑资源消耗太大而只允许创建一个对象。

             二、客户调用类的单个实例只允许使用一个公共访问点，除了该公共访问点，不能通过其他途径访问该实例。

 

           六、总结                                                                                                           

           1. 单例模式中确保程序中一个类最多只有一个实例。

           2. 单例模式的构造器是私有了，而且它必须要提供实例的全局访问点。

           3. 单例模式可能会因为多线程的问题而带来安全隐患。