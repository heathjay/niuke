# 子类可以继承父类的所有成员吗？
    子类可以继承父类的所有成员，包括被private修饰的成员，子类只是无法访问、不能调用被private修饰的方法罢了。
    我们还是要分清继承和访问权限的问题。
    可以继承私有变量但是不能访问！！！！ 
    子类只能访问父类的非私有成员。
# 静态方法中，只能调用静态的方法或属性
链接：https://www.nowcoder.com/questionTerminal/e2e3f21d22a143dfb7b2396a0cd39047
来源：牛客网

class Test{
     private int m;//改称static int m;
         public static void fun() {
         // some code...
         m
    }
}
