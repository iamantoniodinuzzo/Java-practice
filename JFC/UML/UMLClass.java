import java.util.*;

public class UMLClass {
    private HashMap<String, HashSet<UMLAggregation>> aggregations;
    private String titolo;

    public UMLClass(String nome) {
        this.titolo = nome;
        aggregations = new HashMap<>();
    }

    public void addAggregation(UMLAggregation aggregation) {

        addValues(titolo, aggregation);
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        String result = "Classe: " + this.titolo + "\nAggregazioni:\n";
        for (Map.Entry<String, HashSet<UMLAggregation>> entry : aggregations.entrySet()) {
            for (UMLAggregation umlAggregation : entry.getValue()) {
                result += umlAggregation.toString()+"\n";

            }
        }

        return result;
    }

    @Override
    public int hashCode() {
        return titolo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof UMLClass)) return false;

        UMLClass umlClass = (UMLClass) obj;

        return this.titolo.equals(umlClass.getTitolo());
    }

    /**
     * Permette di aggiungere valori duplicati ad un'unica chiave.
     * 
     * @param key
     * @param value
     */
    private void addValues(String key, UMLAggregation value) {
        HashSet<UMLAggregation> tempList = null;
        // Se la map contiene la chiave
        if (aggregations.containsKey(key)) {
            // allora prelevo la lista di valori associata alla chiave e la aggiungo alla
            // lista temporanea
            tempList = aggregations.get(key);
            // se la lista temporanea risulta null
            if (tempList == null)
                // allora la istanzio
                tempList = new HashSet<>();
            // altrimenti aggiungo il nuovo valore
            tempList.add(value);
            // altrimenti se la lista non contiene la chiave
        } else {
            // istanzion la nuova lista temporanea
            tempList = new HashSet<>();
            // aggiungo il nuovo valore
            tempList.add(value);
        }
        // aggiorno la map con la nuova lista di valori aggiornata
        aggregations.put(key, tempList);
    }

    public static void main(String[] args) {
        UMLClass impianto = new UMLClass("Impianto");
        UMLClass apparecchio = new UMLClass("Apparecchio");
        UMLClass contatore = new UMLClass("Contatore");
        new UMLAggregation(apparecchio, impianto, 1, 1);
        new UMLAggregation(impianto, apparecchio, 0, UMLAggregation.INFINITY);
        new UMLAggregation(impianto, contatore, 0, 1);
        System.out.println(impianto);
    }

}
