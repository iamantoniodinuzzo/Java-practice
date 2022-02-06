<p>
<center><h1> Esercizi di Java avanzato</h1></center>
</p>

<img src='https://random-memer.herokuapp.com/' title="Meme" alt="Please refresh the page if the meme doesn't show up.">

## Table of contents
<!-- TABLE OF CONTENTS -->
  <ul>
    <li><a href="#java-collection-framework">Java Collection Framework</a></li>
    <li><a href="#esercizi-elementari">Esercizi elementari</a></li>
    <li><a href="#classi-interne">Classi Interne</a></li>
	<li><a href="#programmazione-parametrica">Programmazione parametrica</a></li>
    <li><a href="#criterio-di-ordinamento-tra-oggetti">Criterio di ordinamento tra oggetti</a></li>
    <li><a href="#iteratori-e-ciclo-foreach">Iteratori e ciclo foreach</a></li>
    <li><a href="#uguaglianza-tra-oggetti">Uguaglianza tra oggetti</a></li>
    <li><a href="#scelta-della-firma">Scelta della firma</a></li>
    <li><a href="#multithreading">Multithreading</a></li>
	<li><a href="#binding-dinamico">Binding Dinamico</a></li>
	<li><a href="#contatto">Contatto</a></li>

  </ul>

<!-- ABOUT THE PROJECT -->

## About The Project
Questa repository è stata creata per esercitarmi con l'esame a scelta di **Linguaggi di programmazione II** del seguente [CDL](http://informatica.dieti.unina.it/index.php/it/)

- Ogni **titolo di sezione** porta alla cartella contentente altri esercizi inerenti a quell'argomento.
- Ogni **titolo di esercizio** porta all'esercizio specifico e al suo svolgimento.
	- Se questo non dovesse capitare è perchè l'esercizio è targato come incompleto.

