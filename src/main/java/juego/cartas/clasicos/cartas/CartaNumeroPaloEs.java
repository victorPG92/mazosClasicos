package juego.cartas.clasicos.cartas;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.CartaNumeroPalo;

/**
 * Carta con 2 caracteristicas, valor y palo
 * los cuales pueden son parametrizables
 * esta implementada la igualdad
 * ( primero se compara el palo y
 *  luego el numero 
 *  por suposicion que hay menos palos que numeros)
 * @author victor
 *
 * @param <N>
 * @param <P>
 */
public class CartaNumeroPaloEs<N,P> extends CartaNumeroPalo<N,P> implements ICartaNumeroPaloEspaniola<N,P>
{

	public CartaNumeroPaloEs(N numero, P palo)
	{
		super(numero, palo);
	}

	
	
	
}
