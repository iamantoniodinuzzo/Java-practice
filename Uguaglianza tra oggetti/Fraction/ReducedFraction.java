import java.math.BigInteger;

public class ReducedFraction extends Fraction {

    public ReducedFraction(int numeratore, int denominatore) {
        super(numeratore / Mcd(numeratore, denominatore), denominatore / Mcd(numeratore, denominatore));
    }

    private static int Mcd(int n, int d) {
        return BigInteger.valueOf(n).gcd(BigInteger.valueOf(d)).intValue();
    }

    public Fraction times(Fraction f) {
        int newNumeratore = getNumeratore() * f.getNumeratore(), newDenominatore = getDenominatore() * f.getDenominatore();

        if (f instanceof ReducedFraction)
            return new ReducedFraction(newNumeratore, newDenominatore);

        return new Fraction(newNumeratore, newDenominatore);
    }
}