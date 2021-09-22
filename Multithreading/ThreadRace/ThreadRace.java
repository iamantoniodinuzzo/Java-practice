public static int threadRace(Runnable r1, Runnable r2)throws InterruptedException{
	
	final int[] result = {0};// il puntatore è final quindi non posso modificare il puntatore creando un nuovo array result = new result[]
	
	Thread t1 = new Thread(
		@Override
		public void run(){
			r1.run();
			result[0] = 1;
		}
	);
	
	Thread t2 = new Thread(
		@Override
		public void run(){
			r2.run();
			result[0] = 2;
		}
	);
	
	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	return 3 - result[0];
	
}