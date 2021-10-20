
class Ticks{
    int val ;
    public Ticks(int val){
        this.val = val;
    }
    public void sell(){
        this.val--;
    }

    public int get(){
        return this.val;
    }
}

class Station extends Thread{
    Ticks t;
    public Station(String name, Ticks t){
        super(name);
        this.t = t;
    }

    static Object ob = "1";
    public void run(){
        while(t.get() > 0){
            synchronized(ob){
                if(t.get() > 0){
                    System.out.println("Station " + this.getName() + ": 卖出" + t.get() + "票");
                    t.sell();
                }else{
                    System.out.println("无");
                }
            }
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class ProCum extends Thread{

    public static void main(String[] args){
        Ticks t = new Ticks(20);
        Station s1 = new Station("1", t);
        Station s2 = new Station("2", t);
        Station s3 = new Station("3", t);
        s1.start();
        s2.start();
        s3.start();
    }
}