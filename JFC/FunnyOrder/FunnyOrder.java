import java.util.*;

public class FunnyOrder implements Comparable<FunnyOrder> {
	private int val;

	public FunnyOrder(int n) { val = n; }
	
	public int compareTo(FunnyOrder x) {
		if (val%2 == 0 && x.val%2 != 0) return -1;
		if (val%2 != 0 && x.val%2 == 0) return 1;
		if (val < x.val) return -1;
		if (val > x.val) return 1;
		
		return 0;
	}
	public static void main(String[] args) {
		List<FunnyOrder> l = new LinkedList<FunnyOrder>();
		l .add(new FunnyOrder(16));
		l .add(new FunnyOrder(3));
		l .add(new FunnyOrder(4));
		l .add(new FunnyOrder(10));
		l .add(new FunnyOrder(2));
		Collections.sort( l ) ;
		for (FunnyOrder f: l)
            /**
             * 2 4 10 16 3
             * Il mio ragionamento è stato guidato dal fatto che 
             * le coppie di numeri pari vengano trattate con ordinamento naturale.
             * Ciò che ho fatto è stato mettere tutti i numeri pari in ordine naturale,
             * per poi confrontare l'unico numero dispari con ognuno seguendo il criterio.
             */
			System.out.println(f.val + " ");
	}
}