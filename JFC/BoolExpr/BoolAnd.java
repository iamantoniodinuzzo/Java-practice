import java.util.Map;
import java.util.Objects;

public class BoolAnd implements BoolExpr{
    
    private BoolExpr mBoolVar1, mBoolVar2;

    public BoolAnd(BoolExpr variable1, BoolExpr variable2){
        this.mBoolVar1 = Objects.requireNonNull(variable1);
        this.mBoolVar2 = Objects.requireNonNull(variable2);
    }

    @Override
    public boolean eval(Map<BoolVar, Boolean> map){
        //TODO Make this method recursive for each value into the map
        boolean boolVar1 = mBoolVar1.eval(map);
        boolean boolVar2 = mBoolVar2.eval(map);
        
        return boolVar1 && boolVar2;
    }
}
