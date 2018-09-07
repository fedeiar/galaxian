package LogicaYGUI;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.SwingConstants.*;

 public class GUI extends JFrame {
 	
 	//ATRIBUTOS
	 
	 JLabel Player,lblEnemigo,lblEnemigo_1,label,label_1,label_2,label_3,label_4,label_5;
	 
	 Logica log;
	 
	 
	//CONSTRUCTOR
	 
	public GUI() {
		super("Galaxian");
		initialize();
	}
 	
	private void initialize() {
		
		//ATRIBUTOS DEL FRAME
		
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setLayout(null);
		this.setBounds(250, 50, 900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//LABELS
		
		Player = new JLabel("Player");
		Player.setForeground(Color.BLACK);
		Player.setBackground(Color.WHITE);
		Player.setBounds(194, 236, 44, 14);
		this.getContentPane().add(Player);
		
		lblEnemigo = new JLabel("Enemigo");
		lblEnemigo.setBounds(68, 22, 70, 14);
		this.getContentPane().add(lblEnemigo);
		
		lblEnemigo_1 = new JLabel("Enemigo");
		lblEnemigo_1.setBounds(68, 47, 70, 14);
		this.getContentPane().add(lblEnemigo_1);
		
		label = new JLabel("Enemigo");
		label.setBounds(148, 22, 70, 14);
		this.getContentPane().add(label);
		
		label_1 = new JLabel("Enemigo");
		label_1.setBounds(148, 47, 70, 14);
		this.getContentPane().add(label_1);
		
		label_2 = new JLabel("Enemigo");
		label_2.setBounds(228, 22, 70, 14);
		this.getContentPane().add(label_2);
		
		label_3 = new JLabel("Enemigo");
		label_3.setBounds(228, 47, 70, 14);
		this.getContentPane().add(label_3);
		
		label_4 = new JLabel("Enemigo");
		label_4.setBounds(308, 22, 70, 14);
		this.getContentPane().add(label_4);
		
		label_5 = new JLabel("Enemigo");
		label_5.setBounds(308, 47, 70, 14);
		this.getContentPane().add(label_5);
		
		
		OyenteTeclado OT = new OyenteTeclado();
		this.addKeyListener(OT);
	}
	
	//------------------------------------
	//-------------OYENTES----------------
	//------------------------------------
	
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
					Player.setBounds(390,r.y,r.width,r.height);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				Rectangle r = Player.getBounds();
				int newX= r.x+=10;
				Rectangle newR = new Rectangle(newX,r.y,r.width,r.height);
				Player.setBounds(newR);
				if (Player.getX() > 390){
					Player.setBounds(0,r.y,r.width,r.height);
				}
			}
			
		}

		public void keyReleased(KeyEvent e) {
			
		}
	}
}