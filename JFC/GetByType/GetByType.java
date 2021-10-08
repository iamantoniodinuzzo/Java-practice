import java.util.HashSet;
import java.util.Collection;



public class GetByType {
    

    /**
     * Data una collezione c (Collection) ed un oggetto x di tipo Class, restituisce un oggetto della collezione il cui tipo effettivo sia esattamente x.
     * Se un tale oggetto non esiste, il metodo restituisce null.
     * @param <T>
     * @param c
     * @param x
     * @return Un oggetto della collezione il cui tipo effettivo sia esattamente x
     */
    public static <T> T getByType(Collection<? extends T> c , final Class<?> x){
        for (T element : c) {
            if(element.getClass() == x){
                return element;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Collection<Object> set = new HashSet<>();
        set.add(1);
        set.add("Ciao");
        set.add(2.0);

        System.out.print(GetByType.getByType(set, String.class));
    }
}
