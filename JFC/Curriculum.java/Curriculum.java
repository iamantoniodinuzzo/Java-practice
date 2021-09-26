import java.util.LinkedList;
import java.util.List;

public class Curriculum {
    private static List<Job> jobs ;
    private String nome;

    public Curriculum(String nome){
        this.nome = nome;
        jobs = new LinkedList<>();
    }

    public Job addJob(String descrizione, int anno_di_inizio){
        Job j = new Job(descrizione, anno_di_inizio);
        jobs.add(j);
        return j;
    }

    public static class Job  {
        private String descrizione;
        private int anno_di_inizio;
    
        public Job(String descrizione, int anno_di_inizio){
            this.descrizione = descrizione;
            this.anno_di_inizio = anno_di_inizio;
        }

        public Job next(){
            try{

                return jobs.get(jobs.indexOf(this)+1) ;

            }catch(IndexOutOfBoundsException e){
                return null;
            }
        }

        public String toString(){
            return descrizione+": "+anno_di_inizio;
        }
        
      
    }

    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Walter White");
        Curriculum.Job j1 = cv.addJob("Chimico", 1995);
        Curriculum.Job j2 = cv.addJob("Insegnante", 2005);
        Curriculum.Job j3 = cv.addJob("Cuoco", 2009);
        System.out.println(j2 .next()) ;
        System.out.println(j3 .next()) ;
    }
    
}
