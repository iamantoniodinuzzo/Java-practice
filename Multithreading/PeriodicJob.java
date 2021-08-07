public static void  periodicJob(Runnable r, int p){
	new Thread(){
		try{
			currentThread().sleep(p);
		}catch(InterruptedException ie){
			r.run();
		}
	}
}