
     class Animal{
        public void out(){
            System.out.println("an out");
        }
    }
    class People extends Animal{
        public void out(){
            System.out.println("people out");
        }
    }
    class bb extends Animal{
        public void out(){
            System.out.println("bb out");
        }
    }
    class A {
        private static A a=new A();
        static {
            System.out.println("static");
        }
        {
            System.out.println("A");
        }
    }
    class B extends A{
        public B(){
            System.out.println("B");
        }
    }
public class Solution{

    public static void main(String[] args) {
       A b= new A();
    }
}