import java.util.*;

public class TesterClass {

    // Method to test
    public static <K, V> Map<? super K, ? super V> makeMap(List<? extends K > keys, List<? extends V> values){
        Map<? super K,? super V> result = new HashMap<>();
        ArrayList<K> keyList = new ArrayList<>(keys);
        ArrayList<V> valuesList = new ArrayList<>(values);

        if(keys.size() != values.size()) 
            throw new RuntimeException("liste di lunghezza diversa");

        for(int i = 0; i < keys.size(); i++){
            result.put(keyList.get(i),valuesList.get(i));
        }

        return result;
        
    }


    public static void main(String[] args) {
        // main
        List<Integer> number = new LinkedList<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);

        List<String> name = new ArrayList<>();
        
        name.add("Uno");
        name.add("Due");
        name.add("Tre");
        name.add("Quattro");
        Map<?, ?> map = TesterClass.makeMap(number,name); 

        System.out.print(map);


        

    }
}