public class TesterBoundedSet {
    public static void main(String[] args) {
        BoundedSet<Integer> s = new BoundedSet<Integer>(3);
        s .add(3); s .add(8); s .add(5); s .add(5);
        System.out.println(s . size ()) ;
        System.out.println(s .contains(3)) ;
        s .add(14);
        System.out.println(s . size ()) ;
        System.out.println(s .contains(3)) ;
    }
}
