import java.util.*;


class Time implements Comparable<Time>{
	
	public static final Time MIDDAY = new Time(12,0,0);
	public static final Time MIDNIGHT = new Time(0,0,0);
	private int hour, minutes, seconds;
	
	public Time(int hour, int minutes, int seconds){
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	public Time minus(Time time){
		return new Time(Math.abs(this.hour - time.hour),
						Math.abs(this.minutes - time.minutes),
						Math.abs(this.seconds - time.seconds));
		
	}
	
	@Override
	public int compareTo(Time time){
		if(this.hour == time.hour){//same hour
			if (this.minutes == time.minutes){//same minutes
				if (this.seconds == time.seconds){//same seconds
					return 0;
				}else if (this.seconds < time.seconds){
					return -1;
				}else{
					return 1;
				}
			}else if (this.minutes < time.minutes){
				return -1;
			}else{
				return 1;
			}
		}else if (this.hour < time.hour){
			return -1;
		}else{
			return 1;
		}

	}
	
	@Override
	public String toString(){
		return this.hour+":"+this.minutes+":"+this.seconds;
	}
	
	
	public static void main(String args[]){
		Time t1 = new Time(14,35,0);
		Time t2 = new Time(7,10,30);
		Time t3 = t1.minus(t2);
		System.out.println(t3) ;
		System.out.println(t3.compareTo(t2));
		System.out.println(t3.compareTo(Time.MIDDAY));
}
}