public class ThreadRace {
    
    public static synchronized int threadRace(Runnable r1, Runnable r2){
	
      Thread t1 = new Thread(r1);
      Thread t2 = new Thread(r2);
      int value = -1;

      try {
          t1.start();
          t2.start();
          t1.join();

          if (t2.isInterrupted()) {
              return value;
          }

          if(t2.isAlive()){
              value = 1; 
          }else{
              value = 2;
          }

      } catch (InterruptedException e) {e.printStackTrace();}
      
      finally { return value; }
        
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run(){}
        };

        System.out.println(threadRace(r, r));
    }
}
