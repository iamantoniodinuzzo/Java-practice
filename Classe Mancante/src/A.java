/*La seguente classe A fa riferimento ad una classe B. Implementare la classe B in modo che venga
compilata correttamente e permetta la compilazione della classe A.*/
public class A extends B {

    public A(int x) {
        super(x-1, x / 2.0);
    }
    public A(double inutile) {
    }

    private void stampa(String s)  {

        if (s == null) throw new B(s);
        else System.out.println(s) ;
    }
}
