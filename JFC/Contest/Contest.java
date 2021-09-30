import java.util.List;
import java.util.ArrayList;
public class Contest<T> {
    
    private List<T> object_list ;

    public Contest(){
        object_list = new ArrayList<>();
    }

    /**
     * Aggiunge un elemento al concorso
     * @param obj L'elemento da aggiungere al concorso
     */
    public void add(T obj){
        object_list.add(obj);
    }

    /**
     * Permette di votare per un oggetto;
     * Se l'oggetto passato a vote non partecipa al concorso (cioè non è stato aggiunto con add),
     *  viene lanciata un'eccezione;
     * 
     * @param obj L'oggetto da votare
     * @throws IllegalArgumentException Se l'oggetto passato a vote non partecipa al concorso (cioè non è stato aggiunto con add),
     *  viene lanciata un'eccezione;
     */
    public void vote(T obj) throws IllegalArgumentException{
        //controllo che l'oggetto sia presente nella lista
        if (!object_list.contains(obj)) {
            throw new IllegalArgumentException();
        }

        //Rimuovi l'oggetto e ponilo in prima posizione
        T o = object_list.get(object_list.indexOf(obj));
        object_list.remove(obj);
        object_list.add(o);
        
    }

    /**
     * Restituisce uno degli oggetti che fino a quel momento ha ottenuto più voti.
     * @return L'oggetto con il maggior numero di voti 
     */
    public T winner(){
        //L'oggetto con più voti sarà sempre in prima posizione
        return object_list.get(1);
    }

    public static void main(String[] args) {
        Contest<String> c = new Contest<String>();
        
        String r = "Red", b = "Blue", g = "Green";
        
        c.add(r);
        c.vote(r) ;
        c.add(b);
        c.add(g);
        c.vote(r) ;
        c.vote(b);
        
        System.out.println(c.winner());
    }
    
}
