
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;

class SetSmaller {

    /**
     * accetta due insiemi e un comparatore, e restituisce
     * vero se e solo se tutti gli elementi del primo insieme sono più piccoli, in base al comparatore,
     * di tutti gli elementi del secondo insieme.
     * @param collection1 La prima collezione di oggetti
     * @param collection2 La seconda collezione di oggetti
     * @param comparator Il comparatore delle due collezioni
     * @return true se e solo se tutti gli elementi del primo insieme sono più piccoli altrimenti false.
     */
    public static <T> boolean isSetSmaller(Set<T> collection1, Set<T> collection2, Comparator comparator) {
        int result = comparator.compare(collection1, collection2);
        if(result < 1){
            return true;
        }
        return false;
    }

   public static final Comparator<Set<Integer>> compareByQuantity = new Comparator<Set<Integer>>() {
       @Override
       public int compare(Set<Integer> o1, Set<Integer> o2) {
           for (Integer i: o1) {
               for (Integer j:o2) {
                   if (i > j){
                       return 1;
                   }
               }
           }
           return -1;
       }
   };

    public static void main(String args[]){
        Set<Integer> collection1 = new HashSet<>(), collection2 = new HashSet<>();
        collection1.add(1);
        collection1.add(2);
        collection1.add(3);
        collection2.add(0);
        collection2.add(5);
        collection2.add(6);

        System.out.println(SetSmaller.isSetSmaller(collection1, collection2, compareByQuantity));
    }


}


