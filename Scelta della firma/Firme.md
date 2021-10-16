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

