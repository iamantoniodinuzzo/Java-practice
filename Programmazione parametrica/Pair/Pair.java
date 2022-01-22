package Pair;
import java.util.*;
public class Pair<T, U> {
    private T obj1;
    private U obj2;

    public Pair(T obj1, U obj2){
        this.obj1 = Objects.requireNonNull(obj1);
        this.obj2 = Objects.requireNonNull(obj2);
    }

    public T getObj1() {
        return obj1;
    }
    public U getObj2() {
        return obj2;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Pair)) return false;

        Pair<?, ?> p = (Pair<?,?>) obj;
        
        return (obj1.equals(p.getObj1()) && obj2.equals(p.getObj2()));
    }

    @Override
    public int hashCode(){
        return obj1.hashCode() ^ obj2.hashCode();
    }

    @Override
    public String toString(){
        return "("+obj1.toString()+","+obj2.toString()+")";
    }

    public static void main(String[] args) {
        Pair<String,Integer> p1 = new Pair<String,Integer>("uno", 1);
        System.out.println(p1);
        
    }


}
