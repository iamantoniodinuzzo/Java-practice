import java.util.*;

public class TesterClass {

    // Method to test
    public static <S,T> boolean arePermutations(List<S> a, List<T> b){
        if(a.size() != b.size()) return false;

        for (S s : a) {
            if(!b.contains(s))
                return false;
        }

        return true;
    }

       public static void main(String[] args) {
         class Person{
            private String nome;
            public Person(String nome){
                this.nome = nome;
            }

            public boolean equals(Object obj){
                if(!(obj instanceof Person)) return false;

                Person p = (Person) obj;

                return this.nome.equalsIgnoreCase(p.getNome());
            }

            public String getNome() {
                return nome;
            }
        }
        ArrayList<Object> l1 = new ArrayList<>();
        l1.add(new Person("Antonio"));
        l1.add(new Person("Marco"));
        l1.add(new Person("Giuseppe"));
        l1.add(new Person("Anna"));

        ArrayList<Object> l2 = new ArrayList<>();
        l2.add(new Person("Anna"));
        l2.add(new Person("Marco"));
        l2.add(new Person("Antonio"));
        l2.add(new Person("Giuseppe"));

        // ArrayList<Object> l2 = new ArrayList<>(Arrays.asList(1,2,3,4));
        
        System.out.println(arePermutations(l1, l2));


    }
}