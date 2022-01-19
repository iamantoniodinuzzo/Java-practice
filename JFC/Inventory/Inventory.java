import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory<T> {

    private List<T> inventory;

    public Inventory(){
        this.inventory = new ArrayList<>();
    }

    public void add(T x){
        inventory.add(x);
    }

    /**
     * Prende come argomento un oggetto di tipo T 
     * e restituisce il numero di oggetti uguali all'argomento 
     * presenti nell'inventario.
     * @param x
     * @return
     */
    public int count(T x){
        int counter = 0;
        for (T t : inventory) {
            if(t.equals(x)) counter++;
        }
        return counter;
    }

    /**
     * Restituisce l'oggetto di cui è presente il maggior numero di esemplari
     * @return
     */
    public T getMostCommon(){
        //Creo un'HashMap la cui chiave è un elemento T e il valore rappresenta
        //le occorrenze di quell'elemento
        HashMap<T, Integer> occurences = new HashMap<>();

        //itero su tutti i valori dell'inventario
        for (T element : inventory) {
            if(!occurences.containsKey(element)){//Se l'elemento T non è presente nelle occorrenze allora aggiungerlo
                occurences.put(element, 1);
            }else{//Se l'elemento T è presente nelle occorrenze allora incrementarne di valore
                //prendo il valore del rispettivo elemento
                int n = occurences.get(element);
                //lo incremento e lo inserisco come nuovo valore dell'elemento
                occurences.replace(element, n+1);
            }
        }

        return getMaxValue(occurences);
    }

    /**
     * Restituisce l'elemento T che ha valore maggiore (numero maggiore di occorrenze)
     * @param map
     * @return
     */
    private T getMaxValue(HashMap<T, Integer> map){
        int max_occurrences = 0;
        T result = null;
        for (Map.Entry<T, Integer> element : map.entrySet()) {
            
            if(max_occurrences < element.getValue()){
                max_occurrences = element.getValue();
                result = element.getKey();
            }
        }
        return result;
    }
}
