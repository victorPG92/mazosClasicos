package juego.cartas.clasicos.cartas;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juego.cartas.clasicos.palos.PaloFrances;
import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.NumCarta;

/**
 * Estructura carta con palo y numero
 * 
 * no entiendo por que es necesario implementar implicitamente ICartaNumeroPaloFrancesa<Integer,PaloFrances> si ya hereda de CartaNumeroPaloFrancesa<Integer,PaloFrances>
 * @author victor
 *
 */
public class CartaFrancesaOld extends CartaNumeroPalo<Integer,PaloFrances> implements Comparable<CartaFrancesaOld> ,ICartaNumeroPaloFrancesa<Integer,PaloFrances>
{/*
	private PaloFrances palo;
	private int num;
*/
	public CartaFrancesaOld(int n , PaloFrances p)
	{
		super(n,p);
	}
	



	public String toString()
	{
		return numero +" de "+ palo;
		//return NumCarta.nombreCarta(num) + " of " +palo.ing();//.name();
	}

	@Override
	public int compareTo(CartaFrancesaOld o) 
	{
		//Carta o= (Carta) i;
		int n1=numero;
		int n2=o.numero;
		if(n1==1)n1 = 15;
		if(n2==1)n2 = 15;
		
		int r= Integer.compare(n1, n2);
		if(r==0)r=0;//tienen el mismo valor
		
		return r;
		
	}
	
	
	public String dameNombre()
	{
		return NumCarta.nombreCarta(numero);
	}
	
	public String dameLetras()
	{
		return NumCarta.letraCarta(numero)+ Character.toLowerCase(palo.letr());
	}
	
	
	/**
	 * Suponiendo que juego con una unica baraja;(si no, pone un atributo idBaraja)
	 * POr lo que una carta sera igual a otra  si sus numeros y palos son coinciden
	 */
	public boolean equals(Object o)
	{
		try
		{
			CartaFrancesaOld c = (CartaFrancesaOld)o;
			return this.numero == c.numero && this.palo.equals(c.palo);
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
}
