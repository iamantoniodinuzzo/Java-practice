import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocialUser  {
    private String name;
    private List<Post> posts;

    public SocialUser(String name){
        this.name = name;
        posts = new LinkedList<>();
    }

    public Post newPost(String text){
        Post post = new Post(this, text);
        posts.add(post);

        return post;
    }

    public String getName(){return name;}
    public List<Post> getPosts(){return posts;}

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof SocialUser)) return false;

        SocialUser u = (SocialUser) obj;

        return u.getName().equalsIgnoreCase(getName());
    }

    public static class Post{
        private SocialUser author;
        private String text;
        private Set<SocialUser> tags;
        //TODO: Non estrae la string acompresa tra la @ e lo spazio
        private String regex = "\\@(.*?)\s";//capturing group between @ and space

        public Post(SocialUser author, String text){
            this.author = author;
            this.text = text;
            tags = new HashSet<>();

            findTags();
        }

        public SocialUser getAuthor(){return author;}

        public Set<SocialUser> getTagged(){return tags;}

        private void findTags(){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()){
                tags.add(new SocialUser(matcher.group()));
            }
        }

    
    }

    
    public static void main(String args[]){
        SocialUser adriana = new SocialUser("Adriana"),
                    barbara = new SocialUser("Barbara");
        SocialUser.Post p = adriana.newPost("Ecco una foto con @Barbara e @Carla.");
        Set<SocialUser> tagged = p.getTagged();
        System.out.println(tagged);
        System.out.println(tagged. iterator () .next() == barbara);
        System.out.println(p.getAuthor());
    }

   

    
    
}
