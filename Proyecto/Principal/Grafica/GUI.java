package Grafica;
import Mapas.*;
import Personajes.Jugador;

import java.awt.*;

import javax.net.ssl.ManagerFactoryParameters;
import javax.swing.*;
import java.awt.event.*;
import java.util.Map;

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
		
		
		//SE CREAN LOS COMPONENTES INICIALES
		log.crearObjetosIniciales();
		
		//empieza el juego
		log.empezarJuego();
		
		
		OyenteTeclado OT = new OyenteTeclado();
		this.addKeyListener(OT);
		
		
	}
	
	public void repintar() {
		numPuntaje.setText(""+log.getPuntaje());
		BarraVida.setValue(log.getHPJugador());
		numVidas.setText(""+log.getVidasJugador());
		repaint();
	}
	
	private void crearFrame() {
		this.setResizable(false);
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().setLayout(null);
		this.setBounds(250, 50, Mapa.MAX_X, Mapa.MAX_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearPanelSuperior() {
		
		//lbl HP:
			
		lblHp = new JLabel("HP:");
		lblHp.setForeground(Color.WHITE);
		lblHp.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblHp.setBounds(6, 11, 32, 14);
		getContentPane().add(lblHp);
				
		//crea la barra de vida
		
		BarraVida = new JProgressBar();
		BarraVida.setForeground(Color.GREEN);
		BarraVida.setBackground(Color.WHITE);
		
		BarraVida.setMaximum(Jugador.maxHP);
		BarraVida.setMinimum(0);
		BarraVida.setValue(Jugador.maxHP);
		
		BarraVida.setBounds(38, 10, 85, 14);
		getContentPane().add(BarraVida);
		
		//arma el puntaje
		
		lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuntaje.setBounds(350, 6, 65, 20);
		getContentPane().add(lblPuntaje);
		
		numPuntaje = new JLabel("0");
		numPuntaje.setForeground(Color.WHITE);
		numPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numPuntaje.setBounds(415, 9, 46, 14);
		getContentPane().add(numPuntaje);
		
		
		//arma las vidas
		
		lblVidas = new JLabel("Vidas:");
		lblVidas.setForeground(Color.WHITE);
		lblVidas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVidas.setBounds(820, 9, 46, 14);
		getContentPane().add(lblVidas);
		
		numVidas = new JLabel(""+Jugador.VidasIniciales);
		numVidas.setForeground(Color.WHITE);
		numVidas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numVidas.setBounds(865, 9, 46, 14);
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
				log.moverJugador(1);
				
			}
			else {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					log.moverJugador(2);
					
				}
				else {
					if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
						log.lanzarDisparoJugador();
					}
					else
						if(e.getKeyCode() == KeyEvent.VK_0) {
							//hacer algo para probar
						}
					
				}
				
			}
		}
		
		public void keyReleased(KeyEvent e) {
			
		}
		
		
		

	}
	
	
	
}