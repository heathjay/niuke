public class CoffeeWithHook extends CaffeineBeverageWithHook{
    void addCondiments() {
        System.out.println("Adding Sugar and Milk...");
    }

    void brew() {
        System.out.println("Dripping Coffee through filter...");
    }

    /**
     * 覆盖该钩子，提供自己的实现方法
     */
    public boolean customerWantsCondiments(){
        if("y".equals(getUserInput().toLowerCase())){
            return true;
        }
        else{
            return false;
        }
    }

    public String getUserInput(){
        String answer = null;
        System.out.print("Would you like milk and sugar with your coffee(y/n):");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(answer == null){
            return "n";
        }
        return answer;

    }
}


四、模式优缺点

            优点

              1、模板方法模式在定义了一组算法，将具体的实现交由子类负责。

              2、模板方法模式是一种代码复用的基本技术。

              3、模板方法模式导致一种反向的控制结构，通过一个父类调用其子类的操作，通过对子类的扩展增加新的行为，符合“开闭原则”。

          缺点

             每一个不同的实现都需要一个子类来实现，导致类的个数增加，是的系统更加庞大。

 
五、使用场景

             1、  一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。

             2、  各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复。

             3、控制子类的扩展。

 
六、模式总结

             1、  模板方法模式定义了算法的步骤，将这些步骤的实现延迟到了子类。

             2、  模板方法模式为我们提供了一种代码复用的重要技巧。

             3、  模板方法模式的抽象类可以定义抽象方法、具体方法和钩子。

             4、  为了防止子类改变算法的实现步骤，我们可以将模板方法声明为final。

 