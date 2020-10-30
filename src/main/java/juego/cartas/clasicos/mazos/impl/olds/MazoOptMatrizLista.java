package juego.cartas.clasicos.mazos.impl.olds;

import java.util.ArrayList;
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
 * matriz de cartas 
 * acceso constante
 * al pedir aleatoria, necesita 2 aleatorios
 * coste en espacio N*M
 * 
 * conteo , constante
 * saber si existe una carta, acceso constante
 * 
 * Clase mixta donde las cartas ya las tengo ordenadas
 * 
 * @author victor
 *
 */
public class MazoOptMatrizLista 
implements 
MazoCartasSimple<CartaFrancesaOld>,
MazoCartasExtraccionConcreta<CartaFrancesaOld>, 
MazoConsulta<CartaFrancesaOld>,
MazoInsercion<CartaFrancesaOld>

{
	private CartaFrancesaOld mazo[][];
	private boolean seleccionada[][];

	List<CartaFrancesaOld> cartasOrdenadas;
	
	private static final  int NUM_PALOS=  PaloFrances.values().length;
	private static final  int NUM_CARTAS= 13;
	
	Random r = new Random(System.currentTimeMillis());

	int indices[]= new int[4];
	
	public MazoOptMatrizLista()
	{
		mazo =  new CartaFrancesaOld[NUM_PALOS][NUM_CARTAS];
		seleccionada= new boolean[NUM_PALOS][NUM_CARTAS];
		cartasOrdenadas= new LinkedList<>();
		for(PaloFrances p : PaloFrances.values())
		{
			for(int i=0;i<NUM_CARTAS;i++)//cambiado
			{
				CartaFrancesaOld carta=new CartaFrancesaOld(i+1,p);
				mazo[p.ordinal()][i]= carta;
				cartasOrdenadas.add(carta);
			}
			indices[p.ordinal()]=NUM_CARTAS*p.ordinal();
		}
	}
	
	
	
	
	/**
	 * Extrae una carta del mazo
	 * 2 aleatoriios y lugo acceso constante
	 * @return carta aleatoria
	 */
	public CartaFrancesaOld dameCartaAleatoria()
	{
		 CartaFrancesaOld cartaElegida=cartasOrdenadas.get(r.nextInt(cartasOrdenadas.size()));
		 
		 seleccionada[cartaElegida.getPalo().ordinal()-1][cartaElegida.getNumero()-1]=true;
		 desplazarIndices(cartaElegida.getPalo());
		 return cartaElegida;
		 
		 
		/*
		if(cont==0){
			return null;
		}else{
		
					
			int nPalo = r.nextInt(NUM_PALOS);
			int nCarta = r.nextInt(NUM_CARTAS);
			
			Palo p =  Palo.values()[nPalo];
			Carta c = new Carta(nCarta+1,p);
			
			while(estaSeleccionada(c))
			{
				nPalo = r.nextInt(NUM_PALOS);
				nCarta = r.nextInt(NUM_CARTAS);
				
				p =  Palo.values()[nPalo];
				c = new Carta(nCarta+1,p);
			}
			
			//cont--;
			seleccionarCarta(c);
			return c;
		}*/
		
	}
	
	
	
	/**
	 * desplaza los indices desde ese palo, es decir, los siguientes
	 * @param palo
	 */
	private void desplazarIndices(PaloFrances palo)
	{
		int i=palo.ordinal()+1;
		for(i=palo.ordinal()+1;i< PaloFrances.values().length;i++)
			indices[i]=indices[i]+1;
		
	}




	/**
	 * Extrae n cartas del mazo
	 * @return cartas aleatorias
	 */
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
		int p = c.getPalo().ordinal();// Palo.values()[nPalo];
		int n= c.getNumero()-1;
		if(n==NUM_CARTAS)n=0;
		
		//si ya esta en el mazo, se inserta de nuevo, pero no repite
		seleccionada[p][n]=true;
		
	}




	@Override
	public void insertaCartas(List<CartaFrancesaOld> l) 
	{

		for(CartaFrancesaOld c: l)
			insertaCarta(c);
	}
	
	/**
	 * Devuelve si hay cartas en el mazo
	 * Coste constante
	 * @return
	 */
	public boolean estaVacio()
	{
		return cartasOrdenadas.isEmpty();
	}
	
	
	/**
	 * Coste constante
	 * @return
	 */
	public int quedanNumCartas()
	{
		return cartasOrdenadas.size();
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Devuelve si la carta c , est� en el mazo
	 * @param c
	 * @return
	 */
	public boolean perteneceCartaAMazo(CartaFrancesaOld c)
	{
		return !estaSeleccionada(c);//mazo.contains(c);
	}
	
	
	
	
	/**
	 * Coste constante
	 */
	public void seleccionarCarta(CartaFrancesaOld c )
	{
		if(c==null) return ;
		int n= c.getNumero()-1;
		if(n==13)n=1; // si es as
		int p= c.getPalo().ordinal();
		if(!estaSeleccionada(c))
		{
			seleccionada[p][n]=true;
			cartasOrdenadas.remove(c);
		}
		
	}
	
	/**
	 * Coste constante
	 */
	public boolean estaSeleccionada(CartaFrancesaOld c)
	{
		if(c==null) return false;
		
		
		int n= c.getNumero()-1;
		if(n==13)n=1; // si es as
		int p= c.getPalo().ordinal();
		boolean b=false;
		try
		{
			b= this.seleccionada[p][n];
		}catch(Exception e)
		{
			System.err.println("mazo. esta seleccionada "+c + " "+ n +" "+ p );
			
			System.exit(-1);
		}
		return b;
	}




	@Override
/**
 * Coste constante
 */
	public CartaFrancesaOld dameCartaConcreta(CartaFrancesaOld cartaConcreta) {
		if(cartaConcreta==null) 
			return null;
		
		
		int n= cartaConcreta.getNumero()-1;
		if(n==13)n=1; // si es as
		int p= cartaConcreta.getPalo().ordinal();
		boolean b=false;
		try
		{
			b= this.seleccionada[p][n];
			
			
		}catch(Exception e)
		{
			System.err.println("mazo. esta seleccionada "+cartaConcreta + " "+ n +" "+ p );
			
			System.exit(-1);
		}
		if(b)
		{
			cartasOrdenadas.remove(cartaConcreta);
			return mazo[p][n];
		
			
		}
		else return null;
	}
	




	@Override
	/**
	 * Coste lineal
	 */
	public List<CartaFrancesaOld> dameNCartasConcretas(List<CartaFrancesaOld> cartasConcretas) {
		
		List<CartaFrancesaOld> cartas= new ArrayList<>();
		for (CartaFrancesaOld carta : cartasConcretas) {
			cartas.add(dameCartaConcreta(carta));
		}
		return cartas;
	}




	
	@Override
	public int size() {
		
		return cartasOrdenadas.size();
	}


	@Override
	public boolean isEmpty() {
		return cartasOrdenadas.isEmpty();
	}

	
	
}
