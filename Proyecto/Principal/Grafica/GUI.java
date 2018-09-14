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
	 
	 private JLabel lblHp , lblPuntaje , lblVidas , numVidas , numPuntaje;
	 private JProgressBar BarraVida;
	 
	 
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
		
		
		//CREA EL FRAME
		crearFrame();
		crearPanelSuperior();
		
		
		//crea al jugador
		this.getContentPane().add(log.getJugador().getLabel());
		
		
		
		//crea a los enemigos
		log.crearEnemigosConArma(10);
		
		
		
		
		OyenteTeclado OT = new OyenteTeclado();
		this.addKeyListener(OT);
	}
	
	private void crearFrame() {
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.getContentPane().setLayout(null);
		this.setBounds(250, 50, mapa.getAncho(), mapa.getAlto());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearPanelSuperior() {
		
		//lbl HP:
		
		lblHp = new JLabel("HP:");
		lblHp.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblHp.setBounds(6, 11, 32, 14);
		getContentPane().add(lblHp);
				
		//crea la barra de vida
		
		BarraVida = new JProgressBar();
		BarraVida.setForeground(Color.GREEN);
		BarraVida.setBackground(Color.WHITE);
		
		BarraVida.setMaximum(10);
		BarraVida.setMinimum(0);
		BarraVida.setValue(10);
		
		BarraVida.setBounds(43, 11, 85, 14);
		getContentPane().add(BarraVida);
		
		//arma el puntaje
		
		lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuntaje.setBounds(264, 6, 65, 20);
		getContentPane().add(lblPuntaje);
		
		numPuntaje = new JLabel("0");
		numPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numPuntaje.setBounds(332, 9, 46, 14);
		getContentPane().add(numPuntaje);
		
		
		//arma las vidas
		
		lblVidas = new JLabel("Vidas:");
		lblVidas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVidas.setBounds(758, 11, 46, 14);
		getContentPane().add(lblVidas);
		
		numVidas = new JLabel("3");
		numVidas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numVidas.setBounds(818, 11, 46, 14);
		getContentPane().add(numVidas);
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
				
			}
			else {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					log.mover(1);
					
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