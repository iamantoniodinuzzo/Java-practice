import java.util.*;

public class Cartella {
    private HashSet<Casella> cartella;
    private static final int RIGHE = 3, COLONNE = 5;

    private enum Premio {
        AMBO, TERNO, QUATERNA, CINQUINA, TOMBOLA
    }

    public Cartella() {
        cartella = new HashSet<>();
        makeFolder();
    }

    public Premio segna(int numero_estratto) {
        int checked_cells = 0;
        for (Casella casella : cartella) {
            if (casella.getNumber() == numero_estratto) {
                casella.setCheck(true);
                // controlla se questa riga ha altre caselle segnate
                checked_cells = howManyCellsAreChecked(casella.getRow());
            }
        }
        return whichPremio(checked_cells);
    }

    private int howManyCellsAreChecked(int row) {
        int checked_cells = 0;
        for (Casella casella : cartella) {
            if (casella.getRow() == row && casella.isCheck()) {
                checked_cells++;
            }
        }
        return checked_cells;
    }

    private Premio whichPremio(int checked_cells) {
        switch (checked_cells) {
            case 2:
                return Premio.AMBO;
            case 3:
                return Premio.TERNO;
            case 4:
                return Premio.QUATERNA;
            case 5:
                return Premio.CINQUINA;
            default:
                // controlliamo se si tratta di una tombola
                for (Casella casella : cartella) {
                    if (!casella.isCheck())
                        return null;
                }
                return Premio.TOMBOLA;
        }
    }

    @Override
    public String toString() {
        String result = "\t\t Cartella \n";
        for (int i = 0; i < RIGHE; i++) {
            for (Casella casella : cartella) {
                if (casella.getRow() == i)
                    result += "\t" + casella;
            }
            result+="\n";
        }
        return result;
    }

    private void makeFolder() {
        for (int i = 0; i < RIGHE; i++) {
            HashSet<Casella> row_cells = new HashSet<>();// tiene memoria delle caselle della riga
            for (int j = 0; j < COLONNE; j++) {
                Casella cell = new Casella(i, j);
                // Controlliamo che la casella creata:
                // * non sia zero
                // * non esista già nella cartella
                // * non sia di una decina già presente nella riga
                while (cartella.contains(cell) || cell.getNumber() == 0 || rowHasCellWSameTens(cell, row_cells)) {
                    cell = new Casella(i, j);
                }
                cartella.add(cell);// aggiunge la casella alla cartella
                row_cells.add(cell);// aggiunge la casella alla riga
            }
        }
    }

    private boolean rowHasCellWSameTens(Casella c, HashSet<Casella> row) {
        for (Casella casella : row) {
            if (casella.sameTens(c.getNumber()))
                return true;
        }
        return false;
    }

    private class Casella {
        private int row, column, number;
        private boolean check;

        public Casella(int row, int column) {
            this.column = column;
            this.row = row;
            // il numero della casella è generato randomicamente dalla classe stessa
            this.number = (int) (Math.random() * 90 + 1);
            this.check = false;
        }

        public int getColumn() {
            return column;
        }

        public int getNumber() {
            return number;
        }

        public int getRow() {
            return row;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public boolean isCheck() {
            return check;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Casella))
                return false;

            Casella c = (Casella) obj;
            // Due celle sono uguali se hanno tutti gli stessi valori
            return (this.row == c.getRow() && this.column == c.getColumn() && this.number == c.getNumber());
        }

        public boolean sameTens(Integer number) {
            String this_number = Integer.toString(this.number);
            String num_to_compare = number.toString();

            if ((this_number.length() == 1 && num_to_compare.length() == 1) || // se sono entrambi una cifra,
                    this_number.subSequence(0, 1).equals(num_to_compare.subSequence(0, 1))) { // oppure hanno la stessa
                                                                                              // decina
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return row ^ column ^ number;
        }

        @Override
        public String toString() {
            return (this.check == true)? "["+number+"]": Integer.toString(number);
        }

    }

    public static void main(String[] args) {
        Cartella c = new Cartella();

        for(int i = 0; i< 5 ; i++){
            System.out.println(c.segna((int)(Math.random()*90+1)));

        }
        
       /* System.out.println(c.segna(1));
        System.out.println(c.segna(2));
        System.out.println(c.segna(12));
        System.out.println(c.segna(22));
        System.out.println(c.segna(82));*/

        System.out.println(c);

    }
}
