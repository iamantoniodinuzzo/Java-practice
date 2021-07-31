public class Main {
    public static void main(String args[]){
        SafeSet<String> a = new SafeSet<>();
        System.out.println(a.add("ciao"));
        System.out.println(a.add("mondo"));
        System.out.println(a.remove("ciao"));
        System.out.println(a.contains("ciao")) ;
        System.out.println(a.remove("ciao"));
        System.out.println(a.contains("ciao")) ;
    }
}
