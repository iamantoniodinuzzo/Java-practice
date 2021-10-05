import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class MakeMap {
    
    /**
     * Crea una map utilizzando due liste di pari lunghezza.
     * @param keys  La lista di elementi non duplicati che fungono da chiavi della map.
     * @param values La lista di valori della map
     * @return Una map che avrà come chiave e valore gli elementi di i-esimo posto.
     * @throws Exception Viene lanciata una DuplicateKeysException nel caso in cui
     * la lista keys abbia dei valori duplicati, altrimenti viene lanciata una 
     * DifferentListsSizesException se le due liste non hanno la stessa lunghezza.
     */
    public  <K,V> Map<K,V> makeMap(List<K> keys, List<V> values) throws Exception{
        //controllo che le liste abbiano la stessa lunghezza.
        if(keys.size() != values.size()) throw new DifferentListsSizesException();

        //Controllo che la lista keys non abbia duplicati.
        //Converto la lista in un hashset in modo da eliminare automaticamente i duplicati
        //in quanto un set non può averne.
        Set<K> set = new HashSet<K>(keys);
        //confronto quindi la lunghezza della lista e del set.
        if(set.size() < keys.size()){
            /* ci sono duplicati */
            throw new DuplicateKeysException();
        }

        //Se sono a questo passaggio i prerequisiti sono soddisfatti.
        //Procedo alla creazione della Map
        //Converto le liste in ArrayList in modo da avere una complessità costante 
        //con l'accesso posizionale.
        ArrayList<K> keys_al = new ArrayList<>(keys);
        ArrayList<V> values_al = new ArrayList<>(values);
        Map<K,V> result = new HashMap<>();

        for(int i = 0 ; i < keys_al.size(); i++ ){
            result.put(keys_al.get(i), values_al.get(i));
        }
        
        return result;
    }

    private class DuplicateKeysException extends Exception{}
    private class DifferentListsSizesException extends Exception{}

    public static void main(String[] args) {
        MakeMap myclass = new MakeMap();

        LinkedList<String> keys = new LinkedList<>();
        keys.add("Uno");
        keys.add("Due");
        keys.add("Tre");
        keys.add("Quattro");


        LinkedList<Integer> values = new LinkedList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);


        try {
            System.out.println(myclass.makeMap(keys, values));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