Alcuni di questi esercizi presentano dei *tips* presi dal libro [Effective Java](https://www.amazon.it/Effective-Java-Joshua-Bloch-dp-0134685997/dp/0134685997/ref=dp_ob_image_bk) che sto raccogliento in un file che presto renderò disponibile in questa repository.

Fanne buon uso!


<!-- JAVA COLLECTION FRAMEWORK -->

# [Java Collection Framework](https://github.com/Indisparte/Java-practice/tree/main/JFC)
<details>
	<summary>Clicca per espandere !</summary>

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
Set<Bug> filo = Bug.getAssignedTo("Filomena");
System.out.println( filo ) ;
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
Reservation p1 = r.reserve("Pasquale Cero", 105, 120);
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

## [subMap](https://github.com/Indisparte/Java-practice/tree/main/JFC/subMap)
Implementare il metodo subMap che accetta una mappa e una collezione e restituisce una nuova
mappa ottenuta restringendo la prima alle sole chiavi che compaiono nella collezione. Il metodo
non modifica i suoi argomenti.
Valutare le seguenti intestazioni per il metodo subMap, in base ai criteri di funzionalità, completezza,
correttezza, fornitura di ulteriori garanzie, semplicità e specificità del tipo di ritorno.
Infine, scegliere l'intestazione migliore oppure proporne un'altra.
```java
/*a)*/ <K> Map<K,?> subMap(Map<K,?> m, Collection<K> c)
/*b)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<?> c)
/*c)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? super K> c)
/*d)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? extends K> c)
/*e)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Set<K> c)
/*f)*/ <K,V,K2 extends K> Map<K,V> subMap(Map<K,V> m, Collection<K2> c)
```

## [Merge](https://github.com/Indisparte/Java-practice/tree/main/JFC/Merge)
Realizzare un metodo chiamato merge che rispetti il seguente contratto:

**Pre-condizione** Accetta due LinkedList dello stesso tipo e di pari lunghezza.<br>

**Post-condizione** Restituisce una nuova LinkedList ottenuta alternando gli elementi della prima
lista e quelli della seconda.</br>
Ad esempio, se la prima lista contiene (1; 2; 3) e la seconda lista (4; 5; 6), la nuova lista deve
contenere (1; 4; 2; 5; 3; 6).</br>

**Penale** Se le liste non hanno la stessa lunghezza, lancia IllegalArgumentException

## [Component & Configuration](https://github.com/Indisparte/Java-practice/tree/main/JFC/Component&Configuration)
Un sito vuole consentire agli utenti di ordinare computer assemblati. Data l'enumerazione:
</br>enum Type { CPU, BOARD, RAM; }</br>
implementare le classi Component, che rappresenta un componente di un PC, e Configuration, che
rappresenta un PC da assemblare.</br>

Un componente è caratterizzato dalla sua tipologia (Type) e da una descrizione (stringa). Il suo
metodo setIncompatible dichiara che questo componente è incompatibile con un altro componente,
passato come argomento. Un componente può essere incompatibile con diversi altri componenti.</br>

Il metodo add di Configuration aggiunge un componente a questo PC e restituisce true, ma solo
se il componente è compatibile con quelli già inseriti, ed è di tipo diverso da quelli già inseriti,
altrimenti non lo inserisce e restituisce false.</br>

**Suggerimento**: Una classe Component ben progettata non nominerà le 3 istanze di Type.</br>

L'implementazione deve rispettare il seguente esempio d'uso.
**Esempio d'uso**
```java

Component cpu1 = new Component(Type.CPU, "Ryzen 5 2600"),
	cpu2 = new Component(Type.CPU, "Core i5 7500"),
	board1 = new Component(Type.BOARD, "Prime X470"),
	board2 = new Component(Type.BOARD, "Prime Z370"),
	ram = new Component(Type.RAM, "DDR4 8GB");
	cpu1.setIncompatible(board2);
	board1.setIncompatible(cpu2);
Configuration pc = new Configuration();
System.out.println(pc.add(cpu1));
System.out.println(pc.add(cpu2)); // due cpu! false
System.out.println(pc.add(board2)); // incompatibile ! false
System.out.println(pc.add(board1));
System.out.println(pc.add(ram));
```

## [Clinica](https://github.com/Indisparte/Java-practice/tree/main/JFC/Clinica-Incompleto)
Data la seguente enumerazione:</br>
enum Specialista { OCULISTA, PEDIATRA; }</br>
Realizzare la classe Clinica, che permette di prenotare e cancellare visite mediche. I metodi
prenota e cancellaPrenotazione accettano uno specialista e il nome di un paziente, ed effettuano
o cancellano la prenotazione, rispettivamente. Il metodo getPrenotati restituisce l'elenco dei
prenotati.</br>
La classe deve rispettare le seguenti proprietà:</br>

 - Non ci si può prenotare con più di uno specialista.
 - Si deve poter aggiungere uno specialista all'enumerazione senza dover
   modificare la classe Clinica.

</br>
Inoltre, l'implementazione deve rispettare il seguente **esempio d'uso**:

```java
Clinica c = new Clinica();
c.prenota(Specialista .OCULISTA, "Pippo Franco");
c.prenota(Specialista .OCULISTA, "Leo Gullotta");
c.prenota(Specialista .OCULISTA, "Leo Gullotta");
c.prenota(Specialista .PEDIATRA, "Ciccio Ingrassia");
c.prenota(Specialista .PEDIATRA, "Leo Gullotta");
c.cancellaPrenotazione(Specialista .PEDIATRA, "Ciccio Ingrassia");
Collection<String> ocu = c.getPrenotati(Specialista.OCULISTA);
System.out.println(ocu);//[Leo Gullotta, Pippo Franco]
System.out.println(c.getPrenotati( Specialista .PEDIATRA));//[]
```
## [MergeIfSorted](https://github.com/Indisparte/Java-practice/tree/main/JFC/mergeIfSorted-Incompleto)

Implementare il metodo statico *mergeIfSorted*, che accetta due liste *a* e *b*, e un comparatore *c*, e
restituisce un'altra lista. Inizialmente, usando due thread diversi, il metodo verifica che le liste
a e b siano ordinate in senso non decrescente (ogni thread si occupa di una lista). Poi, se le liste
sono effettivamente ordinate, il metodo le fonde (senza modificarle) in un'unica lista ordinata,
che viene restituita al chiamante. Se, invece, almeno una delle due liste non è ordinata, il metodo
termina restituendo null.</br>
Il metodo dovrebbe avere complessità di tempo lineare.</br>
Porre particolare attenzione alla scelta della firma, considerando i criteri di funzionalità, completezza,
correttezza, fornitura di garanzie e semplicità.

## [SocialUser](https://github.com/Indisparte/Java-practice/tree/main/JFC/SocialUser)

Per un social network, implementare le classi *SocialUser* e *Post*. Un utente è dotato di un nome
e può creare dei post tramite il metodo newPost. Il contenuto di un post è una stringa, che
può contenere nomi di utenti, preceduti dal simbolo "@". Il metodo **getTagged** della classe Post
restituisce l'insieme degli utenti il cui nome compare in quel post, mentre il metodo **getAuthor**
restituisce l'autore del post.</br>
L'implementazione deve rispettare il seguente **esempio d'uso**:
```java
SocialUser adriana = new SocialUser("Adriana"),
			barbara = new SocialUser("Barbara");
SocialUser.Post p = adriana.newPost("Ecco una foto con @Barbara e @Carla.");
Set<SocialUser> tagged = p.getTagged();
System.out.println(tagged);//[Barbara]
System.out.println(tagged. iterator () .next() == barbara);//true
System.out.println(p.getAuthor());//Adriana
```
*Suggerimento*: l'invocazione a.lastIndexOf(b) restituisce -1 se la stringa b non è presente nella
stringa a, e un numero maggiore o uguale di zero altrimenti.

## [GameLevel](https://github.com/Indisparte/Java-practice/tree/main/JFC/GameLevel-Incompleto)

Implementare la classe *GameLevel*, che rappresenta un livello in un gioco 2D, in cui un personaggio
si muove su una griglia di caselle. Il costruttore accetta le dimensioni del livello (larghezza e
altezza). Il metodo **setWall** accetta le coordinate di una casella e mette un muro in quella casella.
Il metodo **areConnected** accetta le coordinate di due caselle e restituisce *vero* se e solo se esiste
un percorso tra di loro.
```java
GameLevel map = new GameLevel(3, 3);
System.out.println(map.areConnected(0,0,2,2));//true
map.setWall(0,1);
map.setWall(1,1);
System.out.println(map.areConnected(0,0,2,2));//true
map.setWall(2,1);
System.out.println(map.areConnected(0,0,2,2));//false
```
## [Curriculum](https://github.com/Indisparte/Java-practice/tree/main/JFC/Curriculum)
Un oggetto Curriculum rappresenta una sequenza di lavori, ognuno dei quali è un'istanza della
classe Job. Il costruttore di Curriculum accetta il nome di una persona. Il metodo addJob aggiunge
un lavoro alla sequenza, caratterizzato da una descrizione e dall'anno di inizio, restituendo un
nuovo oggetto di tipo Job. Infine, la classe Job offre il metodo next, che restituisce in tempo
costante il lavoro successivo nella sequenza (oppure null).</br>
Implementare le classi Curriculum e Job, rispettando il seguente caso d'uso.
```java
Curriculum cv = new Curriculum("Walter White");
Curriculum.Job j1 = cv.addJob("Chimico", 1995);
Curriculum.Job j2 = cv.addJob("Insegnante", 2005);
Curriculum.Job j3 = cv.addJob("Cuoco", 2009);
System.out.println(j2 .next()) ;//Cuoco: 2009
System.out.println(j3 .next()) ;//null
```

## [Progression](https://github.com/Indisparte/Java-practice/tree/main/JFC/Progression)
Nell'ambito di un programma di gestione del personale, la classe Progression calcola il salario dei
dipendenti, in base alla loro anzianità in servizio. Il salario mensile parte da un livello base ed ogni
anno solare aumenta di un certo incremento. Il costruttore accetta il salario base e l'incremento
annuale. Il metodo **addEmployee** aggiunge un impiegato a questa progressione, specificando il
nome e l'anno di assunzione. Il metodo **getSalary** restituisce il salario mensile di un impiegato
in un dato anno. Infine, il metodo **addBonus** attribuisce ad un impiegato un bonus extra in un
dato anno. Cioè, addBonus("Pippo", 2010, 50) significa che Pippo percepirà 50 euro in più in ogni
mese del 2010.
</br>**Caso d'uso**

```java
Progression a = new Progression(1000, 150);

a.addEmployee("Jesse", 2008);
a.addEmployee("Gale", 2009);
a.addBonus("Gale", 2010, 300);

System.out.println(a.getSalary("Jesse", 2009));//1150
System.out.println(a.getSalary("Gale", 2010));//1450
System.out.println(a.getSalary("Gale", 2011));//1300
```

## [Controller](https://github.com/Indisparte/Java-practice/tree/main/JFC/Controller-Incompleto)
Realizzare la classe Controller, che rappresenta una centralina per autoveicoli, e la classe Function,
che rappresenta una funzionalità del veicolo, che può essere accesa o spenta. Alcune funzionalità
sono *incompatibili* tra loro, per cui accenderne una fa spegnere automaticamente l'altra.</br>

La classe Controller ha due metodi: **addFunction** aggiunge al sistema una nuova funzionalità con
un dato nome; **printOn** stampa a video i nomi delle funzionalità attive. La classe Function ha tre
metodi: **turnOn** e **turnOff** per attivarla e disattivarla; **setIncompatible** accetta un'altra funzionalità
x e imposta un'incompatibilità tra this e x.</br>

Leggere attentamente il seguente caso d'uso, che mostra, tra le altre cose, che l'incompatibilità è
automaticamente simmetrica, ma **non** transitiva.

```java
Controller c = new Controller();
Controller .Function ac = c.addFunction("Aria condizionata");
Controller .Function risc = c.addFunction("Riscaldamento");
Controller .Function sedile = c.addFunction("Sedile riscaldato");

ac.setIncompatible(risc ) ;
ac.setIncompatible(sedile ) ;
ac.turnOn();
c.printOn();//Aria condizionata
System.out.println("----");//----

risc .turnOn();
sedile .turnOn();
c.printOn();//Sedile riscaldato \n Riscaldamento
```

## [Relation](https://github.com/Indisparte/Java-practice/tree/main/JFC/Relation)
Realizzare la classe **Relation**, che rappresenta una relazione binaria tra un insieme S e un insieme
T. In pratica, una Relation è analoga ad una Map, con la differenza che la Relation accetta chiavi
duplicate.</br>
Il metodo **put** aggiunge una coppia di oggetti alla relazione. Il metodo **remove** rimuove una coppia
di oggetti dalla relazione. Il metodo **image** accetta un oggetto x di tipo S e restituisce l'insieme
degli oggetti di tipo T che sono in relazione con x. Il metodo **preImage** accetta un oggetto x di
tipo T e restituisce l'insieme degli oggetti di tipo S che sono in relazione con x.
**Caso d'uso**

```java
Relation<Integer,String> r = new Relation<Integer,String>();
r .put(0, "a"); r .put(0, "b"); r .put(0, "c");
r .put(1, "b"); r .put(2, "c");
r .remove(0, "a");
Set<String> set0 = r.image(0);
Set<Integer> setb = r.preImage("b");
System.out.println(set0) ;//[b,c]
System.out.println(setb) ;//[0,1]
```
## [Contest](https://github.com/Indisparte/Java-practice/tree/main/JFC/Contest)
Un oggetto di tipo Contest consente ai client di votare per uno degli oggetti che partecipano a
un "concorso". Implementare la classe parametrica **Contest** con i seguenti metodi: il metodo **add**
consente di aggiungere un oggetto al concorso; il metodo **vote** permette di votare per un oggetto;
se l'oggetto passato a vote non partecipa al concorso (cioè non è stato aggiunto con add), viene
lanciata un'eccezione; il metodo **winner** restituisce uno degli oggetti che fino a quel momento ha
ottenuto più voti.</br>
Tutti i metodi devono funzionare in tempo costante.
**Caso d'uso**
```java
Contest<String> c = new Contest<String>();
String r = "Red", b = "Blue", g = "Green";
c.add(r);
c.vote(r) ;
c.add(b);
c.add(g);
c.vote(r) ;
c.vote(b);
System.out.println(c.winner());//Red
```
## [inverseMap](https://github.com/Indisparte/Java-practice/tree/main/JFC/inverseMap)
Implementare il metodo inverseMap che accetta una mappa m e ne restituisce una nuova, ottenuta
invertendo le chiavi con i valori. Se m contiene valori duplicati, il metodo lancia un'eccezione. Il
metodo non modifica la mappa m.</br>
Valutare le seguenti intestazioni per il metodo inverseMap, in base ai criteri di funzionalità,
completezza, correttezza, fornitura di ulteriori garanzie, semplicità e specificità del tipo di ritorno.
Infine, scegliere l'intestazione migliore oppure proporne un'altra.
```java
/*a)*/ <K,V> Map<V,K> inverseMap(Map<?,?> m)
/*b)*/ Map<?,?> inverseMap(Map<?,?> m)
/*c)*/ <K,V> Map<K,V> inverseMap(Map<V,K> m)
/*d)*/ <K,V> Map<K,V> inverseMap(Map<? extends V, ? super K> m)
/*e)*/ <K,V> Map<K,V> inverseMap(Map<K,V> m)
/*f)*/ <K,V> Map<K,V> inverseMap(Map<? extends V, ? extends K> m)
``` 
## [BoundedSet](https://github.com/Indisparte/Java-practice/tree/main/JFC/BoundedSet)
Realizzare la classe **BoundedSet**, che rappresenta un insieme di capacità limitata. Il costruttore
accetta la capacità massima dell'insieme. La classe deve implementare i metodi **add**, **contains** e **size**
secondo il contratto previsto dall'interfaccia Set. Se però l'insieme è alla sua capacità massima e
si tenta di inserire un nuovo elemento con **add**, prima dell'inserimento sarà cancellato dall'insieme
l'elemento che vi è stato inserito prima (cioè, l'elemento più "*vecchio*" presente nell'insieme).</br>
Fare in modo che sia add sia contains funzionino in tempo costante.
**Esempio d'uso**

```java
BoundedSet<Integer> s = new BoundedSet<Integer>(3);
s .add(3); s .add(8); s .add(5); s .add(5);
System.out.println(s . size ()) ;//3
System.out.println(s .contains(3)) ;//true
s .add(14);
System.out.println(s . size ()) ;//3
System.out.println(s .contains(3)) ;//false
```
## [Movie](https://github.com/Indisparte/Java-practice/tree/main/JFC/Movie)
La classe **Movie** rappresenta un film, con attributi titolo (stringa) e anno di produzione (intero).
Alcuni film formano delle serie, cioè sono dei sequel di altri film. La classe offre due costruttori:
uno per film normali e uno per film appartenenti ad una serie. Quest'ultimo costruttore accetta
come terzo argomento il film di cui questo è il successore.</br>
Il metodo **getSeries** restituisce la lista dei film che formano la serie a cui questo film appartiene.
Se invocato su un film che non appartiene ad una serie, il metodo restituisce una lista contenente
solo questo film.</br>
Il metodo statico **selectByYear** restituisce l'insieme dei film prodotti in un dato anno, in tempo
costante.
**Esempio d'uso**
```java
Movie r1 = new Movie("Rocky", 1976);
Movie r2 = new Movie("Rocky II", 1979, r1);
Movie r3 = new Movie("Rocky III", 1982, r2);
Movie f = new Movie("Apocalypse Now", 1979);
Set<Movie> movies1979 = Movie.selectByYear(1979);//[Rocky II, Apocalypse Now]
System.out.println(movies1979);
List<Movie> rockys = r2.getSeries();
System.out.println(rockys);//[Rocky, Rocky II, Rocky III]
```
## [ComposeMaps](https://github.com/Indisparte/Java-practice/tree/main/JFC/composeMaps-Incompleto)
Il metodo composeMaps accetta due mappe a e b, e restituisce una nuova mappa c così definita:
le chiavi di c sono le stesse di a; il valore associato in c ad una chiave x è pari al valore associato
nella mappa b alla chiave a(x).</br>
Nota: Se consideriamo le mappe come funzioni matematiche, la mappa c è definita come c(x) =
b(a(x)), cioè come composizione di a e b.</br>
Valutare ciascuna delle seguenti intestazioni per il metodo composeMaps, in base ai criteri di
funzionalità, completezza, correttezza, fornitura di ulteriori garanzie, specificità del tipo di ritorno
e semplicità. Infine, scegliere l'intestazione migliore oppure proporne un'altra.</br>
```java
/*a)*/<S, T, U> Map<S,U> composeMaps(Map<S, T> a, Map<T, U> b)
/*b)*/<S, T, U> Map<S,U> composeMaps(Map<S, T> a, Map<? extends T, U> b)
/*c)*/<S, T, U> Map<S,U> composeMaps(Map<S, T> a, Map<? super T, U> b)
/*d)*/<S, U> Map<S,U> composeMaps(Map<S, ?> a, Map<?, U> b)
/*e)*/<S, U> Map<S,U> composeMaps(Map<S, Object> a, Map<Object, U> b)
```

## [City](https://github.com/Indisparte/Java-practice/tree/main/JFC/City-Incompleto)
La classe City rappresenta una città. Il costruttore accetta il nome della città, mentre il metodo
connect accetta un'altra città e stabilisce un collegamento tra le due (una strada o un altro tipo
di collegamento). Tutti i collegamenti sono bidirezionali.</br>
Il metodo **getConnections** restituisce la collezione delle città direttamente collegate a questa. Il
metodo **isConnected** prende come argomento un'altra città e restituisce vero se è collegata a this
direttamente o indirettamente (cioè, tramite un numero arbitrario di collegamenti).
```java
City n = new City("Napoli"), r = new City("Roma"), s = new City
("Salerno"), p = new City("Parigi");
n.connect(s);
n.connect(r);
Collection<City> r_conn = r.getConnections();
System.out.println(r_conn);//[Napoli]
System.out.println(r .isConnected(s));//true
System.out.println(r .isConnected(p));//false
```

