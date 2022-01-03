import java.util.Map;
import java.util.Objects;

public class BoolNot implements BoolExpr{

    private BoolExpr mVariable;

    public BoolNot(BoolExpr variable){
        mVariable = Objects.requireNonNull(variable);
    }

    @Override
    public boolean eval(Map<BoolVar, Boolean> map){
        //TODO Make this method recursive for each value into the map
        return ! mVariable.eval(map);
    }
}
