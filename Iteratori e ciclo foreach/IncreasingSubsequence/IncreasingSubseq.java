import java.util.*;

public class IncreasingSubseq<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;

    public IncreasingSubseq(List<T> l) {
        this.list = l;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            private T max = list.get(0);

            
            public boolean hasNext() {
                return (currentIndex < list.size()) && (list.get(currentIndex) != null);
            }

            public T next() {
                if(currentIndex++ == 0){
                    return max;
                }else if( max.compareTo(list.get(currentIndex)) > 0 ){
                   return next();
               }
               
               max = list.get(currentIndex);
               return max;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<Integer>();
        l.add(10);
        l.add(3);
        l.add(5);
        l.add(12);
        l.add(11);
        l.add(35);
        for (Integer i : new IncreasingSubseq<Integer>(l))
            System.out.println(i);
    }

}
