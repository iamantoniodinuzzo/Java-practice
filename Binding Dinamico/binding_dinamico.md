# Binding Dinamico
Dati i seguenti programmi (tutte le classi appartengono allo stesso pacchetto):
* Per ogni chiamata ad un metodo (escluso System.out.println) indicare la lista delle firme candidate.
* Indicare l'output del programma. Se un'istruzione provoca un errore di compilazione, specificarlo e poii continuare l'esercizio ignorando quell'istruzione.
> Cliccare sui seguenti link per maggiori informazioni sull'[early binding](http://www.datrevo.com/learly-binding-in-java-lezione-6-di-java-avanzato/) e [late binding](http://www.datrevo.com/il-late-binding-in-java-lezione-7-di-java-avanzato/) .
## (2019-3-19)
```java
class A {
    public String f(A x, A[] y) { return "A1"; }
    public String f(A x, Object y) { return "A2:" + x.f(new B(), null); }
}
class B extends A {
    public String f(B x, B[] y) { return "B1"; }
    public String f(A x, A[] y) { return "B2"; }
    public String f(A x, Object[] y) { return "B3"; }
}
public class Test { 
    public static void main(String[] args) {
        B[] arrayB = new B  [10];
        A[] arrayA = arrayB;
        arrayB[0] = new B();
        System.out.println(arrayB[0]. f (null, arrayB));
        System.out.println(arrayA[0]. f (null, arrayA));
        System.out.println(arrayA[0]. f (arrayA[0], null)) ;
}
}
```
### Firme candidate e più specifica
* `arrayB[0].f(null,arrayB)`; **Candidate**: B1, B2, B3, A1, A2; **Più specifica**: B1</br>
* `arrayA[0].f(null,arrayA)`; **Candidate**: A1, A2 **Più specifica**: B2</br>
* `arrayA[0].f(arrayA[0],null)`; **Candidate**: A1,A2 **Più specifica**: B2
### Output del programma
B1</br> B2</br> B2

<!--   -->
## 2019-2-15
```java
class A {
    public String f(A x, A[] y) { return "A1"; }
    public String f(A x, Object y) { return "A2:" + x.f(new C(), y); }
}
class B extends A {
    public String f(C x, A[] y) { return "B1:" + x.f((A)x, y); }
    public String f(A x, A[] y) { return "B2"; }
    public String f(A x, Object[] y) { return "B3"; }
}
class C extends B {
    public String f(A x, B[] y) { return "C1"; }
}
public class Test {
    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        B[] array = new B[10];
        System.out.println(beta. f (gamma, array));
        System.out.println(gamma.f(beta, null));
        System.out.println(beta. f (array [0], null)) ;
    }
}
```
### Firme candidate e più specifica
* `beta.f(gamma, array)`; **Candidate**: B1, B2, B3, A1, A2; **Più specifica**: B1</br>
* `gamma.f(beta, null)`; **Candidate**: C1, B1, B2,B3, A1, A2 **Più specifica**: C1<br>
* `beta.f(array[0],null)`; **Candidate**: A1,A2 **Più specifica**: B2
### Output del programma
B1: B2</br>
C1</br>
B2
<!--   -->

## 2019-1-23
```java
class A {
    public String f(A x, A y, B z) { return "A1"; }
    public String f(A x, Object y, A z) { return "A2"; }
    private String f(B x, Object y, B z) { return "A3"; }
}   
class B extends A { 
    public String f(A x, A y, B z) { return "B1" + f(x, this, z); }
    private String f(A x, B y, B z) { return "B2"; }
    public String f(B x, Object y, B z) { return "B3"; }    
}   
public class Test { 
    public static void main(String[] args) {    
        B beta = new B();   
        A alfa = beta;
        System.out.println( alfa . f ( alfa , alfa , null)) ;
        System.out.println(beta. f ( alfa , beta, alfa )) ;
        System.out.println(beta. f (beta, beta, beta));
        System.out.println(beta. f ( alfa , alfa , null)) ;
    }
}
```
### Firme candidate e più specifica
`alfa . f ( alfa , alfa , null)`; **Candidate**: A1, A2; **Specifica**: B1;</br>
`beta. f ( alfa , beta, alfa )`; **Candidate**: A2; **Specifica**: A2</br>
`beta. f ( beta , beta, beta )`; **Candidate**: B1, B3, A1, A2; **Specifica**:Errore</br>
`beta. f ( alfa , alfa, null )`; **Candidate**: B1,  B3, A1, A2; **Specifica**: B1</br> 

### Output del programma
B1B2</br>
A2</br>
B1B2

