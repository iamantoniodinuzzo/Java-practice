# Scelta della firma
> Valutare ciascuna delle seguenti intestazioni in base ai criteri di funzionalità, completezza, correttezza, fornitura di ulteriori garanzie, semplicità e specificità del tipo di ritorno. Infine, scegliere l'intestazione migliore oppure proporne un'altra.

<!----->

## findPrevious
Implementare il metodo statico **findPrevious**, che accetta un insieme, un comparatore e un oggetto _x_. e restituisce il più grande oggetto dell'insieme cheè minore di x (secondo il comparatore). Se tale oggetto non esiste (perchè tutti gli elementi dell'insieme sono maggiori o uguali a _x_), il metodo restituisce _null_.</br>

```java
<T> T findPrevious(Set<? extends T> set, Comparator<?> comp, T x);
```
* **Non funzionale**, il comparator deve avere un tipo uguale o superiore a quello del set.
```java
<S, T extends S> T findPrevious(Set<T> set, Comparator<S> comp, T x);
```
* **Corretta**.
* **Non completa** in quanto anche una lista è un insieme ma non è accettata come parametro.
* **Funzionale**.
* **Semplice**

```java
<S, T extends S> T findPrevious(Set<S> set, Comparator<T> comp, S x);
```
* La firma **non è funzionale** in quanto gli elementi della lista devono essere mutualmente comparabili. Qui invece il tipo di parametro del Comparator è inferiore al Set.
* **Non è completa** in quanto una lista può essere intesa come insieme, ma qui non può essere passata come parametro.
* **Corretta**
* **Non è semplice**, troppi parametri.

```java
<T> T findPrevious (Set<T> set, Comparator<? super T> comp, T x);
``` 
* **Funzionale**
* **Corretta**
* **Non completa**
* **Ulteriori garanzie** sono quelle di permettere di accettare comparator esclusivamente delle superclassi si T.
* **Semplice** per i pochi parametri utilizzati.

```java
<T> T findPrevious (Set<T> set, Comparator<T> comp, T x);
```
* **Corretta**
* **Non completa**
* **Funzionale**
* **Semplice**

```java
<T> T findPrevious (Set<? super T> set, Comparator<T> comp, T x);
```
* **Non funzionale**, il contenuto del set non può essere letto
### **Miglior firma e implementazione**
```java
public static <T> T findPrevious(Collection<T> collection, Comparator<? super T> comp, T x) {

        ArrayList<T> list = new ArrayList<>(collection);
        /// aggiungo l'oggetto x
        list.add(x);
        // ordino la lista
        Collections.sort(list, comp);

        // Se l'oggetto x è più grande di tutti, è in fondo alla lista
        // l'oggetto più grande dell'insieme è il penultimo
        if (list.get(list.size()).equals(x)) {
            return list.get(list.size() - 1);
        }
        return null;
    }
```
<!-- -->
## makeMap
Il metodo statico **makeMap** accetta una lista di chiavi e una lista di valori (di pari lunghezza), e restituisce una mappa ottenuta accoppiando ciascun elemento della prima lista al corrispondente elemento della seconda lista.

```java
<K,V> Map<? extends K, ? extends V> makeMap(List<K> keys, List<V> vals);
```
* **Completa**
* **Corretta**
* **Non Funzionale**, impossibile costruire la map di ritorno.
* **Tipo di ritorno troppo specifico**

```java
<K,V> Map<? extends K, ?> makeMap(List<K> keys, List<?> vals);
```
* **Completa**
* **Corretta**
* **Non Funzionale**, impossibile costruire la map di ritorno in quanto è impossibile invocare il metodo *add*.
* **Tipo di ritorno troppo specifico**
```java
<K,V> Map<K,V> makeMap(List<K> keys, List<?> vals);
```
* **Completa**
* **Corretta**
* **Non Funzionale**, impossibile inserire elementi nella map dato che il tipo di ritorno è un tipo specifico ma la lista dei values è un jolly

