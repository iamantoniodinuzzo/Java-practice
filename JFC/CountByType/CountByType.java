import java.util.*;

public class CountByType {

    public static <T> void countByType(List<? extends T> list) {
        Map<String, Integer> map = new HashMap<>();
        for (T element : list) {
            String className = element.getClass().getName();
            if (!map.containsKey(className)) {
                map.put(className, 1);
            } else {
                int value = map.get(className);
                map.put(className, value + 1);
            }
        }

        for (Map.Entry<String, Integer> element : map.entrySet()) {
            System.out.println(element.getKey()+": "+element.getValue());
        }
    }

    public static void main(String[] args) {
        List<Number> l = new LinkedList<Number>();
        l .add(new Integer(3));
        l .add(new Double(4.0));
        l .add(new Float(7.0f));
        l .add(new Integer(11));

        countByType(l);  
    }

}