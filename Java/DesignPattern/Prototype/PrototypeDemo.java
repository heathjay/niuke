public class PrototypeDemo implements Cloneable{
    　　public Object clone(){
    　　　　Object object = null;
    　　　　try {
    　　　　　　object = super.clone();
    　　　　} catch (CloneNotSupportedException exception) {
    　　　　　　System.err.println("Not support cloneable");
    　　　　}
    　　　　return object;
        }
        ……
    }