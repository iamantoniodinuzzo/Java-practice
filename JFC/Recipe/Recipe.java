import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String mName, mDescription;
    private ArrayList<Ingredient> mIngredientsList;
    
    public Recipe(String recipe_name){
        this.mName = Objects.requireNonNull(recipe_name);
        this.mIngredientsList = new ArrayList<>();
    }

    public void setDescr(String description){
        this.mDescription = Objects.requireNonNull(description);
    }

   
    public void addIngr(double quantity, String unity){
         Ingredient newIngredient = new Ingredient(quantity, unity);
        mIngredientsList.add(newIngredient);
    }

    /**
     * Print recipe for n persons
     * @param n Number of person must be greater than 0
     * @return 
     * @throws IllegalArgumentException se il numero di persone è inferiore a 1
     */
    public String toString(int n) throws IllegalArgumentException{
        if(n < 1) throw new IllegalArgumentException();

        String result = "\n";
        for (Ingredient ingredient : mIngredientsList) {
            result += ingredient.toString(n);
        }

        return mName+"\n"+
                result+
                "\nPreparazione:\n"+
                mDescription;
    }

    private static class Ingredient{
        private double mQuantity;
        private String mUnity;

    /**
     * Aggiunge la quantità di ingrediente per una persona alla ricetta.
     * @param quantity La quantità, anche frazionaria di un determinato ingrediente, se la quantità non è misurabile,
     * inserire il valore 0, questo indicherà "q.b." dell'ingrediente in questione.
     * @param unity L'unità di misura dell'ingrediente 
     * @throws IllegalArgumentException quando la  quantity risulta negativa oppure quando  unity è null o vuoto. 
     */
        public Ingredient(double quantity , String unity) throws IllegalArgumentException{
            if(quantity < 0 || unity.isEmpty() || Objects.isNull(unity)) throw new IllegalArgumentException();

            this.mQuantity = quantity;
            this.mUnity = unity;
        }

     
        public String toString(int n){
            return mQuantity != 0 ? mQuantity*n + " "+ mUnity+"\n" : "q.b." + " "+ mUnity+"\n";
        }
    }
}
