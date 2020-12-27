所谓模板方法模式就是在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。



模板方法模式是基于继承的代码复用技术的。在模板方法模式中，我们可以将相同部分的代码放在父类中，而将不同的代码放入不同的子类中。也就是说我们需要声明一个抽象的父类，将部分逻辑以具体方法以及具体构造函数的形式实现，然后声明一些抽象方法让子类来实现剩余的逻辑，不同的子类可以以不同的方式来实现这些逻辑。

其实所谓模板就是一个方法，这个方法将算法的实现定义成了一组步骤，其中任何步骤都是可以抽象的，交由子类来负责实现。这样就可以保证算法的结构保持不变，同时由子类提供部分实现。

模板是一个方法，那么他与普通的方法存在什么不同呢？模板方法是定义在抽象类中，把基本操作方法组合在一起形成一个总算法或者一组步骤的方法。而普通的方法是实现各个步骤的方法，我们可以认为普通方法是模板方法的一个组成部分

    从上面的结构可以看出，模板方法模式就两个角色：

              AbstractClass: 抽象类

              ConcreteClass:  具体子类

          其中抽象类提供一组算法和部分逻辑的实现，具体子类实现剩余逻辑。


遇到这个问题我们可以使用钩子。所谓钩子就是一种被声明在抽象类中的方法，但只有空的或者默认的实现。钩子的存在可以使子类能够对算法的不同点进行挂钩，即让子类能够对模板方法中某些即将发生变化的步骤做出相应的反应。当然要不要挂钩，由子类决定。