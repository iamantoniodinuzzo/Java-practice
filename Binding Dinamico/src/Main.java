public class Main {
    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        A alfa = gamma;
        System.out.println( alfa . f (null, gamma));
//        System.out.println(beta. f (gamma, gamma));
        System.out.println(gamma.f(gamma, alfa));
        System.out.println(gamma.f(beta, beta));
        System.out.println(1 + "1");
    }
}
