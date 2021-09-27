import java.util.HashSet;
import java.util.Set;

/**
 * Calcola il salario dei dipendenti, in base alla loro anzianità in servizio.
 * Il salario mensile parte da un livello base ed ogni anno solare aumenta di un certo incremento.
 */
public class Progression {

    private int salario_base, incremento_annuale;
    private Set<Employe> employes;

    public Progression(int salario_base, int incremento_annuale) {
        this.salario_base = salario_base;
        this.incremento_annuale = incremento_annuale;
        employes = new HashSet<>();
    }

    public int getSalarioBase() {
        return salario_base;
    }

    public int getIncremento_annuale() {
        return incremento_annuale;
    }

    public Set<Employe> getEmployes() {
        return employes;
    }

    /**
     * Aggiunge un impiegato a questa progressione, specificando il nome e l'anno di assunzione.
     * @param nome
     * @param anno_di_assunzione
     */
    public void addEmployee(String nome, int anno_di_assunzione) {
        employes.add(new Employe(nome, anno_di_assunzione));
    }

    /**
     * Attribuisce ad un impiegato un bonus extra in un dato anno.
     * Cioè, addBonus("Pippo", 2010, 50) significa che Pippo percepirà 50 euro in più in ogni mese del 2010.
     * @param nome
     * @param anno
     * @param bonus
     */
    public void addBonus(String nome, int anno, int bonus) {
        // Cerco il dipendente dalla lista
        Employe fortunato = findEmploye(nome);
        // aggiungo il bonus
        fortunato.setBonus(new Bonus(anno, bonus));
    }

    /**
     * Restituisce il salario mensile di un impiegato in un dato anno
     * @param nome
     * @param anno
     * @return
     */
    public int getSalary(String nome, int anno) {
        int salario;
        Employe e = findEmploye(nome);
        // controllo che l'anno specificato sia maggiore o uguale dell'anno di
        // assunzione
        if (e != null && e.getAnnoDiAssunzione() <= anno) {
            // calcolo gli anni trascorsi
            int anni_trascorsi = anno - e.getAnnoDiAssunzione();
            //calcolo il salario
            salario = salario_base +(incremento_annuale * anni_trascorsi);
            // controllo se il dipendente ha bonus che rientra nell'anno specificato
            if (e.getBonus() != null && e.getBonus().getAnno() == anno) {
                salario += e.getBonus().getValore();
            }
        } else {
            throw new IllegalArgumentException("Il dipendente non era stato ancora assunto nel " + anno);
        }
        return salario;
    }

    private Employe findEmploye(String nome) {

        for (Employe employe : employes) {
            if (employe.getName().equals(nome)) {
                return employe;
            }
        }
        return null;
    }

    private class Employe {
        private String nome;
        private int anno_di_assunzione;
        private Bonus bonus;

        public Employe(String nome, int anno_di_assunzione) {
            this.nome = nome;
            this.anno_di_assunzione = anno_di_assunzione;
            bonus = null;
        }

        public String getName() {
            return nome;
        }

        public int getAnnoDiAssunzione() {
            return anno_di_assunzione;
        }

        public void setBonus(Bonus bonus) {
            this.bonus = bonus;
        }

        public Bonus getBonus() {
            return bonus;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + " anno di assunzione: " + anno_di_assunzione;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Employe))
                return false;

            Employe e = (Employe) obj;

            return (e.getAnnoDiAssunzione() == anno_di_assunzione && e.getName().equals(nome)) ? true : false;
        }

        @Override
        public int hashCode() {
            return anno_di_assunzione ^ nome.hashCode();
        }
    }

    private class Bonus {
        private int anno;
        private int valore;

        public Bonus(int anno, int valore) {
            this.anno = anno;
            this.valore = valore;
        }

        public int getAnno() {
            return anno;
        }

        public int getValore() {
            return valore;
        }
    }

    public static void main(String[] args) {
        Progression a = new Progression(1000, 150);
        a.addEmployee("Jesse", 2008);
        a.addEmployee("Gale", 2009);
        a.addBonus("Gale", 2010, 300);

        System.out.println(a.getSalary("Jesse", 2009));
        System.out.println(a.getSalary("Gale", 2010));
        System.out.println(a.getSalary("Gale", 2011));
    }
}