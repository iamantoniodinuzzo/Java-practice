public class Main {
    public static void main(String[] args) {
        BinRel<String> rel = new BinRel<>();
        rel .addPair("a", "albero");
        rel .addPair("a", "amaca");
        System.out.println( rel .isSymmetric());
        rel .addPair("albero", "a");
        rel .addPair("amaca", "a");
        System.out.println( rel .isSymmetric());
        System.out.println( rel .areRelated("a", "amaca"));
    }
}
