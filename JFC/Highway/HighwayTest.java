public class HighwayTest {
    public static void main(String[] args) {
        Highway h = new Highway(10);
        h.insertCar(3) ; h.insertCar(3) ; h.insertCar(5) ;
        System.out.println(h.nCars(4));
        h.progress() ;
        System.out.println(h.nCars(4));
    }
}
