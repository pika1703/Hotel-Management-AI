package hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de gestion de l'hôtel.
 */
public class Hotel {

    private List<Chambre> chambres;
    private List<Reservation> reservations;

    public Hotel() {
        chambres = new ArrayList<>();
        reservations = new ArrayList<>();
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
}
