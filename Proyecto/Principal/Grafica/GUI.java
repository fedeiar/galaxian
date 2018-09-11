package Grafica;
import Mapas.*;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import Logica.Logica;

import javax.swing.SwingConstants.*;

 public class GUI extends JFrame {
 	
 	//ATRIBUTOS
	 
	 private JLabel label_disparo;
	 
	 private Logica log;
	 private Mapa mapa;
	 
	//CONSTRUCTOR
	 
	public GUI() {
		super("Galaxian");
		initialize();
	}
 	
	private void initialize() {
		
		
		mapa = new Mapa_1(this);
		log = new Logica(mapa, this);
		
		//CREA EL FRAME EN EL NIVEL 1
		
		mapa.crearNivel();
		
		//LABELS
		
		//crea al jugador
		this.getContentPane().add(log.getJugador().getLabel());
		
		//crea a los enemigos
		log.crearEnemigosConArma(10);
		
		
		
		
		
		
		OyenteTeclado OT = new OyenteTeclado();
		this.addKeyListener(OT);
	}
	
	//-------------------------------------------
	//-------------OYENTES-----------------------
	//-------------------------------------------
	
	class OyenteTeclado implements KeyListener{

		public void keyTyped(KeyEvent e) {
			
		}

		
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				log.mover(0);
				
				
				/*
				Rectangle r = Player.getBounds();
				int newX = r.x-=10;
				Rectangle newR = new Rectangle(newX,r.y,r.width,r.height);
				Player.setBounds(newR);
				
				if (Player.getX() < 0){
					Player.setBounds(MAX_X - log.getJugador().getDimension().getAncho(), r.y, r.width, r.height);
				 */
			}
			else {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					log.mover(1);
					
					/*
					Rectangle r = Player.getBounds();
					int newX= r.x+=10;
					Rectangle newR = new Rectangle(newX,r.y,r.width,r.height);
					Player.setBounds(newR);
					if (Player.getX() + log.getJugador().getDimension().getAncho() > MAX_X  ){
						Player.setBounds(0,r.y,r.width,r.height);
					}
					*/
				}
				else {
					
					
					/*
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						label_disparo = new JLabel();
						label_disparo.setOpaque(true);
						label_disparo.setBackground(Color.YELLOW);
						label_disparo.setBounds(0,0,5,20);
						getContentPane().add(label_disparo);
						
						int Pos_X = Player.getX() + Player.getWidth()/2;
						int Pos_Y = Player.getY() - Player.getHeight();
						label_disparo.setBounds(Pos_X , Pos_Y , label_disparo.getWidth(), label_disparo.getHeight());
					*/
					}
				}
				
			}
		
		public void keyReleased(KeyEvent e) {
			
		}
			
		

		
	}
	
	
	
}