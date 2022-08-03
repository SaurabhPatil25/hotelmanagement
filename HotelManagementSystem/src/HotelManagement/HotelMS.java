package HotelManagement;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotelMS {

	 JFrame frame;
	private JLabel text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelMS window = new HotelMS();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public HotelMS() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1366, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// background image
		 
		 ImageIcon i1 = new ImageIcon("icon/first.jpg");   // importing image 
		 frame.getContentPane().setLayout(null);
		 JLabel image = new JLabel(i1);                  
		 frame.getContentPane().add(image);
		 image.setBounds(0,  0, 1352 , 528);     // location x, location y , width , height
		 
		 // hotel tag 
		 
		 text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		 image.add(text);
		 text.setForeground(Color.white);
		 text.setBackground(Color.white);
		 text.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 40));
		 text.setBounds(33, 419, 679, 99);
		 
		 JButton next = new JButton("LogIn");
		 image.add(next);
		 next.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		login window = new login();
				window.frame.setVisible(true);
			}
		 });
		 next.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
		 next.setBackground(Color.WHITE);
		 next.setFocusPainted(false);
		 next.setRolloverEnabled(false);
		 next.setBounds(1199, 451, 117, 44);
		 
		
		 
		
	}
}
