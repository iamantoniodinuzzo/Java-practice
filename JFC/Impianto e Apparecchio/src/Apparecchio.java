public class Apparecchio  implements Controllore   {
    private int potenzaAssorbitaMassima, potenzaErogataMassima;
    private boolean isOn = false;

    public Apparecchio(int potenza) {
        super();
        this.potenzaAssorbitaMassima = potenza;
    }

    public void on() throws PowerOverCapacityException {
        if (this.potenzaAssorbitaMassima > potenzaErogataMassima)throw new PowerOverCapacityException();

        this.isOn = true;
    }

    public void off() {
        this.isOn = false;
    }

    public int getPotenzaAssorbitaMassima() {
        return potenzaAssorbitaMassima;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void erogazioneMassima(int valoreMassimo) {
        this.potenzaErogataMassima = valoreMassimo;
    }
}
