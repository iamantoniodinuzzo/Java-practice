import java.util.Set;
import java.util.*;

class Library {
    private Set<Book> library = new HashSet<>();

    public Book addBook(String titolo, String autore) {
    	Book book = new Book(titolo, autore);
        library.add(book);
    	return book;
    }

    public HashSet<Book> getBooksByTag(String tag) {
        HashSet<Book> booksSameTag = new HashSet<>();
        for (Book book : library) {
			if (book.getTags().contains(tag)) booksSameTag.add(book);
        }
        return booksSameTag;
    }


    public static class Book {
        private String titolo;
        private String autore;
        private Set<String> tags = new HashSet<>();

		public Book(String titolo, String autore) {
			this.titolo = titolo;
			this.autore = autore;
		}

		public void addTag(String tag) {
            tags.add(tag.toLowerCase(Locale.ROOT));
        }

        public Set<String> getTags() {
            return tags;
        }



        @Override
        public String toString() {
            return titolo + " , by " + autore;
        }


    }


}