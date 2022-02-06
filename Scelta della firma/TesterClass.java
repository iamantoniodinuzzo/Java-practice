import java.util.*;

public class TesterClass {

    public static <T> Comparator<T> combine(Comparator<Object> a, Comparator<Object> b){
        return new Comparator<T>(){
            @Override
            public int compare(T valA, T valB){
                int result1 = a.compare(valA, valB);
                int result2 = b.compare(valA, valB);

                return (result1 != 0) ? result1 : result2; 
            }
        };
    }
    public static void main(String[] args) {
        
    }
   
}