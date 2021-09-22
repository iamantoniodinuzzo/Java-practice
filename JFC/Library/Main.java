public class Main {
    public static void main(String args[]) {
        Library lib = new Library();
        Book a = new Book("a"), b = new Book("b"), c = new Book(
                "c");
        System.out.println(lib.addBook(a));
        System.out.println(lib.addBook(b));
        System.out.println(lib.addBook(c));
        System.out.println(lib.addBook(a));
        try {
            System.out.println(lib.loanBook(b));
            System.out.println(lib.loanBook(a));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        lib.printLoans();
    }
}
