import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

public class Person {

    private enum Typology {

        MYSELF, ENEMY, FRIEND;

    }

    private String name;
    private Map<Person, Typology> persons;

    public Person(String name) {
        this.name = name;
        persons = new HashMap<>();
    }

    public void addFriend(Person p) {
        if(p.equals(this) )throw new IllegalArgumentException();
        persons.put(p, Typology.FRIEND);
    }

    public void addEnemy(Person p) {
        if(p.equals(this) )throw new IllegalArgumentException();
        persons.put(p, Typology.ENEMY);

    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person))
            return false;

        Person p = (Person) obj;

        return this.name.equalsIgnoreCase(p.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Person> contacts() {
        LinkedList<Person> list = new LinkedList<>();

        for (Map.Entry<Person, Typology> entry : persons.entrySet()) {
            Person key = entry.getKey();
            Typology value = entry.getValue();
            if(value == Typology.ENEMY){
                list.addLast(key);
            }else{
                list.addFirst(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Person a = new Person("Antonio");
        Person c = new Person("Cleopatra");
        Person o = new Person("Ottaviano");
        a.addEnemy(o);
        a.addFriend(c);
        for (Person p : a.contacts())
            System.out.println(p);
    }

}
