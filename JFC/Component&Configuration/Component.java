import java.util.Set;
import java.util.HashSet;
import java.util.*;

/**
 * Rappresenta un componente di un PC
 */
class Component {
    private Type type;
    private String descrizione;
    private Set<Component> incompatibleComponents = new HashSet<>();

    public Component(Type type, String descrizione) {
        this.type = type;
        this.descrizione = descrizione;
    }

    /**
     * Dichiara che questo componente è incompatibile con il componente passato come parametro
     * @param component Il componente incompatibile con quest'ultimo
     */
    public void setIncompatible(Component component) {
        incompatibleComponents.add(component);
    }

    public Set<Component> getIncompatibleComponents() {
        return incompatibleComponents;
    }

    public Type getType() {
        return type;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Component)) return false;

        Component component = (Component) o;

        return getType() == component.getType();
    }

    @Override
    public String toString() {
        return "Type: "+this.getType()+" Name: "+this.getDescrizione()+"\n";
    }

    
}