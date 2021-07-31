public class Main {
    public static void main(String[] args) {
        Apparecchio tv = new Apparecchio(150);
        Apparecchio radio = new Apparecchio(30);
        Impianto i = new Impianto(3000);
        i . collega (tv) ;
        i . collega (radio) ;
        System.out.println( i .potenza());
        tv.on();
        System.out.println( i .potenza());
        radio.on();
        System.out.println( i .potenza());
    }
}
