
import java.util.*;

public class Intersect {

    public static <T> Collection<T> intersect(Collection<? extends T> x, Collection<? extends T> y) {
        HashSet<T> result = new HashSet<>();

        for (T iterable_element : x) {
            if (y.contains(iterable_element))
                result.add(iterable_element);
        }
        return result;
    }

    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        HashSet<Integer> b = new HashSet<>();
        b.add(9);
        b.add(8);
        b.add(3);
        b.add(4);

        System.out.println(Intersect.intersect(a, b));

    }
}
