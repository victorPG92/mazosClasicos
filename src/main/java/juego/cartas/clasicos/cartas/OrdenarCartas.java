package juego.cartas.clasicos.cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;


/**
 * 
 * @author victor
 * Ordenacion por burbuja  para cartas 
 * Incluye ordenar por numero, por color, por escalera
 * 
 */
public class OrdenarCartas<T extends ICartaNumeroPalo<N, P>,N,P> //<CartaFrancesaOld> 
{
	
	Comparator<T> compNumero;
	Comparator<T> compPalo;
	
	Dominio<N> domV;
	/**
	 * Ordena de mayor a menor
	 * @param mano
	 * @return
	 */
	public List<T> ordenarPorNumero( List<T> mano)
	{
		List<T> a = new ArrayList<>();
		a.add(mano.get(0));
		
		
		for(int j=1;j<mano.size();j++)
		{
			T elem = mano.get(j);
			int i=0;
			while(i < a.size() && compNumero.compare(elem, a.get(i))<0)//elem.compareTo(a.get(i))<0)
			{
				i++;
			}
			a.add(i,elem);
			//i=0;
			
		}
		return a;
	}
	
	
	public List<T> ordenarPorNumeroAscendente( List<T> l)
	{
		/*
		TreeSet<T> ts= new TreeSet<>();
		ts.addAll(l);
		ArrayList<T> r = new ArrayList<>();
		r.addAll(ts); 
		return r;
		*/
		
		Collections.sort(l,compNumero);
		return l;
	}
	
	/**
	 * Agrupa por color
	 * @param l
	 * @return
	 */
	public List<T> ordenarPorColor( List<T> l)
	{
		
		/*
		ArrayList<CartaFrancesaOld> a = new ArrayList<>();
		a.add(l.get(0));
		
		
		for(int j=1;j<l.size();j++)
		{
			CartaFrancesaOld elem = l.get(j);
			int i=0;
			while(i < a.size() && elem.getPalo().compareTo(a.get(i).getPalo())<0)
			{
				i++;
			}
			a.add(i,elem);
			i=0;
			
		}
		return a;
		*/
		
		Collections.sort(l, compPalo);
		return l;
	}
	
	/**
	 * Ordena por escalera desdendentemente /// ascendentemente
	 * VA MAL, DEBERIA ORDENAR DE OTRA FORMA 
	 * @param l
	 * @return
	 */
	public List<T> ordenarPorEscalera( List<T> l)
	{
		List<T> ordenadoNumero = ordenarPorNumero(l);
		ArrayList<T> r = new ArrayList<>();
		 
		
		for(int i=0;i<ordenadoNumero.size()-1;i++)
		{
			int dif=0;
			
			T e1 = ordenadoNumero.get(i);
			T e2 = ordenadoNumero.get(i+1);
			
			dif = domV.dif(e1.getNumero(),e2.getNumero());//e2.getNumero()-e1.getNumero();
			
			if(dif == 1 )
			{
				if(r.isEmpty())
				{
					r.add(e1);
					r.add(e2);
				}
				else
				{
					// si continuio la escalera
					if(r.get(r.size()-1).equals(e1))
					{
						r.add(e2);//meto la carta siguiente
					}
					else if(r.size()<3)// si no tengo escalera de 3 cartas, empiezo con una nueva 
					{
						r = new ArrayList<>();
						r.add(e1);
						r.add(e2);
					}
				}
				
			}
			
			
		}
		
		
		for(T c : ordenadoNumero)
		{
			if(!r.contains(c)) r.add(c);
		}
		return r;
	}
	
	public List<T> ordenarPorIguales( List<T> l)
	{
		//if(T == CartaFrancesaOld.class)
		return ordenarPorIguales1(l);
	}
	
	public List<T> ordenarPorIguales1( List<T> l)
	{
		
		//Collections.frequency(c, o)
		/*ArrayList<Carta> a = ordenarPorNumero(l);
		
		ArrayList<Carta> r = new ArrayList<>();
		 
		
		
		for(int i=0;i<a.size();i++)
		{
			
			
		}*/
		
		return null;//r
		
		
	}
	
	//sin ordenar
	/**
	 * 
	 * Hace algo mal con las restantes
	 * @param l
	 * @return
	 */
	public List<CartaFrancesaOld> ordenarPorIguales2( List<CartaFrancesaOld> l)
	{
		
		
		ArrayList<CartaFrancesaOld> r = new ArrayList<>();
		List<CartaFrancesaOld> aux = new ArrayList<>();
		
		for(CartaFrancesaOld c : l)
		{
			aux.add(c);
		}
		
		
		HashMap<Integer,Integer> m = new  HashMap<>();
		
		for(CartaFrancesaOld c : l)
		{
			int i = c.getNumero();
			int v= 1;
			if(m.containsKey(i)) v += m.get(i);
			m.put(i, v);
		}
		int max=0;
		//como solo son 5, puede ser que sean (2 2 1), o (3  2) o  o (4 1) o (1..2 ) o (1..1)
		for( Integer i : m.keySet())
		{
			int v= m.get(i);
			if(v > max) max=v;
			
			ArrayList<CartaFrancesaOld> coinc= new ArrayList<>();
			for(CartaFrancesaOld c : l)
			{
				if(c.getNumero()==i) coinc.add(c);
				
			}
			if(v==2)
			{
				if(max>2) // como mucho ==3
				{
					for(CartaFrancesaOld c :coinc)
					{
						r.add(3,c);
						aux.remove(c);
					}
				}
				else
				{
					for(CartaFrancesaOld c :coinc)
					{
						r.add(0,c);
						aux.remove(c);
					}
					
				}
			}
			else if(v>2 )
			{
				
				for(CartaFrancesaOld c :coinc)
				{
					r.add(0,c);
					aux.remove(c);
				}
			}
		}
		if(!aux.isEmpty())// si hay cartas sueltas 
		{
			aux= (new OrdenarCartas()).ordenarPorNumero(aux); //ordena descendentemente
			
			
		}
		
		for(CartaFrancesaOld c:aux)
			r.add(c);
		
		return r;
	}
	
	
/*
	public ArrayList<Carta> ordenarPorEscalera( ArrayList<Carta> l)
	{
		ArrayList<Carta> a = ordenarPorNumero(l);
		ArrayList<Carta> r = new ArrayList<>();
		 
		
		for(int i=0;i<l.size()-1;i++)
		{
			int dif=0;
			int j=0;
			while(dif != 1 && j < l.size())
			{
				Carta e1 = l.get(i);
				Carta e2 = l.get(i+1);
				dif = e2.getNum()-e1.getNum();
				//MAALs
				// si la diferencia entre el primer elemento y el siguiente no es 1 
				// muevo el primer elemento al final 
				if(dif !=1)  
				{
					
				}
				j++;
			}
			
			
		}
		return a;
	}*/

}
