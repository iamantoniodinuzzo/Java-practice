/**
 * Rappresenta una relazione binaria tra un insieme e se stesso.
 */
public class BinRel<T> {

    private Set<Couple> set = new HashSet<>();
  
    public void addPair(T obj1, T obj2){
       set.add(new Couple<T>(obj1, obj2));
    }

    public boolean areRelated(T obj1, T obj2){
        for (Couple element : set) {
            if(obj1.equals(element.getObj2()) && obj2.equals(element.getObj1()))
                return true;
        }
        return false;
    }
    
    public boolean isSymmetric(){
        boolean result ;
        for (Couple element : set) {
            result = false;
            for (Couple element2 : set) {
                if(element.compareTo(element2) == 0)
                    result = true;
                    break;
            }
        }
        return result;
    }
}
