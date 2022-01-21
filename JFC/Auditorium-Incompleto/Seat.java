public class Seat {
    public int row, col;

    public Seat(int row, int col){
        this.row = row;
        this.col = col;
    }

   

    @Override
    public String toString(){
        return "("+row+","+col+")";
    }
}