```java
<T> Map<T,T> makeMap(List<? extends T> keys, List<? extends T> vals);
```
* **Non Completa** perchè accetta liste che abbiano lo stesso tipo o sottoclassi della stessa classe.
* **Corretta**
* **Funzionale**
* **Tipo di ritorno poco specifico**
* **Ulteriori garanzie** sono quelle di impossibilitare la modifica delle liste passate come argomento.

```java
<K> Map<K,?> makeMap(List<K> keys, List<Object> values);
```
* **Corretta**
* **Completa**
* **Non Funzionale**, impossibile costruire la map a causa del tipo di values.
* **Semplice** 
* **Tipo di ritorno poco specifico**

```java
<K,V extends K > Map<K,V> makeMap(List<K> keys, List<V> values);
```
* **Corretta**
* **Non completa**, i values possono essere solo sottoclassi della classe K.
* **Funzionale**
* **Tipo di ritorno troppo specifico**
### **Firma migliore**
```java
  public static <K, V> Map<? super K, ? super V> makeMap(List<? extends K > keys, List<? extends V> values){
        Map<? super K,? super V> result = new HashMap<>();
        ArrayList<K> keyList = new ArrayList<>(keys);
        ArrayList<V> valuesList = new ArrayList<>(values);

        if(keys.size() != values.size()) 
            throw new RuntimeException("liste di lunghezza diversa");

        for(int i = 0; i < keys.size(); i++){
            result.put(keyList.get(i),valuesList.get(i));
        }

        return result;
        
    }
```

<!--  -->
## greatestLowerBound
Implementare il metofo gLB (per *greatestLowerBound*), che accetta due insiemi A e B, e un comparatore e restituisce il più grande di A che è più piccolo di tutti gli elementi di B. Se un tale elemento non esiste, il metodo restituisce *null*.
```java
<T> T gtLB(Set<? extends T> a, Set<? extends T> b, Comparator<T> c);
```
* **Funzionale**
* **Corretta**
* **Completa**
* **Ulteriori garanzie** fornite sono l'immodificabilità dei due set su cui non è possibile invocare il metodo add.
* **Semplice** in quanto presenta un unico parametro.
* **Specificità del tipo di ritorno** alta.

```java
<S,T> Object gLB(Set<S> a, Set<T> b, Comparator<Object> c);
```
* **Non funzionale** in quanto ilcomparator non può essere utilizzato.

```java
<T> T gLB(Set<T> a, Set<T> b, Comparator<? super T> c);
```
* **Funzionale**
* **Corretta**
* **Non completa** in quanto accetta solo insiemi dello stesso tipo.
* **Specificità del tipo di ritorno** alta.
* **Semplice**

```java
<S, T extends S> S gLB(Set<S> a, Set<T> b, Comparator<S> c);
```
* **Funzionale**
* **Corretta**
* **Non completa** in quanto non posso passare come primo parametro un insieme a di sottoclassi di S.
* **Specificità del tipo di ritorno** alta.

```java
<T> t gLB(Set<? super T> a, Set<? super T>, Comparator<T> c );
```
* **Non funzionale** in quanto non è possibile leggere gli insiemi.
### Firma Migliore 
```java
 public static <T> T gLB(Set<? extends T> a, Set<? extends T> b, Comparator<? super T> c) {

        // Converto entrambi gli insiemi in ArrayList in modo da poter ordinare con il
        // metodo sort
        ArrayList<T> a_rray = new ArrayList<>(a);
        ArrayList<T> b_rray = new ArrayList<>(b);
        Collections.sort(a_rray, c);
        Collections.sort(b_rray, c);
        // Prelevo l'ultimo elemento di a_rray e b_rray (i più grandi)
        T bigger_a = a_rray.get(a_rray.size() - 1);
        T bigger_b = b_rray.get(b_rray.size() - 1);
        // Se i due bigger sono uguali, li rimuovo dalla lista e recupero di nuovo
        // l'ultimo elemento
        while(c.compare(bigger_a, bigger_b) == 0 && a_rray.size() >0 && b_rray.size() > 0) {
            a_rray.remove(bigger_a);
            bigger_a = null;
            bigger_a = a_rray.get(a_rray.size() - 1);
            b_rray.remove(bigger_b);
            bigger_b = null;
            bigger_b = b_rray.get(b_rray.size() - 1);
        }
        // Se bigger_b è maggiore di bigger_a, restiuisco bigger_a altrimenti null
        if ((bigger_a != null && bigger_b != null) && c.compare(bigger_a, bigger_b) < 0)
            return bigger_a;

        return null;

    }
```

