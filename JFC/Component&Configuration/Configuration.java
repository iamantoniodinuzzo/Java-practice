import java.util.Set;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import java.util.FormattableFlags;
import java.util.HashSet;

/**
 * Rappresenta un PC da assemblare
 */
class Configuration {
    private Set<Component> components = new HashSet<>();

/**
 * Aggiunge un componente a questa configurazione,
 * tenendo conto delle compatibilità e del tipo dei componenti
 * @param component Il componente da aggiungere
 * @return TRUE solo se il componente è compatibile, FALSE altrimenti
 */
    public boolean add(Component component) {
              
        for (Component element: components) {
            if(element.getIncompatibleComponents().contains(component) || component.equals(element))
                return false;
        }
        return components.add(component);
    }

    @Override
    public String toString(){
       return components.toString();
    }

}