public class Prenotazione {
    
    private Specialista mSpecialista;
    private String mNomePaziente;

    public Prenotazione(Specialista specialista, String nome_paziente){
        mSpecialista = specialista;
        mNomePaziente = nome_paziente;
    }

    public String getPazienteName(){return mNomePaziente;}
    public Specialista getSpecialista(){return mSpecialista;}


    @Override
    public boolean equals(Object o){

        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        
        Prenotazione p = (Prenotazione) o ;
        
        return (p.getPazienteName().equals(mNomePaziente) );
    }

    @Override
    public int hashCode() {
        return mNomePaziente.hashCode() ;
    }

   
    @Override
    public String toString(){
        return mNomePaziente;
    }
}
