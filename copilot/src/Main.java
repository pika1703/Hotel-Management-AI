// Main.java
/**
 * Point d'entrée de l'application.
 * Lance l'interface console utilisateur.
 */
public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hôtel du Centre");
        ConsoleInterface ui = new ConsoleInterface(hotel);
        ui.lancer();
    }
}
