package Visitors;
import Premios.*;
import Personajes.*;
public class VisitorCongelamientoTiempo extends Visitor{

	//atributos
	
	CongelamientoTiempo CT;
	
	//constructor
	
	public VisitorCongelamientoTiempo(CongelamientoTiempo ct) {
		CT = ct;
	}
	
	//metodos
	
	public void afectarJugador(Jugador j) {
		j.congelarTiempo();
	}
}
