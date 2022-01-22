package BoundedMap;

public class TesterBoundedMap {
    public static void main(String[] args) {
        BoundedMap<String,String> m = new BoundedMap<String,String>(2);
        m.put("NA", "Napoli");
        m.put("SA", "Salerno");
        System.err.println(m.toString());
        System.out.println(m.get("NA"));
        m.put("AV", "Avellino");
        System.out.println(m.get("SA")); 
    }
}