## [Auditorium](https://github.com/Indisparte/Java-practice/tree/main/JFC/Auditorium)
La seguente classe (semplificata) Seat rappresenta un posto in un auditorium.</br>
```java
public class Seat { public int row, col; }
```
La classe Auditorium serve ad assegnare i posti in un teatro. Il costruttore prende come argomenti
le dimensioni della platea, in termini di file e posti per fila, nonché un oggetto Comparator che
serve ad ordinare i posti in ordine di preferenza. Il metodo assignSeats prende come argomenti
il numero n di posti richiesti e restituisce un insieme contenente gli n posti migliori (in base
al comparatore) ancora disponibili. Se la platea non contiene n posti disponibili, il metodo
restituisce null.
**Esempio d'uso**
```java
Auditorium a = new Auditorium(5, 5, new Comparator<Seat>() {
public int compare(Seat a, Seat b) {
return (a.row==b.row)? (a.col-b.col): (a.row-b.row);
}
});
Set<Seat> s = a.assignSeats(4);
System.out.println(s) ;//[(0,0),(0,1),(0,2),(0,3)]
```

## [SocialNetwork](https://github.com/Indisparte/Java-practice/tree/main/JFC/SocialNetwork)
Nell'ambito dell'implementazione di un social network, la classe **Person** rappresenta un utente.
Tramite i metodi **addFriend** e **addEnemy** è possibile aggiungere un amico o un nemico a questa
persona, rispettando le seguenti regole:</br>
- una persona non può aggiungere se stessa come amico o nemico;
- una persona non può aggiungere la stessa persona sia come amico sia come nemico.
</br>Il metodo **contacts** permette di iterare su tutti i contatti di questa persona tramite un iteratore,
che restituirà prima tutti gli amici e poi tutti i nemici.</br>

**Esempio d'uso**
```java
Person a = new Person("Antonio");
Person c = new Person("Cleopatra");
Person o = new Person("Ottaviano");
a.addEnemy(o);
a.addFriend(c);
for (Person p: a.contacts())
	System.out.println(p);//Cleopatra \n Ottaviano
```
## [Panino](https://github.com/Indisparte/Java-practice/tree/main/JFC/Panino)
Implementare la classe Panino, il cui metodo **addIngrediente** aggiunge un ingrediente, scelto da
un elenco fisso. Gli ingredienti sono divisi in categorie. Se si tenta di aggiungere più di un
ingrediente della stessa categoria, il metodo addIngrediente solleva un'eccezione.
Elenco delle categorie e degli ingredienti:</br>
- **ripieni**: PROSCIUTTO, SALAME
- **formaggi**: SOTTILETTA, MOZZARELLA
- **salse**: MAIONESE, SENAPE
</br>**Esempio d'uso**

```java
Panino p = new Panino();
p.addIngrediente(Panino.Ingrediente.SALAME);
p.addIngrediente(Panino.Ingrediente.SOTTILETTA);
System.out.println(p);//panino con SALAME, SOTTILETTA
p.addIngrediente(Panino.Ingrediente.MOZZARELLA);//EXCPETION	
```

