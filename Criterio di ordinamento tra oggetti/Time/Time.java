public class Time implements Comparable<Time> {
    public static final Time MIDDAY = new Time(12,0,0);
    public static final Time MIDNIGHT = new Time(0,0,0);
    private int hour, minutes, seconds;


    /**
     *	Il costruttore della classe
     *	@param hour accetta interi positivi da 0 a 23
     *	@param minutes accetta interi positivi da 0 a 59
     *	@param seconds accetta interi posiitivi da 0 a 59
     *	@throws IllegalArgumentException viene lanciata quando uno dei valori non rispetta l'intervallo
     */
    public Time(int hour, int minutes, int seconds)throws IllegalArgumentException{

        if((hour < 0 || hour > 23) || (minutes < 0 || minutes > 59) || (seconds < 0 || seconds > 59))
            throw new IllegalArgumentException();

        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;

    }

    /**
     * Il metodo accetta un orario e calcola la differenza.
     * @return la differenza di orario
     */
    public Time minus(Time x){
        int newHour, newMinutes, newSecods;

        //calculate difference between hours
        if(this.hour > x.hour){
            newHour = this.hour - x.hour;
        }else{
            newHour = x.hour - this.hour;
        }

        //calculate difference between minutes
        if(this.minutes > x.minutes){
            newMinutes = this.minutes - x.minutes;
        }else{
            newMinutes = x.minutes - this.minutes;
        }

        //calculate difference between seconds
        if(this.seconds > x.seconds){
            newSecods = this.seconds - x.seconds;
        }else{
            newSecods = x.seconds - this.seconds;
        }

        return new Time(newHour, newMinutes, newSecods);

    }

    @Override
    public String toString(){
        String hour, minutes, seconds;
        hour = (this.hour > 0) ? String.valueOf(this.hour) : "00";
        minutes = (this.minutes > 0) ? ":"+ this.minutes +":" : ":00:";
        seconds = (this.seconds > 0) ? String.valueOf(this.seconds) : "00";
        return hour + minutes + seconds;

    }


    public int compareTo(Time x){
        int result;
        if( compareIntegers(this.hour, x.hour) != 0){
            result = compareIntegers(this.hour, x.hour);
        }else if(compareIntegers(this.minutes, x.minutes) != 0){
            result = compareIntegers(this.minutes, x.minutes);
        }else{
            result = compareIntegers(this.seconds, x.seconds);
        }
        return result;

    }

    private int compareIntegers(int a, int b){
        if(a > b){
            return 1;
        }else if(a < b){
            return -1;
        }
        return 0;
    }

}
