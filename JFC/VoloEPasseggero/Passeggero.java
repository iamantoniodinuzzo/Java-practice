import java.util.Objects;

public class Passeggero {
    private String nome;

    public Passeggero(String nome){
        this.nome = Objects.requireNonNull(nome);
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Passeggero))
            return false;
        
        Passeggero p = (Passeggero) o;
        return nome.equals(p.nome);

    }

    @Override
    public int hashCode(){return nome.hashCode();}
    
}
