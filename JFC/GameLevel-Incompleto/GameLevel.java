import java.util.*;

public class GameLevel {
    private HashSet<Cell> level;

    private int altezza, larghezza;

    public GameLevel(int larghezza, int altezza) {
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.level = new HashSet<>();
        createLevel();
    }

    public void setWall(int larghezza, int altezza) {
        Cell cell_wall = new Cell(larghezza, altezza);
        for (Cell cell : level) {
            if(cell.equals(cell_wall))
                cell.setWall(true);
        }
    }

    public boolean areConnected(int l_c1, int a_c1, int l_c2, int a_c2) {
        return false;
    }

    private void createLevel() {
        for (int i = 0; i < larghezza; i++) {
            for (int j = 0; j < altezza; j++) {
                level.add(new Cell(i, j));
            }
        }
    }

    public String toString(){
        String result = "Game Level\n";
        for (int i = 0; i < altezza; i++) {
            for (Cell cell : level) {
                if (cell.getCoordinata_y() == i) {
                    result+=cell;
                }
            }
            result += "\n";
        }
        return result;
    }

    private class Cell {
        private int coordinata_x, coordinata_y;
        private boolean wall;

        public Cell(int coordinata_x, int coordinata_y) {
            this.wall = false;
            this.coordinata_x = coordinata_x;
            this.coordinata_y = coordinata_y;

        }

        public int getCoordinata_x() {
            return coordinata_x;
        }

        public int getCoordinata_y() {
            return coordinata_y;
        }

        public boolean isWall() {
            return wall;
        }

        public void setWall(boolean wall) {
            this.wall = wall;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Cell)) return false;

            Cell c = (Cell) obj;

           return c.getCoordinata_x() == this.coordinata_x && c.getCoordinata_y() == this.coordinata_y;
        }

        @Override
        public int hashCode() {
            return coordinata_x ^ coordinata_y;
        }

        @Override
        public String toString(){
            return (this.isWall())?"| x |":"|   |";
        }
    }

    public static void main(String[] args) {
        GameLevel map = new GameLevel(3, 3);
        
        System.out.println(map.areConnected(0,0,2,2));
        map.setWall(0,1);
        map.setWall(1,1);
        System.out.println(map.areConnected(0,0,2,2);
        map.setWall(2,1);
        System.out.println(map.areConnected(0,0,2,2));

    }
}
