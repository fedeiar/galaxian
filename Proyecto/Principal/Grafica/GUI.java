package Grafica;
import Mapas.*;

import java.awt.*;

import javax.net.ssl.ManagerFactoryParameters;
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
	
	 
	//CONSTRUCTOR
	 
	public GUI() {
		super("Galaxian");
		initialize();
	}
 	
	private void initialize() {
		
		//CREA EL FRAME
		crearFrame();
		crearPanelSuperior();
		
		//SE CREA LA PARTE LOGICA
		log = new Logica(this);
		
		
		//SE CREAN LOS COMPONENTES
		log.crearObjetos();
		
		//empieza el juego
		log.empezarJuego();
		
		
		OyenteTeclado OT = new OyenteTeclado();
		this.addKeyListener(OT);
		
		
	}
	
	private void crearFrame() {
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.getContentPane().setLayout(null);
		this.setBounds(250, 50, Mapa.MAX_X, Mapa.MAX_Y);
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
				mover(0);
				
			}
			else {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					mover(1);
					
				}
				else {
					//aqui planear el disparo
					}
				}
				
			}
		
		public void keyReleased(KeyEvent e) {
			
		}
		
		private void mover(int n) {
			log.moverJugador(n);
			repaint();
		}
		

	}
	
	
	
}