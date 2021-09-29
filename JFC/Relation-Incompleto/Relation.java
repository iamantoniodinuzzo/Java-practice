import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class Relation<S,T>{

    Map<S, T> relations;

    public Relation(){
        relations = new HashMap<>();
    }

    /**
     * aggiunge una coppia di oggetti alla relazione.
     */
    public void put(S obj1, T obj2){
        relations.put(obj1, obj2);
    }

    /**rimuove una coppia di oggetti dalla relazione */
    public void remove(S obj1, T obj2){
        relations.remove(obj1, obj2);
    }
    /**
     * accetta un oggetto x di tipo S e restituisce l'insieme degli oggetti di tipo T che sono in relazione con x.
     */
    public Set<T> image(S x){
        Set<S> keys = relations.keySet();
        Iterator i = keys.iterator();
        while (i.hasNext()) {
           System.out.println(i.next());
        }
        return images;
        
    }

    /**
     * accetta un oggetto x di tipo T e restituisce l'insieme degli oggetti di tipo S che sono in relazione con x.
     */
    public Set<S> preImage(T x){

        Set<S> keys = relations.keySet();
        Iterator i = keys.iterator();
        while (i.hasNext()) {
           System.out.println(i.next());
        }      
        return images;
    }

    public static void main(String[] args) {
        Relation<Integer,String> r = new Relation<Integer,String>();
        r .put(0, "a"); r .put(0, "b"); r .put(0, "c");
        r .put(1, "b"); r .put(2, "c");
        r .remove(0, "a");

        Set<String> set0 = r.image(0);
        Set<Integer> setb = r.preImage("b");

        System.out.println(set0) ;
        System.out.println(setb) ;  
    }

}