public class Employee {
    private double salary ;
    private int years;

    public Employee(int years, double salary){
        this.years = years;
        this.salary = salary;
    }
    
    public int getYears(){
        return years;
    }

    public void setSalary(double i){
        salary =i;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Anno: "+years+" _salary: "+salary;
    }
}
