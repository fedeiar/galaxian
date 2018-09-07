import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel Player = new JLabel("Player");
		Player.setForeground(Color.BLACK);
		Player.setBackground(Color.WHITE);
		Player.setBounds(194, 236, 44, 14);
		frame.getContentPane().add(Player);
		
		JLabel lblEnemigo = new JLabel("Enemigo");
		lblEnemigo.setBounds(68, 22, 70, 14);
		frame.getContentPane().add(lblEnemigo);
		
		JLabel lblEnemigo_1 = new JLabel("Enemigo");
		lblEnemigo_1.setBounds(68, 47, 70, 14);
		frame.getContentPane().add(lblEnemigo_1);
		
		JLabel label = new JLabel("Enemigo");
		label.setBounds(148, 22, 70, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Enemigo");
		label_1.setBounds(148, 47, 70, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Enemigo");
		label_2.setBounds(228, 22, 70, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Enemigo");
		label_3.setBounds(228, 47, 70, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Enemigo");
		label_4.setBounds(308, 22, 70, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Enemigo");
		label_5.setBounds(308, 47, 70, 14);
		frame.getContentPane().add(label_5);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e){
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

			@Override
			public void keyReleased(KeyEvent e){
				
			}

			@Override
			public void keyTyped(KeyEvent e){
				
			}	
		});
	}
}
