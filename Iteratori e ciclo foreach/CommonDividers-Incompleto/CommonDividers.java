import java.util.ArrayList;
import java.util.HashSet;

public class CommonDividers implements Iterable<Integer> {
    private int a, b, min_list_size;
    private HashSet<Integer> divisor;

    public CommonDividers(int a, int b) {
        this.a = a;
        this.b = b;

    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currentIndex = 0;

            public boolean hasNext() {

            }

            public int next() {

            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private List<Integer> findDivisor(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        //questo metodo è copiato da geeksgeeks
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {

                if (n / i == i) {
                    // list.add(i);
                
                } else { 
                // list.add(i);
                // list.add(n / i);
            }
        }
        return list;
    }

}
