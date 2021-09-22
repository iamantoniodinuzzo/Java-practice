public class MyThread <T> extends Thread {
    
    private List list;
    private Comparator comparator;

    public  MyThread(List<T> l , Comparator<T> c){
        list = l;
    }

    @Override
    public void run(){
        

    }
}
