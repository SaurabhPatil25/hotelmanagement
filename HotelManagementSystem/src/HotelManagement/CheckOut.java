package HotelManagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOut {

	JFrame frame;
	JTextField RT, COT, CIT;
    Choice CI;
    Conn c;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut window = new CheckOut();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CheckOut() {
		initialize();
	}

	private void initialize() {

			frame = new JFrame();
			frame.getContentPane().setBackground(Color.WHITE);
			frame.setBounds(250, 200, 1050, 604);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel updatestatuslabel = new JLabel("Update Room Status");
			updatestatuslabel.setForeground(Color.RED);
			updatestatuslabel.setBackground(Color.WHITE);
			updatestatuslabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			updatestatuslabel.setBounds(146, 22, 279, 30);
			frame.getContentPane().add(updatestatuslabel);
			
			JLabel customerid = new JLabel("Customer Id");
			customerid.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			customerid.setBounds(44, 100, 183, 35);
			frame.getContentPane().add(customerid);
			
			
			JLabel roomnumber = new JLabel("Room Number");
			roomnumber.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			roomnumber.setBackground(Color.WHITE);
			roomnumber.setBounds(44, 180, 183, 35);
			frame.getContentPane().add(roomnumber);
			
			RT = new JTextField();
			RT.setBounds(257, 180, 208, 35);
			RT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.getContentPane().add(RT);
			RT.setColumns(10);
			
			JLabel lblAvailability = new JLabel("Check-In-Time");
			lblAvailability.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			lblAvailability.setBackground(Color.WHITE);
			lblAvailability.setBounds(44, 260, 183, 35);
			frame.getContentPane().add(lblAvailability);
			
			CIT = new JTextField();
			CIT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			CIT.setColumns(10);
			CIT.setBounds(257, 260, 208, 35);
			frame.getContentPane().add(CIT);
			
			JLabel lblCleaningStatus = new JLabel("Check-OutTime");
			lblCleaningStatus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			lblCleaningStatus.setBackground(Color.WHITE);
			lblCleaningStatus.setBounds(44, 340, 183, 35);
			frame.getContentPane().add(lblCleaningStatus);
			
			
			   Date date = new Date();

			  JLabel dateT = new JLabel(""+date);
			  dateT.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  dateT.setBackground(Color.WHITE);
			  dateT.setBounds(257, 340, 208, 35);
			  frame.getContentPane().add(dateT);

			
			    CI = new Choice();
				CI.setBounds(257, 100, 208, 35);
				CI.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				frame.getContentPane().add(CI);
				
				try {
					 c = new Conn();
					ResultSet rs = c.s.executeQuery("select * from customerr");
					
					while(rs.next()) {
						CI.add(rs.getString("number"));
//						RT.setText(rs.getString("Room_number"));
//						CIT.setText(rs.getString("checkintime"));
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				JButton search = new JButton("Search");
				search.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					    c = new Conn();
					    String Query ="select * from customerr where number = '"+CI.getSelectedItem()+"'";
					    try {
							 
							ResultSet rs = c.s.executeQuery(Query);
							
							while(rs.next()) {
								
								RT.setText(rs.getString("Room_number"));
								CIT.setText(rs.getString("checkintime"));
							}
							
						}catch(Exception ae) {
							ae.printStackTrace();
						}
					    
					}
				});
				search.setFocusPainted(false);
				search.setForeground(Color.WHITE);
				search.setBackground(Color.BLACK);
				search.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				search.setBounds(39, 439, 121, 30);
				frame.getContentPane().add(search);
				
				JButton btnUpdate = new JButton("Check Out");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Query1 ="delete from customerr where number = '"+CI.getSelectedItem() +"'"; 
					    String Query2 ="update rooms set AvailbleStatus = 'Available' where RoomNumber ='"+RT.getText()+"' ";
						c = new Conn();
						
					    try {
							c.s.executeUpdate(Query1);
							c.s.executeUpdate(Query2);
							JOptionPane.showMessageDialog(null , " Check Out Done");
							frame.setVisible(false);
							Reception window = new Reception();
							window.frame.setVisible(true);
							
						}catch(Exception ae) {
							ae.printStackTrace();
						}
					}
				});
				btnUpdate.setFocusPainted(false);
				btnUpdate.setForeground(Color.WHITE);
				btnUpdate.setBackground(Color.BLACK);
				btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				btnUpdate.setBounds(192, 439, 127, 30);
				frame.getContentPane().add(btnUpdate);
				
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						Reception window = new Reception();
						window.frame.setVisible(true);
					}
				});
				btnBack.setFocusPainted(false);
				btnBack.setForeground(Color.WHITE);
				btnBack.setBackground(Color.BLACK);
				btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				btnBack.setBounds(349, 439, 121, 30);
				frame.getContentPane().add(btnBack);
				
				 ImageIcon i1 = new ImageIcon("icon/sixth.jpg");   // importing image 
				 Image i2 = i1.getImage().getScaledInstance(503, 332, Image.SCALE_DEFAULT);
				 ImageIcon i3 = new ImageIcon(i2);
				 JLabel image = new JLabel(i3);                  
				 frame.getContentPane().add(image);
				 image.setBounds(505,  100, 503 , 332); 

		
			
	}
}