## isIncreasing
Il metodo statico **isIncreasing** accetta una mappa e un comparatore, e restituisce vero se e solo se ciascuna chiave è minore o uguale del valore ad essa associato.
```java
<K,V> boolean isIncreasing(Map<K,V> m, Comparator<K> c);
```
* Corretta
* Compelta
* Non funzionale in quanto non posso comparare K e V.

```java
<K,V> boolean isIncreasing(Map<K,V> m, Comparator<? super K> c);
```
* Corretta
* Completa 
* Ulteriori garanzie fornite dal comparator in quanto accetta solo comparator di superclassi di K
* Non Funzionale in quanto non posso comparare K e V perchè V non è confrontabile con K

```java
<K,V extends K> boolean isIncreasing(Map<K,V> m, Comparator<? super K> c);
```
* Corretta
* Completa
* Ulteriori garanzie fornite dal comparator e dal tipo di valore assunto dalla map, più nello specifico la map può avere come valore solo le sottoclassi di K.
* Funzionale

```java
<T> boolean isIncreasing(Map<T,T> m, Comparator<T> c);
```
* Corretta
* Non completa in quanto non posso passare come argomento una Map che abbia le chiavi diverse dai valori o viceversa.
* Funzionale

```java
<T> boolean isIncreasing(Map<T,T> m, Comparator<? extends T> c);
```
* Non funzionale

```java
<T> boolean isIncreasing(Map<? extends T, ? extends T> m, Comaprator<T> c);
```
* Corretta
* Completa
* Funzionale
* Ulteriori garanzie fornite sono l'impossibilità di richiamare il metodo put di map
* Semplicità della firma
* Specificità del tipo di ritorno

```java
boolean isIncreasing(Map<?,?> m, Comparator<?> c);
```
* Non funzionale
### Miglior firma
```java
 public static <T> boolean isIncreasing(Map< ? extends T, ? extends T> m, Comparator<? super T> c){
        
        for (Map.Entry<? extends T,? extends T> entry : m.entrySet()) {
            if(c.compare(entry.getKey(), entry.getValue()) > 0)
                return false;
        }
        return true;
    }
```

## commonKeys
Implementare un metodo statico commonKeys, che accetta due mappe, e restituisce l'insieme
degli oggetti che compaiono come chiavi in entrambe le mappe.

```java
<T> Set<T> commonKeys(Map<T,?> m1, Map<T,?> m2);
```
1. Funzionalità, il metodo non è funzionale perchè non posso inserire un oggetto sconosciuto all'interno del set di ritorno di tipo definito.

```java
<T,V1,V2> Set<T> commonKeys(Map<T,V1> m1, Map<T,V2> m2);
```
1. Funzionalità, il metodo non è funzionale in quanto le due mappe hanno le stesse chiavi ma valori di tipo diverso ed è dunque impossibile costruire un Set di ritorno.

```java
Set<Object> commonKeys(Map<?,?> m1, Map<?,?> m2)
```
1. Funzionalità, il metodo è funzionale, quando itero su m1 ed m2 non posso conoscere il loro tipo effettivo e con Object non ho problemi.
2. Completezza, il metodo è completo in quanto con il parametro jolly posso passare qualsiasi tipo di valore.
3. Correttezza, il metodo non è corretto in quanto i valori delle due mappe possono essere diversi e renderebbe impossibile costruire il set di ritorno
4. Semplicità, non presenta parametri di tipo ed è dunque una firma molto semplice. Ulteriori garanzie, non posso invocare add su entrambe le mappe.

```java
<T> Set<? extends T> commonKeys(Map<? extends T,?> m1, Map<? extends T,?> m2);
```
1. Funzionalità, non è funzionale in quanto non posso invocare add sul set di ritorno e dunque non posso costruire il risultato.

