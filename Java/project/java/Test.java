import java.lang.reflect.*;
public class Test{
    public void func(String key, String[] args){
        System.out.println((args == null) ? "null" : args.length);

    }
    public static void re(){
        re();
    }
    static void demo(int i){
        Integer num1 = new Integer(i);
        Integer num2 = new Integer(i);
        Integer num3 = i;
        Integer num4 = Integer.valueOf(i);
        Integer num5 = Integer.valueOf(i);


        System.out.print(num1==num2);
        System.out.print(",");
        System.out.print(num2==num3);
        System.out.print(",");
        System.out.print(num3==num4);
        System.out.print(",");
        System.out.print(num4==num5);
    }
    public static void main(String[] args){
        Test obj = new Test();
        try{
            Method m = obj.getClass().getMethod("func", String.class, String[].class);
            m.invoke(obj, new String(), new String[1]);
            //m.invoke(obj, new String(), new Object[]{new String[]{"a", "b"}});
            m.invoke(obj, new String(), new String[2]);
        }catch(IllegalAccessException e){

        }catch(InvocationTargetException e1){

        }catch(NoSuchMethodException e3){

        }
       
        //demo(49);
        demo(200);

    }
}