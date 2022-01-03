import java.util.Objects;

import java.util.Map;

public interface  BoolExpr {
      
     /**
      * This method evaluate the expression
      * @param map Set of value where key is the variable created and value is the logic value associated
      * @return The result of the expression
      */
     boolean eval(Map<BoolVar, Boolean> map);
}
