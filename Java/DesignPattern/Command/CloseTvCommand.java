public class CloseTvCommand implements Command{
    private Television tv;

    public CloseTvCommand(){
        tv = new Television();
    }

    public void execute() {
        tv.close();
    }

}