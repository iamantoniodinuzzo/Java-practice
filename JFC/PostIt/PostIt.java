import java.util.*;

public class PostIt {
    private Object surface;
    private String text;
    private static Map<Object,List<PostIt>> messages = new HashMap<>(); 
    private static ArrayList<PostIt> l ;

    public PostIt(Object surface, String text) {
       //controllo se è già presente l'oggetto, altrimenti creo la lista
       if(messages.get(surface) == null)
        l = new ArrayList<>();
    
        //creo PostIt
        this.surface = surface;
        this.text = text;
        //aggiungo PostIt alla lista dell'oggetto
        l.add(this);
        //inserisco la surface e la nuova lista della mappa
        messages.put(surface, l);
    }

    public static List<PostIt> getMessages(Object surface) {
        return messages.get(surface);
    }

    @Override
    public String toString() {
        return text;
    }

    public static void main(String[] args) {
        Object frigorifero = new Object();
        Object libro = new Object();
        new PostIt(frigorifero, "comprare il latte");
        new PostIt(libro, "Bello !! ");
        new PostIt(libro, "restituire  a Carlo");
        List<PostIt> pl = PostIt.getMessages(libro);
        for (PostIt p : pl)
            System.out.println(p);
    }

}