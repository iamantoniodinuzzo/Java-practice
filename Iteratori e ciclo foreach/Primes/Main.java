public class Main {

    public static void main(String[] args) {
        for (Integer i : Primes.all){
            if (i> 20)break;
            System.out.println(i);
        }
    }
}
