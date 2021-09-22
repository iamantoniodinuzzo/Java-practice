import java.util.HashSet;

class Cellphone{
	
	private String gestore;
	private String numero_telefonico;
	private static HashSet<Costo> costs = new HashSet<>();

	
	public Cellphone(String gestore, String numero_telefonico){
		this.gestore = gestore;
		this.numero_telefonico = numero_telefonico;
	}

	public String getGestore(){return gestore;}
	
	/**
	 * Consente di impostare il costo al minuto di una telefonata con un dato gestore
	 * di partenza e un dato gestore di arrivo	
	 * @param gestore_partenza Il gestore di partenza
	 * @param gestore_arrivo Il gestore di arrivo
	 * @param costo Il costo al minuto
	 */
	public static void setCost(String gestore_partenza, String gestore_arrivo, double costo){
		Costo newCost = new Costo(gestore_partenza, gestore_arrivo, costo);
		costs.add(newCost);
	}
	
	/**
	 * Calcola il costo di una telefonata verso
	 * una data utenza e di una data durata (in minuti).	
	 * @param gestore_arrivo Il gestore di arrivo
	 * @param minuti Il numero di minuti
	 * @return Il costo della telefonata in minuti
	 */
	public double getCost(Cellphone gestore_arrivo, int minuti){

		double price = 0;
		Costo cost_to_find = new Costo(this.getGestore(), gestore_arrivo.getGestore(), 0);

		for (Costo element : costs) {
			if(element.equals(cost_to_find)){
					price = element.getCosto()* minuti;
			}			
		}

		if(price == 0)
			throw new RuntimeException();
			
		return price;
	}
	
	
	
}