import java.util.HashSet;

public class Persona {
    private String nome;
    private HashSet<GreenPass> elenco;

    public Persona(String nome){
        this.nome = nome;
        this.elenco = new HashSet<>();
    }

    public GreenPass vaccinate(int data_vaccinazione){
        GreenPass newGreenPass;
        if(elenco.isEmpty()){
            newGreenPass = new GreenPass(nome, data_vaccinazione, true);
        }else{
            newGreenPass = new GreenPass(nome, data_vaccinazione, true);
        }

        elenco.add(newGreenPass);

        return newGreenPass;
    }

    public String getNome(){return this.nome;}

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Person)) return false;

        Persona p = (Persona) obj;

        return this.nome.equalsIgnoreCase(p.getNome());
    }

    public static void main(String[] args) {
        Persona aldo = new Persona("Aldo"), barbara = new Persona("Barbara");
        GreenPass p1 = aldo.vaccinate(10), p2 = aldo.vaccinate(250);
        System.out. println (p1.isValidOn(20)) ;
        System.out. println (p1.isValidOn(200)) ;
        System.out. println (p1.belongsTo(barbara)) ;
    }

}
