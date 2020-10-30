package juego.cartas.clasicos.dom.fact;

import java.util.HashSet;
import java.util.Set;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.fact.FactComparator;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDobleVP;

/**
 * Crea dominios concretos de valores y palos de las cartas espaniola y francesa
 * con palos tipo string
 * @author victor
 *
 */
public class FactDominiosCartasFr <C extends ICartaNumeroPaloEspaniola<Integer,String>>
extends FactDominioDobleVP<Integer, String, C>
//implements FactDominioDoble<Integer, String, ICartaNumeroPaloFrancesa<Integer,String>>
{
	
	
	
	
	public Dominio<String> getDominioPalos()
	{
		return getDominioPalosCartasFrancesa();
	}
	public Dominio<String> getDominioPalosCartasFrancesa() {
		return new Dominio<>(Set.of("diamantes","picas","corazones","treboles"),new FactComparator().creaComparadorDeComparable());
		
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
		
		dom.getGetterByAlias().cambiarAlias(11, "J");
		dom.getGetterByAlias().cambiarAlias(12, "Q");
		dom.getGetterByAlias().cambiarAlias(13, "K");

		
		
		return dom;
	}
	
	
	
	/*public GetterByAlias<Integer> getAliasFrances(Collection<> coll)
	{
		GetterByAlias<Integer> getter= new GetterByAliasSimpleMap<>(coll) 
	}*/
}
