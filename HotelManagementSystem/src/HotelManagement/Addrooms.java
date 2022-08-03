package HotelManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Addrooms {

	 JFrame frame;
	 private JLabel RN;
	 private JTextField RNT;
	 private JLabel AV;
	 private JComboBox AVT;
	 private JLabel CS;
	 private JComboBox CST;
	 private JLabel PR;
	 private JTextField PRT;
	 private JLabel BT;
	 private JComboBox BTT;
	 private JButton ABUTTON;
	 private JButton CBUTTON;
	 private JLabel lblNewLabel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addrooms window = new Addrooms();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Addrooms() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(250, 200, 980, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		RN = new JLabel("Room Number");
		RN.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		RN.setBounds(47, 93, 173, 36);
		frame.getContentPane().add(RN);
		
		RNT = new JTextField();
		RNT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		RNT.setColumns(10);
		RNT.setBounds(241, 93, 182, 36);
		frame.getContentPane().add(RNT);
		
		AV = new JLabel("Available");
		AV.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		AV.setBounds(47, 153, 173, 36);
		frame.getContentPane().add(AV);
		
		AVT = new JComboBox();
		AVT.setModel(new DefaultComboBoxModel(new String[] {"Available", "Occupied"}));
		AVT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		AVT.setBackground(Color.WHITE);
		AVT.setBounds(241, 153, 182, 36);
		frame.getContentPane().add(AVT);
		
		CS = new JLabel("Cleaning Status");
		CS.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		CS.setBounds(47, 213, 173, 36);
		frame.getContentPane().add(CS);
		
		CST = new JComboBox();
		CST.setModel(new DefaultComboBoxModel(new String[] {"Cleaned", "Dirty"}));
		CST.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		CST.setBackground(Color.WHITE);
		CST.setBounds(241, 213, 182, 36);
		frame.getContentPane().add(CST);
		
		PR = new JLabel("Price");
		PR.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		PR.setBounds(47, 273, 161, 36);
		frame.getContentPane().add(PR);
		
		PRT = new JTextField();
		PRT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		PRT.setColumns(10);
		PRT.setBounds(241, 273, 182, 36);
		frame.getContentPane().add(PRT);
		
		BT = new JLabel("Bed Type");
		BT.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		BT.setBounds(47, 333, 161, 36);
		frame.getContentPane().add(BT);
		
		BTT = new JComboBox();
		BTT.setModel(new DefaultComboBoxModel(new String[] {"Single Bed", "Double Bed"}));
		BTT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		BTT.setBackground(Color.WHITE);
		BTT.setBounds(241, 333, 182, 36);
		frame.getContentPane().add(BTT);
		
		ABUTTON = new JButton("Add Room");
		ABUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String RoomNumber = RNT.getText();
				String available = (String) AVT.getSelectedItem();
				String CleaningStatus =  (String) CST.getSelectedItem();
				String price = PRT.getText();
				String BedType = (String)BTT.getSelectedItem();
				
				
				try {
					Conn cn = new Conn();
					
					String query = "insert into rooms values('"+RoomNumber+"', '"+available+"' , '"+ CleaningStatus+"', '"+ price+"' , '"+BedType+"')";
							
					cn.s.executeUpdate(query); 
					
					JOptionPane.showMessageDialog(null , " Room added successfully");
					frame.setVisible(false);
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		ABUTTON.setForeground(Color.WHITE);
		ABUTTON.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		ABUTTON.setFocusPainted(false);
		ABUTTON.setBackground(Color.BLACK);
		ABUTTON.setBounds(79, 424, 161, 42);
		frame.getContentPane().add(ABUTTON);
		
		CBUTTON = new JButton("Cancel");
		CBUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		CBUTTON.setForeground(Color.WHITE);
		CBUTTON.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		CBUTTON.setFocusPainted(false);
		CBUTTON.setBackground(Color.BLACK);
		CBUTTON.setBounds(292, 424, 131, 42);
		frame.getContentPane().add(CBUTTON);
		
		lblNewLabel = new JLabel("ADD ROOMS");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(390, 10, 245, 60);
		frame.getContentPane().add(lblNewLabel);
		
		

		 ImageIcon i1 = new ImageIcon("icon/twelve.jpg");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(503, 351, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(453,  91, 503 , 351); 
		
		
	}
}
