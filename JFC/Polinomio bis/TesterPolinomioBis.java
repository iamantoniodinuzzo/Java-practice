public class TesterPolinomioBis {
    public static void main(String[] args) {
        double a1[] = {1, 2, 0, 3};
        double a2[] = {0, 2};
        Polynomial p1 = new Polynomial(a1);
        Polynomial p2 = new Polynomial(a2);
        System.out.println(p1);
        System.out.println(p2);
        for (Pair<Integer, Double> p: p1)
            System.out.println(p. getFirst () + " : " + p.getSecond());
    }
}
