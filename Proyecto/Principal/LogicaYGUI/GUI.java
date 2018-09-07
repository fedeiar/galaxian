package LogicaYGUI;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.SwingConstants.*;

 public class GUI extends JFrame {
 	
 	//ATRIBUTOS
	 private final static int  MAX_X=900; //ancho del frame
	 private final static int MAX_Y=600;  //alto del frame
	 
	 private JLabel Player,lblEnemigo,lblEnemigo_1,label,label_1,label_2,label_3,label_4,label_5,label_disparo;
	 
	 private Logica log;
	 
	 
	//CONSTRUCTOR
	 
	public GUI() {
		super("Galaxian");
		initialize();
	}
 	
	private void initialize() {
		
		log = new Logica();
		
		//ATRIBUTOS DEL FRAME
		
		this.setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.getContentPane().setLayout(null);
		this.setBounds(250, 50, MAX_X, MAX_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//LABELS
		
		int anch = log.getJugador().getDimension().getAncho();
		int alt = log.getJugador().getDimension().getAlto();
		int posinicial_X = log.getJugador().getPosicion().getx();
		int posinicial_Y = log.getJugador().getPosicion().gety();
		Player = new JLabel("Player");
		Player.setIcon(null);
		Player.setForeground(Color.RED); //cambiar la letra
		Player.setOpaque(true);  //necesario para cambiarle el color al label
		Player.setBackground(Color.BLUE); //cambiar el color del label
		Player.setBounds(posinicial_X, posinicial_Y, anch, alt);
		this.getContentPane().add(Player);
		
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
		
		label_disparo = new JLabel();
		label_disparo.setOpaque(true);
		label_disparo.setBackground(Color.YELLOW);
		label_disparo.setBounds(0,0,5,20);
		this.getContentPane().add(label_disparo);
		
		
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
				Rectangle r = Player.getBounds();
				int newX = r.x-=10;
				Rectangle newR = new Rectangle(newX,r.y,r.width,r.height);
				Player.setBounds(newR);
				
				if (Player.getX() < 0){
					Player.setBounds(MAX_X - log.getJugador().getDimension().getAncho(), r.y, r.width, r.height);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				Rectangle r = Player.getBounds();
				int newX= r.x+=10;
				Rectangle newR = new Rectangle(newX,r.y,r.width,r.height);
				Player.setBounds(newR);
				if (Player.getX() + log.getJugador().getDimension().getAncho() > MAX_X  ){
					Player.setBounds(0,r.y,r.width,r.height);
				}
				
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				int Pos_X = Player.getX() + Player.getWidth()/2;
				int Pos_Y = Player.getY() - Player.getHeight();
				label_disparo.setBounds(Pos_X , Pos_Y , label_disparo.getWidth(), label_disparo.getHeight());
				while(label_disparo.getY() > 0) {
					label_disparo.setBounds(label_disparo.getX(), -5, label_disparo.getWidth(), label_disparo.getHeight());
				}
			}
			
		}

		public void keyReleased(KeyEvent e) {
			
		}
	}
	
	
	
}