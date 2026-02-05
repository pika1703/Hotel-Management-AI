package gemini;
import java.util.*;

//--- CLASSES DE BASE ---

abstract class Chambre {
 protected int numero;
 protected double prixBase;

 public Chambre(int numero, double prixBase) {
     this.numero = numero;
     this.prixBase = prixBase;
 }

 // Méthode polymorphe pour le calcul du prix
 public abstract double calculerPrix(int nuitees);

 @Override
 public String toString() {
     return "Chambre n°" + numero + " [" + this.getClass().getSimpleName() + "]";
 }
}

class Client {
 private String nom;
 private String email;

 public Client(String nom, String email) {
     this.nom = nom;
     this.email = email;
 }

 public String getNom() { return nom; }
}

//--- HÉRITAGE ET POLYMORPHISME ---

class ChambreStandard extends Chambre {
 public ChambreStandard(int numero, double prixBase) {
     super(numero, prixBase);
 }

 @Override
 public double calculerPrix(int nuitees) {
     return prixBase * nuitees;
 }
}

class ChambreLuxe extends Chambre {
 private double fraisServiceVip;

 public ChambreLuxe(int numero, double prixBase, double fraisVip) {
     super(numero, prixBase);
     this.fraisServiceVip = fraisVip;
 }

 @Override
 public double calculerPrix(int nuitees) {
     // Le luxe inclut des frais fixes de service VIP
     return (prixBase * nuitees) + fraisServiceVip;
 }
}

//--- GESTION DES RÉSERVATIONS ---

class Reservation {
 private Client client;
 private Chambre chambre;
 private int nuitees;

 public Reservation(Client client, Chambre chambre, int nuitees) {
     this.client = client;
     this.chambre = chambre;
     this.nuitees = nuitees;
 }

 public void afficherFacture() {
     System.out.println("\n--- FACTURE ---");
     System.out.println("Client : " + client.getNom());
     System.out.println("Hébergement : " + chambre);
     System.out.println("Durée : " + nuitees + " nuits");
     System.out.println("Total à payer : " + chambre.calculerPrix(nuitees) + " €");
     System.out.println("----------------");
 }
}

//--- APPLICATION PRINCIPALE (CONSOLE) ---

public class GestionHotel {
 public static void main(String[] args) {
     // Initialisation des données
     List<Chambre> chambresDisponibles = new ArrayList<>();
     chambresDisponibles.add(new ChambreStandard(101, 50.0));
     chambresDisponibles.add(new ChambreLuxe(201, 150.0, 40.0));

     Scanner sc = new Scanner(System.in);

     System.out.println("=== BIENVENUE AU GEMINI HOTEL ===");
     
     // Simulation d'une création de client
     System.out.print("Entrez votre nom : ");
     String nom = sc.nextLine();
     Client client = new Client(nom, nom.toLowerCase() + "@example.com");

     // Choix de la chambre
     System.out.println("\nChambres disponibles :");
     for (int i = 0; i < chambresDisponibles.size(); i++) {
         System.out.println(i + " - " + chambresDisponibles.get(i));
     }
     
     System.out.print("Choisissez le numéro d'index de la chambre : ");
     int choix = sc.nextInt();
     
     System.out.print("Nombre de nuits : ");
     int nuits = sc.nextInt();

     // Création et affichage de la réservation
     if (choix >= 0 && choix < chambresDisponibles.size()) {
         Reservation res = new Reservation(client, chambresDisponibles.get(choix), nuits);
         res.afficherFacture();
     } else {
         System.out.println("Choix invalide.");
     }

     sc.close();
 }
}