import java.util.*;
public class Auditorium {
   private int rows, columns, freeSeats;//indicano il numero di righe e di colonne dell'auditorium e il numero di posti liberi
   private List<Seat> seats;
    
   public Auditorium(int rows, int columns , Comparator<Seat> c){
        if(rows <= 0 || columns <= 0) throw new IllegalArgumentException();
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<>();

        createAuditorium();

        Collections.sort(seats, c);
   }

   private void createAuditorium(){
       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < columns; j++) {
               seats.add(new Seat(i,j));
           }
       }
       freeSeats = rows*columns;
   }

   public Set<Seat> assignSeats(int n){
        HashSet<Seat> result = new HashSet<>();
       //Se il numero di poltrone richiesto supera il numero di poltrone libere
       if(n <= freeSeats && n != 0){
           freeSeats-= n;
            int i = 0;
            while(n > 0){
                Seat s = seats.get(i);
                if(s.isAvaiable() ){
                    result.add(s);
                    s.setAvaiable(false);
                    n--;
                }
                i++;
            }
       }
        return !result.isEmpty() ? result : Collections.emptySet();
   }

}
