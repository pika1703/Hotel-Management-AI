package hotel;

/**
 * Chambre standard sans supplément.
 */
public class ChambreStandard extends Chambre {

    public ChambreStandard(int numero) {
        super(numero, 80.0);
    }

    @Override
    public double calculerPrix(int nombreNuits) {
        return getPrixParNuit() * nombreNuits;
    }
}