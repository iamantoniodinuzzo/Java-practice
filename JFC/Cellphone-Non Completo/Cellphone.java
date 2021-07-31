class Cellphone{
	
	private String nome;
	private String numero_telefonico;
	
	public Cellphone(String nome, String numero_telefonico){
		this.nome = nome;
		this.numero_telefonico = numero_telefonico;
	}
	
	/**
	*consente di impostare il costo al minuto di una telefonata con un dato gestore
	*di partenza e un dato gestore di arrivo
	*@param gestore_di_arrivo il gestore di arrivo
	*/
	public static void setCost(String gestore_partenza, String gestore_arrivo, double costo){
		
	}
	
	/**
	*Calcola il costo di una telefonata verso
	*una data utenza e di una data durata (in minuti).
	*@param gestore_arrivo Il gestore a cui arriba la chiamata
	*@minuti la durata della chiamata
	*/
	public String getCost(Cellphone gestore_arrivo, int minuti){
		
	}
	
	
	
}