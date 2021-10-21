public class Interruptor {

	/**
	 * Interrompe un dato thread dopo un numero di secondi
	 * 
	 * @param t Il thread da interrompere.
	 * @param s Il numero di secondi dopo i quali il thread viene interrotto.
	 */
	public Interruptor(Thread t, int s) {
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(s * 1000);
				} catch (InterruptedException i) {
					return;
				}
				t.interrupt();

			}
		}.start();
	}


	public static void main(String[] args) {

		Interruptor i = new Interruptor(new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						return;
					}
				}
			}
		}, 1);
	}

}