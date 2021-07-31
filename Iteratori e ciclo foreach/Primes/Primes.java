import org.omg.IOP.CodecPackage.InvalidTypeForEncoding;
import sun.security.mscapi.CPublicKey;

import java.util.Iterator;
import java.util.List;

public abstract class Primes {
    public static final Iterable<Integer> all = new Iterable<Integer>() {
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                private int n = 1;

                public boolean hasNext() {
                    return true;
                }

                public Integer next() {
                    int j, temp = n;
                    while (true) {
                        n++;
                        // cerca un divisore j di n
                        for (j = 2; j <= n / 2; j++) if (n % j == 0) break;
                        // esce dal while se n e' primo
                        if (j > n / 2) break;
                    }
                    return temp;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }; // fine classe anonima derivata da Iterator
        } // fine metodo iterator()
    }; // fine classe anonima derivata da Iterable
} // fine classe Primes