## [MakeMap](https://github.com/Indisparte/Java-practice/tree/main/JFC/MakeMap)
Scrivere un metodo che accetta due liste (**List**) **k** e **v** di pari lunghezza, e restituisce una **mappa**
in cui all'elemento i-esimo di k viene associato come valore l'elemento i-esimo di v.
Il metodo lancia un'eccezione se le liste non sono di pari lunghezza, oppure se k contiene elementi
duplicati.
Si ricordi che non è opportuno utilizzare l'accesso posizionale su liste generiche.

## [Intersect](https://github.com/Indisparte/Java-practice/tree/main/JFC/Intersect)
Implementare il metodo statico intersect, che accetta come argomenti due **Collection** x e y e
restituisce una nuova Collection che contiene l'intersezione di x ed y (cioè, gli oggetti comuni ad
entrambe le collezioni).</br>
Prestare particolare attenzione alla scelta della firma del metodo.

## [SelectKeys](https://github.com/Indisparte/Java-practice/tree/main/JFC/SelectKeys)
Scrivere un metodo che accetta una lista *l* e una mappa *m*, e restituisce una nuova lista che
contiene gli elementi di *l* che compaiono come chiavi in *m*.</br> Porre particolare attenzione alla
scelta della firma.

## [Color](https://github.com/Indisparte/Java-practice/tree/main/JFC/Color)
La classe **Color** rappresenta un colore, determinato dalle sue componenti RGB. La classe offre
alcuni colori predefiniti, tra cui **RED**, **GREEN** e **BLUE**. Un colore nuovo si può creare solo con
il metodo factory make. Se il client cerca di ricreare un colore predefinito, gli viene restituito
quello e non uno nuovo.</br> Ridefinire anche il metodo toString, in modo che rispetti il seguente caso
d'uso.
```java
Color rosso = Color.RED;
Color giallo = Color.make(255, 255, 0);
Color verde = Color.make(0, 255, 0);

System.out.println(rosso) ;//red
System.out.println( giallo ) ;//(255,255,0)
System.out.println(verde);//green
System.out.println(verde == Color.GREEN);//true
```
## [GetByType](https://github.com/Indisparte/Java-practice/tree/main/JFC/GetByType)
Implementare il metodo statico getByType che, data una collezione c (Collection) ed un oggetto
x di tipo Class, restituisce un oggetto della collezione il cui tipo effettivo sia esattamente x. Se
un tale oggetto non esiste, il metodo restituisce null.</br>
Prestare particolare attenzione alla scelta della firma del metodo. Si ricordi che la classe Class è
parametrica.

## [RadioChannel](https://github.com/Indisparte/Java-practice/tree/main/JFC/RadioChannel)
Radio offre un costruttore senza argomenti e i seguenti metodi:
- addChannel memorizza e restituisce una nuova stazione,caratterizzata da nome e frequenza. Il tentativo di memorizzare una stazione che ha la stessa frequenza di una stazione già memorizzata deve provocare un’eccezione.
- nearest accetta una frequenza e restituisce la stazione con la frequenza più vicina a quella data.

Inoltre, se si itera su un oggetto Radio si ottiene la sequenza di stazioni inserite, in ordine crescente di frequenza.

Fare in modo che l’unico modo per creare oggetti Channel sia tramite il metodo addChannel.

L’implementazione deve rispettare il seguente esempio d’uso.
```java
Radio r = new Radio();
Radio.Channel rai1 = r.addChannel("Rai Radio Uno", 89.3);
Radio.Channel kk = r.addChannel("Radio Kiss Kiss", 101.4);
Radio.Channel rmc = r.addChannel("Radio Monte Carlo", 96.4);

for (Radio.Channel c: r) {
	System.out. println (c) ;//Rai Radio Uno (89.3)
							// Radio Monte Carlo (96.4)
							//Radio Kiss Kiss (101.4)
}
System.out. println (r . nearest (98.1)) ;//Radio Monte Carlo (96.4)

```

## [UML](https://github.com/Indisparte/Java-practice/tree/main/JFC/UML)
Nell'ambito di un programma per la progettazione del software, si implementino la classi **UML-Class** e **UMLAggregation**, che rappresentano una classe ed una relazione di aggregazione, all'interno di un diagramma delle classi **UML**. Il costruttore di **UMLAggregation** accetta le due classi tra le
quali vale l'aggregazione, la cardinalità minima e quella massima.
**Esempio d'uso**

```java
UMLClass impianto = new UMLClass(``Impianto'');
UMLClass apparecchio = new UMLClass(``Apparecchio'');
UMLClass contatore = new UMLClass(``Contatore'');
new UMLAggregation(apparecchio, impianto, 1, 1);
new UMLAggregation(impianto, apparecchio, 0,
UMLAggregation.INFINITY);
new UMLAggregation(impianto, contatore, 0, 1);
System.out.println(impianto);//Classe: Impianto
							//Aggregazioni:
							//Impianto-Apparecchio, cardinalità: 0..infinito
							//Impianto-Contatore, cardinalità: 0..1
```

## [CountByType](https://github.com/Indisparte/Java-practice/tree/main/JFC/CountByType)
Implementare il metodo statico countByType che, data una lista di oggetti, stampa a video il
numero di oggetti contenuti nella lista, divisi in base al loro tipo effettivo.

_Attenzione_: il metodo deve funzionare con qualunque tipo di lista e di oggetti contenuti.
**Caso d'uso**
```java
List<Number> l = new LinkedList<Number>();
l .add(new Integer(3));
l .add(new Double(4.0))
l .add(new Float(7.0f));
l .add(new Integer(11));
countByType(l);//java.lang.Double : 1
				//java.lang.Float : 1
				//java.lang.Integer : 2
```

## [VoloEPasseggero](https://github.com/Indisparte/Java-practice/tree/main/JFC/VoloEPasseggero)
Si implementino la classe Volo e la classe Passeggero. Il costruttore della classe **Volo** prende come
argomenti l'istante di partenza e l'istante di arrivo del volo (due numeri interi). Il metodo **add**
permette di aggiungere un passeggero a questo volo. Se il passeggero che si tenta di inserire è
già presente in un volo che si accavalla con questo, il metodo add lancia un'eccezione.

**Esempio d'uso**
```java
Volo v1 = new Volo(1000, 2000);
Volo v2 = new Volo(1500, 3500);
Volo v3 = new Volo(3000, 5000);
Passeggero mario = new Passeggero("Mario");
Passeggero luigi = new Passeggero("Luigi");
v1.add(mario);
v1.add(luigi ) ;
v3.add(mario);
// La seguente istruzione provoca l ' eccezione
v2.add(mario);//Exception in thread "main"...
```

## [PostIt](https://github.com/Indisparte/Java-practice/tree/main/JFC/PostIt)
Un oggetto di tipo PostIt rappresenta un breve messaggio incollato (cioè, collegato) ad un oggetto.
Il costruttore permette di specificare il messaggio e l'oggetto al quale incollarlo. Il metodo
statico **getMessages** prende come argomento un oggetto e restituisce l'elenco dei PostIt collegati
a quell'oggetto, sotto forma di una lista, oppure null se non c'è nessun PostIt collegato.

**Esempio d'uso**
```java
Object frigorifero = new Object();
Object libro = new Object();
new PostIt( frigorifero , "comprare il latte");
new PostIt(libro, "Bello !! ");
new PostIt(libro, " restituire  a Carlo");
List<PostIt> pl = PostIt.getMessages(libro);
	for (PostIt p: pl)
		System.out.println(p);//Bello!!
							//restituire a Carlo
```
## [Molecola](https://github.com/Indisparte/Java-practice/tree/main/JFC/Molecola)
Nell'ambito di un programma di chimica, si implementino le classi **Elemento** e **Molecola**. Un elemento
è rappresentato solo dalla sua sigla ("O" per ossigeno, etc.). Una molecola è rappresentata
dalla sua formula bruta (H_(2)0 per acqua, etc.), cioè dal numero di atomi di ciascun elemento
presente.

**Esempio d'uso**
```java
Elemento ossigeno = new Elemento("O");
Elemento idrogeno = new Elemento("H");
Molecola acqua = new Molecola();
acqua.add(idrogeno, 1);
acqua.add(ossigeno, 1);
acqua.add(idrogeno, 1);
System.out.println(acqua);//H2 O
```

## [WifiENetwork](https://github.com/Indisparte/Java-practice/tree/main/JFC/WifiENetwork)
Realizzare le classi **WiFi** e **Network**, che rappresentano un elenco di reti WiFi e una singola rete. La classe WiFi offre un costruttore senza argomenti e i seguenti metodi:
* **addNetwork**: memorizza e restituisce una nuova rete, caratterizzata da nome (SSID) e intensità del segnale.

