package src;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Bug b1 = new Bug("Application crashes on Windows 8"),
                b2 = new Bug("Application freezes after 2 hours"),
                b3 = new Bug("Application does not print on laser printer"),
                        b4 = new Bug("Data missing after partial save");
        Set<Bug> unassigned = Bug.getUnassigned();
        System.out.println(unassigned.size ()) ;
        b2.assignTo("Paolo");
        b3.assignTo("Filomena");
        b4.assignTo("Filomena");
        System.out.println(unassigned.size ()) ;
        Set<Bug> filo = Bug.getAssignedTo("Filomena");
        System.out.println(filo) ;
    }
}
