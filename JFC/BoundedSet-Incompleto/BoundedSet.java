import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;


public class BoundedSet<T> {

    private Set<T> bounded_set ;

    private int max_capacity;

    /**
     * Costruttore
     * @param max_capacity La capacità massima dell'insieme
     */
    public BoundedSet(int max_capacity){
            this.max_capacity = max_capacity;
            bounded_set = new HashSet<>();
    }

   /**
    * Aggiunge un elemento all'insieme. Se però l'insieme è alla sua capacità massima e
    * si tenta di inserire un nuovo elemento con add, prima dell'inserimento sarà cancellato dall'insieme
    * l'elemento che vi è stato inserito prima (cioè, l'elemento più "vecchio" presente nell'insieme).
    *
    * @param element L'elemento da inserire.
    * @return True se l'elemento è stato inserito, false altrimenti.
    */
    public boolean add(T element) {
    
        if (bounded_set.size() == max_capacity) {
             //rimuovi l'elemento più vecchio
           
        }

        return bounded_set.add(element);

    }
    
    public boolean contains(T element){
        return bounded_set.contains(element);

    }

    public int size(){
        return bounded_set.size();
    }

    public static void main(String[] args) {
        BoundedSet<Integer> s = new BoundedSet<Integer>(3);
        s .add(3); s .add(8); s .add(5); s .add(5);
        System.out.println(s . size ()) ;
        System.out.println(s .contains(3)) ;
        s .add(14);
        System.out.println(s . size ()) ;
        System.out.println(s .contains(3))
    }
}
