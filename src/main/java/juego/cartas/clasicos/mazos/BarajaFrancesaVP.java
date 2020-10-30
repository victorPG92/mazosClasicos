package juego.cartas.clasicos.mazos;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasDeshacer;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasExtraccionConcreta;
import juegos.cartas.cartas.mazos.modelos.func.MazoCartasSimple;
import juegos.cartas.cartas.mazos.modelos.func.MazoConsulta;
import juegos.cartas.cartas.mazos.modelos.func.MazoInsercion;

public interface BarajaFrancesaVP <C extends ICartaNumeroPaloFrancesa<N, P>,N,P> 
extends 
MazoCartasSimple<C>,
MazoCartasExtraccionConcreta<C>, 
MazoConsulta<C>,
MazoInsercion<C>,
MazoCartasDeshacer<C>
{
	
}