* **strongest**: restituisce la rete con l'intensità più alta (più vicina allo zero).

Inoltre, gli oggetti WIFi devono essere iterabili, dando la possibilità di scorrere le reti inserite, _in ordine di intensità decrescente_.

La classe **Network** offre soltanto il metodo **updateStrength**, che aggiorna l'intensità del segnale. Fare in modo che l'unico modo per creare oggetti **Network** sia tramite il metodo **addNetwork**.

L'implementazione deve rispettare il seguente esempio d'uso.

```java
WiFi manager = new WiFi();
WiFi.Network home = manager.addNetwork("Vodafone", -40.5);
WiFi.Network hotel = manager.addNetwork("Hotel Vesuvio", -53.05);
WiFi.Network neighbor = manager.addNetwork("Casa Esposito", -48.95);
neighbor.updateStrength(-39.6);
WiFi.Network x = manager.strongest();
System.out.println(x);//Casa Esposito (-39.6 dBm)
```

## [BoolExpr](https://github.com/Indisparte/Java-practice/tree/main/JFC/BoolExpr)
La classe (o interfaccia) **BoolExpr** rappresenta un'espressione dell'algebra booleana (ovvero un
circuito combinatorio). Il tipo più semplice di espressione è una semplice variabile, rappresentata
dalla classe **BoolVar**, sottotipo di BoolExpr. Espressioni più complesse si ottengono usando gli
operatori di tipo and, or e not, corrispondenti ad altrettante classi sottotipo di **BoolExpr**. Tutte
le espressioni hanno un metodo eval che, dato il valore assegnato alle variabili, restituisce il valore
dell'espressione. Si consideri *attentamente* il seguente caso d'uso.
```java
public static void main(String args[]) {
	BoolVar x = new BoolVar("x");
	BoolVar y = new BoolVar("y");
	BoolExpr notx = new BoolNot(x);
	BoolExpr ximpliesy = new BoolOr(notx, y);
	Map<BoolVar,Boolean> m = new HashMap<BoolVar,Boolean>();
	m.put(x, true);
	m.put(y, true);
	System.out.println(x.eval(m));//true
	System.out.println(ximpliesy.eval(m));//true
	m.put(y, false);
	System.out.println(ximpliesy.eval(m));//false
}
```

## [Recipe](https://github.com/Indisparte/Java-practice/tree/main/JFC/Recipe)
Si implementi una classe **Recipe** che rappresenta una ricetta. Il costruttore accetta il nome della
ricetta. Il metodo **setDescr** imposta la descrizione della ricetta. Il metodo **addIngr** aggiunge
un ingrediente alla ricetta, prendendo come primo argomento la quantità (anche frazionaria)
dell'ingrediente, per una persona, e come secondo argomento una stringa che contiene l'unità di
misura e il nome dell'ingrediente. Se un ingrediente è diffcilmente misurabile, si imposterà la
sua quantità a zero, e verrà visualizzato come "q.b." ("quanto basta"). Il metodo **toString** prende
come argomento il numero di coperti *n* e restituisce una stringa che rappresenta la ricetta, in cui
le quantità degli ingredienti sono state moltiplicate per n.

**Esempio d'uso**

```java
Recipe r = new Recipe("Spaghetti aglio e olio");
r .addIngr(100, "grammi di spaghetti");
r .addIngr(2, "cucchiai d' olio d' oliva");
r .addIngr(1, "spicchi d' aglio");
r .addIngr(0, "sale");
r .setDescr("Mischiare tutti gli  ingredienti  e servire .")
;
System.out.println(r .toString(4)) ; //Spaghetti aglio e olio
									//Ingredienti per 4 persone:
									//400 grammi di spaghetti
									//8 cucchiai d'olio d'oliva
									//4 spicchi d'aglio
									//q.b. sale
									//Preparazione:
									//Mischiare tutti gli
									//ingredienti e servire.
```

## [FunnyOrder](https://github.com/Indisparte/Java-practice/tree/main/JFC/FunnyOrder)
Determinare l'output del seguente programma e descrivere brevemente l'ordinamento dei numeri
interi definito dalla classe FunnyOrder.
```java
public class FunnyOrder implements Comparable<FunnyOrder> {
	private int val;

	public FunnyOrder(int n) { val = n; }
	
	public int compareTo(FunnyOrder x) {
		if (val%2 == 0 && x.val%2 != 0) return -1;
		if (val%2 != 0 && x.val%2 == 0) return 1;
		if (val < x.val) return -1;
		if (val > x.val) return 1;
		
		return 0;
	}
	public static void main(String[] args) {
		List<FunnyOrder> l = new LinkedList<FunnyOrder>();
		l .add(new FunnyOrder(16));
		l .add(new FunnyOrder(3));
		l .add(new FunnyOrder(4));
		l .add(new FunnyOrder(10));
		l .add(new FunnyOrder(2));
		Collections.sort( l ) ;
		for (FunnyOrder f: l)
			System.out.println(f.val + " ");//2 4 10 16 3
	}
}
```
## [Highway](https://github.com/Indisparte/Java-practice/tree/main/JFC/Highway)

Implementare una classe **Highway**, che rappresenti un'autostrada a senso unico. Il costruttore accetta la lunghezza dell'autostrada in chilometri. Il metodo **insertCar** prende un intero **x** come
argomento ed aggiunge un'automobile al chilometro x. L'automobile inserita percorrerà l'autostrada
alla velocità di un chilometro al minuto, (60 km/h) fino alla fine della stessa. Il metodo
**nCars** prende un intero x e restituisce il numero di automobili presenti al chilometro x. Il metodo
**progress** simula il passaggio di 1 minuto di tempo (cioè fa avanzare tutte le automobili di un
chilometro).

Si supponga che thread multipli possano accedere allo stesso oggetto **Highway**.

Dei 25 punti, 8 sono riservati a coloro che implementeranno progress in tempo indipendente dal
numero di automobili presenti sull'autostrada.

**Esempio d'uso**
```java
Highway h = new Highway(10);
h.insertCar(3) ; h.insertCar(3) ; h.insertCar(5) ;
System.out.println(h.nCars(4));//0
h.progress() ;
System.out.println(h.nCars(4));//2
```
## [Polinomio bis](https://github.com/Indisparte/Java-practice/tree/main/JFC/Polinomio%20bis)
Si consideri la seguente classe Pair
```java
public class Pair<T,U>{
	public Pair(T first, U second){
		this.first = first;
		this.second = second;
	}

	public T getFirst(){return first;}
	public U getSecond(){return second;}

	private T first;
	private U second;

}
```
Un *polinomio* è una espressione algebrica del tipo a0+a1x+: : :+anxn. Si implementi una classe
Polynomial, dotata di un costruttore che accetta un array contenente i coefficienti a0 : : : an. Deve
essere possibile iterare sulle coppie (esponente, coefficiente) in cui il coefficiente è diverso da zero.
Cioè, Polynomial deve implementare Iterable<Pair<Integer, Double>>. Infine, il metodo toString
deve produrre una stringa simile a quella mostrata nel **seguente caso d'uso**.
```java
double a1[] = {1, 2, 0, 3};
double a2[] = {0, 2};
Polynomial p1 = new Polynomial(a1);
Polynomial p2 = new Polynomial(a2);
System.out.println(p1);//1.0+2.0x^1+3.0x^3
System.out.println(p2);//2.0x^1
for (Pair<Integer, Double> p: p1)
	System.out.println(p. getFirst () + " : " + p.getSecond());//0:1.0
																//1:2.0
																//3:3.0
```

## [Inventory](https://github.com/Indisparte/Java-practice/tree/main/JFC/Inventory)

