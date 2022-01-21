import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class Auditorium {
    private int num_file, posti_x_fila;
    private Comparator<? super Seat> comparator;
    private Set<Seat> auditorium;

    public Auditorium(int num_file, int posti_x_fila, Comparator<? super Seat> comparator) {
        this.num_file = num_file;
        this.posti_x_fila = posti_x_fila;
        this.comparator = comparator;
        // creation of auditorium
        createAuditorium();
    }

    public Set<Seat> assignSeats(int n_posti_richiesti) {
        Set<Seat> bestSeats = new HashSet<>();
        for (Seat seatA : auditorium) {
                for (Seat seatB : auditorium) {
                    if (comparator.compare(seatA, seatB) >= 0 && n_posti_richiesti >= 0)
                        bestSeats.add(seatA);
                    n_posti_richiesti--;
                
                }
        }
        return bestSeats;
    }

    private void createAuditorium() {
        auditorium = new HashSet<>();
        for (int fila = 0; fila < num_file; fila++) {
            for (int posto = 0; posto < posti_x_fila; posto++) {
                auditorium.add(new Seat(fila, posto));
            }
        }
    }


   
}
