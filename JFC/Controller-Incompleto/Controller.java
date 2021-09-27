import java.util.HashSet;
import java.util.Set;

/**
 * Rappresenta una centralina per autoveicoli
 */
public class Controller {
    private static Set<Function> functions;

    public Controller(){
        functions = new HashSet<>();
    }

    /**
     * Aggiunge al sistema una nuova funzionalità con un dato nome
     */
    public Function addFunction(String name) {
        Function func = new Function(name);
        functions.add(func);
        return func;
    }

    /**
     * Stampa a video i nomi delle funzionalità attive 
     */
    public void printOn() {
        for (Function function : functions) {
            if(function.getIsActive()){
                System.out.println(function);
            }
        }
    }

    /**
     * Rappresenta una funzionalità del veicolo, che può essere accesa o spenta.
     * Alcune funzionalità sono incompatibili tra loro, per cui accenderne una fa
     * spegnere automaticamente l'altra.
     */
    public static class Function {

        private boolean isActve;
        private String name;
        private Set<Function> incompatibilities;

        public Function(String name) {
            this.name = name;
            incompatibilities = new HashSet<>();
            turnOff();
        }

        public void turnOn() {
            //controllo se ci sono funzionalità incompatibili da spegnere
           for (Function function : incompatibilities) {
               if(functions.contains(function) && function.getIsActive()){
                   function.turnOff();
               }
           }
            isActve = true;
        }

        public void turnOff() {
            isActve = false;
        }

        public boolean getIsActive(){
            return isActve;
        }

        public String getName() {
            return name;
        }

        public void setIncompatible(Function func) {
            incompatibilities.add(func);
        }

        @Override
        public String toString(){
            return name;
        }

        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Function)) return false;

            Function func = (Function) obj;

            return func.getName().equalsIgnoreCase(name);
        }

        @Override
        public int hashCode(){
            return name.hashCode();
        }
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        Controller .Function ac = c.addFunction("Aria condizionata");
        Controller .Function risc = c.addFunction("Riscaldamento");
        Controller .Function sedile = c.addFunction("Sedile riscaldato");
        
        ac.setIncompatible(risc ) ;
        ac.setIncompatible(sedile ) ;

        ac.turnOn();
        c.printOn();
        System.out.println("----");
        
        risc .turnOn();
        sedile .turnOn();
        c.printOn();
    }
}