public class MutilThread{
    public static void main(String arsg[]){
       // MyThread mythread = new MyThread();
       // mythread.start();
    //    MyThread2 mythread2 = new MyThread2();
    //    Thread executeThread = new Thread(mythread2);

       String s1 = new String("ss");
       String s2 = "ss";
       String s3 = s2;
       s2 = "snidji";
       System.out.println(s1.equals(s3));
       System.out.println(s2);
       System.out.println(s3);
       
        Integer a1= new Integer(12);
        Integer a2 = 12;
        int a3 = 12;
        System.out.println(a1 == a3);
        System.out.println(a1 == a2);
    //    executeThread.start();
    //     for(int i = 0 ;i < 3;i++){
    //         System.out.println("main+" + i);
    //     }


        final MutilThread my = new MutilThread();
        final Thread t1 = new Thread(new Runnable(){
            public void run(){
                my.setData(true);
            }
        });
        t1.start();
        final Thread t2 = new Thread(new Runnable(){
            public void run(){
                try{
                    t1.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                
                System.out.println("t1 改变以后的值：" + my.getData());
            }
        });
        t2.start();

    }

    private boolean hasData = true;

    public boolean getData(){
        return this.hasData;
    }

    public void setData(boolean f){
        this.hasData = f;
    }

}
class MyThread extends Thread{
    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println("mythread +" + i);
        }
       
    }
}

class MyThread2 implements Runnable{
    public void run(){
        System.out.println("mythread2");
    }
}