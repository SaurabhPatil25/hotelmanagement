package HotelManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class AddDriver {

	 JFrame frame;
	private JTextField NT;
	private JTextField AT;
	private JTextField CCT;
	private JTextField CMT;
	private JTextField LOT;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDriver window = new AddDriver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddDriver() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(270, 200, 981, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel N = new JLabel("Name");
		N.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		N.setBounds(46, 90, 81, 30);
		frame.getContentPane().add(N);
		
		NT = new JTextField();
		NT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		NT.setBounds(226, 90, 190, 30);
		frame.getContentPane().add(NT);
		NT.setColumns(10);
		
		JLabel A = new JLabel("Age");
		A.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		A.setBounds(46, 140, 81, 30);
		frame.getContentPane().add(A);
		
		AT = new JTextField();
		AT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		AT.setColumns(10);
		AT.setBounds(226, 140, 190, 30);
		frame.getContentPane().add(AT);
		
		JLabel G = new JLabel("Gender");
		G.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		G.setBounds(46, 190, 81, 30);
		frame.getContentPane().add(G);
		
		JLabel CC = new JLabel("Car Company");
		CC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		CC.setBounds(46, 240, 143, 30);
		frame.getContentPane().add(CC);
		
		CCT = new JTextField();
		CCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		CCT.setColumns(10);
		CCT.setBounds(226, 240, 190, 30);
		frame.getContentPane().add(CCT);
		
		JLabel CM = new JLabel("Car Model");
		CM.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		CM.setBounds(46, 290, 122, 30);
		frame.getContentPane().add(CM);
		
		CMT = new JTextField();
		CMT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		CMT.setColumns(10);
		CMT.setBounds(226, 290, 190, 30);
		frame.getContentPane().add(CMT);
		
		JLabel AV = new JLabel("Available");
		AV.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		AV.setBounds(46, 340, 122, 30);
		frame.getContentPane().add(AV);
		
		JLabel LO = new JLabel("Location");
		LO.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		LO.setBounds(46, 390, 122, 30);
		frame.getContentPane().add(LO);
		
		LOT = new JTextField();
		LOT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LOT.setColumns(10);
		LOT.setBounds(226, 390, 190, 30);
		frame.getContentPane().add(LOT);
		
	
		
		final JComboBox GT = new JComboBox();
		GT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GT.setModel(new DefaultComboBoxModel(new String[] {"Choose One", "Male", "Female"}));
		GT.setBackground(Color.WHITE);
		GT.setBounds(226, 190, 190, 30);
		frame.getContentPane().add(GT);
		
		final JComboBox AVT = new JComboBox();
		AVT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		AVT.setModel(new DefaultComboBoxModel(new String[] {"Choose One", "Available", "Not Available"}));
		AVT.setBackground(Color.WHITE);
		AVT.setBounds(226, 340, 190, 30);
		frame.getContentPane().add(AVT);
		
		JLabel ADDDRIVER = new JLabel("Add Drivers");
		ADDDRIVER.setFont(new Font("Times New Roman", Font.BOLD, 30));
		ADDDRIVER.setBounds(419, 10, 175, 45);
		frame.getContentPane().add(ADDDRIVER);
		
		JButton AD = new JButton("Add Driver");
		AD.setFocusPainted(false);
		AD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String name = NT.getText();
				String age = AT.getText();
				String gender = (String) GT.getSelectedItem();
				String carCompany = CCT.getText();
				String carModel = CMT.getText();
				String available = (String) AVT.getSelectedItem();
				String location = LOT.getText();
				
				try {
					Conn cn = new Conn();
					
					String qu = "insert  into driver values('"+name+"', '"+age+"' , '"+ gender+"', '"+ carCompany+"' , '"+carModel+"' , '"+available+"' , '"+location+"')" ;
					
					cn.s.executeUpdate(qu);
					JOptionPane.showMessageDialog(null , " Driver added successfully");
					frame.setVisible(false);
					
				} catch(Exception e){
					e.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		AD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		AD.setBackground(Color.BLACK);
		AD.setForeground(Color.WHITE);
		AD.setBounds(60, 450, 155, 35);
		frame.getContentPane().add(AD);
		
		JButton CN = new JButton("Cancel");
		CN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		CN.setFocusPainted(false);
		CN.setBackground(Color.BLACK);
		CN.setForeground(Color.WHITE);
		CN.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		CN.setBounds(261, 450, 155, 35);
		frame.getContentPane().add(CN);
		

		 ImageIcon i1 = new ImageIcon("icon/eleven.jpg");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(503, 351, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(453,  91, 503 , 351); 
	}
}
