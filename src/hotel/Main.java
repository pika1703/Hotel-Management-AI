package hotel;

/**
 * Point d'entrée de l'application.
 */
public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        Chambre chambre1 = new ChambreStandard(101);
        Chambre chambre2 = new ChambreLuxe(201);

        hotel.ajouterChambre(chambre1);
        hotel.ajouterChambre(chambre2);

        Client client = new Client("Alice Dupont");

        Reservation reservation = new Reservation(client, chambre2, 3);
        hotel.ajouterReservation(reservation);

        hotel.afficherReservations();
    }
}
