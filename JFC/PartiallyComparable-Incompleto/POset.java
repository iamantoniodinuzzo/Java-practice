import java.util.*;

public class POset<T extends PartComparble> {
    private SortedSet<T> set ;

    public POset(){
        set = new TreeSet<>();
    }

    public void add(T x){
        set.add(x);
    }

    public boolean isMaximal(T x){
        //controllo se l'oggetto è nell'insieme
        //altrimenti lancio una eccezione
        if(!set.contains(x)) throw new IllegalArgumentException();

        //controllo se questo elemento è uguale all'ultimo del set
        if (set.last().equals(x)) {
            return true;
        }
    return false;

    }

    public static void main(String[] args) {
        // Stringhe, ordinate parzialmente dalla relazione di prefisso
        class POString implements PartComparable<POString> { 

            @Override
            public PartComparison compareTo(POString x) {
                
            }
        }
        POSet<POString> set = new POSet<POString>();
        set .add(new POString("architetto"));
        set .add(new POString("archimede"));
        set .add(new POString("archi"));
        set .add(new POString("bar"));
        set .add(new POString("bari"));
        System.out.println(set .isMaximal(new POString("archimede")))
        ;
        System.out.println(set .isMaximal(new POString("bar")));
        set .add(new POString("archimedeo"));
        System.out.println(set .isMaximal(new POString("archimede")))
    }
    
}