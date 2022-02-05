import java.util.*;
public class BoundedSet<T> {
    private final int dimension;
    private LinkedList<T> set;

    public BoundedSet(int dim){
        if(dim < 0 ) throw new IllegalArgumentException();

        dimension = Objects.requireNonNull(dim);
        set = new LinkedList<>();
    }
    
    /**
     * L'esercizio richiede che sia add che contains lavorino di tempo costante
     * In questo svolgimento non lavorano di tempo costante ma per far si che
     * questa richiesta sia soddisfatta, bisognerebbe usare per questi due metodi
     * un ArrayList, il quale è consigliato per l'accesso posizionale in tempo costante.
     * Usando un ArrayList però , viene meno la semplicità con cui riconoscere 
     * l'elemento più vecchio della collezione in quanto, il metodo add di LinkedList
     * equivale al metodo addLast che ci permette di trovare gli elementi nuovi in fondo alla lista e, 
     * l'elemento più vecchio in prima posizione.
     * 
     */
    public boolean add(T elem){
        if(set.contains(elem))
            return false;
        if(set.size() == dimension){
            set.removeFirst();
            set.add(elem);
        }else{
            set.add(elem);
        }
        return true;
        
    }

    public boolean contains(T elem){
        return set.contains(elem);
    }

    public int size(){
        return set.size();
    }


}
