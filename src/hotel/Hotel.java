package hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de gestion de l'hôtel.
 */
public class Hotel {

    private List<Chambre> chambres;
    private List<Reservation> reservations;
    private List<Client> clients;

    public Hotel() {
        chambres = new ArrayList<>();
        reservations = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public void ajouterChambre(Chambre chambre) {
        chambres.add(chambre);
    }

    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void afficherReservations() {
        for (Reservation r : reservations) {
            r.afficherDetails();
            System.out.println("----------------------");
        }
    }
    
    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

}
