可以使用两种方式给一个类或者对象添加行为。

        一是使用继承。继承是给一个类添加行为的比较有效的途径。通过使用继承，可以使得子类在拥有自身方法的同时，还可以拥有父类的方法。但是使用继承是静态的，在编译的时候就已经决定了子类的行为，我们不便于控制增加行为的方式和时机。

        二是使用关联。组合即将一个对象嵌入到另一个对象中，由另一个对象来决定是否引用该对象来扩展自己的行为。这是一种动态的方式，我们可以在应用程序中动态的控制。

        与继承相比，关联关系的优势就在于不会破坏类的封装性，且具有较好的松耦合性，可以使系统更加容易维护。但是它的缺点就在于要创建比继承更多的对象

一、基本定义
装饰者模式，动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更加有弹性的替代方案。





           1、装饰者模式可以提供比继承更多的灵活性

           2、可以通过一种动态的方式来扩展一个对象的功能，在运行时选择不同的装饰器，从而实现不同的行为。

           3、通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造出很多不同行为的组合。可以使用多个具体装饰类来装饰同一对象，得到功能更为强大的对象。

           4、具体构件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体构件类和具体装饰类，在使用时再对其进行组合，原有代码无须改变，符合“开闭原则”。

 

        
缺点

           1、会产生很多的小对象，增加了系统的复杂性

           2、这种比继承更加灵活机动的特性，也同时意味着装饰模式比继承更加易于出错，排错也很困难，对于多次装饰的对象，调试时寻找错误可能需要逐级排查，较为烦琐。

 

       
五、模式的适用场景
1、在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。

                 2、需要动态地给一个对象增加功能，这些功能也可以动态地被撤销。  当不能采用继承的方式对系统进行扩充或者采用继承不利于系统扩展和维护时。

 

        六、总结nbsp;                1、 组合和委托可以在运行时动态的添加新的行为，而继承是静态的，在系统编译时就已经决定了对象的行为。

                 2、装饰者模式意味着一群装饰者类，这些类用来包装具体组件

                 3、装饰者可以在被装饰者的行为前面或者后面加上自己的行为，甚至可以将被装饰者的行为整个取代掉，从而达到特定的目的。

                 4、可以用多个装饰者包装一个组件。

                 5、装饰者一般对于组件的客户是透明的，除非客户程序依赖于组件的具体类型。

                 6、装饰者会导致设计中出现许多的小对象，如果过度的使用，会让系统变得更加复杂。

                 7、装饰者和被装饰者对象有相同的超类型。