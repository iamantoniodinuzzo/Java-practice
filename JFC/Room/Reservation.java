class Reservation implements Comparable<Reservation>{
	
	String nome_cliente;
       int data_inizio,data_fine;

       public Reservation(String nome_cliente,int data_inizio, int data_fine) {
              this.nome_cliente = nome_cliente;
              this.data_inizio = data_inizio;
              this.data_fine = data_fine;
       }
       public String getName() {
              return this.nome_cliente;
       }


       public boolean contenuto(TreeSet<Reservation> t,Reservation r){
              for(Reservation r1:t){
                     if((r.data_inizio>=r1.data_inizio && r.data_inizio<r1.data_fine) || (r.data_fine>r1.data_inizio && r.data_fine<=r1.data_fine) || (r.data_inizio<r1.data_inizio && r.data_fine>=r1.data_fine)) return true;
              }
              return false;
       }

       @Override
       public int compareTo(Reservation r){
              if(this.data_inizio>r.data_inizio) return 1;
              if(this.data_inizio<r.data_inizio) return -1;
              return 0;
       }
	
	
	
}