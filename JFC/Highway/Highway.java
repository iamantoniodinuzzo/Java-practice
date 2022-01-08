import java.util.*;

public class Highway {
    
    private int mLength ; //lunghezza dell'autostrada in km
    private List<Car> cars;

    /**
     * @param length la lunghezza dell'autostrada
     * @throws IllegalArgumentException se l'argomento è inferiore ad 1
     */
    public Highway(int length){
        if(length < 1) throw new IllegalArgumentException();

        this.mLength = length;
        this.cars = new ArrayList<>();
    }

    /**
     * Aggiunge un'automobile in quell'esatto km
     * @param position il km in cui inserire un'auto
     */
    public void insertCar(int position){
        //controllo se la posizione specificata è inferiore o uguale 
        //alla lunghezza dell'autostrada specificata
        if(position > mLength) throw new IllegalArgumentException();
        
        cars.add(new Car(position));        

    }

    public int nCars(int x){
        int counter = 0;

        for (Car car : cars) {
            if(car.getPosition() == x)
                counter++;
        }

        return counter;
    }

    /**
     * Simula il passaggio di 1 minuto di tempo (cioè fa avanzare tutte le automobili di un
     * chilometro)
     */
    public void progress(){
        for (Car car : cars) {
            car.incrementPosition();
        }
    }



    private class Car{
        private  int mPosition;

        public Car(int position){this.mPosition = position;}

        public int getPosition(){return mPosition;}

        public void incrementPosition(){
            mPosition+= 1;
        }
    }
}
