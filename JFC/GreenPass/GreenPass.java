public class GreenPass {
    private static final int VALIDITA_PRIMA_DOSE = 180;
    private static final int VALIDITA = 270;
    private String soggetto;
    private int data_somministrazione;
    private boolean isFirst;

    public GreenPass(String soggetto, int data_somministrazione, boolean isFirst) {
        this.soggetto = soggetto;
        this.data_somministrazione = data_somministrazione;
        this.isFirst = isFirst;
    }

    public boolean isValidOn(int data) {
        if(isFirst){
            return (VALIDITA_PRIMA_DOSE > (data + data_somministrazione))? true : false;
        }
        return (VALIDITA > (data + data_somministrazione))? true : false;

    }

    public boolean belongsTo(Persona p) {
        return p.equals(new Persona(soggetto));
    }

    @Override
    public int hashCode() {
        return soggetto.hashCode() ^ data_somministrazione;
    }

}
