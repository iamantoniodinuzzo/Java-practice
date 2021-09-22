public class Costo {

private String gestore_partenza;
private String gestore_arrivo;
private double costo;

public Costo(String gestore_partenza, String gestore_arrivo, double costo){
    this.gestore_partenza = gestore_partenza;
    this.gestore_arrivo = gestore_arrivo;
    this.costo = costo;
}

public String getGestorePartenza(){return gestore_partenza;}
public String getGestoreArrivo(){return gestore_arrivo;}
public double getCosto(){return costo;}


@Override
public boolean equals(Object x) {
    if(this == x)
            return true;
        if(x == null || x.getClass()!= this.getClass())
            return false;
          
        Costo costo = (Costo) x;
          
        return (costo.gestore_arrivo.equals(this.gestore_arrivo) && (costo.getGestorePartenza().equals(this.gestore_partenza)));
    }


    
}
