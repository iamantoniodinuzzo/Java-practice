public class Fraction {

    private int numeratore, denominatore;

    public Fraction(int numeratore, int denominatore) {
        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Fraction)) return false;

        Fraction f = (Fraction) o;

        return numeratore / denominatore == f.getNumeratore() / f.getDenominatore();
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    @Override
    public String toString() {
        return numeratore + "/" + denominatore;

    }

    public Fraction times(Fraction f) {
        int newNumeratore = numeratore * f.getNumeratore(), newDenominatore = denominatore * f.getDenominatore();

        return new Fraction(newNumeratore, newDenominatore);
    }

}

