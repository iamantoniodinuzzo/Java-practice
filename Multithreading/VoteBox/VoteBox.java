import java.util.LinkedList;

public class VoteBox{

    private final int n ;
    private int[] candidato = new int[2];
    private LinkedList<Thread> l = new LinkedList<Thread>();
    private boolean esito ;
    private Thread t;

    public VoteBox(int numThread){
        this.n = numThread;

        t = new Thread(){
            public void run(){
                synchronized(VoteBox.this){
                    while(!t.isInterrupted()){
                        if(l.size() == n && candidato[0] < candidato[1])
                            esito = true;
                        System.out.println("Vince: "+esito);
                        VoteBox.this.notifyAll();
                        t.interrupt();
                        
                    }
                }
            
            }

        };

        t.start();
    }

    /**
     * Permette di votare sollevando un'eccezione se si cerca di votare più di una volta
     * @param vote il voto 
     * @throws {@link java.lang.RuntimeException} Viene sollevata quando si cerca di votare più di una volta.
     */
    public void vote(boolean vote)  {
        if(l.contains(Thread.currentThread())){
            t.interrupt();
            throw new RuntimeException(Thread.currentThread()+" Ha tentato di votare due volte");
        }
        l.add(Thread.currentThread());
    }

    /**
     * Restituisce il risultato della votazione
     * @return Il risultato della votazione
     */
    public boolean waitForResult(){

        try {
            VoteBox.this.wait();
        } catch (InterruptedException e) {e.printStackTrace();}
        return esito;
    }

    /**
     * @return True se la votazione è terminata, false altrimenti
     */
    public boolean isDone(){return !t.isAlive();}

    public static void main(String[] args) {
        VoteBox b = new VoteBox(10);
        b.vote(true);
        System.out.println(b.isDone());
        b.vote(false);
    }


}