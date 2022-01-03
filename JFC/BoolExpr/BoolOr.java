import java.util.Map;
import java.util.Objects;

public class BoolOr implements BoolExpr {
    
    private BoolExpr mBoolVar1, mBoolVar2;

    public BoolOr(BoolExpr variable1, BoolExpr variable2){
        mBoolVar1 = Objects.requireNonNull(variable1);
        mBoolVar2 =  Objects.requireNonNull(variable2);
    }

    @Override
    public boolean eval(Map<BoolVar, Boolean> map){
        //TODO make it recursive if map has more than two values
        boolean boolVar1 = mBoolVar1.eval(map);
        boolean boolVar2 = mBoolVar2.eval(map);
        return boolVar1 || boolVar2;
    }
}
