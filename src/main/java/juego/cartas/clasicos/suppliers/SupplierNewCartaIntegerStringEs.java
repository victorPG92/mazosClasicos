package juego.cartas.clasicos.suppliers;

import juego.cartas.clasicos.cartas.CartaNumeroPaloEs;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;

/**
 * Provee una nueva carta con numero y palo en string
 * @author victor
 *
 * @param <C>
 * @param <N>
 * @param <P>
 */
public class SupplierNewCartaIntegerStringEs implements SupplierNewCarta<ICartaNumeroPaloEspaniola<Integer, String>,Integer,String>
{

	@Override
	public ICartaNumeroPaloEspaniola<Integer, String> creaNuevaCarta(Integer numero, String palo) {
		return new CartaNumeroPaloEs<>(numero,palo	) ;
	}

	@Override
	public ICartaNumeroPaloEspaniola<Integer, String>[][] creaMatriz(Integer numero, String palo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICartaNumeroPaloEspaniola<Integer, String>[][] creaMatriz(int numero, int palo) {
		//return new CartaNumeroPalo<Integer, String>[numero][palo];

		return new ICartaNumeroPaloEspaniola[numero][palo];
}

	
	
}
