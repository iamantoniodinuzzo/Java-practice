import java.util.Objects;

public class Elemento {
    private String sigla;

    public Elemento(String sigla){
        this.sigla = Objects.requireNonNull(sigla);
    }

    @Override
    public String toString() {
        return sigla;
    }
}
