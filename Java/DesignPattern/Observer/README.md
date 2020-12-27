何谓观察者模式？观察者模式定义了对象之间的一对多依赖关系，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并且自动更新。

        在这里，发生改变的对象称之为观察目标，而被通知的对象称之为观察者。一个观察目标可以对应多个观察者，而且这些观察者之间没有相互联系，所以么可以根据需要增加和删除观察者，使得系统更易于扩展。

        观察者模式又称为发布-订阅模式


Subject：目标。他把所有对观察者对戏的引用保存在一个聚集里，每一个主题都可以有多个观察者。

Observer：观察者。为所有的具体观察者定义一个接口，在得到主题的通知时能够及时的更新自己。

ConcreteSubject：具体主题。将有关状态存入具体观察者对象。在具体主题发生改变时，给所有的观察者发出通知。

ConcreteObserver:具体观察者。实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题状态相协调。


        四、观察者模式的优缺点

        优点：

           1、当两个对象之间送耦合，他们依然可以交互，但是不太清楚彼此的细节。观察者模式提供了一种对象设计，让主题和观察者之间送耦合。主题所知道只是一个具体的观察者列表，每一个具体观察者都符合一个抽象观察者的接口。主题并不认识任何一个具体的观察者，它只知道他们都有一个共同的接口。

           2、观察者模式支持“广播通信”。主题会向所有的观察者发出通知。

           3、观察者模式符合“开闭原则”的要求。

        缺点：

           1、如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。

           2、 如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进  行循环调用，可能导致系统崩溃。

           3、   观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。

 

        五、观察者模式的适用场所

       1、一个抽象模型有两个方面，其中一个方面依赖于另一个方面。将这些方面封装在独立的对象中使它们可以各自独立地改变和复用。

        2、一个对象的改变将导致其他一个或多个对象也发生改变，而不知道具体有多少对象将发生改变，可以降低对象之间的耦合度。

        3、一个对象必须通知其他对象，而并不知道这些对象是谁。需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行为将影响C对象……，可以使用观察者模式创建一种链式触发机制。

 

        总结

        1、观察者模式定义了对象之间的一对多关系。多个观察者监听同一个被观察者，当该被观察者的状态发生改变时，会通知所有的观察者。

        2、观察者模式中包含四个角色。主题，它指被观察的对象。具体主题是主题子类，通常它包含有经常发生改变的数据，当它的状态发生改变时，向它的各个观察者发出通知；观察者，将对观察主题的改变做出反应；具体观察者中维护一个指向具体目标对象的引用，它存储具体观察者的有关状态，这些状态需要和具体目标的状态保持一致。

        3、主题用一个共同的接口来更新观察者。

        4、观察者与被观察者之间用松耦合方式结合。

        5、有多个观察者时，不可以依赖特定的通知次序。

        6、使用观察者模式，可以从被观察者处推或者拉数据。

 

       该读书笔记的代码和部分语句均来自《Head First 设计模式》