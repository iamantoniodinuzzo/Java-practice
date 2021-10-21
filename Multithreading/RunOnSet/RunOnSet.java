import java.util.Collection;
import java.util.HashSet;

public class RunOnSet<T> extends Thread{
	
	private Collection<Thread> threadCollection = new HashSet<>();
	
	public RunOnSet(final RunnableWithArg<T> r,final Collection<T> c){
		for(final T t : c){
			threadCollection.add(new Thread(){
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

	public static void main(String[] args) {
		
		Collection<Integer> s = new HashSet<>();
		s.add(2); s.add(13); s.add(88);

		RunnableWithArg<Integer> r = new RunnableWithArg<>(){
			public void run(Integer i){
				System.out.println(i/2);
			}
		};

	Thread t = new RunOnSet<Integer>(r, s);
	t.start();
	}
}