## 2018-9-17
```java
class A {
    public String f (Object x, A y) { return "A1"; }
    private String f (A x, Object y) { return "A2"; }
    protected String f(A x, B y) { return "A3"; }
}
class B extends A {
    public String f(B x, B y) { return "B1 + " + f(x, (Object)y); }
    public String f(A x, Object y) { return "B2"; }
}
class C extends B {
    public String f(A x, Object y) { return "C1 + " + f(x, (B)y); }
    public String f(Object x, A y) { return "C2"; }
}
public class Test {
    public static void main(String[] args) {
        B beta = new C();
        A alfa = beta;
        System.out.println(alfa. f (beta, null)) ;
        System.out.println(beta. f (beta, beta));
        System.out.println(beta. f ( alfa , (B)null));
}
}
```
### Firme candidate e più specifica
`(alfa. f (beta, null)`; **Firme candidate**: A1, A3; **Più specifica**: A3</br>
`(beta. f (beta, beta)`; **Firme candidate**: B1, B2, A1, A2, A3; **Più specifica**: B1
### Output
A3</br>
B1 + C1 + A3 (non ne ho la più pallida idea)</br>
A3

## 2018-7-19
```java
class A {
    public String f(Object a, A b) { return "A1"; }
    public String f(A a, B b) { return "A2"; }
}
class B extends A {
    public String f(B a, B b) { return "B1 + " + f(a, (A)b); }
    public String f(A a, B b) { return "B2"; }
}
public class Test {
    public static void main(String[] args) {
        B beta = new B();
        A alfa = beta;
        System.out.println( alfa . f (beta, null)) ;
        System.out.println(beta. f (beta, beta));
        System.out.println(beta. f ( alfa , null)) ;
    }
}
```
### Firme candidate e più specifiche
`alfa . f (beta, null)`; **Candidate**: A1, A2; **Specifica**: B2</br>
`beta . f (beta, beta)`; **Candidate**: B1, B2, A2, A1; **Specifica**: B1</br>
`beta . f (alfa, null)`; **Candidate**: B2, A2, A1; **Specifica**: B2
### Output
B2</br>
B1 + A1</br>
B2

## 2018-6-20
```java
class A {
    public String f(Object x, A y, B z) { return "A1"; }
    public String f(A x, C y, C z) { return "A2"; }
}
class B extends A {
    public String f (Object x, A y, A z) { return "B1 + " + f(null, new B(), y); }
    private String f(A x, B y, B z) { return "B2"; }
}
class C extends B {
    public String f(A x, A y, B z) { return "C1"; }
    public String f(A x, C y, C z) { return "C2"; }
}
public class Test {
    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        A alfa = gamma;
        System.out.println( alfa . f (beta, gamma, gamma));
        System.out.println(beta. f (beta, beta, beta));
        System.out.println(gamma.f(alfa, null, beta));
    }
}
```
### Firme candidate e più specifica
`alfa . f (beta, gamma, gamma)`; **Candidate**: A1, A2; **Specifica**: A2</br>
`beta . f (beta, beta, beta)`; **Candidate**: B1, A1; **Specifica**: A1</br>
`gamma . f (alfa, null, beta)`; **Candidate**: C1, B1, A1; **Specifica**: C1

## Output
C2</br>
A1</br>
C1

## 2018-5-2
```java
class A {
    public String f(Object a, A b) { return "A1"; }
    public String f(A a, C b) { return "A2"; }
}
class B extends A {
    public String f (Object a, A b) { return "B1 + " + f(null, new B()); }
    private String f(A a, B b) { return "B2"; }
}
class C extends B {
    public String f(Object a, B b) { return "C1"; }
    public String f(A a, B b) { return "C2"; }
}
public class Test {
    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        A alfa = gamma;
        System.out.println( alfa . f (beta, gamma));
        System.out.println(beta. f (beta, beta));
        System.out.println(gamma.f(alfa, null));
        System.out.println(beta instanceof A);
    }
}
```
### Firme candidate e più specifica
`alfa . f (beta, gamma)`; **Candidate**: A1, A2; **Specifica**: A2;</br>
`beta.f(beta, beta)`; **Candidate**: B1, A1; **Specifica**: B1</br>
`gamma.f(alfa, null)`; **Candidate**: C2, C1, B1, A2, A1; **Specifica**: A2</br>
### Output
A2</br>B1+B2</br>A2</br>true

## 2018-3-23
```java
class A {
    public String f (Object x, A y, B z) { return "A1"; }
    private String f(A x, B y, A z) { return "A2"; }
}
class B extends A {
    public String f(Object x, A y, B z) { return "B1 + " + f(null, z, new B()); }
    private String f(B x, B y, B z) { return "B2"; }
}
public class Test {
    public static void main(String[] args) {
        B beta = new B();
        A alfa = (A) beta;
        System.out.println( alfa . f ( alfa , beta, beta));
        System.out.println( alfa . f (beta, alfa , null)) ;
        System.out.println(beta. f (beta, beta, beta));
        System.out.println( alfa instanceof B);
    }
}
```
## Firme candidate e specifica
`alfa . f ( alfa , beta, beta)`; **Candidate**: A1; **Specifica**:A1 </br>
`alfa . f (beta, alfa , null)`; **Candidate** : A1; **Specifica**: A1</br>
`beta. f (beta, beta, beta)`; **Candidate**: B1, A1; **Specifica**: B1</br>
## Output
B1+B2</br>B1+B2</br>B1 + B2</br> true