import java.util.*;

public class Product implements Comparable<Product> {
    private String descrizione;
    private double prezzo;
    private static HashSet<Product> products = new HashSet<>();

    public Product(String descrizione, double prezzo){
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        Product.products.add(this);
    }
    @Override 
    public boolean equals(Object obj) {
        if(!(obj instanceof Product)) return false;

        Product p = (Product) obj;

        return this.descrizione.equals(p.getDescrizione());
    }

    @Override
    public int compareTo(Product p){
        if(this.descrizione.compareTo(p.getDescrizione()) > 1)
            return 1;
        else if(this.descrizione.compareTo(p.getDescrizione()) < 0)
            return -1; 

        return 0;
    }

    @Override
    public int hashCode(){
        return this.descrizione.hashCode();
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public static final Comparator<Product> comparatorByPrice = new Comparator<>() {
      public int compare(Product p1, Product p2) {
      
        if(p1.getPrezzo() > p2.getPrezzo())
            return 1;
        if(p1.getPrezzo()< p2.getPrezzo())
            return -1;

        return 0;
    }
    };

    public static Product getMostExpensive(){
        LinkedList<Product> list = new LinkedList<>(products);
        Collections.sort(list, comparatorByPrice);
        return list.getLast();
    }

    public String toString(){
        return descrizione+","+prezzo;
    }

    public static void main(String[] args) {
        Product a = new Product("Sale", 0.60),
        b = new Product("Zucchero", 0.95),
        c = new Product("Caffe'", 2.54);
        System.out.println(Product.getMostExpensive());
        System.out.println(b.compareTo(c));
        System.out.println(Product.comparatorByPrice.compare(b, c));
    }
}
