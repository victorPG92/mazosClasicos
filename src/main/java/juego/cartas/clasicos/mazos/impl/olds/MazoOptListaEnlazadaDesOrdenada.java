package juego.cartas.clasicos.mazos.impl.olds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import juego.cartas.clasicos.cartas.CartaFrancesaOld;
import juego.cartas.clasicos.palos.PaloFrances;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.func.MazoConsulta;
import juegos.cartas.cartas.mazos.modelos.func.MazoInsercion;

/**
 * Mazo peor.
 * bueno que una lista enlazada puede borrar en el medio sin reordenar las otras
 * pero el acceso indice no es constante
 * 
 * Lista enlazada, al borrar , quita del medio
 * @author victor
 *
 */
public class MazoOptListaEnlazadaDesOrdenada implements 
MazoCartasSimple<CartaFrancesaOld>,
MazoCartasExtraccionConcreta<CartaFrancesaOld>, 
MazoConsulta<CartaFrancesaOld>,
MazoInsercion<CartaFrancesaOld>
{
	private LinkedList<CartaFrancesaOld> mazo;
	
	private List<CartaFrancesaOld> cartasUsadas;
	
	
	Random r= new Random(System.currentTimeMillis());


	
	public MazoOptListaEnlazadaDesOrdenada()
	{
		mazo = new LinkedList<>();
		cartasUsadas = new LinkedList<>();
		for(PaloFrances p : PaloFrances.values())
		{
			for(int i=1;i<14;i++)//cambiado
				mazo.add(new CartaFrancesaOld(i,p));
		}

		
		Collections.shuffle(mazo);
	}
	
	
	/**
	 * 
	 */
	public CartaFrancesaOld dameCartaAleatoria()
	{
		
		CartaFrancesaOld carta = mazo.remove(0);
		cartasUsadas.add(carta);
		return carta;
		
	}



	@Override
	public List<CartaFrancesaOld> dameNCartasAleatoria(int n) 
	{
		
		 ArrayList<CartaFrancesaOld> a = new  ArrayList<>();
		 for(int i=0;i<n;i++)
			 a.add(dameCartaAleatoria());
		
		 
		 return a;
	}



	@Override
	public void insertaCarta(CartaFrancesaOld c)
	{
		mazo.add(c);
		
	}



	@Override
	public void insertaCartas(List<CartaFrancesaOld> l)
	{
		mazo.addAll(l);
		/*
		for(Carta c: l)
			insertaCarta(c);
		*/
	}



	/**
	 * Coste n
	 * intentar coste log n - busqqueda binaria
	 */
	@Override
	public CartaFrancesaOld dameCartaConcreta(CartaFrancesaOld cartaConcreta)
	{		
		
		mazo.remove(cartaConcreta);
		return cartaConcreta;
		/*
		 * Palo palo = cartaConcreta.getPalo();
		int ord=palo.ordinal();
		
		
		Carta pivote= mazo.get(ord*10);// coste lineal
		
		
		Carta cartaBuscada= null;
		
		
		
		return cartaBuscada;
		*/
	}



	/**
	 * Suponer que las cartas existen 
	 */
	@Override
	public List<CartaFrancesaOld> dameNCartasConcretas(List<CartaFrancesaOld> cartasConcretas) {
		/*List<Carta> cartas= new ArrayList<>();
		for (Carta carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
		}*/
		
		mazo.removeAll(cartasConcretas);

		
		
		return cartasConcretas;

	}



	
	



	@Override
	public boolean perteneceCartaAMazo(CartaFrancesaOld c) {
		return mazo.contains(c);
	}


	@Override
	public int size() {
		
		return mazo.size();
	}


	@Override
	public boolean isEmpty() {
		return mazo.isEmpty();
	}
	
	
	
}
