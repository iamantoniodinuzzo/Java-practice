import java.util.*;
public class AgeBonus extends Thread {
    private final int threshold ;
    public AgeBonus(int n) { this . threshold = n; }
    private List<Employee> list = Arrays.asList(new Employee(6,200), new Employee(4, 200), new Employee(3, 200));

    @Override
    public void run() {
        synchronized(list){

            for (Employee e: list ) {
                    if (e. getYears () > threshold)
                        e. setSalary (e. getSalary () + 100);
                        
            }
        }
    }
        
        
    

    public synchronized List<Employee> getList() {
        return list;
    }


    }
