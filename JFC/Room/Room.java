import java.util.zip.DataFormatException;
import java.util.TreeSet;

class Room{

    private TreeSet<Reservation> t = new TreeSet<>();

	/**
	*@param nome Il nome per la prenotazione della stanza
	*@param data_inizio La data dio inizio prenotazione, un intero compreso tra 0 e 365
	*@param data_fine La data di fine prenotazione, un intero compreso tra 0 e 365
	*@return La prenotazione
	*@throws RuntimeException lanciata se una delle camere è occupata
	*/
	public Reservation reserve(String nome, int data_inizio, int data_fine){
		
		Reservation r=new Reservation(nome,data_inizio,data_fine);
              if(r.contenuto(t,r)){
				  throw new RuntimeException("Elemento già presente con Nome: "
											+r.nome_cliente
											+ " Data Inizio:" +
											r.data_inizio);
				}
              t.add(r);
              return r;
		
		
	}
	
	public TreeSet<Reservation> getReservations(){
        return t;
    }
	
	
	
	
}