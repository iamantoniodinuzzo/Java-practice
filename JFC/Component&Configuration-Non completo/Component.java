import java.util.Set;
import java.util.HashSet;
import java.util.*;

class Component {
    private Type type;
    private String descrizione;
    private Set<Component> incompatibleComponents = new HashSet<>();

    public Component(Type type, String descrizione) {

        this.type = type;
        this.descrizione = descrizione;

    }


    public void setIncompatible(Component component) {
        incompatibleComponents.add(component);
    }

    public Set<Component> getIncompatibleComponents() {
        return incompatibleComponents;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Component)) return false;
        Component component = (Component) o;
        return getType() == component.getType();
    }

    public static Comparator<Component> compareByCompatibility = new Comparator<Component>() {
        @Override
        public int compare(Component o1, Component o2) {
            for (Component com: o2.getIncompatibleComponents()) {
                if (o1.getIncompatibleComponents().contains(com)) return -1;
            }
            return 0;
        }
    };

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}