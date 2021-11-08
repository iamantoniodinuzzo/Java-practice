import java.util.*;

public class PostIt {
    private Object surface;
    private String text;
    private static ArrayList<PostIt> allPostIt = new ArrayList<>();

    public PostIt(Object surface, String text) {
        this.surface = Objects.requireNonNull(surface);
        this.text = Objects.requireNonNull(text);
        allPostIt.add(this);
    }

    public static List<PostIt> getMessages(Object surface) {
        List<PostIt> result = new ArrayList<>();
        for (PostIt postIt : allPostIt) {
            if (postIt.getSurface().equals(surface))
                result.add(postIt);
        }
        return result;
    }

    public Object getSurface() {
        return surface;
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