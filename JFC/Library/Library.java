import java.util.*;

class Library {

    private Set<Book> library;
    private LinkedList<Book> lentBooks = new LinkedList<>();

    public Library() {
        library = new HashSet<>();
    }

    /**
     * Aggiunge un libro alla biblioteca.
     * Se il libro è già stato aggiunto , restituisce false
     *
     * @param book da aggiungere
     */
    public boolean addBook(Book book) {
        return library.add(book);
    }

    /**
     * Prende un libro come argomento e lo dà in prestito se disponibile.
     *
     * @param book libro da prestare
     * @throws Exception lanciata se il libro non è presente in biblioteca.
     */
    public boolean loanBook(Book book) throws Exception {
        if (library.contains(book) && !lentBooks.contains(book)) {
            lentBooks.addLast(book); // i libri prestati più recenti sono alla fine della lista
            return true;
        } else if (!library.contains(book)) {
            throw new Exception("Il libro non è presente in biblioteca!");
        }
        return false;
    }

    /**
     * Restituisce il libro alla biblioteca.
     *
     * @param book libro da restituire.
     * @throws Exception lanciata nel caso in cui il libro non sia stato prestato.
     */
    public void returnBook(Book book) throws Exception {
        if (lentBooks.contains(book)) {
            lentBooks.remove(book);
        }else{
        	throw new Exception("Il libro non è stato prestato!");
		}

    }

    /*
     * Stampa la lista dei libri attualmente in prestito, in ordine temporale,
     * a partire dal libro prestato da più tempo.
     */
    public void printLoans() {
		for(Book book : lentBooks){
			System.out.println(book);
		}
    }


}