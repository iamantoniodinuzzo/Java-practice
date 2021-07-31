public class Main {

    public static void main(String[] args) {
        Book b = new Book();
        b.addChapter("Prefazione", "Sono passati pochi anni...");
        b.addChapter("Introduzione", "Un calcolatore digitale...");
        b.addChapter("Sistemi di elaborazione", "Un calcolatore...");
//                Book bb = (Book) b.clone();
        System.out.println(b.getChapterContent(1));
        System.out.println(b.getChapterTitle(2));
    }
}
