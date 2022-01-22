package BoundedMap;

import java.util.*;

public class BoundedMap<T, U> {
    private int capacity;
    private Map<MapElem<T, U>, Integer> map ;

    public BoundedMap(int capacity){
        if(capacity < 0) throw new IllegalArgumentException();

        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public U get(T key){
        for (Map.Entry<MapElem<T,U>, Integer> element : map.entrySet()) {
            MapElem<T,U> elem = element.getKey();
            int call_counter = element.getValue();
            if(elem.getObj1().equals(key)){
                call_counter++;
                return elem.getObj2();
            }
        }
        return null;

    }

    public U put(T key, U value){
        MapElem<T,U> new_me = new MapElem<>(key, value) ;
        for (Map.Entry<MapElem<T,U>, Integer> element : map.entrySet()) {
            MapElem<T,U> elem = element.getKey();
            if(elem.equals(new_me)){
                map.put(new_me, element.getValue());
                return elem.getObj2();  
              
            }else{
                map.put(new_me, 0);
                break;
            }
          
        }
        //Se dopo questo inserimento la map supera la capacità
         //rimuovi l'elemento meno chiamato con get non considerando questo appena messo
        if(map.size() >= capacity)
            findLessCommonKey(new_me);
        return null;
        
    }

    private void findLessCommonKey(MapElem<T,U> new_elem){
        int min_call = 0;//indica il numero minimo di chiamate
        MapElem<T,U> lessCommonElem = null;

        for (Map.Entry<MapElem<T,U>,Integer> element : map.entrySet()) {
            //Se questo elemento è diverso da nuovo elemento 
            //ed è stato invocato meno volte, allora inseriscilo nelle variabili
            if((! element.getKey().equals(new_elem)) && element.getValue()<= min_call)
                lessCommonElem = element.getKey();
                min_call = element.getValue();
        }

        map.remove(lessCommonElem);
    }

    

    private class MapElem<T, U>{
        private T obj1;
        private U obj2;

        public MapElem(T obj1, U obj2){
            this.obj1 = Objects.requireNonNull(obj1);
            this.obj2 = Objects.requireNonNull(obj2);
        }

        public T getObj1() {
            return obj1;
        }
        public U getObj2() {
            return obj2;
        }
        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof MapElem)) return false;

            MapElem<T,U> p = (MapElem<T,U>) obj;

            return obj1.equals(p.getObj1());
        }

        @Override
        public int hashCode() {
            return obj1.hashCode() ;
        }
        

        



    }

}
