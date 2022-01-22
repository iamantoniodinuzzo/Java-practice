import java.util.*;
public class Relation<S, T> {

    private Map<S, ArrayList<T>> relations;

    public Relation() {
        relations = new HashMap<>();
    }

    /**
     * Aggiunge una coppia di oggetti alla relazione.
     */
    public void put(S key, T value) {
        addValues(key, value);
    }

    /** rimuove una coppia di oggetti dalla relazione */
    public void remove(S key, T value) {
        removeValues(key, value);
    }

    /**
     * accetta un oggetto x di tipo S e restituisce l'insieme degli oggetti di tipo
     * T che sono in relazione con x.
     */
    public Set<T> image(S x) {
        HashSet<T> result = new HashSet<>();
        for (Map.Entry<S, ArrayList<T>> entry : relations.entrySet()) {
            if (entry.getKey().equals(x))
                result.addAll(entry.getValue());
        }
        return result;

    }

    /**
     * accetta un oggetto x di tipo T e restituisce l'insieme degli oggetti di tipo
     * S che sono in relazione con x.
     */
    public Set<S> preImage(T x) {
        HashSet<S> result = new HashSet<>();
        for (Map.Entry<S, ArrayList<T>> entry : relations.entrySet()) {
            if (entry.getValue().contains(x))
                result.add(entry.getKey());
        }
        return result;

    }

    /**
     * Permette di aggiungere valori duplicati ad un'unica chiave.
     * @param key
     * @param value
     */
    private void addValues(S key, T value) {
        ArrayList<T> tempList = null;
        //Se la map contiene la chiave
        if (relations.containsKey(key)) {
            //allora prelevo la lista di valori associata alla chiave e la aggiungo alla lista temporanea
            tempList = relations.get(key);
            //se la lista temporanea risulta null
            if (tempList == null)
            //allora la istanzio
                tempList = new ArrayList<>();
            //altrimenti aggiungo il nuovo valore
            tempList.add(value);
        //altrimenti se la lista non contiene la chiave
        } else {
            //istanzion la nuova lista temporanea
            tempList = new ArrayList<>();
            //aggiungo il nuovo valore
            tempList.add(value);
        }
        //aggiorno la map con la nuova lista di valori aggiornata
        relations.put(key, tempList);
    }

    /**
     * Permette di rimuovere un determinato valore o una chiave dalla map
     * @param key
     * @param value
     */
    private void removeValues(S key, T value){
        //Si itera sull'intera mappa
        for (Map.Entry<S,ArrayList<T>> entry : relations.entrySet()) {
            //Se l'entry ha la chiave corrispondente al valore che vogliamo rimuovere
            if(entry.getKey().equals(key)){
                //allora rimuovo il valore dall'arrayList di valori associato a quella chiave
                entry.getValue().remove(value);
                //inoltre se l'arrayList di valori associato a quella chiave è vuoto dopo la rimozione
                if(entry.getValue().isEmpty())
                //allora procedo nel rimuovere dalla map anche quella chiave
                    relations.remove(key);
            }
        }
    }

    public static void main(String[] args) {
        Relation<Integer, String> r = new Relation<Integer, String>();
        r.put(0, "a");
        r.put(0, "b");
        r.put(0, "c");
        r.put(1, "b");
        r.put(2, "c");
        r.remove(0, "a");

        Set<String> set0 = r.image(0);
        Set<Integer> setb = r.preImage("b");

        System.out.println(set0);
        System.out.println(setb);
    }

}