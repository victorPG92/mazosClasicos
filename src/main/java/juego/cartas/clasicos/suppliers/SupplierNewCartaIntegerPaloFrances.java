package juego.cartas.clasicos.suppliers;

import juego.cartas.clasicos.cartas.CartaFrancesaOld;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juego.cartas.clasicos.palos.PaloFrances;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;

/**
 * Provee una nueva carta con numero y palo frances con enumerado
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerPaloFrances implements SupplierNewCarta<ICartaNumeroPaloFrancesa<Integer, PaloFrances>,Integer,PaloFrances>
{

	@Override
	public CartaFrancesaOld creaNuevaCarta(Integer numero, PaloFrances palo) {
		return new CartaFrancesaOld(numero,palo) ;
	}

	@Override
	public CartaFrancesaOld[][] creaMatriz(Integer numero, PaloFrances palo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaFrancesaOld[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new CartaFrancesaOld[numero][palo];
}

	
	
}