Definire una classe parametrica **Inventory<T>** che rappresenta un inventario di oggetti di tipo T.
Il costruttore senza argomenti crea un inventario vuoto. Il metodo add aggiunge un oggetto di
tipo T all'inventario. Il metodo count prende come argomento un oggetto di tipo T e restituisce il
numero di oggetti uguali all'argomento presenti nell'inventario. Infine, il metodo **getMostCommon**
restituisce l'oggetto di cui è presente il maggior numero di esemplari. **Esempio d'uso:**
```java
Inventory<Integer> a = new Inventory<Integer>();
Inventory<String> b = new Inventory<String>();
a.add(7); a.add(6); a.add(7); a.add(3);
b.add("ciao"); b.add("allora?"); b.add("ciao ciao"); b.add("allora?
");
System.out.println(a.count(2));//0
System.out.println(a.count(3));//1
System.out.println(a.getMostCommon());//7
System.out.println(b.getMostCommon());//allora?
```
## [Exchange](https://github.com/Indisparte/Java-practice/tree/main/JFC/Exchange)
Realizzare la classe **Exchange** che rappresenta una borsa valori. Il metodo **setPrice** imposta il prezzo
corrente di un titolo quotato. Il metodo **addLowAlert** fa in modo che un dato runnable venga eseguito la prima 
volta che il prezzo di un dato titolo raggiunge o scende sotto una data soglia. Il runnable viene eseguito immediatamente
se il prezzo di quel tipo è già inferiore o uguale alla soglia. Simmetricamente, il metodo **setHighAlert** offre lo stesso servizio,
quando il prezzo raggiunge o sale al di sopra di una data soglia. E' possibile impostare più alert per lo stesso titolo, con soglie diverse o uguali tra loro.
La classe Exchange deve essere *thread-safe*.
L'implementazione deve rispettare il seguente caso d'uso:
 ```java
 Exchange borsa = new Exchange();
 borsa.setPrice("MaxiCom", 10.56);
 borsa.setPrice("MegaCorp", 18.2);
 borsa.setPrice("SuperMarket", 3.91);

 borsa.addLowAlert("MegaCorp", 17.5, ()->{System.out.println("Below the threshold!");});
 borsa.addHighAlert("MaxiCom", 12, ()->{System.out.println("More than 12!");});
 borsa.addLowAlert("MaxiCom", 20.5, ()->{System.out.println("More than 20.5!");});

 borsa.setPrice("MaxiCom", 12.3);//More than 12!
 ```
<p align="right">
<a href="#java-collection-framework">Back to top of section</a>

</p>
</details>
<p align="right">
<a href="#table-of-contents">Back to top</a>
</p>



<!--PROGRAMMAZIONE PARAMETRICA-->
# [Programmazione parametrica](https://github.com/Indisparte/Java-practice/tree/main/Programmazione%20parametrica)
<details>
	<summary>Clicca per espandere !</summary>

## [Range](https://github.com/Indisparte/Java-practice/tree/main/Programmazione%20parametrica/Range)
Realizzare la classe parametrica Range, che rappresenta un intervallo di oggetti dotati di ordinamento
naturale, con le seguenti funzionalità:
a) Il costruttore accetta gli estremi dell'intervallo (l'oggetto minimo e l'oggetto massimo).
b) Il metodo isInside accetta un oggetto x e restituisce true se e solo se x appartiene all'intervallo.
c) Il metodo isOverlapping accetta un altro intervallo x e restituisce true se e solo se x è
sovrapposto a questo intervallo (cioè se i due hanno intersezione non vuota).
d) Il metodo equals è ridefinito in modo che due intervalli con gli stessi estremi risultino uguali.
e) Il metodo hashCode è ridefinito in modo da essere coerente con equals.
Porre attenzione alla firma di isOverlapping e spiegare se è completa o meno.
L'implementazione deve rispettare il seguente **esempio d'uso**.
```java
Range<Integer> a = new Range<>(10, 20);
System.out.println(a. isInside (10)) ;//true
System.out.println(a. isInside (50)) ;//false
Range<String> b = new Range<>("albero", "dirupo"),
c = new Range<>("casa", "catrame");
System.out.println(b.isOverlapping(c)) ;//true
Range<Object> d = new Range<>(); // errore di compilazione
```

## [Pair](https://github.com/Indisparte/Java-practice/tree/main/Programmazione%20parametrica/Pair)

Realizzare la classe parametrica Pair, che rappresenta una coppia di oggetti di tipo potenzialmente
diverso. La classe deve supportare le seguenti funzionalità:
1) due Pair sono uguali secondo equals se entrambe le loro componenti sono uguali secondo equals;
2) il codice hash di un oggetto Pair è uguale allo XOR tra i codici hash delle sue due componenti;
3) la stringa corrispondente ad un oggetto Pair è "(str1,str2)", dove str1 (rispettivamente,
str2) è la stringa corrispondente alla prima (risp., seconda) componente.
**Esempio d'uso**
```java
Pair<String,Integer> p1 = new Pair<String,Integer>("uno", 1);
System.out.println(p1);
```

## [BoundedMap-Incompleto](https://github.com/Indisparte/Java-practice/tree/main/Programmazione%20parametrica/BoundedMap-Incompleto)
Implementare la classe **BoundedMap**, che rappresenta una mappa con capacità limitata. Il costruttore
accetta la dimensione massima della mappa. I metodi get e put sono analoghi a quelli
dell'interfaccia **Map**. Se però la mappa è piena e viene invocato il metodo put con una chiave
nuova, verrà rimossa dalla mappa la chiave che fino a quel momento è stata ricercata meno volte
con **get**.
L'implementazione deve rispettare il seguente **caso d'uso**.
```java
BoundedMap<String,String> m = new BoundedMap<String,String>(2);
m.put("NA", "Napoli");
m.put("SA", "Salerno");
System.out.println(m.get("NA"));
m.put("AV", "Avellino");
System.out.println(m.get("SA"));
```

<p align="right">
<a href="#programmazione-parametrica">Back to top of section</a>
</p>
</details>

<p align="right">
<a href="#table-of-contents">Back to top</a>
</p>
<!-- ESERCIZI ELEMENTARI -->

# [Esercizi elementari](https://github.com/Indisparte/Java-practice/tree/main/Esercizi%20elementari)

<details>
	<summary>Clicca per espandere !</summary>

## [Triangolo](https://github.com/Indisparte/Java-practice/tree/main/Esercizi%20elementari/Triangolo)
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

## [Tutor](https://github.com/Indisparte/Java-practice/tree/main/Esercizi%20elementari/Tutor-Incompleto)
Un *tutor* è un dispositivo per la misurazione della velocità media in autostrada. Una serie di
sensori identifica i veicoli in base alle targhe e ne calcola la velocità, misurando il tempo che il
veicolo impiega a passare da un sensore al successivo (e, naturalmente, conoscendo la distanza
tra i sensori).</br>

Si implementi la classe **Tutor** e la classe **Detector** (sensore). Il metodo *addDetector* di Tutor crea
un nuovo sensore posto ad un dato kilometro del tracciato. Il metodo *carPasses* di Detector
rappresenta il passaggio di un veicolo davanti a questo sensore: esso prende come argomenti la targa di un veicolo ed un tempo assoluto in secondi, e restituisce una stima della velocità di quel veicolo, basata anche sui dati dei sensori che lo precedono. Tale metodo restituisce -1 se il
sensore non ha sufficienti informazioni per stabilire la velocità.</br>

Si supponga che le chiamate ad addDetector avvengano tutte all'inizio e con kilometri crescenti,
come nel seguente esempio d'uso.
```java
Tutor tang = new Tutor();
Tutor.Detector a = tang.addDetector(2);
Tutor.Detector b = tang.addDetector(5);
Tutor.Detector c = tang.addDetector(9);
// nuovo veicolo
System.out.println(a.carPasses("NA12345", 0));//-1
// 3km in 1200 sec (20 minuti), quindi 9km/h
System.out.println(b.carPasses("NA12345", 1200));//9
// nuovo veicolo
System.out.println(b.carPasses("SA00001", 1200));//-1
// 4km in 120 sec (2 minuti), quindi 120km/h
System.out.println(c.carPasses("NA12345", 1320));//120
// 4km in 180 sec (3 minuti), quindi 80km/h
System.out.println(c.carPasses("SA00001", 1380));//80
```
## [Cartella](https://github.com/Indisparte/Java-practice/tree/main/Esercizi%20elementari/Cartella)
Realizzare la classe Cartella, che rappresenta una cartella nella Tombola. Una cartella contiene 15 numeri casuali diversi, compresi tra 1 e 90, disposti in 3 righe di 5 numeri, rispettando laseguente regola:
- una riga non può contenere due numeri della stessa "decina"; ad esempio, una riga può contenere 9 e 11, ma non 11 e 13.

Il metodo segna accetta il prossimo numero estratto, e controlla se questa cartella ha ottenuto
un premio, restituendo null, oppure un valore enumerato che rappresenta uno dei premi della
Tombola: AMBO, TERNO, QUATERNA, CINQUINA, TOMBOLA (implementare anche questa
enumerazione).

