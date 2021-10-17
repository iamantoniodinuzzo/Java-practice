import java.util.*;

public class TesterClass {

    // Method to test
    public static <T> T gLB(Set<? extends T> a, Set<? extends T> b, Comparator<? super T> c) {

        // Converto entrambi gli insiemi in ArrayList in modo da poter ordinare con il
        // metodo sort
        ArrayList<T> a_rray = new ArrayList<>(a);
        ArrayList<T> b_rray = new ArrayList<>(b);
        Collections.sort(a_rray, c);
        Collections.sort(b_rray, c);
        // Prelevo l'ultimo elemento di a_rray e b_rray (i più grandi)
        T bigger_a = a_rray.get(a_rray.size() - 1);
        T bigger_b = b_rray.get(b_rray.size() - 1);
        // Se i due bigger sono uguali, li rimuovo dalla lista e recupero di nuovo
        // l'ultimo elemento
        if (c.compare(bigger_a, bigger_b) == 0) {
            a_rray.remove(bigger_a);
            bigger_a = a_rray.get(a_rray.size() - 1);
            b_rray.remove(bigger_b);
            bigger_b = b_rray.get(b_rray.size() - 1);
        }
        // Se bigger_b è maggiore di bigger_a, restiuisco bigger_a altrimenti null
        if (c.compare(bigger_a, bigger_b) < 0)
            return bigger_a;

        return null;

    }

    public static void main(String[] args) {
        // main

        HashSet<Integer> i1 = new HashSet<>(Arrays.asList(5, 20, 30));
        HashSet<Integer> i2 = new HashSet<>(Arrays.asList(25, 26, 30));

        System.out.println(gLB(i1, i2, Comparator.naturalOrder()));

    }
}