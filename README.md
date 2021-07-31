<!-- TABLE OF CONTENTS -->
  <h2 style="display: inline-block">Table of Contents</h2></summary>
  <ul>
    <li>
      <a href="#about-the-project">About the project</a>
    </li>
    <li>
      <a href="#java-Collection-Framework(JFC)">Java Collection Framework</a>
    </li>
    <li>
      <a href="#classi-interne">Classi Interne</a>
    </li>
    <li><a href="#iteratori-e-ciclo-foreach">Iteratori e ciclo foreach</a></li>
    <li><a href="#uguaglianza-tra-oggetti">Uguaglianza tra oggetti</a></li>
  </ul>

<!-- ABOUT THE PROJECT -->
# About The Project
Questa repository è un insieme di esercizi inerenti al miglior utilizzo del linguaggio java. 
Di seguito troverai ogni repository con all'interno le rispettive tracce e i link agli svolgimenti (in corso) di ogni esercizio relativo all'argomento del capitolo.




# [Java Collection Framework(JFC)](https://github.com/Indisparte/Java-practice/tree/main/JFC)
## [Library](https://github.com/Indisparte/Java-practice/tree/main/JFC/Library)
Realizzare per una biblioteca le classi **Library** e **Book**. Un oggetto **Book** è caratterizzato dal suo titolo. La classe Library offre le seguenti funzionalità:
* Un costruttore senza argomenti che crea una biblioteca vuota.
* Il metodo **addBook** aggiunge un libro alla biblioteca. Se il libro era già stato aggiunto, restituisce false.
* Il metodo **loanBook** prende un libro come argomento e lo dà in prestito, a patto che sia disponibile. Se quel libro è già in prestito, restituisce false. Se quel libro non è mai stato inserito nella biblioteca, lancia un'eccezione.
* Il metodo **returnBook** prende un libro come argomento e restituisce quel libro alla biblioteca.
Se quel libro non era stato prestato col metodo loanBook, il metodo returnBook lancia
un'eccezione.
* Il metodo **printLoans** stampa la lista dei libri attualmente in prestito, in ordine temporale
(a partire dal libro in prestito da più tempo).
Inoltre, rispondere alla seguente domanda: nella vostra implementazione, qual è la complessità
dei metodi **loanBook** e **returnBook**, rispetto al numero di libri n inseriti nella biblioteca?
L'implementazione deve rispettare il seguente esempio d'uso.
```java
    Library lib = new Library();
Book a = new Book("a"), b = new Book("b"), c = new Book(
"c");
System.out.println( lib .addBook(a));//true
System.out.println( lib .addBook(b));//true
System.out.println( lib .addBook(c));//true
System.out.println( lib .addBook(a));//false
System.out.println( lib . loanBook(b));//true
System.out.println( lib . loanBook(a));//true
lib .printLoans();// a b
```
## [SafeSet](https://github.com/Indisparte/Java-practice/tree/main/JFC/SafeSet)
Realizzare la classe SafeSet, che rappresenta un insieme che richiede due passaggi per rimuovere completamente un oggetto. Il metodo add aggiunge un elemento all'insieme, restituendo true se l'inserimento ha avuto successo. Il metodo remove rimuove un elemento dall'insieme, ma la rimozione è definitiva solo dopo una seconda chiamata. Il metodo contains verifica se l'insieme contiene un dato elemento (in base a equals). Infine, un SafeSet deve essere thread-safe.
```java
SafeSet<String> a = new SafeSet<>();
System.out.println(a.add("ciao"));//true
System.out.println(a.add("mondo"));//true
System.out.println(a.remove("ciao"));//true
System.out.println(a.contains("ciao"));//false
System.out.println(a.remove("ciao"));// true
System.out.println(a.contains("ciao")) ;//false
```
## [Book & Library](https://github.com/Indisparte/Java-practice/tree/main/JFC/Book%26Library)
Realizzare le classi **Book** e **Library**, che rappresentano rispettivamente un libro e una collezione
di libri. Il metodo **addBook** di **Library** aggiunge un libro alla collezione, con un dato titolo e un
dato autore. A ciascun libro è possibile attribuire uno o più argomenti tramite il suo metodo
**addTag**. Il metodo **getBooksByTag** di Library restituisce in tempo costante l'insieme dei libri di
un argomento dato.
L'implementazione deve rispettare il seguente esempio d'uso:
```java
Library casa = new Library(), ufficio = new Library();
Library.Book b1 = casa.addBook("Esercizi di stile", "Queneau");
b1.addTag("letteratura");
b1.addTag("umorismo");
Library.Book b2 = casa.addBook("Me parlare bene un giorno", "Sedaris");
b2.addTag("umorismo");
Library.Book b3 = ufficio.addBook("Literate programming", "Knuth");
b3.addTag("programmazione");
Set<Library.Book> humorCasa = casa.getBooksByTag("umorismo");
System.out.println(humorCasa);
Set<Library.Book> humorUfficio = ufficio.getBooksByTag("umorismo");
System.out.println(humorUfficio);//[Esercizi di stile, by Queneau, Me parlare bene un giorno, by Sedaris]
//null
```
## [Bug](https://github.com/Indisparte/Java-practice/tree/main/JFC/Bug)
Realizzare la classe **Bug**, che rappresenta un errore in un programma. Il costruttore accetta
una descrizione dell'errore. Inizialmente, l'errore non è assegnato ad alcuno sviluppatore. Il metodo **assignTo** assegna l'errore ad uno sviluppatore, identificato dal nome, che sarà incaricato di risolvere l'errore.
Il metodo statico **getUnassigned** restituisce in tempo costante l'insieme degli errori non ancora
assegnati. Il metodo statico **getAssignedTo** restituisce in tempo costante l'insieme degli errori
assegnati ad uno sviluppatore dato.
Nota: un bug assegnato ad uno sviluppatore può essere riassegnato ad un altro.
L'implementazione deve rispettare il seguente esempio d'uso:
```java
Bug b1 = new Bug("Application crashes on Windows 8"),
b2 = new Bug("Application freezes after 2 hours"),
b3 = new Bug("Application does not print on laser 
printer"),
b4 = new Bug("Data missing after partial save");
Set<Bug> unassigned = Bug.getUnassigned();
System.out.println(unassigned.size ()) ;
b2.assignTo("Paolo");
b3.assignTo("Filomena");
b4.assignTo("Filomena");
System.out.println(unassigned.size ()) ;
Set<Bug> lo = Bug.getAssignedTo("Filomena");
System.out.println( lo ) ;
```
## [Room](https://github.com/Indisparte/Java-practice/tree/main/JFC/Room)
Realizzare le classi **Room** e **Reservation**, che rappresentano una camera d'albergo
e una prenotazione per la camera. Il metodo reserve di Room accetta un nome, la data di
inizio e di fine prenotazione, e restituisce un oggetto di tipo Reservation. Se la camera è occupata
in una delle giornate richieste, il metodo lancia un'eccezione. Per semplicità, una data è rappresentata
da un numero intero tra 0 a 365. Il metodo **reservations** di Room consente di scorrere
l'elenco delle prenotazioni, in ordine cronologico.
L'implementazione deve rispettare il seguente esempio d'uso.
```java
Room r = new Room();
Reservation p1 = r.reserve("Pasquale Caero", 105, 120);
Reservation p2 = r.reserve("Carlo Martello", 5, 20);
Reservation p3 = r.reserve("Piero", 20, 22);
Reservation p4 = r.reserve("Marinella", 200, 222);
for (Reservation p: r . reservations ())
System.out.println(p.getName());
```
## [isSetSmaller](https://github.com/Indisparte/Java-practice/tree/main/JFC/SetSmaller)
Implementare il metodo statico **isSetSmaller**, che accetta due insiemi e un comparatore, e restituisce
vero se e solo se tutti gli elementi del primo insieme sono più piccoli, in base al comparatore,
di tutti gli elementi del secondo insieme.
Porre particolare attenzione alla scelta della firma.
# [Classi interne](https://github.com/Indisparte/Java-practice/tree/main/Classi%20interne)
## [Washer](https://github.com/Indisparte/Java-practice/tree/main/Classi%20interne/Washer)
La seguente classe rappresenta le operazioni elementari di una lavatrice:
```java
class Washer {
public void setTemp(int temp) { System.out.println("Setting temperature to " + temp); }
public void setSpeed(int rpm) { System.out.println("Setting speed to " + rpm); }
public void addSoap() { System.out.println("Adding soap!"); }
}
```
Si implementi una classe **Program**, che rappresenta un programma di lavaggio per una lavatrice.
Il metodo **addAction** aggiunge una nuova operazione elementare al programma. Un'operazione
elementare può essere una delle tre operazioni elementari della lavatrice, oppure l'operazione
**Wait**, che aspetta un dato numero di minuti. Il metodo **execute** applica il programma ad una
data lavatrice.
```java
Washer w = new Washer();
Program p = new Program();
p.addAction(new Program.SetTemp(30));//Setting temperature to 30
p.addAction(new Program.SetSpeed(20));//Setting speed to 20
p.addAction(new Program.Wait(10));
p.addAction(new Program.AddSoap());//Adding soap! (dopo 10 minuti)
p.addAction(new Program.SetSpeed(100));////Setting speed to 100
p.addAction(new Program.Wait(10));
p.addAction(new Program.SetSpeed(0));//Setting speed to 0 (dopo 10 minuti)
p.execute(w);
```
## [Interval](https://github.com/Indisparte/Java-practice/tree/main/Classi%20interne/Interval)
Si implementi la classe **Interval**, che rappresenta un intervallo di numeri reali. Un intervallo
può essere chiuso oppure aperto, sia a sinistra che a destra. Il metodo **contains** prende come argomento un numero x e restituisce vero se e solo se x appartiene a questo intervallo. Il metodo
**join** restituisce l'unione di due intervalli, senza modificarli, sollevando un'eccezione nel caso in
cui questa unione non sia un intervallo. Si implementino anche le classi **Open** e **Closed**, in modo
da rispettare il seguente caso d'uso.
```java
Interval i1 = new Interval.Open(5, 10.5);
Interval i2 = new Interval.Closed(7, 20);
Interval i3 = i1. join (i2) ;
System.out.println(i1 .contains(5)) ;//false
System.out.println(i1) ;//(5,10,5)
System.out.println(i2) ;//[7,20]
System.out.println(i3) ;//(5,20]
```
## [Triangolo](https://github.com/Indisparte/Java-practice/tree/main/Classi%20interne/Triangolo)
Nell'ambito di un programma di geometria, si implementi la classe **Triangolo**, il cui costruttore
accetta le misure dei tre lati. Se tali misure non danno luogo ad un triangolo, il costruttore deve
lanciare un'eccezione. Il metodo **getArea** restituisce l'area di questo triangolo. Si implementino
anche la classe **Triangolo.Rettangolo**, il cui costruttore accetta le misure dei due cateti, e la classe
**Triangolo.Isoscele**, il cui costruttore accetta le misure della base e di uno degli altri lati.
Si ricordi che:
* Tre numeri a, b e c possono essere i lati di un triangolo a patto che a < b + c, b < a + c e c < a + b.
* L'area di un triangolo di lati a, b e c è data da:
$\sqrt{p \cdot p \cdot (p - a) \cdot (p - b) \cdot (p - c)}$(formula di Erone)
dove p è il semiperimetro.
```java
Triangolo x = new Triangolo(10,20,25);
Triangolo y = new Triangolo.Rettangolo(5,8);
Triangolo z = new Triangolo.Isoscele(6,5);
System.out.println(x.getArea());//94.9918
System.out.println(y.getArea());//19.9999
System.out.println(z.getArea());//12.0
```
# [Iteratori e ciclo foreach](https://github.com/Indisparte/Java-practice/tree/main/Iteratori%20e%20ciclo%20foreach)
## [BinaryTreePreIterator](https://github.com/Indisparte/Java-practice/tree/main/Iteratori%20e%20ciclo%20foreach/BinaryTreePreIterator)
Il seguente frammento di classe denisce un nodo in un albero binario.
```java
public class BinaryTreeNode {
private BinaryTreeNode left, right;
public BinaryTreeNode getLeft() { return left; }
public BinaryTreeNode getRight() { return right; }
}
```

