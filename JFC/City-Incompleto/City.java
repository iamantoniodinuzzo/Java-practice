import java.util.HashSet;
import java.util.Set;
import java.util.Collection;


public class City {
    private String name;
    private Set<City> connections;

    public City(String name){
        this.name = name;
        connections = new HashSet<>();
    }

    public void connect(City city){
        this.connections.add(city);
        city.connections.add(this);
    }

    public Collection<City> getConnections(){
        return connections;
    }

    public boolean isConnected(City city){
       //TODO: Come controllare ricorsivamente tutte le città?
    }

    private boolean containsCity(City current, City toSearch) {
        if (current.equals(toSearch)) {
            return true;
        } 
        if (value == current.value) {
            return true;
        } 
        return value < current.value
          ? containsNodeRecursive(current.left, value)
          : containsNodeRecursive(current.right, value);
    }
   
    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof City)) return false;

        City c= (City) obj;

        return this.name.equalsIgnoreCase(c.getName());
    }

    public String getName() {
        return name;
    }
    

    public static void main(String[] args) {
        City n = new City("Napoli"), r = new City("Roma"), s = new City
        ("Salerno"), p = new City("Parigi");
        n.connect(s);
        n.connect(r);
        Collection<City> r_conn = r.getConnections();
        System.out.println(r_conn);
        System.out.println(r .isConnected(s));
        System.out.println(r .isConnected(p));
    }

}
