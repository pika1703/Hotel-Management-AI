package hotel;

import java.util.Scanner;

/**
 * Point d'entrée de l'application avec menu console.
 */
public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("=== Gestion de l'hôtel ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Ajouter une chambre");
            System.out.println("3. Créer une réservation");
            System.out.println("4. Afficher les réservations");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // nettoyage

            switch (choix) {

                case 1:
                    System.out.print("Nom du client : ");
                    String nom = scanner.nextLine();
                    hotel.ajouterClient(new Client(nom));
                    break;

                case 2:
                    System.out.print("Numéro de chambre : ");
                    int numero = scanner.nextInt();

                    System.out.print("Type (1 = Standard, 2 = Luxe) : ");
                    int type = scanner.nextInt();

                    Chambre chambre = (type == 2)
                            ? new ChambreLuxe(numero)
                            : new ChambreStandard(numero);

                    hotel.ajouterChambre(chambre);
                    break;

                case 3:
                    if (hotel.getClients().isEmpty() || hotel.getChambres().isEmpty()) {
                        System.out.println("Clients ou chambres manquants.");
                        break;
                    }

                    Client client = hotel.getClients().get(0);
                    Chambre ch = hotel.getChambres().get(0);

                    System.out.print("Nombre de nuits : ");
                    int nuits = scanner.nextInt();

                    hotel.ajouterReservation(new Reservation(client, ch, nuits));
                    break;

                case 4:
                    hotel.afficherReservations();
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        scanner.close();
    }
}
