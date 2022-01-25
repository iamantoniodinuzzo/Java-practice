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
          MapElem<T,U> new_elem = new MapElem<T,U>(key, value);

        for (Map.Entry<MapElem<T,U>, Integer> element : map.entrySet()) {
            MapElem<T,U> elem = element.getKey();
            int counter = element.getValue();
            if(elem.getObj1().equals(key)){
                map.remove(elem.getObj1());
                map.put(new_elem, counter);
                System.out.println("Aggiunto: "+new_elem+" Rimosso: "+elem);
                return elem.getObj2();
            }
        }
        map.put(new_elem, 0);
        System.out.println("Aggiunto: "+new_elem);


        if(map.size()>= capacity)
            findLessCommonKey(new_elem);
       
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

    @Override
    public String toString(){
        String result = "[\n";
        for (Map.Entry<MapElem<T,U>, Integer> elem : map.entrySet()) {
            result+= elem.getKey().toString()+", cercato: "+elem.getValue()+"\n";
        }
        result+= "]";
        return result;
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

        public String toString(){
            return "("+obj1+","+obj2+")";
        }
        

        



    }

}
