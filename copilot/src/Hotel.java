// Hotel.java
import java.util.ArrayList;
import java.util.List;

/**
 * Représente un hôtel, gère les chambres et les réservations en mémoire.
 */
public class Hotel {
    private String nom;
    private List<Chambre> chambres;
    private List<Reservation> reservations;

    public Hotel(String nom) {
        this.nom = nom;
        this.chambres = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterChambre(Chambre chambre) {
        chambres.add(chambre);
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Recherche une chambre par son numéro.
     */
    public Chambre trouverChambreParNumero(int numero) {
        for (Chambre c : chambres) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    /**
     * Affiche un résumé des chambres.
     */
    public void afficherChambres() {
        System.out.println("Chambres de l'hôtel " + nom + " :");
        for (Chambre c : chambres) {
            System.out.println(" - " + c);
        }
    }

    /**
     * Affiche un résumé des réservations.
     */
    public void afficherReservations() {
        System.out.println("Réservations de l'hôtel " + nom + " :");
        for (Reservation r : reservations) {
            System.out.println(" - " + r + " | Prix total: " + r.calculerPrixTotal() + " €");
        }
    }
}
