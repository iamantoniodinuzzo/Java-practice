import java.util.Map;
import java.util.Objects;

public class BoolVar implements BoolExpr{
    private String valName;

    public BoolVar(String name){
        this.valName = Objects.requireNonNull(name);
    }
   

    public String getName(){return valName;}

    @Override
    public boolean eval(Map<BoolVar, Boolean> map){
       return map.get(this);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof BoolVar)) throw new IllegalArgumentException();

        BoolVar otherVar = (BoolVar) obj;

        return valName.equals(otherVar.valName);
    }

    @Override
    public int hashCode(){
        return valName.hashCode() ;
    }
}
