
public class UMLAggregation {
    private UMLClass class1, class2;
    public static final int INFINITY = -1;
    private int min_cardinality, max_cardinality;


    public UMLAggregation(UMLClass class1, UMLClass class2, int min, int max) {
        this.class1 = class1;
        this.class2 = class2;
        this.min_cardinality = min;
        this.max_cardinality = max;

        addAggregationToClasses();

    }

    private void addAggregationToClasses() {
        class1.addAggregation(this);
    }



    @Override
    public String toString() {
        String result = class1.getTitolo()+"-"+class2.getTitolo()+", cardinalità:";
        if(min_cardinality == -1)
            result+="infinito";
        else    
            result+= min_cardinality;
        
        if(max_cardinality ==-1)
            result+= "..infinito";
        else
            result +=".."+max_cardinality;
        
        return result;

    }

    public UMLClass getClass1() {
        return class1;
    }
    public UMLClass getClass2() {
        return class2;
    }
    @Override
    public int hashCode() {
        return class1.hashCode() ^ class2.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof UMLAggregation)) return false;

        UMLAggregation umlAggregation = (UMLAggregation) obj;

        return this.class1.equals(umlAggregation.getClass1()) ||
                this.class1.equals(umlAggregation.getClass2()) ||
                this.class2.equals(umlAggregation.getClass2()) ||
                this.class2.equals(umlAggregation.getClass1());
    }



}
