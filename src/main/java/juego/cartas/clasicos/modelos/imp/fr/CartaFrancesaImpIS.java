package juego.cartas.clasicos.modelos.imp.fr;

import juego.cartas.clasicos.modelos.CartaFrancesa;


/**
 * Implementacion carta francesa con CartaNumeroPalo
 * @author victor
 *
 * @param <V>
 * @param <P>
 */
public class CartaFrancesaImpIS 
extends CartaFrancesaImpI<Integer, String>
implements CartaFrancesa
{

public CartaFrancesaImpIS(Integer numero, String palo) {
		super(numero, palo);
	}



}
