public class Seat {
    public final int row, col;//indicano le cordinate della seduta
    private boolean avaiable;

    public Seat(int row, int column){
        if(row <0 || column < 0) throw new IllegalArgumentException();
        this.col = column;
        this.row = row;
        avaiable = true;
    }

    public int getColumn() {
        return col;
    }
    public int getRow() {
        return row;
    }

    public boolean isAvaiable() {
        return avaiable;
    }
    
    public void setAvaiable(boolean avaiable) {
        this.avaiable = avaiable;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Seat)) return false;

        Seat s = (Seat) obj;

        return row == s.getRow() && col == s.getColumn();
    }

    @Override
    public int hashCode(){
        int result = Integer.hashCode(row);

        return 31 * Integer.hashCode(col) + result;
    }

    @Override
    public String toString(){
        return "("+row+","+col+")";
    }


}
