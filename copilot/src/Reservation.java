// Reservation.java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Représente une réservation d'une chambre par un client.
 */
public class Reservation {
    private Client client;
    private Chambre chambre;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Reservation(Client client, Chambre chambre, LocalDate dateDebut, LocalDate dateFin) {
        this.client = client;
        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Calcule le nombre de nuits entre la date de début et la date de fin.
     */
    public long getNombreDeNuits() {
        return ChronoUnit.DAYS.between(dateDebut, dateFin);
    }

    /**
     * Calcule le prix total de la réservation.
     * Utilise le polymorphisme via chambre.calculerPrixParNuit().
     */
    public double calculerPrixTotal() {
        long nuits = getNombreDeNuits();
        if (nuits <= 0) {
            return 0.0;
        }
        return nuits * chambre.calculerPrixParNuit();
    }

    @Override
    public String toString() {
        return "Réservation de " + client +
               " pour " + chambre +
               " du " + dateDebut + " au " + dateFin +
               " (" + getNombreDeNuits() + " nuits)";
    }
}
