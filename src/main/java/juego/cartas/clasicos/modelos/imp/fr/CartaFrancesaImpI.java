package juego.cartas.clasicos.modelos.imp.fr;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.cartas.CartaNumeroPalo;

/**
 * Implementacion carta francesa con CartaNumeroPalo
 * @author victor
 *
 * @param <V>
 * @param <P>
 */
public class CartaFrancesaImpI<V,P> 
extends CartaNumeroPalo<V, P>
implements ICartaNumeroPaloFrancesa<V, P>
{

public CartaFrancesaImpI(V numero, P palo) {
		super(numero, palo);
	}



}
