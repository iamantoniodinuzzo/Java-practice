import java.util.*;
/**
 * Rappresenta una borsa valori
 */
public class Exchange {
    private Set<Titolo> titoli;

    public Exchange(){
        this.titoli = new HashSet<>();
    }

    public synchronized void setPrice(String nome, double valore){
        Titolo newTitolo = new Titolo(Objects.requireNonNull(nome), Objects.requireNonNull(valore));

        if(titoli.contains(newTitolo)){
            for (Titolo titolo : titoli) {
                if(titolo.equals(newTitolo))
                    titolo.setValore(valore);
            }
        }else{
            titoli.add(newTitolo);
        }
    }

    public synchronized void addLowAlert(String titleName, double low_limit, Runnable r){
        Titolo t = findTitle(Objects.requireNonNull(titleName)).orElseThrow( IllegalArgumentException::new);
        t.addLowAlert(Objects.requireNonNull(low_limit),Objects.requireNonNull(r) );
    }

    public synchronized void addHighAlert(String titleName, double high_limit, Runnable r){
        Titolo t = findTitle(Objects.requireNonNull(titleName)).orElseThrow(IllegalArgumentException::new);
        t.addHighAlert(Objects.requireNonNull(high_limit),Objects.requireNonNull(r));
    }

    private Optional<Titolo> findTitle(String title){
        for (Titolo titolo : titoli) {
            if(titolo.getNome().equals(title))
                return Optional.of(titolo);
        }
        return Optional.empty();
    }

    public String toString(){
        return titoli.toString();
    }


    /**
     * Un titolo di borsa rappresentato da un nome e un valore
     */
    private class Titolo{
        private final String nome; 
        private double valore;
        private Map<Double, Runnable> highAlerts;
        private Map<Double, Runnable> lowAlerts;

        public Titolo(String nome, double valore){
            highAlerts = new HashMap<>();
            lowAlerts = new HashMap<>();

            this.nome = nome;
            this.valore = valore;
        }

        public void addLowAlert(Double lowValue, Runnable r){
            lowAlerts.put(lowValue, r);
        }

        public void addHighAlert(Double highValue, Runnable r){
            highAlerts.put(highValue, r);
        }

        public String getNome() {
            return nome;
        }
        public double getValore() {
            return valore;
        }

        public synchronized void setValore(double valore) {
            //controlla se il valore supera o è uguale a qualche limite
            for(Map.Entry<Double, Runnable> element : highAlerts.entrySet()){
                Runnable r = element.getValue();
                Double limit = element.getKey();
                if(valore >= limit){
                    Thread t = new Thread(r);
                    t.run();
                }
            }
            for(Map.Entry<Double, Runnable> element : lowAlerts.entrySet()){
                Runnable r = element.getValue();
                Double limit = element.getKey();
                if(valore <= limit){
                    Thread t = new Thread(r);
                    t.run();
                }
            }
            this.valore = valore;
        }

        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Titolo)) return false;

            Titolo t = (Titolo) obj;

            return nome.equals(t.getNome());
        }

        @Override
        public int hashCode(){
            return nome.hashCode();
        }

        public String toString(){
            return "Nome: "+nome+" Valore: "+valore;
        }

        

    }

  

   
}