Si implementi una classe iteratore **BinaryTreePreIterator** che visiti i nodi dell'albero in preorder
(ciascun nodo prima dei suoi figli). Tale classe deve poter essere usata nel seguente modo:
```java
public static void main(String[] args) {
 BinaryTreeNode root = ...;
 Iterator i = new BinaryTreePreIterator(root);
	while (i.hasNext()) {
		BinaryTreeNode node = (BinaryTreeNode) i.next();
		...
	}
}
```
## [Primes](https://github.com/Indisparte/Java-practice/tree/main/Iteratori%20e%20ciclo%20foreach/Primes)
Definire una classe **Primes** che rappresenta l'insieme dei numeri primi. Il campo statico iterable
fornisce un oggetto su cui si può iterare, ottenendo l'elenco di tutti i numeri primi. Non deve essere possibile per un'altra classe creare oggetti di tipo Primes.
*Suggerimento*: Primes potrebbe implementare sia Iterator<Integer> che Iterable<Integer>. In tal
caso, il campo iterable potrebbe puntare ad un oggetto di tipo Primes.
```java
for (Integer i : Primes.iterable ) {
	if ( i > 20) break;
	System.out.println( i ) ;
}
```
# [Uguaglianza tra oggetti](https://github.com/Indisparte/Java-practice/tree/main/Uguaglianza%20tra%20oggetti)
## [Fraction](https://github.com/Indisparte/Java-practice/tree/main/Uguaglianza%20tra%20oggetti/Fraction)
Implementare la classe **Fraction**, che rappresenta una frazione, e la sottoclasse **ReducedFraction**,
che rappresenta una frazione irriducibile.
Due oggetti di questi tipi devono essere uguali per equals se rappresentano lo stesso numero
razionale, anche se uno è di tipo Fraction e l'altro ReducedFraction.
Oltre a un costruttore che accetta numeratore e denominatore, le due classi offrono il metodo
**times**, che calcola il prodotto, restituendo un nuovo oggetto Fraction. Il nuovo oggetto deve essere
di tipo effttivo ReducedFraction se e soltanto se entrambi gli operandi del prodotto sono di tipo
effettivo ReducedFraction.
*Suggerimento*: per calcolare il massimo comun divisore tra due interi a e b, si può usare
l'istruzione 
```java
BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue().
```



```java
Fraction a = new Fraction(12,30), b = new ReducedFraction
(12,30),
c = new Fraction(1,4), d = c.times(a);
System.out.println(a);//12/30
System.out.println(b);//2/5
System.out.println(d);//12/120
System.out.println(a.equals(b));//true
System.out.println(c.times(b));//2/20
```

