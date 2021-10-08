import java.util.HashSet;

public class Tutor {
    private HashSet<Detector> detectors ;

    public Tutor(){
        detectors = new HashSet<>();
    }

    public void addDetector(int posizione_km){
        detectors.add(new Detector(posizione_km));
    }

    public class Detector {

        private Integer posizione;
        private HashSet<Car> car_passed;

        public Detector(int posizione){
            this.posizione = posizione;
            car_passed = new HashSet<>();
        }
    
        public int carPasses(String targa, int secondi){
            car_passed.add(new Car(targa, secondi));
        }

        @Override
        public boolean equals(Object obj){
            if (!(obj instanceof Detector)) return false;

            Detector d = (Detector) obj;
            
            return this.posizione == obj.getPosizione(); 

        }

        @Override
        public int hashCode(){
            return this.posizione.hashCode();
        }

        public int getPosizione() {
            return posizione;
        }
    }

    private class Car{
        private String targa;
        private int secondi;

        public Car(String targa, int secondi){
            this.targa = targa;
            this.secondi = secondi;
        }
    }
    
}
