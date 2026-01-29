package hotel;

/**
 * Chambre de luxe avec supplément.
 */
public class ChambreLuxe extends Chambre {

    public ChambreLuxe(int numero) {
        super(numero, 150.0);
    }

    @Override
    public double calculerPrix(int nombreNuits) {
        return getPrixParNuit() * nombreNuits * 1.2; // supplément luxe
    }
}
