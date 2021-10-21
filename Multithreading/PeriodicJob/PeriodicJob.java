public class PeriodicJob{

	public static void  periodicJob(Runnable r, int p){
		new Thread(){
			@Override
			public void run(){
				while(!Thread.currentThread().isInterrupted()){
					new Thread(r).start();
					try{
						Thread.sleep(p);
					}catch(InterruptedException e){
						return;
					}	
				}
			}
		}.start();
	}

	public static void main(String[] args){
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("ciao");
			}
		};
		periodicJob(r,2000);		
	}
}