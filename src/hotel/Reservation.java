package hotel;

/**
 * Représente une réservation.
 */
public class Reservation {

    private Client client;
    private Chambre chambre;
    private int nombreNuits;

    public Reservation(Client client, Chambre chambre, int nombreNuits) {
        this.client = client;
        this.chambre = chambre;
        this.nombreNuits = nombreNuits;
    }

    public double calculerPrixTotal() {
        return chambre.calculerPrix(nombreNuits);
    }

    public void afficherDetails() {
        System.out.println("Client : " + client.getNom());
        System.out.println("Chambre n° : " + chambre.getNumero());
        System.out.println("Nombre de nuits : " + nombreNuits);
        System.out.println("Prix total : " + calculerPrixTotal() + " €");
    }
}