L'implementazione deve rispettare il seguente esempio d'uso: (*Essendo numeri randomici, improbabile ricreare il seguente caso d'uso. Nel mio svolgimento i numeri da segnare sono anch'essi randomici.*)
```java
Cartella c = new Cartella();
System.out.println(c.segna(1));
System.out.println(c.segna(2));
System.out.println(c.segna(12));
System.out.println(c.segna(22));
System.out.println(c.segna(82));
```

## [Answer&Question](https://github.com/Indisparte/Java-practice/tree/main/Esercizi%20elementari/Answer&Question)
Per un sito di domande e risposte, realizzare le classi **Question** e **Answer**. Ogni risposta è associata ad un'unica domanda e gli utenti possono votare la risposta migliore invocando il metodo *voteUp* di Answer. Inoltre, il metodo *getBestAnswer* restituisce in tempo costante la risposta (o una delle risposte) che ha ottenuto il maggior numero di voti.

Rispettare il seguente caso d'uso.
```java
Question q = new Question("Dove si trova Albuquerque?");
Answer a1 = new Answer(q, "Canada");
Answer a2 = new Answer(q, "New Mexico");
a1.voteUp();
System.out.println(q.getBestAnswer());//Canada
a2.voteUp();
a2.voteUp();
System.out.println(q.getBestAnswer());//New Mexico
```
<p align="right">
<a href="#esercizi-elementari">Back to top of section</a>
</p>
</details>

<p align="right">
<a href="#table-of-contents">Back to top</a>
</p>

<!-- CLASSI INTERNE -->

# [Classi interne](https://github.com/Indisparte/Java-practice/tree/main/Classi%20interne)

<details>
	<summary>Clicca per espandere !</summary>


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
<p align="right">
<a href="#classi-interne">Back to top of section</a>

</p>
</details>
<p align="right">
<a href="#table-of-contents">Back to top</a>
</p>

<!-- CRITERI DI ORDINAMENTO TRA OGGETTI -->

# [Criterio di ordinamento tra oggetti](https://github.com/Indisparte/Java-practice/tree/main/Criterio%20di%20ordinamento%20tra%20oggetti)

<details>
	<summary>Clicca per espandere !</summary>

## [Time](https://github.com/Indisparte/Java-practice/blob/main/Criterio%20di%20ordinamento%20tra%20oggetti/Time)
Implementare la classe Time, che rappresenta un orario della giornata (dalle 00:00:00 alle 23:59:59).
Gli orari devono essere confrontabili secondo Comparable. Il metodo minus accetta un altro orario
x come argomento e restituisce la differenza tra questo orario e x, sotto forma di un nuovo
oggetto Time. La classe fornisce anche gli orari predefiniti MIDDAY e MIDNIGHT.
</br>ESEMPIO D'USO	

```java
Time t1 = new Time(14,35,0);
Time t2 = new Time(7,10,30);
Time t3 = t1.minus(t2);
System.out.println(t3) ; //7:24:30
System.out.println(t3.compareTo(t2)); //1
System.out.println(t3.compareTo(Time.MIDDAY)); //-1
```

## [Date](https://github.com/Indisparte/Java-practice/blob/main/Criterio%20di%20ordinamento%20tra%20oggetti/Date)
La classe **Date** rappresenta una data tramite tre numeri interi (giorno, mese e anno) e ridefinisce
**equals** nel modo naturale.

Dire quali delle seguenti sono specifiche valide per un comparatore tra due oggetti **Date** a e **b**.
Dire anche quali specifiche sono coerenti con **equals**.

compare(a,b) restituisce (nei casi non contemplati, restituisce 0):

a) -1 se l'anno di a è minore di quello di b; 1 se l'anno di a è maggiore di quello di b.</br>
b) -1 se a e b hanno lo stesso mese; 1 se a e b hanno mesi diversi.</br>
c) -1 se il mese di a è tra gennaio e giugno e quello di b tra luglio e dicembre; 1 se il mese di b
è tra gennaio e giugno e quello di a tra luglio e dicembre.</br>
d) -1 se il giorno oppure il mese di a è uguale a quello di b; 1 se sia il giorno sia il mese di a
sono diversi da quelli di b.


## [Product](https://github.com/Indisparte/Java-practice/blob/main/Criterio%20di%20ordinamento%20tra%20oggetti/Date)
Realizzare la classe **Product**, che rappresenta un prodotto di un supermercato,
caratterizzato da descrizione e prezzo. I prodotti sono dotati di ordinamento naturale, in base
alla loro descrizione (ordine alfabetico). Il metodo **getMostExpensive** restituisce il prodotto più
costoso. Il campo **comparatorByPrice** contiene un comparatore tra prodotti, che confronta i prezzi.

L'implementazione deve rispettare il seguente esempio d'uso.

```java
Product a = new Product("Sale", 0.60),
b = new Product("Zucchero", 0.95),
c = new Product("Caffe'", 2.54);
System.out.println(Product.getMostExpensive());//Caffe', 2.54
System.out.println(b.compareTo(c));//1
System.out.println(Product.comparatorByPrice.compare(b, c));//-1
```
<p align="right">
<a href="#criterio-di-ordinamento-tra-oggetti">Back to top of section</a>
</p>
</details>
<p align="right">
<a href="#table-of-contents">Back to top</a>
</p>

<!-- ITERATORI E CICLO FOR EACH -->

# [Iteratori e ciclo foreach](https://github.com/Indisparte/Java-practice/tree/main/Iteratori%20e%20ciclo%20foreach)
<details>
	<summary>Clicca per espandere !</summary>

## [BinaryTreePreIterator](https://github.com/Indisparte/Java-practice/tree/main/Iteratori%20e%20ciclo%20foreach/BinaryTreePreIterator)
Il seguente frammento di classe definisce un nodo in un albero binario.
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

## [IncreasingSubsequence](https://github.com/Indisparte/Java-practice/tree/main/Iteratori%20e%20ciclo%20foreach/IncreasingSubsequence)
Implementare la classe **IncreasingSubseq** che, data una lista di oggetti tra loro confrontabili,
rappresenta la *sottosequenza crescente* che inizia col primo elemento.

Attenzione: la classe deve funzionare con qualunque tipo di dato che sia confrontabile (non solo
con "Integer").

Sarà valutato negativamente l'uso di "strutture di appoggio", ovvero di spazio aggiuntivo di
dimensione non costante.

**Esempio d'uso**
```java
List<Integer> l = new LinkedList<Integer>();
l .add(10); l .add(3);
l .add(5); l .add(12);
l .add(11); l .add(35);
for (Integer i : new IncreasingSubseq<Integer>(l))
System.out.println( i ) ;//10 12 35
```
## [Selector](https://github.com/Indisparte/Java-practice/tree/main/Iteratori%20e%20ciclo%20foreach/Selector)
L'interfaccia parametrica **Selector** prevede un metodo *select* che restituisce un valore booleano
per ogni elemento del tipo parametrico.
```java
public interface Selector<T> {
	boolean select(T x);
}
```
Implementare una classe **SelectorIterator** che accetta una collezione e un selettore dello stesso
tipo, e permette di iterare sugli elementi della collezione per i quali il selettore restituisce true.

**Esempio d'uso**
```java
Integer [] a = { 1, 2, 45, 56, 343, 22, 12, 7, 56};
List<Integer> l = Arrays.asList(a);
Selector<Integer> pari = new Selector<Integer>() {
	public boolean select(Integer n) {
		return (n % 2) == 0;
	}
};
for (Integer n: new SelectorIterator<Integer>(l, pari))
	System.out.print(n + " ");//2 56 22 12 56
```
<p align="right">
<a href="#iteratori-e-ciclo-foreach">Back to top of section</a>

</p>
</details>
<p align="right">
<a href="#table-of-contents">Back to top</a>
</p>

<!-- UGUAGLIANZA TRA OGGETTI  -->

# [Uguaglianza tra oggetti](https://github.com/Indisparte/Java-practice/tree/main/Uguaglianza%20tra%20oggetti)
<details>
	<summary>Clicca per espandere !</summary>

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
	
## [2008-7-9](https://github.com/Indisparte/Java-practice/tree/main/Uguaglianza%20tra%20oggetti/2008-7-9)
Data la seguente classe.
	
