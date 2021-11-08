import java.util.*;

public class Molecola {
    private HashMap<Elemento, Integer> composizione;

    public Molecola() {
        composizione = new HashMap<>();
    }

    public void add(Elemento elemento, int numero_atomi) {
        if (numero_atomi <= 0)
            throw new IllegalArgumentException();

        if (composizione.containsKey(elemento)) {
            int oldValue = composizione.get(elemento);
            composizione.put(elemento, oldValue + numero_atomi);
        } else {
            composizione.put(elemento, numero_atomi);
        }

    }

    public String toString() {
        String result = "";
        for (Map.Entry<Elemento, Integer> element : composizione.entrySet()) {
            if (element.getValue() == 1)
                result += element.getKey().toString();
            else
                result += element.getKey().toString() + element.getValue();
            result += " ";
        }
        return result;
    }

    public static void main(String[] args) {
        Elemento ossigeno = new Elemento("O");
        Elemento idrogeno = new Elemento("H");
        Molecola acqua = new Molecola();
        acqua.add(idrogeno, 1);
        acqua.add(ossigeno, 1);
        acqua.add(idrogeno, 1);
        System.out.println(acqua);
    }
}
