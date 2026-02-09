package hotel;

/**
 * Classe abstraite représentant une chambre d'hôtel.
 */
public abstract class Chambre {

    private int numero;
    private double prixParNuit;

    public Chambre(int numero, double prixParNuit) {
        this.numero = numero;
        this.prixParNuit = prixParNuit;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrixParNuit() {
        return prixParNuit;
    }

    /**
     * Calcul du prix total selon le type de chambre.
     */
    public abstract double calculerPrix(int nombreNuits);
}
