import java.util.Set;
import java.util.HashSet;
import java.util.*;

class Configuration {
    private Set<Component> components = new HashSet<>();


    public boolean add(Component component) {
      
        return components.add(component);
    }


}