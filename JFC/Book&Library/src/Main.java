import java.util.Set;

public class Main {

    public static void main(String args[]){
        Library casa = new Library(), ufficio = new Library();
        Library.Book b1 = casa.addBook("Esercizi di stile", "Queneau");
        b1.addTag("letteratura");
        b1.addTag("umorismo");
        Library.Book b2 = casa.addBook("Me parlare bene un giorno", "Sedaris");
        b2.addTag("umorismo");
        Library.Book b3 = ufficio.addBook("Literate programming", "Knuth");
        b3.addTag("programmazione");
        Set<Library.Book> humorCasa = casa.getBooksByTag("umorismo");
        System.out.println(humorCasa);
        Set<Library.Book> humorUfficio = ufficio.getBooksByTag("umorismo");
        System.out.println(humorUfficio);
    }
}
