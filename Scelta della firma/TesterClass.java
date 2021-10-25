import java.util.*;

public class TesterClass {

    // Method to test
    public static <T> T findNext(Collection<? extends T> coll, Comparator<? super T> comp, T x){
        final ArrayList<T> list = new ArrayList<>(coll);
        Collections.sort(list, comp);

        return (comp.compare(list.get(0), x) > 0)? list.get(0): null;

    }

       public static void main(String[] args) {
      
        ArrayList<Integer> coll = new ArrayList<>();
        coll.add(1);
        coll.add(2);
        coll.add(0);
        coll.add(16);

        Comparator<Integer> comp = new Comparator<>(){
            @Override
            public int compare(Integer i1, Integer i2){
                if(i1 % 2 == 0 || i2 % 2 == 0){
                    if(i1 % 2 == 0){
                        return 1;
                    }

                    if(i2 % 2 == 0){
                        return -1;
                    }
                }
                return 0;
            }
        };


    }
}