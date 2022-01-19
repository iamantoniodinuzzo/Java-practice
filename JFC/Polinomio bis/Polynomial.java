import java.util.ArrayList;
import java.util.Iterator;

public class Polynomial implements Iterable<Pair<Integer, Double>> {

    private ArrayList<Elemento> polynom; 
    
    public Polynomial(double[] coeff){
        polynom = new ArrayList<>();
        for(int exponent = 0; exponent < coeff.length;++exponent){
            polynom.add(new Elemento(exponent, coeff[exponent]));
        }
    }

    public final Iterator<Pair<Integer,Double>> iterator(){
        return new Iterator<Pair<Integer, Double>>() {
            private int index = 0;
            @Override
            public boolean hasNext(){
               return  (index < polynom.size()) && (polynom.get(index) != null);
            
            }

            @Override
            public Pair<Integer,Double> next(){
                Elemento elem = polynom.get(index++);
                if(elem.isPrintable())
                    return elem ;
                return next();
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    } 

    @Override
    public String toString(){
        String result = "";
        int n_plus = polynom.size()-1;//indica il numero di '+' da inserire.
                                    //se il polinomio avrà n elementi allora avrà n-1 '+'
       
        for (Elemento element : polynom) {
            if(element.isPrintable()){
                result += element ;
                //c'è un '+' da inserire?
                if(n_plus != 0)
                    result+= " + ";
            }
            n_plus--;//il decremento è posizionato al di fuori dell'if in quanto
                    //che sia o no un elemento stampabile e quindi diverso dallo zero
                    //và decrementato per evitare un elemento vuoto circondato da due '+'
                    //ad esempio 2-0 x^1 + +3.0 x^3
        }

        return result;
    }

    /**
     * Un termine del polinomio
     */
    private class Elemento extends Pair<Integer, Double>{
        private boolean printable ;

        public Elemento(Integer exp, Double coeff){
            super(exp, coeff);
            printable = (exp>=0 && coeff!= 0);
            
        }

        @Override
        public String toString(){
            String result = "";
            int exp = getFirst();
            double coeff = getSecond();
            //Controllo se questo elemento ha grado zero e il coefficiente non è zero
            if(exp == 0 && coeff != 0)
                result+= coeff;
            //altrimenti se l'exponente non è zero e non lo è anche il coefficiente
            //inserisco entrambi
            else if(coeff != 0)
                result += coeff+" x^"+exp;
            
            return result;
        }

        public boolean isPrintable(){return printable;}
    }
}
