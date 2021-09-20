import Selector.java
import java.util.*

public class ConcurrentFilter{
	
	public static void main(String args[]){
		Set<Integer> x = new HashSet<Integer>();
		x.add(1); x.add(2); x.add(5);
		Selector<Integer> oddSelector = new Selector<Integer>() {
		
			public boolean select(Integer n) {
				return (n%2 != 0);
			}
		};

		Set<Integer> y = concurrentFilter(x, oddSelector);
			for (Integer n: y)
				System.out.println(n);
		
	}
	
	public <T> static Set<T> concurrentFilter(Set<T> set, Selector<T> selector){
		
		Set<T> newSet = new Set();
		
		for(T element : set){
			new Thread(){
				@Override
				public void run(){
					if(selector.select(element))
						newSet.add(element)
					
				}
			}.start();
			
		return newSet;
		
		}
		
	}
	
	
}