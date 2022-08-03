package HotelManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;

public class AddCustomer {

  JFrame frame;
  private JTextField numberT;
  private JTextField nameT;
  private JTextField countryT;
  private JTextField depositT;
  Choice croom;
  JLabel dateT;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer window = new AddCustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddCustomer() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(250, 200, 1030, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel id = new JLabel("ID");
		id.setForeground(Color.BLACK);
		id.setBackground(Color.WHITE);
		id.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		id.setBounds(41, 82, 80, 25);
		frame.getContentPane().add(id);
		
		JLabel number = new JLabel("Number");
		number.setForeground(Color.BLACK);
		number.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		number.setBackground(Color.WHITE);
		number.setBounds(41, 130, 170, 25);
		frame.getContentPane().add(number);
		
		numberT = new JTextField();
		numberT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		numberT.setBounds(324, 130, 199, 25);
		frame.getContentPane().add(numberT);
		numberT.setColumns(10);
		
		final JComboBox idT = new JComboBox();
		idT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		idT.setModel(new DefaultComboBoxModel(new String[] {"Choose-One", "Passport", "Aadhar Card", "Driving License", "Voter-id-Card"}));
		idT.setBackground(Color.WHITE);
		idT.setBounds(324, 82, 199, 25);
		frame.getContentPane().add(idT);
		
		final JComboBox genderT = new JComboBox();
		genderT.setModel(new DefaultComboBoxModel(new String[] {"Choose-one", "Male", "Female"}));
		genderT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		genderT.setBackground(Color.WHITE);
		genderT.setBounds(324, 226, 199, 25);
		frame.getContentPane().add(genderT);
		
		JLabel name = new JLabel("Name");
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		name.setBackground(Color.WHITE);
		name.setBounds(41, 178, 170, 25);
		frame.getContentPane().add(name);
		
		nameT = new JTextField();
		nameT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nameT.setColumns(10);
		nameT.setBounds(324, 178, 199, 25);
		frame.getContentPane().add(nameT);
		
		JLabel gender = new JLabel("Gender");
		gender.setForeground(Color.BLACK);
		gender.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		gender.setBackground(Color.WHITE);
		gender.setBounds(41, 226, 80, 25);
		frame.getContentPane().add(gender);
		
		JLabel country = new JLabel("Country");
		country.setForeground(Color.BLACK);
		country.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		country.setBackground(Color.WHITE);
		country.setBounds(41, 274, 170, 25);
		frame.getContentPane().add(country);
		
		countryT = new JTextField();
		countryT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		countryT.setColumns(10);
		countryT.setBounds(327, 274, 199, 25);
		frame.getContentPane().add(countryT);
		
		JLabel RoomNumber = new JLabel("Room Number");
		RoomNumber.setForeground(Color.BLACK);
		RoomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		RoomNumber.setBackground(Color.WHITE);
		RoomNumber.setBounds(41, 322, 262, 25);
		frame.getContentPane().add(RoomNumber);
		
		JLabel checkintime = new JLabel("Check-In-Time");
		checkintime.setForeground(Color.BLACK);
		checkintime.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		checkintime.setBackground(Color.WHITE);
		checkintime.setBounds(41, 370, 170, 25);
		frame.getContentPane().add(checkintime);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setForeground(Color.BLACK);
		deposit.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		deposit.setBackground(Color.WHITE);
		deposit.setBounds(41, 418, 170, 25);
		frame.getContentPane().add(deposit);
		
		depositT = new JTextField();
		depositT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		depositT.setColumns(10);
		depositT.setBounds(324, 418, 199, 25);
		frame.getContentPane().add(depositT);
		
		
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Reception window = new Reception();
				window.frame.setVisible(true);
			}
		});
		back.setFocusPainted(false);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back.setBounds(324, 477, 156, 35);
		frame.getContentPane().add(back);
		
		
	
		croom = new Choice();
		croom.setBounds(327, 322, 199, 29);
		croom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		croom.setBackground(Color.WHITE);
		try {
			Conn c = new Conn();
			
			String query = "select * from rooms where  AvailbleStatus = 'available' ";
			
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				croom.add(rs.getString("RoomNumber"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		frame.getContentPane().add(croom);
		
		  Date date = new Date();

		  dateT = new JLabel(""+date);
		  dateT.setFont(new Font("Tahoma", Font.BOLD, 12));
		  dateT.setBackground(Color.WHITE);
		  dateT.setBounds(327, 370, 199, 25);
		  frame.getContentPane().add(dateT);
		 
		
		
		
		 ImageIcon i1 = new ImageIcon("icon/fifth.png");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(489, 441, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(517,  70, 489 , 441); 
		 
		 JLabel heading = new JLabel("NEW CUSTOMER FORM");
		 heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 heading.setForeground(Color.RED);
		 heading.setBackground(Color.WHITE);
		 heading.setBounds(100, 10, 394, 35);
		 frame.getContentPane().add(heading);
		 
		 
		 JButton addcustomer = new JButton("Add Customer");
			addcustomer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					
					String id  = (String )idT.getSelectedItem();
					String number = numberT.getText();
					String name = nameT.getText();
					String gender = (String )genderT.getSelectedItem();
					String country = countryT.getText();
					String roomNumber = (String )croom.getSelectedItem();
					String checkintimee = dateT.getText();
 					String deposit = depositT.getText();
 					
 					try {
 						Conn cd = new Conn();
 						
 						
 						String query = "insert into customerr values('" +id+ "', '"+number+"',  '"+name+"', '"+gender+"' ,'"+country+"', '"+roomNumber+"' ,'"+ checkintimee+"', '"+deposit+"') ";
 						String query1 = "update rooms set AvailbleStatus = 'occupied' where RoomNumber = '" +roomNumber+"'";
 						cd.s.executeUpdate(query);
 						cd.s.executeUpdate(query1);
 						
 						JOptionPane.showMessageDialog(null , " New Customer  added successfully");
 						frame.setVisible(false);
 						
 					}catch(Exception e) {
 						e.printStackTrace();
 					}
					 


				}
			});
			addcustomer.setFocusPainted(false);
			addcustomer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			addcustomer.setBackground(Color.BLACK);
			addcustomer.setForeground(Color.WHITE);
			addcustomer.setBounds(81, 477, 176, 35);
			frame.getContentPane().add(addcustomer); 
	}
}
