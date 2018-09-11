package Mapas;
import java.awt.Color;

import javax.swing.JFrame;

import Grafica.*;

public class Mapa_1 extends Mapa{

	//atributos
	
	//constructor
	
	public Mapa_1(GUI g) {
		super(g);
	}
	
	public void crearNivel() {
		gui.setResizable(false);
		gui.getContentPane().setBackground(Color.LIGHT_GRAY);
		gui.getContentPane().setLayout(null);
		gui.setBounds(250, 50, getAncho(), getAlto());
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
