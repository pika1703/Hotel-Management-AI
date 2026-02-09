// ConsoleInterface.java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interface console permettant à l'utilisateur d'interagir avec l'hôtel.
 * Cette classe ne contient aucune logique métier : elle appelle simplement les méthodes du modèle.
 */
public class ConsoleInterface {

    private final Hotel hotel;
    private final Scanner scanner;
    private final List<Client> clients; // stockage simple en mémoire

    public ConsoleInterface(Hotel hotel) {
        this.hotel = hotel;
        this.scanner = new Scanner(System.in);
        this.clients = new ArrayList<>();
    }

    /**
     * Lance la boucle principale du menu.
     */
    public void lancer() {
        int choix;

        do {
            afficherMenu();
            choix = lireEntier("Votre choix : ");

            switch (choix) {
                case 1 -> ajouterClient();
                case 2 -> ajouterChambre();
                case 3 -> creerReservation();
                case 4 -> hotel.afficherChambres();
                case 5 -> hotel.afficherReservations();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }

            System.out.println();

        } while (choix != 0);
    }

    private void afficherMenu() {
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Ajouter une chambre");
        System.out.println("3. Créer une réservation");
        System.out.println("4. Afficher les chambres");
        System.out.println("5. Afficher les réservations");
        System.out.println("0. Quitter");
    }

    // ---------------------------
    // Gestion des clients
    // ---------------------------

    private void ajouterClient() {
        System.out.println("=== Ajout d'un client ===");

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        Client client = new Client(nom, prenom, email);
        clients.add(client);

        System.out.println("Client ajouté !");
    }

    private Client choisirClient() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return null;
        }

        System.out.println("=== Choisissez un client ===");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ". " + clients.get(i));
        }

        int choix = lireEntier("Votre choix : ");
        if (choix < 1 || choix > clients.size()) {
            System.out.println("Choix invalide.");
            return null;
        }

        return clients.get(choix - 1);
    }

    // ---------------------------
    // Gestion des chambres
    // ---------------------------

    private void ajouterChambre() {
        System.out.println("=== Ajout d'une chambre ===");

        int numero = lireEntier("Numéro de chambre : ");
        int capacite = lireEntier("Capacité : ");
        double prixBase = lireDouble("Prix de base par nuit : ");

        System.out.println("Type de chambre :");
        System.out.println("1. Standard");
        System.out.println("2. Luxe");

        int type = lireEntier("Votre choix : ");

        Chambre chambre;

        if (type == 1) {
            chambre = new ChambreStandard(numero, capacite, prixBase);
        } else if (type == 2) {
            double coef = lireDouble("Coefficient de luxe : ");
            chambre = new ChambreLuxe(numero, capacite, prixBase, coef);
        } else {
            System.out.println("Type invalide.");
            return;
        }

        hotel.ajouterChambre(chambre);
        System.out.println("Chambre ajoutée !");
    }

    private Chambre choisirChambre() {
        List<Chambre> chambres = hotel.getChambres();

        if (chambres.isEmpty()) {
            System.out.println("Aucune chambre disponible.");
            return null;
        }

        System.out.println("=== Choisissez une chambre ===");
        for (int i = 0; i < chambres.size(); i++) {
            System.out.println((i + 1) + ". " + chambres.get(i));
        }

        int choix = lireEntier("Votre choix : ");
        if (choix < 1 || choix > chambres.size()) {
            System.out.println("Choix invalide.");
            return null;
        }

        return chambres.get(choix - 1);
    }

    // ---------------------------
    // Gestion des réservations
    // ---------------------------

    private void creerReservation() {
        System.out.println("=== Création d'une réservation ===");

        Client client = choisirClient();
        if (client == null) return;

        Chambre chambre = choisirChambre();
        if (chambre == null) return;

        System.out.print("Date de début (AAAA-MM-JJ) : ");
        LocalDate debut = LocalDate.parse(scanner.nextLine());

        System.out.print("Date de fin (AAAA-MM-JJ) : ");
        LocalDate fin = LocalDate.parse(scanner.nextLine());

        if (!fin.isAfter(debut)) {
            System.out.println("La date de fin doit être après la date de début.");
            return;
        }

        Reservation reservation = new Reservation(client, chambre, debut, fin);
        hotel.ajouterReservation(reservation);

        System.out.println("Réservation créée !");
        System.out.println("Prix total : " + reservation.calculerPrixTotal() + " €");
    }

    // ---------------------------
    // Méthodes utilitaires
    // ---------------------------

    private int lireEntier(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre : ");
            scanner.next();
        }
        int valeur = scanner.nextInt();
        scanner.nextLine(); // vider le buffer
        return valeur;
    }

    private double lireDouble(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Veuillez entrer un nombre : ");
            scanner.next();
        }
        double valeur = scanner.nextDouble();
        scanner.nextLine(); // vider le buffer
        return valeur;
    }
}
