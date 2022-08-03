package HotelManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class login {
	
    
	JFrame frame;
	private JTextField username;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public login() {
		initialize();
	}

	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setAutoRequestFocus(false);
		frame.setBounds(400, 200, 671, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton login = new JButton("LogIn");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String user = username.getText();
				String pass = password.getText();
				try {
					Conn c = new Conn();
					
			 		String query = " select * from login where username = '"+ user+"' and password = '" +pass +"'";
					ResultSet rs = c.s.executeQuery(query);
					if(rs.next()) {
						frame.setVisible(false);
						DashBoard window = new DashBoard();
						window.frame.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null , " invalid Username or Password");
						
					}
					
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);
		login.setFocusPainted(false);
		login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		login.setBounds(59, 240, 115, 37);
		frame.getContentPane().add(login);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setFocusPainted(false);
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cancel.setBounds(202, 240, 115, 37);
		frame.getContentPane().add(cancel);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		username.setBounds(59, 85, 258, 37);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(59, 172, 258, 37);
		frame.getContentPane().add(password);
		
		JLabel user = new JLabel("Username");
		user.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		user.setBounds(59, 51, 131, 24);
		frame.getContentPane().add(user);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		pass.setBounds(59, 138, 131, 24);
		frame.getContentPane().add(pass);
		
		
		 ImageIcon i1 = new ImageIcon("icon/second.jpg");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(370,  35, 250 , 250); 
	}
}
