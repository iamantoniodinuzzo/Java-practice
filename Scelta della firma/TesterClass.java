import java.util.*;

public class TesterClass {

    // Method to test
    public static <T> boolean isIncreasing(Map< ? extends T, ? extends T> m, Comparator<? super T> c){
        
        for (Map.Entry<? extends T,? extends T> entry : m.entrySet()) {
            if(c.compare(entry.getKey(), entry.getValue()) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // main

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map.put(7, 8);

        System.out.println(TesterClass.isIncreasing(map, Comparator.naturalOrder()));

    }
}