```java
public class Z {
	private Z other;
	private int val;
	...
}
```
Si considerino le seguenti specifiche alternative per il metodo equals. Due oggetti x e y di tipo Z
sono uguali se:
<ol>
<li>x.other e y.other puntano allo stesso oggetto ed x.val è maggiore o uguale di y.val;</li>
<li>x.other e y.other puntano allo stesso oggetto ed x.val e y.val sono entrambi pari;</li>
<li>x.other e y.other puntano allo stesso oggetto oppure x.val è uguale a y.val;
</li>
<li>x.other e y.other sono entrambi null oppure nessuno dei due è null ed x.other.val è uguale a
y.other.val.</li>
</ol>

- Dire quali specifiche sono valide e perché. (20 punti)
- Implementare la specifica (4). (10 punti)
<p align="right">
<a href="#uguaglianza-tra-oggetti">Back to top of section</a>
</p>
</details>
<p align="right">
<a href="#table-of-contents">Back to top</a>
</p>
	
<!-- SCELTA DELLA FIRMA-->

# [Scelta della firma](https://github.com/Indisparte/Java-practice/tree/main/Scelta%20della%20firma)
>Visitare la cartella linkata nel titolo della sezione per visualizzare gli svolgimenti.

<!-- MULTITHREADING -->

# [Multithreading](https://github.com/Indisparte/Java-practice/tree/main/Multithreading)
<details>
	<summary>Clicca per espandere !</summary>

## [Interruptor](https://github.com/Indisparte/Java-practice/blob/main/Multithreading/Interruptor)
Implementare la classe **Interruptor**, il cui compito è quello di interrompere un dato thread dopo un numero fissato di secondi.

Ad esempio, se t è un riferimento ad un oggetto Thread, la linea
 `Interruptor i = new Interruptor(t,10);`

crea un nuovo thread di esecuzione che interrompe il thread t dopo 10 secondi.


## [delayIterator](https://github.com/Indisparte/Java-practice/blob/main/Multithreading/DelayIterator)
Implementare un metodo statico delayIterator che prende come argomenti un iteratore i ed un
numero intero n, e restituisce un nuovo iteratore dello stesso tipo di i, che restituisce gli stessi
elementi di i, ma in cui ogni elemento viene restituito (dal metodo next) dopo un ritardo di n
secondi. Viene valutato positivamente l'uso di classi anonime.
Si ricordi che nella classe Thread è presente il metodo:
```java
public static void sleep(long milliseconds) throws InterruptedException
```
Esempio d'uso:
```java
List<Integer> l = new LinkedList<Integer>();
l.add(3);
l.add(4);
l.add(177);

Iterator<Integer> i = delayIterator(l.iterator()),2);
while(i.hasNext()){
	System.out.println(i.next());
}
```

Output: il programma stampa il contenuto della lista, mostrando ciascun valore dopo 2 secondi di ritardo.

## [PeriodicJob](https://github.com/Indisparte/Java-practice/blob/main/Multithreading/PeriodicJob)
Implementare il metodo statico periodicJob, che accetta un Runnable r e un periodo p espresso in millisecondi e fa partire un'esecuzione di r ogni p millisecondi .
Il metodo periodicJob non deve essere bloccante.
Esempio d'uso:
```java
Runnable r = new Runnable(){
	public void run(){
		System.out.println("Ciao");		
	}
};
periodicJob(r,2000);
```
Risultato : il programma stampa "Ciao" ogni 2 secondi.

## [RunOnSet](https://github.com/Indisparte/Java-practice/blob/main/Multithreading/RunOnSet)
Si consideri la seguente interfaccia.
```java
public interface RunnableWithArg<T> {
	void run(T x);
}
```
Un oggetto RunnableWithArg è simile ad un oggetto Runnable, tranne per il fatto che il suo
metodo run accetta un argomento.
Si implementi una classe RunOnSet che esegue il metodo run di un oggetto RunnableWithArg su
tutti gli oggetti di un dato insieme, in parallelo.
```java
Set<Integer> s = new HashSet<Integer>();
s .add(3); s .add(13); s .add(88);
RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
	public void run(Integer i) {
		System.out.println(i/2);
	}
};
Thread t = new RunOnSet<Integer>(r, s);
t . start ()
```
**Un possibile output**</br>
1</br>
6</br>
44


## [Shared Object](https://github.com/Indisparte/Java-practice/blob/main/Multithreading/SharedObject)
Elencare tutte le sequenze di output possibili per il seguente programma.
```java
public static void main(String[] args) throws InterruptedException {
	class MyThread extends Thread {
		private int id;
		private int[] arr ;
		public MyThread(int id, int[] arr) {
			this.id = id;
			this.arr = arr;
		}
		public void run() {
			synchronized (arr) {
				arr[0]++;
				System.out.println(id + ":" + arr[0]) ;
			}
		return;
		}
	}
	int [] a = { 0 };
	Thread t1 = new MyThread(1,a);
	Thread t2 = new MyThread(2,a);
	t3 = new MyThread(3,a);
	t1. start () ; t2. start () ; t3. start () ;
}
```
## [ThreadRace](https://github.com/Indisparte/Java-practice/blob/main/Multithreading/ThreadRace)
Implementare il metodo statico threadRace, che accetta due oggetti Runnable come argomenti,
li esegue contemporaneamente e restituisce 1 oppure 2, a seconda di quale dei due Runnable è
terminato prima.
Si noti che threadRace è un metodo bloccante. Sarà valutato negativamente l'uso di attesa attiva.

## [Concurrent Filter](https://github.com/Indisparte/Java-practice/tree/main/Multithreading/ConcurrentFilter)
Data la seguente interfaccia:
```java
    public interface Selector<T> {
    boolean select(T x);
    }
```
implementare il metodo (statico) concurrentFilter, che prende come argomenti un Set X e un
Selector S, di tipi compatibili, e restituisce un nuovo insieme Y che contiene quegli elementi di X
per i quali la funzione select di S restituisce il valore true.
Inoltre, il metodo deve invocare la funzione select in parallelo su tutti gli elementi di X (dovrà
quindi creare tanti thread quanti sono gli elementi di X).
Esempio d'uso
```java
Set<Integer> x = new HashSet<Integer>();
x.add(1); x.add(2); x.add(5);
Selector<Integer> oddSelector = new Selector<Integer>() {
	public boolean select(Integer n) {
		return (n%2 != 0);
	}
};
Set<Integer> y = concurrentFilter(x, oddSelector);
for (Integer n: y)
	System.out.println(n);//1,5
```

## [VoteBox](https://github.com/Indisparte/Java-practice/tree/main/Multithreading/VoteBox)
Si implementi la classe **VoteBox**, che rappresenta un'**urna elettorale**, tramite la quale diversi thread possono votare tra due alternative, rappresentate dai due valori booleani.
Il **costruttore** accetta il numero totale n di thread aventi diritto al voto. La votazione termina quando n thread diversi hanno votato. In caso di pareggio, vince il valore false. 
Metodi: 
 - Il metodo ***vote***, con parametro boolean e nessun valore di ritorno,
   permette ad un thread di votare, e solleva un'eccezione se lo stesso
   thread tenta di votare più di una volta.
 - Il metodo ***waitForResult***, senza argomenti e con valore di ritorno
   booleano, restituisce il risultato della votazione, mettendo il
   thread corrente in attesa se la votazione non è ancora terminata.
 - Infine, il metodo ***isDone*** restituisce true se la votazione è
   terminata, e false altrimenti. 
   
   *E' necessario evitare attesa attiva e  race condition.*
   **Esempio d'uso:** 
   ```java
   VoteBox b = new VoteBox(10);
    b.vote(true); 
    System.out.println(b.isDone());//false
    b.vote(false);//Exception in thread "main"...
    ```
## [ExecuteInParallel](https://github.com/Indisparte/Java-practice/tree/main/Multithreading/ExecuteInParallel)
Implementare il metodo statico ***executeInParallel***, che accetta come argomenti un array di Runnable
e un numero naturale k, ed esegue tutti i Runnable dell'array, k alla volta.

In altre parole, all'inizio il metodo fa partire i primi k Runnable dell'array. Poi, non appena uno
dei Runnable in esecuzione termina, il metodo ne fa partire un altro, preso dall'array, fino ad
esaurire tutto l'array.
<p align="right">
<a href="#multithreading">Back to top of section</a>

</details>
<p align="right">
<a href="#table-of-contents">Back to top</a>

</p>

# Contatto
Invia una email a 📫 **tonydinu02@gmail.com** per qualsiasi errore, confronto o consiglio!
> Inserisci come oggetto nella email "[GitHub] oggetto " dove per *oggetto* si intende il motivo per cui mi stai contattando.

p.s. Clica sulla email, risponderò appena sarò disponibile.


