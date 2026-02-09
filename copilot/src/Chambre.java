// Chambre.java
/**
 * Classe abstraite représentant une chambre d'hôtel.
 * Utilisée comme base pour les différents types de chambres.
 */
public abstract class Chambre {
    private int numero;
    private int capacite;
    private double prixBaseParNuit;

    public Chambre(int numero, int capacite, double prixBaseParNuit) {
        this.numero = numero;
        this.capacite = capacite;
        this.prixBaseParNuit = prixBaseParNuit;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public double getPrixBaseParNuit() {
        return prixBaseParNuit;
    }

    public void setPrixBaseParNuit(double prixBaseParNuit) {
        this.prixBaseParNuit = prixBaseParNuit;
    }

    /**
     * Méthode polymorphe pour calculer le prix d'une nuit.
     * Chaque type de chambre peut appliquer sa propre logique.
     */
    public abstract double calculerPrixParNuit();

    @Override
    public String toString() {
        return "Chambre n°" + numero + " (capacité: " + capacite + ")";
    }
}
