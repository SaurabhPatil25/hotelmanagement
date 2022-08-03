package HotelManagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updateRoomStatus {

	 JFrame frame;
	private JTextField RT, AT , CST ;
	Choice  CIT;
	Conn c ;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateRoomStatus window = new updateRoomStatus();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public updateRoomStatus() {
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
		
		 CIT = new Choice();
		CIT.setBounds(257, 100, 208, 35);
		CIT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(CIT);
		
		try {
			 c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customerr");
			
			while(rs.next()) {
				CIT.add(rs.getString("number"));
			}
			
		}catch(Exception e) {
			
		}
		
		
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
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAvailability.setBackground(Color.WHITE);
		lblAvailability.setBounds(44, 260, 183, 35);
		frame.getContentPane().add(lblAvailability);
		
		AT = new JTextField();
		AT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		AT.setColumns(10);
		AT.setBounds(257, 260, 208, 35);
		frame.getContentPane().add(AT);
		
		JLabel lblCleaningStatus = new JLabel("Cleaning Status");
		lblCleaningStatus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblCleaningStatus.setBackground(Color.WHITE);
		lblCleaningStatus.setBounds(44, 340, 183, 35);
		frame.getContentPane().add(lblCleaningStatus);
		
		CST = new JTextField();
		CST.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		CST.setColumns(10);
		CST.setBounds(257, 340, 208, 35);
		frame.getContentPane().add(CST);
		
		
		JButton btncheck = new JButton("Check");
		btncheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					c = new Conn();
					String Query = "select * from customerr where number ='"+CIT.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(Query);
					while(rs.next()) {
						RT.setText(rs.getString("Room_number"));
					}
					
					String Query1 = "select * from rooms where RoomNumber ='"+RT.getText()+"'";
					ResultSet r = c.s.executeQuery(Query1);
					while(r.next()) {
						AT.setText(r.getString("AvailbleStatus"));
						CST.setText(r.getString("CleaningStatus"));
					}
					
				}catch(Exception ae) {
					ae.printStackTrace();
				}
				
				
			}
		});
		btncheck.setFocusPainted(false);
		btncheck.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btncheck.setForeground(Color.WHITE);
		btncheck.setBackground(Color.BLACK);
		btncheck.setBounds(44, 441, 120, 35);
		frame.getContentPane().add(btncheck);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					c = new Conn();
					 
					String check = RT.getText();
					String checkQuery = "select RoomNumber from rooms where RoomNumber ='"+check+"'";
					ResultSet s = c.s.executeQuery(checkQuery);
					String s2 ="0";
					while(s.next()) {
						s2 = s.getString("roomNumber");
					}
					
					if(Integer.parseInt(check) !=  Integer.parseInt(s2)) {
						JOptionPane.showMessageDialog(null , " Room is not exist");
						return; 
					}
					
					String query = "update rooms set RoomNumber='"+ RT.getText()+"', AvailbleStatus ='"+ AT.getText()+"', CleaningStatus ='"+ CST.getText()+"' where RoomNumber ='"+ RT.getText()+"'";  
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null , " Data Updated successfully");
					frame.setVisible(false); 
					Reception window = new Reception();
					window.frame.setVisible(true);
				}catch(Exception ae){
					ae.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFocusPainted(false);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(207, 441, 120, 35);
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
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(377, 441, 120, 35);
		frame.getContentPane().add(btnBack);
		

		 ImageIcon i1 = new ImageIcon("icon/seventh.jpg");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(503, 351, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(509,  74, 503 , 332); 
		
	}
}
