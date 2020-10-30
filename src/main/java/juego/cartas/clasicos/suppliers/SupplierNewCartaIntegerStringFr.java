package juego.cartas.clasicos.suppliers;

import juego.cartas.clasicos.cartas.CartaNumeroPaloFr;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;

/**
 * Provee una nueva carta con numero y palo en string
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerStringFr implements SupplierNewCarta<ICartaNumeroPaloFrancesa<Integer, String>,Integer,String>
{

	@Override
	public ICartaNumeroPaloFrancesa<Integer, String> creaNuevaCarta(Integer numero, String palo) {
		return new CartaNumeroPaloFr<>(numero,palo	) ;
	}

	@Override
	public ICartaNumeroPaloFrancesa<Integer, String>[][] creaMatriz(Integer numero, String palo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICartaNumeroPaloFrancesa<Integer, String>[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new ICartaNumeroPaloFrancesa[numero][palo];
}

	
	
}
