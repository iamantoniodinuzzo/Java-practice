import java.util.*;
public class TesterAuditorium {
    public static void main(String[] args) {
        Auditorium a = new Auditorium(5, 5, new Comparator<Seat>() {
            public int compare(Seat a, Seat b) {
            return (a.row==b.row)? (a.col-b.col): (a.row-b.row);
            }
            });
            Set<Seat> s = a.assignSeats(4);
            System.out.println(s) ;
            Set<Seat> s2 = a.assignSeats(4);
            System.out.println(s2) ;

    }
}
