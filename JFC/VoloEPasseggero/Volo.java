import java.util.*;

public class Volo {
    private int partenza, arrivo;
    private HashSet<Passeggero> passeggeri;
    private static HashSet<Volo> voli = new HashSet<>();

    /**
     * Costruttore della classe
     * 
     * @param partenza istante di partenza
     * @param arrivo   isatante di arrivo
     */
    public Volo(int partenza, int arrivo) {
        if (partenza < 0 || arrivo < 0 || partenza >= arrivo)
            throw new IllegalArgumentException();

        this.partenza = partenza;
        this.arrivo = arrivo;
        passeggeri = new HashSet<>();
        voli.add(this);
    }

    public HashSet<Passeggero> getPasseggeri() {
        return passeggeri;
    }

    public void add(Passeggero p) {
        if (checkUbiquity(p))
            throw new RuntimeException();
        passeggeri.add(p);
    }

    public int getArrivo() {
        return arrivo;
    }

    public int getPartenza() {
        return partenza;
    }

    /**
     * Controlla se il passeggero è presente in un altro volo che si accavalla con
     * questo
     * 
     * @param p Il presunto passeggero con il dono dell'ubiquità
     * @return true se il passeggero risulta in un volo che si accavalla con questo,
     *         altrimenti false.
     */
    private boolean checkUbiquity(Passeggero p) {
        for (Volo volo : voli) {
            Set<Passeggero> passeggeri = volo.getPasseggeri();
            if (passeggeri.contains(p) && !(getPartenza() > volo.getArrivo()))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Volo v1 = new Volo(1000, 2000);
        Volo v2 = new Volo(1500, 3500);
        Volo v3 = new Volo(3000, 5000);
        Passeggero mario = new Passeggero("Mario");
        Passeggero luigi = new Passeggero("Luigi");
        v1.add(mario);
        v1.add(luigi);
        v3.add(mario);
        // La seguente istruzione provoca l ' eccezione
        v2.add(mario);
    }

}
