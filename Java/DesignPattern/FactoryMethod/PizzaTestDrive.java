public class PizzaTestDrive {
    public static void main(String[] args) {
        System.out.println("---------Joel 需要的芝加哥的深盘披萨---------");
        ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();       //建立芝加哥的披萨店
        Pizza joelPizza =chicagoPizzaStore.orderPizza("cheese");             //下订单
        System.out.println("Joel ordered a " + joelPizza.getName() + "\n");

        System.out.println("---------Ethan 需要的纽约风味的披萨---------");
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza ethanPizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + ethanPizza.getName() + "\n");

    }
}

// 1、工厂方法模式完全符合“开闭原则”。

// 2、工厂方法模式使用继承，将对象的创建委托给子类，通过子类实现工厂方法来创建对象。

// 3、工厂方法允许类将实例化延伸到子类进行。

// 4、工厂方法让子类决定要实例化的类时哪一个。在这里我们要明白这并不是工厂来决定生成哪种产品，而是在编写创建者类时，不需要知道实际创建的产品是哪个，选择了使用哪个子类，就已经决定了实际创建的产品时哪个了。

// 5、在工厂方法模式中，创建者通常会包含依赖于抽象产品的代码，而这些抽象产品是、由子类创建的，创建者不需要真的知道在制作哪种具体产品。
// 七、工厂方法适用场景                                                                                             

//         1、一个类不知道它所需要的对象的类。在工厂方法模式中，我们不需要具体产品的类名，我们只需要知道创建它的具体工厂即可。

//         2、一个类通过其子类来指定创建那个对象。在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。

//         3、将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定。