import java.util.*;

public class Tutor {
    private static Map<String, Integer> carsMap;
    private static TreeSet<Detector> detectors;

    public Tutor() {
        this.carsMap = new HashMap<>();
        this.detectors = new TreeSet<>(Detector.compareByKm);
    }

    static class Detector {

        private Integer km;
        private Car car_passed;

        public Detector(Integer posizione) {
            if (posizione < 0)
                throw new IllegalArgumentException("La posizione no può essere negativa!");
            this.km = posizione;
            this.car_passed = null;
        }

        /**
         * Rappresenta il passaggio di un veicolo davanti a questo sensore
         * 
         * @param targa
         * @param secondi
         * @return Stima della velocità del veicolo, basata anche sui sensori che lo
         *         precedono. Tale metodo restituisce -1 se il sensore non ha
         *         sufficienti informazioni per stabilire la velocità.
         */
        public int carPasses(String targa, int secondi) {
            this.car_passed = new Car(targa, secondi);

            Integer prev = carsMap.put(targa, secondi);// Se la mappa conteneva un valore con la stessa chiave
                                                       // allora quella nuova chiave avrà il nuovo valore specificato
                                                       // e il metodo ritornerà il vecchio valore
            if (prev == null) {
                return -1;
            } else {
                for (Detector detector : detectors) {
                    if(!(detector.getCar_passed() != null && detector.getCar_passed().equals(car_passed))){
                        break;
                    }else{
                        return (Math.abs(this.km - detector.getKm()) * 3600) / secondi;
                    }
                }
            }
            return (Math.abs(this.km - prev) * 3600) / secondi;
        }

        public static final Comparator<Detector> compareByKm = new Comparator<>() {
            @Override
            public int compare(Detector d1, Detector d2) {
                return d1.getKm() - d2.getKm();
            }
        };

        public Integer getKm() {
            return km;
        }

        public Car getCar_passed() {
            return car_passed;
        }

        private class Car {
            private String targa;
            private int secondi;

            public Car(String targa, int secondi) {
                this.secondi = secondi;
                this.targa = targa;
            }

            public int getSecondi() {
                return secondi;
            }

            public String getTarga() {
                return targa;
            }
            @Override
            public boolean equals(Object obj) {
                if(!(obj instanceof Car)) return false;

                Car c = (Car) obj;

                return this.targa.equals(c.getTarga());
            }
        }

    }

    public Detector addDetector(int km) {
        Detector d = new Detector(km);
        detectors.add(d);
        return d;
    }

    public static void main(String[] args) {
        Tutor tang = new Tutor();
        Tutor.Detector a = tang.addDetector(2);
        Tutor.Detector b = tang.addDetector(5);
        Tutor.Detector c = tang.addDetector(9);
        // nuovo veicolo
        System.out.println(a.carPasses("NA12345", 0));
        // 3km in 1200 sec (20 minuti), quindi 9km/h
        System.out.println(b.carPasses("NA12345", 1200));
        // nuovo veicolo
        System.out.println(b.carPasses("SA00001", 1200));
        // 4km in 120 sec (2 minuti), quindi 120km/h
        System.out.println(c.carPasses("NA12345", 1320));
        // 4km in 180 sec (3 minuti), quindi 80km/h
        System.out.println(c.carPasses("SA00001", 1380));
    }

}
