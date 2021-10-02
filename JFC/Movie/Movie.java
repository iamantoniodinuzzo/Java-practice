import java.util.HashSet;
import java.util.Set;


import java.util.List;
import java.util.ArrayList;

public class Movie {

    private String titolo;
    private int anno_di_produzione;
    private List<Movie> serie = new ArrayList<>();
    private static Set<Movie> movies = new HashSet<>();

    public Movie(String titolo, int anno_di_produzione) {
        this.anno_di_produzione = anno_di_produzione;
        this.titolo = titolo;
        movies.add(this);
    }

    public Movie(String titolo, int anno_di_produzione, Movie film_precedente) {
        this.titolo = titolo;
        this.anno_di_produzione = anno_di_produzione;
        movies.add(this);

       addToSerie(film_precedente);

    }

    private void addToSerie(Movie film_precedente){
        if(!film_precedente.getSeries().isEmpty()){//il film precedente è già un sequel
            //prelevo la serie già iniziata
            List<Movie> serie = film_precedente.getSeries();
            //aggiungo il nuovo sequel alla serie
            serie.add(this);
            //copio la serie aggiornata nel film corrente
            this.setSerie(serie);
        }else{                                  //il film precedente non fa parte di una serie, questo è il primo sequel
            //aggiungo il film precedente e corrente alla serie
            this.serie.add(film_precedente);
            this.serie.add(this);
            //aggiungo questa nuova serie al film precedente
            film_precedente.setSerie(serie);
        }
    }

    public void setSerie(List<Movie> serie) {
        this.serie = serie;
    }
   
    public List<Movie> getSeries() {
        return serie;
    }


    public static Set<Movie> selectByYear(int anno) {
        Set<Movie> movieByYear = new HashSet<>();
        for (Movie movie : movies) {
            if (movie.getAnno_di_produzione() == anno) {
                movieByYear.add(movie);
            }
        }
        return movieByYear;
    }

    public int getAnno_di_produzione() {
        return anno_di_produzione;
    }

    @Override
    public String toString() {
        return this.titolo;
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