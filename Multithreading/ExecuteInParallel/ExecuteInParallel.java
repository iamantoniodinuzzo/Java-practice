public class ExecuteInParallel {
    

    /**
     * Esegue tutti gli oggetti Runnable dell'array, k alla volta
     * @param a L'array di oggetti {@link Runnable}
     * @param k Il numero di oggetti Runnable da eseguire alla volta
     */
    public static void executeInParallel(Runnable[] r , int k){
        Thread[] t = new Thread[r.length];
        for(int i = 0; i < k; i++){
            t[i] = new Thread(r[i]);
            t[i].start();
        }
        do {
            for(int i = 0; i < k ; i++){
                if(t[i].isAlive() || t[i].isInterrupted())continue;
                /*Necessario altrimenti ad ogni ciclo
                *si avvierebbe ancora una volta un nuovo thread
                *per tutti quelli già terminati. */
                t[i].interrupt();
                if(k < r.length){
                    t[k] = new Thread(r[k]);
                    t[k++].start();
                }
            }
        } while (k < r.length);

    }

    public static void main(String[] args) {
        Runnable r = new Runnable(){
            public void run(){
                System.out.println(System.currentTimeMillis());
            }
        };
        Runnable[] a = new Runnable[10];
        for (int i = 0; i < a.length; i++) a[i] = r;
        executeInParallel(a, 4);

    }
}
