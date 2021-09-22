public class DelayIterator extends Thread{

	public static <T> Iterator<T> (Iterator<T> i, int n ){
		return new Iterator<T>(){
			@Override
			public boolean hasNext(){return i.hasNext();}
			public void remove(){throw UnsupportedOperationException("");}
			@Override
			public T next(){
				try{
					currentThread().sleep(n);
					return i.next();
				catch(InterruptedException){
					return null;
				}
			}
		}
	}
}