// ChambreLuxe.java
/**
 * Chambre de luxe : applique un coefficient de luxe sur le prix de base.
 */
public class ChambreLuxe extends Chambre {

    private double coefficientLuxe;

    public ChambreLuxe(int numero, int capacite, double prixBaseParNuit, double coefficientLuxe) {
        super(numero, capacite, prixBaseParNuit);
        this.coefficientLuxe = coefficientLuxe;
    }

    public double getCoefficientLuxe() {
        return coefficientLuxe;
    }

    public void setCoefficientLuxe(double coefficientLuxe) {
        this.coefficientLuxe = coefficientLuxe;
    }

    @Override
    public double calculerPrixParNuit() {
        // Prix de base multiplié par un coefficient de luxe
        return getPrixBaseParNuit() * coefficientLuxe;
    }

    @Override
    public String toString() {
        return "ChambreLuxe - " + super.toString() + " (coef luxe: " + coefficientLuxe + ")";
    }
}
