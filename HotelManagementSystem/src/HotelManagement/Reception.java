package HotelManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reception {

	 JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reception window = new Reception();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Reception() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 180, 1002, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton NewCustomerForm = new JButton("New Customer Form");
		NewCustomerForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer window = new AddCustomer();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		NewCustomerForm.setFocusPainted(false);
		NewCustomerForm.setForeground(Color.WHITE);
		NewCustomerForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		NewCustomerForm.setBackground(Color.BLACK);
		NewCustomerForm.setBounds(20, 25, 190, 30);
		frame.getContentPane().add(NewCustomerForm);
		
		JButton Rooms = new JButton("Rooms");
		Rooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room window = new Room();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		Rooms.setFocusPainted(false);
		Rooms.setForeground(Color.WHITE);
		Rooms.setBackground(Color.BLACK);
		Rooms.setFont(new Font("Tahoma", Font.BOLD, 12));
		Rooms.setBounds(20, 70, 190, 30);
		frame.getContentPane().add(Rooms);
		
		JButton Department = new JButton("Department");
		Department.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				department window = new department();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		Department.setFocusPainted(false);
		Department.setFont(new Font("Tahoma", Font.BOLD, 12));
		Department.setBackground(Color.BLACK);
		Department.setForeground(Color.WHITE);
		Department.setBounds(20, 115, 190, 30);
		frame.getContentPane().add(Department);
		
		JButton AllEmployee = new JButton("All Employee");
		AllEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllEmployee window = new AllEmployee();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		AllEmployee.setFocusPainted(false);
		AllEmployee.setForeground(Color.WHITE);
		AllEmployee.setBackground(Color.BLACK);
		AllEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
		AllEmployee.setBounds(20, 160, 190, 30);
		frame.getContentPane().add(AllEmployee);
		
		JButton CustomerInfo = new JButton("Customer Info");
		CustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerinfo window = new customerinfo();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		CustomerInfo.setFocusPainted(false);
		CustomerInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		CustomerInfo.setBackground(Color.BLACK);
		CustomerInfo.setForeground(Color.WHITE);
		CustomerInfo.setBounds(20, 205, 190, 30);
		frame.getContentPane().add(CustomerInfo);
		
		JButton ManagerInfo = new JButton("Manager Info");
		ManagerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerinfo window = new managerinfo();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		ManagerInfo.setFocusPainted(false);
		ManagerInfo.setBackground(Color.BLACK);
		ManagerInfo.setForeground(Color.WHITE);
		ManagerInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		ManagerInfo.setBounds(20, 250, 190, 30);
		frame.getContentPane().add(ManagerInfo);
		
		JButton CheckOut = new JButton("Check Out");
		CheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut window = new CheckOut();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		CheckOut.setFocusPainted(false);
		CheckOut.setForeground(Color.WHITE);
		CheckOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		CheckOut.setBackground(Color.BLACK);
		CheckOut.setBounds(20, 295, 190, 30);
		frame.getContentPane().add(CheckOut);
		
		JButton UpdateStatus = new JButton("Update Status");
		UpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStatus window = new updateStatus();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		UpdateStatus.setFocusPainted(false);
		UpdateStatus.setBackground(Color.BLACK);
		UpdateStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		UpdateStatus.setForeground(Color.WHITE);
		UpdateStatus.setBounds(20, 340, 190, 30);
		frame.getContentPane().add(UpdateStatus);
		
		JButton UpdateRoomStatus = new JButton("Update Room Status");
		UpdateRoomStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateRoomStatus window = new updateRoomStatus();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		UpdateRoomStatus.setFocusPainted(false);
		UpdateRoomStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		UpdateRoomStatus.setForeground(Color.WHITE);
		UpdateRoomStatus.setBackground(Color.BLACK);
		UpdateRoomStatus.setBounds(20, 385, 190, 30);
		frame.getContentPane().add(UpdateRoomStatus);
		
		JButton PickUpService = new JButton("Pick Up Service");
		PickUpService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pickupservice window = new pickupservice();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		PickUpService.setFocusPainted(false);
		PickUpService.setBackground(Color.BLACK);
		PickUpService.setForeground(Color.WHITE);
		PickUpService.setFont(new Font("Tahoma", Font.BOLD, 12));
		PickUpService.setBounds(20, 430, 190, 30);
		frame.getContentPane().add(PickUpService);
		
		JButton SearchRoom = new JButton("Search Room");
		SearchRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchRoom window = new SearchRoom();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		SearchRoom.setFocusPainted(false);
		SearchRoom.setFont(new Font("Tahoma", Font.BOLD, 12));
		SearchRoom.setForeground(Color.WHITE);
		SearchRoom.setBackground(Color.BLACK);
		SearchRoom.setBounds(20, 475, 190, 30);
		frame.getContentPane().add(SearchRoom);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.setVisible(false);
				
			
				
			}
		});
		 back.setFocusPainted(false);
		 back.setBackground(Color.BLACK);
		 back.setForeground(Color.WHITE);
		 back.setFont(new Font("Tahoma", Font.BOLD, 12));
		 back.setBounds(20, 520, 190, 30);
		frame.getContentPane().add( back);
		

		 ImageIcon i1 = new ImageIcon("icon/fourth.jpg");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(709, 525, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(247,  25, 709 , 525); 
	}

}
