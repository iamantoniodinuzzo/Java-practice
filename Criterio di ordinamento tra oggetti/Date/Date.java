import java.util.Comparator;

public class Date implements Comparator<Date>{
    private int giorno, mese, anno;


    public Date(int giorno, int mese, int anno){
        if(!isValidDate(giorno) && !isValidDate(mese)) throw new IllegalArgumentException();
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    private boolean isValidDate(int d){
        return ((d >= 1) && (d <= 12));
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Date))
            return false;

        Date date = (Date) obj;

        return (this.giorno == date.getGiorno()) && (this.mese == date.getMese()) && (this.anno == date.getAnno());
    }

    public int getAnno() {
        return anno;
    }

    public int getGiorno() {
        return giorno;
    }

    public int getMese() {
        return mese;
    }

    public int compare(Date a, Date b){
        if((a.getAnno() < b.getAnno() || a.getMese() == b.getMese() || a.getGiorno() == b.getGiorno()) ||
                 ((a.getMese() >= 1 && a.getMese()<= 6)) && (b.getMese()>= 7 && b.getMese()<= 12)){
            return -1;
        }else if ((a.getAnno() > b.getAnno() || a.getMese() != b.getMese() || a.getGiorno() != b.getGiorno()) || 
                        ((a.getMese()>= 7 && a.getMese() <=12) && (b.getMese()>= 1 && b.getMese()<= 6))){ 
            return 1;
        }
        return 0;
    }

}
