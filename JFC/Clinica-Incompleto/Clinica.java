import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Permette di prenotare e cancellare visite mediche
 */
public class Clinica {
    
    private Set<Prenotazione> mPrenotazioni = new HashSet<>();

    public void prenota(Specialista specialista, String nome_paziente){
        
        mPrenotazioni.add(new Prenotazione(specialista, nome_paziente));
    }


    public void cancellaPrenotazione(Specialista specialista, String nome_paziente ){
    
       mPrenotazioni.remove(new Prenotazione(specialista, nome_paziente));
    }

    public Collection<String> getPrenotati(Specialista specialista){
        Collection<String> filter_result = new HashSet<>();
        for (Prenotazione element : mPrenotazioni) {
            if(element.getSpecialista().equals(specialista))
                filter_result.add(element.getPazienteName());
        }

        return filter_result;
    }

    public static void main(String[] args){
        Clinica c = new Clinica();
        c.prenota(Specialista .OCULISTA, "Pippo Franco");
        c.prenota(Specialista .OCULISTA, "Leo Gullotta");
        c.prenota(Specialista .OCULISTA, "Leo Gullotta");
        c.prenota(Specialista .PEDIATRA, "Ciccio Ingrassia");
        c.prenota(Specialista .PEDIATRA, "Leo Gullotta");
        c.cancellaPrenotazione(Specialista .PEDIATRA, "Ciccio Ingrassia");
        Collection<String> ocu = c.getPrenotati(Specialista.OCULISTA);
        System.out.println(ocu);
        System.out.println(c.getPrenotati( Specialista .PEDIATRA));


    }

}
