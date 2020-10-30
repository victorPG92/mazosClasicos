package juego.cartas.clasicos.mazos.impl.olds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
public class MazoOptListaMapa 
implements 
MazoCartasSimple<CartaFrancesaOld>,
MazoCartasExtraccionConcreta<CartaFrancesaOld>,
MazoConsulta<CartaFrancesaOld>,
MazoInsercion<CartaFrancesaOld>
{
	private LinkedList<CartaFrancesaOld> mazo;
	
	
	private Map<CartaFrancesaOld,Boolean> estaUsada;
	
	Random r= new Random(System.currentTimeMillis());


	
	public MazoOptListaMapa()
	{
		mazo = new LinkedList<>();
		estaUsada=  new HashMap<>();
		for(PaloFrances p : PaloFrances.values())
		{
			for(int i=1;i<14;i++)
			{
				CartaFrancesaOld carta= new CartaFrancesaOld(i,p);
				mazo.add(carta);
				estaUsada.put(carta, false);
			}
		}
	
	}
	
	
	/**
	 * Coste lineal 
	 */
	public CartaFrancesaOld dameCartaAleatoria()
	{
		int n= r.nextInt(mazo.size());
		CartaFrancesaOld carta = mazo.remove(n);
		estaUsada.put(carta,true);
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



	/**
	 * coste cte
	 */
	@Override
	public void insertaCarta(CartaFrancesaOld c)
	{
		mazo.add(c);
		estaUsada.put(c, false);
		
	}



	/**
	 * coste lineal
	 */
	@Override
	public void insertaCartas(List<CartaFrancesaOld> l)
	{
		for(CartaFrancesaOld c: l)
			insertaCarta(c);
		
	}



	/**
	 * Coste n
	 * intentar coste log n - busqqueda binaria
	 */
	@Override
	public CartaFrancesaOld dameCartaConcreta(CartaFrancesaOld cartaConcreta)
	{
		
		mazo.remove(cartaConcreta);
		estaUsada.put(cartaConcreta, false);
		
		
		
		
		return cartaConcreta;
	}



	@Override
	public List<CartaFrancesaOld> dameNCartasConcretas(List<CartaFrancesaOld> cartasConcretas) {

		List<CartaFrancesaOld> cartas= new ArrayList<>();
		for (CartaFrancesaOld carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
		}
		
		cartas.removeAll(cartasConcretas);
		
		
		return cartas;
	}



	
	



	@Override
	public boolean perteneceCartaAMazo(CartaFrancesaOld c)
	{
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
