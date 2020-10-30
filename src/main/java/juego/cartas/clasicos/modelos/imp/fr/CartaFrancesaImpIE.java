package juego.cartas.clasicos.modelos.imp.fr;

import juego.cartas.clasicos.modelos.CartaFrancesa;
import juego.cartas.clasicos.palos.PaloFrances;

/**
 * Implementacion carta francesa con CartaNumeroPalo
 * @author victor
 *
 * @param <V>
 * @param <P>
 */
public class CartaFrancesaImpIE 
extends CartaFrancesaImpI<Integer, PaloFrances>
implements CartaFrancesa
{

public CartaFrancesaImpIE(Integer numero, PaloFrances palo) {
		super(numero, palo);
	}



}
