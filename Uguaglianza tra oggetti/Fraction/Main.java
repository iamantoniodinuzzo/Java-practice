public class Main {
    public static void main(String[] args) {
        Fraction a = new Fraction(12,30), b = new ReducedFraction(12,30),
                c = new Fraction(1,4), d = c.times(a);

        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        System.out.println(a.equals(b));
        System.out.println(c.times(b));
    }
}
