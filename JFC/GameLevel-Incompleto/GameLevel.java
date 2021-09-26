import java.util.HashSet;
import java.util.Set;

public class GameLevel {
    private int larghezza, altezza;
    private Set<Wall> walls = new HashSet<>();

    public GameLevel(int larghezza, int altezza ){
        this.larghezza = larghezza;
        this.altezza = altezza;
    }
    
    /**
     * Accetta le coordinate di una casella e mette un muro in quella casella
     * @param larghezza
     * @param altezza
     */
    public void setWall(int horizontal_position, int vertical_position){
        if(horizontal_position > larghezza || vertical_position > altezza) throw new IllegalArgumentException();

        walls.add(new Wall(horizontal_position, vertical_position));
    }

    public boolean areConnected(int horizontal_c_1, int vertical_c_1, int horizontal_c_2, int vertical_c_2){

       if((horizontal_c_1 == horizontal_c_2) && (vertical_c_1 == vertical_c_2)){//sono sulla stessa casella
            return true;
       }else if(vertical_c_1 == vertical_c_2){//sono sulla stessa colonna
            int start, end;

            if(horizontal_c_1 > horizontal_c_2){
             start = horizontal_c_2;
             end = horizontal_c_1;
            }else{
                start = horizontal_c_1;
                end = horizontal_c_2;
            }

            for(int i = start; i< end; i++){
                if(walls.contains(new Wall(i, vertical_c_1))) return false;
            }
        return true;

       }else if (horizontal_c_1 == horizontal_c_2){//sono sulla stessa riga
            int start, end;

            if(vertical_c_1 > vertical_c_2){
                start = vertical_c_2;
                end = vertical_c_1;
            }else{
                start = vertical_c_1;
                end = vertical_c_2;
            }

            for(int i = start; i< end; i++){
                if(walls.contains(new Wall(i, horizontal_c_1))) return false;
            }
        return true;
       }else{
           
       }
        return false;
    }

   

    private class Wall{
        private int position_h, position_v;

        public Wall(int l, int a){
            this.position_h = l;
            this.position_v = a;
        }

        public int getHorizontalPosition(){return position_h;}
        public int getVerticalPosition(){return position_v;}

        public boolean equals(Object obj){
            if(!(obj instanceof Wall))return false;

            Wall w = (Wall) obj;

            return (this.position_h == w.getHorizontalPosition())&&(this.position_v == w.getVerticalPosition());
        }

        public int hashCode(){return position_h ^ position_v;}

    }
}
