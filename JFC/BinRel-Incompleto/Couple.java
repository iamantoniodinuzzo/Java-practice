public class Couple<T> implements Comparable<T>{
    private T obj1;
    private T obj2;

    public Couple(T obj1, T obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;

    }

    public T getObj1(){return obj1;}
    public T getObj2(){return obj2;}

    public int compareTo(Couple<T> x){
        
        return (x.getObj1().equals(getObj2())&& x.getObj2().equals(getObj1()));
            
    }
   

}
