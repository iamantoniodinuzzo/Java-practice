public class Test {
    public static void main(String[] args) {
        AgeBonus a = new AgeBonus(5);
        AgeBonus b = new AgeBonus(3);

        a.start();
        b.start();
       System.out.println( a.getList());
       System.out.println( b.getList());



    }
}
