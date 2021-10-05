import java.util.ArrayList;

public class Panino {
    
    private ArrayList<Ingrediente> ingredienti;

    public Panino(){
        ingredienti = new ArrayList<>();
    }

    /**
     * Aggiunge un ingrediente, scelto da
     * un elenco fisso. Se si tenta di aggiungere più di un
     * ingrediente della stessa categoria, il metodo solleva un'eccezione
     * @param ingrediente
     */
    public void addIngrediente(Ingrediente ingrediente){
        String categoria = ingrediente.getCategoria();
        for (Ingrediente element : ingredienti) {
            if (element.getCategoria().equals(categoria)) {
                throw new IllegalArgumentException();
            }
        }

        ingredienti.add(ingrediente);
    }

    @Override
    public String toString() {
        return "panino con "+ingredienti;
    }

    public enum Ingrediente{
        SALAME("ripieni"), PROSCIUTTO("ripieni"), SOTTILETTA("formaggi"), MOZZARELLA("formaggi"), MAIONESE("salse"), SENAPE("salse");
        private final String categoria;

        private Ingrediente(String categoria){
            this.categoria = categoria;
        }

        public String getCategoria() {
            return categoria;
        }
              
    }

    public static void main(String[] args) {
        Panino p = new Panino();

        p.addIngrediente(Panino.Ingrediente.SALAME);
        p.addIngrediente(Panino.Ingrediente.SOTTILETTA);
        System.out.println(p);
        p.addIngrediente(Panino.Ingrediente.MOZZARELLA);
    }
}
