import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SelectKeys{
   
    public static <K> List<K> selectKeys(List<? extends K> l, Map<? extends K,?> m){
        ArrayList<K> keys = new ArrayList<>();

        for (K key : l) {
            if(m.containsKey(key))
                keys.add(key);
        }
        return keys;
        
    }

    public static void main(String[] args) {
        List<String> nomi = new LinkedList<>();

        nomi.add("Uno");
        nomi.add("Due");
        nomi.add("Tre");
        nomi.add("Quattro");
        nomi.add("Cinque");

        Map<String, Integer> map = new HashMap<>();

        map.put("Quattro", 4);
        map.put("Tre", 3);
        map.put("Cinque", 5);
        map.put("Uno",1);
        map.put("Otto",8);

        System.out.println(selectKeys(nomi, map));



    }
}