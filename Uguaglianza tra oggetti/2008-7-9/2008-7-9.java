/*
Si considerino le seguenti specifiche alternative per il metodo equals. Due oggetti x e y di tipo Z
sono uguali se:
a) x.other e y.other puntano allo stesso oggetto ed x.val è maggiore o uguale di y.val;
b) x.other e y.other puntano allo stesso oggetto ed x.val e y.val sono entrambi pari;
c) x.other e y.other puntano allo stesso oggetto oppure x.val è uguale a y.val;
d) x.other e y.other sono entrambi null oppure nessuno dei due è null ed x.other.val è uguale a
y.other.val.

--------soluzione---------
a) 
b)
c)
d)
*/

public class Z {
	private Z other;
	private int val;
	
	
	@Override
	public boolean equals(Object o){
		if(!o instanceof Z)
			return false;
		Z z = (Z) o;
		if(this.other == null && z.other == null) 
			return true;
		
		if((this.other != null && z.other != null) && (this.other.val == z.other.val))
			return true;
		
		return false;
		
	}

}