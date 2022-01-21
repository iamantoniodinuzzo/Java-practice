package Range;
public class TestRange {
    public static void main(String[] args) {
        Range<Integer> a = new Range<>(10, 20);
        System.out.println(a. isInside (10)) ;
        System.out.println(a. isInside (50)) ;
        
        Range<String> b = new Range<>("albero", "dirupo"),
                        c = new Range<>("casa", "catrame");

        
        System.out.println(b.isOverlapping(c)) ;
        
        //Range<Object> d = new Range<>(); // errore di compilazione
    }
}
