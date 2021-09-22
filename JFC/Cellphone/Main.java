public class Main {
    public static void main(String[] args) {
        Cellphone a = new Cellphone("TIMMY", "3341234"),
        b = new Cellphone("Megafon", "3355678"),
        c = new Cellphone("Odissey", "3384343");
        Cellphone.setCost("TIMMY", "TIMMY", 0.05);
        Cellphone.setCost("TIMMY", "Megafon", 0.15);
        Cellphone.setCost("Megafon", "TIMMY", 0.25);
        System.out.println(a.getCost(b, 10));
        System.out.println(b.getCost(a, 8)) ;
        System.out.println(a.getCost(c, 10)); // provoca eccezione
    }
    
}
