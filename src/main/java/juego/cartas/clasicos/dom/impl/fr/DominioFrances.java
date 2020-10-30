package juego.cartas.clasicos.dom.impl.fr;

import java.util.Comparator;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;

/**
 * Dominio de cartas francesas
 * @author victor
 *
 * @param <V>
 * @param <P>
 */
public class DominioFrances<V,P> extends DominioValorPalo<V, P, ICartaNumeroPaloFrancesa<V, P>>{

	public DominioFrances(Dominio<V> domValor, Dominio<P> domPalo,
			Comparator<ICartaNumeroPaloFrancesa<V, P>> comparadorCartasValoracion) {
		super(domValor, domPalo, comparadorCartasValoracion);
	}

	public DominioFrances(Dominio<V> domValor, Dominio<P> domPalo) {
		super(domValor, domPalo);
	}

	

	

	
	
}
