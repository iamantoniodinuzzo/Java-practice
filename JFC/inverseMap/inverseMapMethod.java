import java.lang.invoke.StringConcatException;
import java.util.HashMap;
import java.util.Map;

public class inverseMapMethod {
    
     static <K,V> Map<K,V> inverseMap(Map < V, K> m){
        Map<K,V> invertedMap = new HashMap<>();

        for (Map.Entry<V, K> entry : m.entrySet()) {
            invertedMap.put(entry.getValue(),entry.getKey());
        }

    return invertedMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("Uno","1");
        map.put("Due","2");
        map.put("Tre","3");
        map.put("Quattro","4");

        System.out.println(map);
        System.out.println(inverseMap(map));
        System.out.println(map);

        


    }
}
