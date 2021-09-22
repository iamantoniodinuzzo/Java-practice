import java.util.HashSet;
import java.util.Set;

class Bug{
	
	private String descrizione;
	private String sviluppatoreAssegnato;
	private static Set<Bug> unassigned = new HashSet<>();
	private static Set<Bug> assigned = new HashSet<>();
	
	
	
	public Bug(String descrizione){
		this.descrizione = descrizione;
		unassigned.add(this);
	}
	
	public void assignTo(String nome){
		this.sviluppatoreAssegnato = nome;
		assigned.add(this);
		unassigned.remove(this);
	}
	
	public static Set<Bug> getUnassigned(){return unassigned;}
	
	public static Set<Bug> getAssignedTo(String nome){
		
		HashSet<Bug> bugAssegnati = new HashSet<>();
		
		for(Bug bug : assigned){
			if(bug.getSviluppatoreAssegnato().equals(nome)) 
				bugAssegnati.add(bug);
		}
		return bugAssegnati;
	}
		
	public String getSviluppatoreAssegnato(){return sviluppatoreAssegnato;}
	
	@Override
	public String toString(){return "(\""+descrizione+", assigned to "+sviluppatoreAssegnato+"\")";}
	
	
	
}