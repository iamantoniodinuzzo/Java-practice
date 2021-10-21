import java.util.Iterator;
import java.util.*;

public class DelayIterator extends Thread{

	public static <T> Iterator<T> delayIterator(Iterator<T> i, int n ){
		return new Iterator<T>(){
			@Override
			public boolean hasNext(){return i.hasNext();}
			// public void remove(){throw UnsupportedOperationException("");}
			@Override
			public T next(){
				try{
					currentThread().sleep(n);
					return i.next();
				}catch(InterruptedException e){
					return null;
				}
			}
		};
	}

	public static void main(String[] args) {
		List<Integer> l = new LinkedList<>();
		l.add(3);
		l.add(4);
		l.add(177);

		Iterator<Integer> i = delayIterator(l.iterator(), 2);
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}