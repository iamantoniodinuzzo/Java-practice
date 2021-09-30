import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;



public class Movie{

    private String titolo;
    private int anno_di_produzione;
    private Serie serie ;
    private static Set<Movie> movies = new HashSet<>();
    
    public Movie(String titolo, int anno_di_produzione){
        this.anno_di_produzione = anno_di_produzione;
        this.titolo = titolo;
        movies.add(this);
    }

    public Movie(String titolo, int anno_di_produzione, Movie film_precedente){
        this.titolo = titolo;
        this.anno_di_produzione = anno_di_produzione;
        movies.add(this);

        if(serie == null){
            serie = new Serie();
            serie.addToSerie(film_precedente);
            serie.addToSerie(this);
        }else{
            //TODO: come aggiungere un film ad una serie già iniziata?
        }
        
    }

    public List<Movie> getSeries(){
        return this.serie.getFilm();
    }

    public Serie getSerie() {
        return serie;
    }

    public static Set<Movie> selectByYear(int anno){
        Set<Movie> movieByYear = new HashSet<>();
        for (Movie movie : movies) {
            if(movie.getAnno_di_produzione() == anno){
                movieByYear.add(movie);
            }
        }
        return movieByYear;
    }

    public int getAnno_di_produzione() {
        return anno_di_produzione;
    }

    @Override
    public String toString(){
        return this.titolo;
    }

    private class Serie{
        private List<Movie> film;

        public Serie(){
            film = new ArrayList<>();
        }

        public void addToSerie(Movie movie){
            film.add(movie);
        }

    public List<Movie> getFilm() {
        return film;
    }

    }
    public static void main(String[] args) {
        Movie r1 = new Movie("Rocky", 1976);
        Movie r2 = new Movie("Rocky II", 1979, r1);
        Movie r3 = new Movie("Rocky III", 1982, r2);
        Movie f = new Movie("Apocalypse Now", 1979);
        Set<Movie> movies1979 = Movie.selectByYear(1979);
        System.out.println(movies1979);
        List<Movie> rockys = r2.getSeries();
        System.out.println(rockys);
    }

}