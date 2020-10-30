package juego.cartas.clasicos.dom.fact;

import java.util.HashSet;
import java.util.Set;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juego.cartas.clasicos.palos.PaloFrances;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.fact.FactComparator;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDobleVP;

/**
* Crea dominios concretos de valores y palos de las cartas espaniola y francesa
* con palos con tipo enumerados
* @author victor
*
*/
public class FactDominiosCartasEnumFr <C extends ICartaNumeroPaloFrancesa<Integer,PaloFrances>>
extends FactDominioDobleVP<Integer, PaloFrances, C>
{
	
	
	public Dominio<PaloFrances> getDominioPalos()
	{
		return getDominioPalosCartasFrancesa();
	}
	public Dominio<PaloFrances> getDominioPalosCartasFrancesa() {
		return new Dominio<>(Set.of(PaloFrances.DIAMANTES,
				PaloFrances.PICAS,
				PaloFrances.CORAZONES,
				PaloFrances.TREBOLES),
				
				new FactComparator().creaComparadorDeComparable());
		
	}

	public Dominio<Integer> getDominioNumerico()
	{
		return getDominioNumericoCartasFrancesa();
	}
	public Dominio<Integer> getDominioNumericoCartasFrancesa() {
		FactComparator fComp= new FactComparator();
		Set<Integer> valores= new HashSet<>();
		for(int i=1;i<14;i++)
			valores.add(i);
		
		
			
		
		Dominio<Integer> dom= new Dominio<>(valores, fComp.creaComparadorDeComparable());
		
		return dom;
	}
}