```java
<T> Set<?> commonKeys(Map<T,?> m1, Map<?,?> m2)
```
1. Funzionalità, non è funzionale in quanto non posso invocare il metodo add sul set di ritorno.

**La Miglior firma**
```java
<T, V> Set<V> commonKeys(Map<? extends T,V> m1, Map<? extends T,V> m2)
```
1. Funzionalità, è funzionale inq uanto posso iterare su entrambe le mappe
2. Completezza, in quanto accetta tutti i valori richiesti
3. Correttezza, è corretta perchè rifiuta i valori non richiesti in questo caso rifiuta le mappe che hanno tipo di valori diverso
4. Semplicità, non è semplice in quanto presenta parametri di tipo. Ulteriori garanzie, è impossibile invocare il metodo put su entrambe le mappe.
**Implementazione**

```java
public static <T, V> Set<V> commonKeys(Map<? extends T,V> m1, Map<? extends T,V> m2){
       HashSet<V> result = new HashSet<>();
       
       for (Map.Entry<? extends T,V> entry : m1.entrySet()) {
        for (Map.Entry<? extends T,V> entry2 : m2.entrySet()) {
           if(entry.getKey().equals(entry2.getKey())){
               result.add(entry.getValue());
               result.add(entry2.getValue());
           }
        }
    }
    return result;
   }
```
## findNext
Il metodo statico findNext accetta un insieme, un comparatore e un oggetto x, e restituisce il più
piccolo oggetto dell'insieme che è maggiore di x (secondo il comparatore).

```java
<T> T findNext(Set<? extends T> set, Comparator<?> comp, T x)
```
1. Funzionalità, il metodo non è funzionale in quanto non posso utilizare il comparatore di tipo jolly.

```java
<S,T extends S> T findNext(Set<T> set, Comparator<S> comp, T x);
```
1. Funzionalità, è funzionale, posso costruire il corpo del metodo ed utilizzare il comparatore.
2. Completezza, non è completa posso utilizzare solo il comparatore della superclasse quindi avessi un set di Employee con superclasse Person, potrei passare come comparatore solo `Comparator<Person>`.
3. Correttezza, la firma rifiuta i valori non corretti.
4. Semplicità, la firma non è semplice per la presenza di due parametri di tipo. Ulteriori garanzie non vengono offerte.

```java
<S,T extends S> S findNext(Set<S> set, Comparator<T> comp, S x);
```
1. Funzionalità, è funzionale.
2. Completezza, non è completa posso utilizzare solo il comparatore che abbia come tipo la sottoclasse T e dunque avessi una classe Employee con superclasse Person, potrei passare come comparatore solo `Comparator<Employee>`.
3. Correttezza, la firma è corretta in quanto rifiuta i valori non corretti.
4. Semplicità, la firma non è semplice per la presenta di due parametri di tipo. Ulteriori garanzie non vengono offerte.

```java
<T> T findNext(Set<T> set, Comparator<? super T> comp, T x);
```
1. Funzionalità, il metodo è funzionale.
2. Completezza, è completo accetta il giusto tipo di comparatore.
3. Correttezza, la firma è corretta in quanto rifiuta i valori non validi.
4. Semplicità, la firma è semplice perchè presenta un solo parametro di tipo. Ulteriori garanzie offerte, nessuna.

```java
<T> T findNext(Set<T> set, Comparator<T> comp, Object x);
```
1. Funzionalità, il metodo non è funzionale in quanto non posso confrontare gli elementi del set e confrontarli con Object.
**Firma migliore**
```java
<T> T findNext(Set<? extends T> coll, Comparator<? super T> comp, T x); 
```
1. Funzionale.
2. Completa in quanto accetta tutti i tipi di collezione
**Implementazione**
```java
public static <T> T findNext(Set<? extends T> set, Comparator<? super T> comp, T x){
        final ArrayList<T> list = new ArrayList<>(set);
        Collections.sort(list, comp);

        return (comp.compare(list.get(0), x) > 0)? list.get(0): null;

}
```

