public class Driver {
    public static void main(String[] args) {
        Color rosso = Color.RED;
        Color giallo = Color.make(255, 255, 0);
        Color verde = Color.make(0, 255, 0);
        System.out.println(rosso) ;
        System.out.println( giallo ) ;
        System.out.println(verde);
        System.out.println(verde == Color.GREEN);
    }
}
