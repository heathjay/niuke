 public class PizzaStore {
        SimplePizzaFactory factory;      //SimplePizzaFactory的引用
        public PizzaStore(SimplePizzaFactory factory){
            this.factory = factory;
        }
        
        public Pizza orderPizza(String type){
            Pizza pizza;
            pizza = factory.createPizza(type);       //使用工厂对象的创建方法，而不是直接new。这里不再使用具体实例化
            
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            
            return pizza;
        }
    }