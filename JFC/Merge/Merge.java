import java.util.LinkedList;
import java.util.List;

public class Merge {
    
    /**
     * 
     * @param <T>
     * @param l1
     * @param l2
     * @return
     */
    public static  <T> List<T> merge(LinkedList<T> l1, LinkedList<T> l2){

        if(l1.size() != l2.size()) throw new IllegalArgumentException();
        
        int size = l1.size(),i = 0;
        List<T> alternateConcaList = new LinkedList<>();

        while (i < size) {
           alternateConcaList.add(l1.get(i));
           alternateConcaList.add(l2.get(i));
           i++;

        }

        return alternateConcaList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(6);

        System.out.println(merge(l1, l2));

    }
}
