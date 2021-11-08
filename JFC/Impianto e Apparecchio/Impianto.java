import java.util.ArrayList;
import java.util.List;

public class Impianto {

    protected int potenzaErogataMassima;
    private List<Apparecchio> apparecchi = new ArrayList<>();


    public Impianto(int potenza){
        this.potenzaErogataMassima = potenza;
    }

    public Impianto() {}

    public void collega(Apparecchio apparecchio){
        apparecchio.erogazioneMassima(potenzaErogataMassima);
        apparecchi.add(apparecchio);
    }

    public int potenza(){
        int potenzaAssorbitaApparecchi = 0;
        for(Apparecchio apparecchio : apparecchi){
            if (apparecchio.isOn()) {
                potenzaAssorbitaApparecchi += apparecchio.getPotenzaAssorbitaMassima();
            }
        }
        return potenzaAssorbitaApparecchi;
    }

    public static void main(String[] args) {
        Apparecchio tv = new Apparecchio(150);
        Apparecchio radio = new Apparecchio(30);
        Impianto i = new Impianto(3000);
        i . collega (tv) ;
        i . collega (radio) ;
        System.out.println( i .potenza());
        tv.on();
        System.out.println( i .potenza());
        radio.on();
        System.out.println( i .potenza());
    }


}
