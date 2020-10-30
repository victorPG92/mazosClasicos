package juego.cartas.clasicos.modelos.imp.es;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.CartaNumeroPalo;

/**
 * Implementacion de carta espaniola con CartaNumeroPalo  
 * @author victor
 *
 */
public class CartaEspaniolaImp<V,P> 
extends CartaNumeroPalo<V, P>
implements ICartaNumeroPaloEspaniola<V, P>
{

public CartaEspaniolaImp(V numero, P palo) {
		super(numero, palo);
	}



}
