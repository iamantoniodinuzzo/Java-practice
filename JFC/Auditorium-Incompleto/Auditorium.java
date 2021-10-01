import java.util.HashSet;
import java.util.Comparator;
import java.util.Set;

public class Auditorium {
    private int num_file, posti_x_fila;
    private Comparator<Seat> comparator;
    private Set<Seat> auditorium;

    public Auditorium(int num_file, int posti_x_fila, Comparator<Seat> comparator) {
        this.num_file = num_file;
        this.posti_x_fila = posti_x_fila;
        this.comparator = comparator;
        // creation of auditorium
        createAuditorium();
    }

    public Set<Seat> assignSeats(int n_posti_richiesti) {
        Set<Seat> bestSeat = new HashSet<>();
        for (Seat seatA : auditorium) {
                for (Seat seatB : auditorium) {
                    if (comparator.compare(seatA, seatB) >= 0) {
                        bestSeat.add(seatA);
                    } 
                }
            
        }
        return bestSeat;
    }

    private void createAuditorium() {
        auditorium = new HashSet<>();
        for (int fila = 1; fila < num_file; fila++) {
            for (int posto = 1; posto < posti_x_fila; posto++) {
                Seat seat = new Seat();
                auditorium.add(seat);
            }
        }
    }

    public class Seat {

        public int row, col;
    
        public String toString(){
            return "("+row+","+col+")";
        }
        
    }
    
    public static void main(String[] args) {
        Auditorium a = new Auditorium(5, 5, new Comparator<Seat>() {
            public int compare(Seat a, Seat b) {
                return (a.row==b.row)? (a.col - b.col) : (a.row - b.row);
            }
        });
            Set<Seat> s = a.assignSeats(4);
            System.out.println(s) ;
    }
}
