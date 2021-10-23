import java.util.*;

public class SelectorIterator<T> implements Iterable<T> {
    private Collection<T> col;
    private Selector<T> selector;

    public SelectorIterator(Collection<T> collection, Selector<T> s) {
        this.col = collection;
        this.selector = s;
    }

    public Iterator<T> iterator() {
        ArrayList<T> list = new ArrayList<>(col);
        
        return new Iterator<T>() {
            private int currentIndex = 0;

            public boolean hasNext() {
                return (currentIndex < list.size()) && (list.get(currentIndex) != null);
            }

            public T next() {
                T currentElem = list.get(currentIndex++);
                if (selector.select(currentElem)) {
                    return currentElem;
                }
                return next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        Integer [] a = { 1, 2, 45, 56, 343, 22, 12, 7, 56};
        List<Integer> l = Arrays.asList(a);

        Selector<Integer> pari = new Selector<Integer>() {
            public boolean select(Integer n) {
                return (n % 2) == 0;
            }
        };
        for (Integer n: new SelectorIterator<Integer>(l, pari))
            System.out.print(n + " ");
    }
}
