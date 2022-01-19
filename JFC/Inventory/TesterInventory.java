public class TesterInventory {
    public static void main(String[] args) {
        Inventory<Integer> a = new Inventory<Integer>();
        Inventory<String> b = new Inventory<String>();
        
        a.add(7); a.add(6); a.add(7); a.add(3);
        b.add("ciao"); b.add("allora?"); b.add("ciao ciao"); b.add("allora?");
        
        System.out.println(a.count(2));
        System.out.println(a.count(3));
        System.out.println(a.getMostCommon());
        System.out.println(b.getMostCommon());
    }
}
