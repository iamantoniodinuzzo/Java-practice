import java.util.*;

public class ConcurrentFilter {

	public static <T> Set<T> concurrentFilter(final Set<? extends T> x, final Predicate<? super T> p) {
		final Set<T> y = new HashSet<>();

		class MyThread extends Thread {
			private T abj;

			public MyThread(T abj) {
				this.abj = abj;
			}

			public void run() {
				if (p.test(abj)) {
					synchronized (y) {
						y.add(abj);
					}
				}
			}
		}

		Thread[] tarr = new Thread[x.size()];

		int i = 0;
		for (T elem : x) {
			tarr[i] = new MyThread(elem);
			tarr[i++].start();
		}

		for (Thread t : tarr) {
			try {
				t.join();
			} catch (InterruptedException e) {
				return null;
			}
		}
		return y;
	}

	public static void main(String args[]) {
		Set<Integer> x = new HashSet<Integer>();
		x.add(1);
		x.add(2);
		x.add(5);

		Predicate<Integer> oddSelector = new Predicate<Integer>() {
			public boolean test(Integer n) {
				return (n % 2 != 0);
			}
		};

		Set<Integer> y = concurrentFilter(x, oddSelector);
		for (Integer n : y)
			System.out.println(n);

	}
}