package HotelManagement;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class DashBoard {

	JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DashBoard() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1925, 830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon i1 = new ImageIcon("icon/third.jpg");   // importing image 
        frame.getContentPane().setLayout(null);
        JLabel image = new JLabel(i1);                  
        image.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().add(image);
		image.setBounds(0,  0, 1540 , 793);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 1540, 44);
		image.add(menuBar);
		
		JMenu hotelMan = new JMenu("Hotel Management");
		hotelMan.setFont(new Font("Times New Roman", Font.BOLD, 22));
		hotelMan.setBackground(Color.WHITE);
		hotelMan.setForeground(Color.RED);
		menuBar.add(hotelMan);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reception window = new Reception();
				window.frame.setVisible(true);
			}
		});
		reception.setBackground(Color.WHITE);
		reception.setForeground(Color.BLACK);
		reception.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		hotelMan.add(reception);
		
		JMenu admin = new JMenu("Admin");
		admin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		admin.setForeground(Color.RED);
		menuBar.add(admin);
		
		
		
		JMenuItem employes = new JMenuItem("ADD EMPOLYEE");
		employes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee window = new AddEmployee();
				window.frame.setVisible(true);
			}
		});
		employes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		employes.setBackground(Color.WHITE);
		admin.add(employes);
		
		JMenuItem room = new JMenuItem("ADD ROOMS");
		room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addrooms window = new Addrooms();
				window.frame.setVisible(true);
			}
		});
		room.setBackground(Color.WHITE);
		room.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		admin.add(room);
		
		JMenuItem driver = new JMenuItem("ADD DRIVER");
		driver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDriver window = new AddDriver();
				window.frame.setVisible(true);
			}
		});
		driver.setBackground(Color.WHITE);
		driver.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		admin.add(driver);
		
		JLabel lblNewLabel = new JLabel("HOTEL METROPOLE WELCOMES YOU");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblNewLabel.setBounds(200, 60, 1300, 107);
		image.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HotelMS window = new HotelMS();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(1333, 698, 105, 36);
		frame.getContentPane().add(btnNewButton);
		
	}
}
