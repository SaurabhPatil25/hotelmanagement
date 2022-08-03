package HotelManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateStatus {

	 JFrame frame;
	private JTextField RT , CITT , APT , PAT , NT;
	Choice  CIT;
	Conn c;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateStatus window = new updateStatus();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public updateStatus() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(250, 200, 1050, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel updatestatuslabel = new JLabel("Update Status");
		updatestatuslabel.setForeground(Color.RED);
		updatestatuslabel.setBackground(Color.WHITE);
		updatestatuslabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		updatestatuslabel.setBounds(160, 22, 193, 31);
		frame.getContentPane().add(updatestatuslabel);
		
		JLabel customerid = new JLabel("Customer Id");
		customerid.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		customerid.setBounds(44, 100, 183, 30);
		frame.getContentPane().add(customerid);
		
		 CIT = new Choice();
		CIT.setBounds(257, 100, 208, 30);
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
		roomnumber.setBounds(44, 160, 183, 30);
		frame.getContentPane().add(roomnumber);
		
		RT = new JTextField();
		RT.setBounds(257, 160, 208, 30);
		RT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(RT);
		RT.setColumns(10);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		name.setBackground(Color.WHITE);
		name.setBounds(44, 220, 183, 30);
		frame.getContentPane().add(name);
		
		NT = new JTextField();
		NT.setBounds(257, 220, 208, 30);
		NT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(NT);
		NT.setColumns(10);
		
		
		JLabel checkInTime = new JLabel("Checkin Time");
		checkInTime.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		checkInTime.setBackground(Color.WHITE);
		checkInTime.setBounds(44, 280, 183, 30);
		frame.getContentPane().add(checkInTime);
		
		CITT = new JTextField();
		CITT.setBounds(257, 280, 208, 30);
		CITT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(CITT);
		CITT.setColumns(10);
		
		JLabel amountpaid = new JLabel("Amount Paid");
		amountpaid.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		amountpaid.setBackground(Color.WHITE);
		amountpaid.setBounds(44, 340, 183, 30);
		frame.getContentPane().add(amountpaid);
		
		APT = new JTextField();
		APT.setBounds(257, 340, 208, 30);
		APT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(APT);
		APT.setColumns(10);
		
		JLabel pendingamount = new JLabel("Pending Amount");
		pendingamount.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		pendingamount.setBackground(Color.WHITE);
		pendingamount.setBounds(44, 400, 183, 30);
		frame.getContentPane().add(pendingamount);
		
		PAT = new JTextField();
		PAT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		PAT.setBounds(257, 400, 208, 30);
		frame.getContentPane().add(PAT);
		PAT.setColumns(10);
		
		JButton btncheck = new JButton("Check");
		btncheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					c = new Conn();
					String Query = "select * from customerr where number ='"+CIT.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(Query);
					
					while(rs.next()) {
						RT.setText(rs.getString("Room_number"));
						NT.setText(rs.getString("name"));
						CITT.setText(rs.getString("checkintime"));
						APT.setText(rs.getString("deposite"));
						
						}
					String paid = APT.getText();
					String q1 = "select price from rooms where RoomNumber = '"+RT.getText()+"'";
					ResultSet r = c.s.executeQuery(q1);
					while(r.next()) {
						String remaining = r.getString("price");
						int result = Integer.parseInt(remaining) - Integer.parseInt(paid) ;
						PAT.setText(Integer.toString(result));
						
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
		btncheck.setBounds(44, 484, 120, 35);
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
					}else {
						String availablle  = "select AvailbleStatus from rooms where AvailbleStatus ='"+check+"'";
						ResultSet sd = c.s.executeQuery(availablle);
						String s4 ="0";
						while(sd.next()) {
						    s4 = sd.getString("Available"); 
						}
						if(s4.charAt(0) != 'A') {
							JOptionPane.showMessageDialog(null , " Room is not Available");
							return; 
						}
					}
					
					
					
					
					String query = "update customerr set Room_number='"+ RT.getText()+"', name = '"+NT.getText()+"', checkintime = '"+CITT.getText()+"', deposite = '"+APT.getText()+"' where number ='"+CIT.getSelectedItem()+"'";  
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
		btnUpdate.setBounds(219, 484, 120, 35);
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
		btnBack.setBounds(388, 484, 120, 35);
		frame.getContentPane().add(btnBack);
		

		 ImageIcon i1 = new ImageIcon("icon/nine.jpg");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(503, 351, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(509,  74, 503 , 351); 
		
		
		
	}
}
