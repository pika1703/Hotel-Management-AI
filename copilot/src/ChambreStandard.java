// ChambreStandard.java
/**
 * Chambre standard : le prix par nuit est simplement le prix de base.
 */
public class ChambreStandard extends Chambre {

    public ChambreStandard(int numero, int capacite, double prixBaseParNuit) {
        super(numero, capacite, prixBaseParNuit);
    }

    @Override
    public double calculerPrixParNuit() {
        // Pas de supplément, prix = prix de base
        return getPrixBaseParNuit();
    }

    @Override
    public String toString() {
        return "ChambreStandard - " + super.toString();
    }
}
