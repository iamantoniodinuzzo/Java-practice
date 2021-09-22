public interface RunnableWithArg<T>{
	void run(T x);
}
public class RunOnSet<T> extends Thread{
	
	private final Collection<Thread> threadCollection = new HashSet<>();
	
	public RunOnSet(final RunnableWithArg<T> r,final Collection<T> c){
		for(final T t : c){
			threadCollection.add(new Thread()){
				@Override
				public void run(){
					r.run(t);
				}
			});
		}
		
		
	}
	
	@Override
	public void run(){
		for(Thread t : threadCollection)
			t.start();
	}
}