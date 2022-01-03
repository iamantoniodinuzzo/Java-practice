public class Runner {
    public static void main(String[] args) {
        Recipe r = new Recipe("Spaghetti aglio e olio");
        r .addIngr(100, "grammi di spaghetti");
        r .addIngr(2, "cucchiai d' olio d' oliva");
        r .addIngr(1, "spicchi d' aglio");
        r .addIngr(0, "sale");
        r .setDescr("Mischiare tutti gli  ingredienti  e servire .");
        System.out.println(r .toString(4)) ;
    }
}
