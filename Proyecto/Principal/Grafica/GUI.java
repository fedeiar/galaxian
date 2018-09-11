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
	 
	 private JLabel lblEnemigo,lblEnemigo_1,label,label_1,label_2,label_3,label_4,label_5,label_disparo;
	 
	 private Logica log;
	 private Mapa mapa;
	 
	//CONSTRUCTOR
	 
	public GUI() {
		super("Galaxian");
		initialize();
	}
 	
	private void initialize() {
		
		
		mapa = new Mapa();
		log = new Logica(mapa, this);
		
		//ATRIBUTOS DEL FRAME
		
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.getContentPane().setLayout(null);
		this.setBounds(250, 50, mapa.getAncho(), mapa.getAlto());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//LABELS
		
		
		
		this.getContentPane().add(log.getJugador().getLabel());
		
		lblEnemigo = new JLabel("Enemigo");
		lblEnemigo.setBounds(32, 89, 70, 14);
		this.getContentPane().add(lblEnemigo);
		
		lblEnemigo_1 = new JLabel("Enemigo");
		lblEnemigo_1.setBounds(106, 22, 70, 14);
		this.getContentPane().add(lblEnemigo_1);
		
		label = new JLabel("Enemigo");
		label.setBounds(189, 89, 70, 14);
		this.getContentPane().add(label);
		
		label_1 = new JLabel("Enemigo");
		label_1.setBounds(278, 22, 70, 14);
		this.getContentPane().add(label_1);
		
		label_2 = new JLabel("Enemigo");
		label_2.setBounds(406, 89, 70, 14);
		this.getContentPane().add(label_2);
		
		label_3 = new JLabel("Enemigo");
		label_3.setBounds(525, 22, 70, 14);
		this.getContentPane().add(label_3);
		
		label_4 = new JLabel("Enemigo");
		label_4.setBounds(751, 22, 70, 14);
		this.getContentPane().add(label_4);
		
		label_5 = new JLabel("Enemigo");
		label_5.setBounds(639, 86, 95, 20);
		this.getContentPane().add(label_5);
		
		
		
		
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