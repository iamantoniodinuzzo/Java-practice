
import sun.swing.CachedPainter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Book  {
	
	private LinkedList<Capitolo> capitoli;
	
	public Book(){
		capitoli = new LinkedList<>();
	}
	
	public void addChapter(String titolo, String contenuto){
		Capitolo capitolo = new Capitolo(titolo, contenuto);
		capitoli.addLast(capitolo);
	}
	
	public String getChapterTitle(int capitolo){
		int i = 1;
		for(Capitolo cap: capitoli){
			if(i == capitolo) return cap.getTitolo();
			
			i++;
		}
		return null;
	}

	public String getChapterContent(int capitolo){
		int i = 1;
		for(Capitolo cap: capitoli){
			if(i == capitolo) return cap.getContenuto();
			
			i++;
		}
		return null;
	}
	
	private class Capitolo{
		private String titolo;
		 private String contenuto;
		 
		 public Capitolo(String titolo, String contenuto){
			 
			 this.titolo = titolo;
			 this.contenuto = contenuto;
			 
		 }
		 
		 public String getTitolo(){return titolo;}
		 public String getContenuto(){return contenuto;}
		
	}
	
	
	
}