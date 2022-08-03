package HotelManagement;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import net.proteanit.sql.*;
import java.sql.*;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Room {

	 JFrame frame;
	 JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room window = new Room();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Room() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(250, 200, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		 ImageIcon i1 = new ImageIcon("icon/eight.jpg");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(523, 560, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 frame.getContentPane().setLayout(null);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(513,  0, 523 , 563);
		 
		 table_1 = new JTable();
		 table_1.setGridColor(Color.WHITE);
		 table_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		 table_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		 table_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		 table_1.setBackground(Color.WHITE);
		 table_1.setBounds(10, 50, 493, 400);
		 frame.getContentPane().add(table_1);
		 
		 table_1.setVisible(true);
		 
		 try {
			 Conn c = new Conn();
			
			 ResultSet rs = c.s.executeQuery("select * from rooms");
			 table_1.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 JLabel lblNewLabel = new JLabel("Room Number");
			 lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
			 lblNewLabel.setBounds(10, 10, 93, 25);
			 frame.getContentPane().add(lblNewLabel);
			 
			 JLabel lblAvaibility = new JLabel("Availability");
			 lblAvaibility.setFont(new Font("Times New Roman", Font.BOLD, 13));
			 lblAvaibility.setBounds(104, 10, 101, 25);
			 frame.getContentPane().add(lblAvaibility);
			 
			 JLabel lblCleaningStatus = new JLabel("Cleaning Status");
			 lblCleaningStatus.setFont(new Font("Times New Roman", Font.BOLD, 13));
			 lblCleaningStatus.setBounds(188, 10, 129, 25);
			 frame.getContentPane().add(lblCleaningStatus);
			 
			 JLabel lblPrice = new JLabel("Price");
			 lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 13));
			 lblPrice.setBounds(329, 10, 65, 25);
			 frame.getContentPane().add(lblPrice);
			 
			 JLabel lblBedType = new JLabel("Bed Type");
			 lblBedType.setFont(new Font("Times New Roman", Font.BOLD, 13));
			 lblBedType.setBounds(404, 10, 99, 25);
			 frame.getContentPane().add(lblBedType);
			 
			 JButton back = new JButton("Back");
			 back.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		frame.setVisible(false);
			 		Reception window = new Reception();
					window.frame.setVisible(true);
			 	}
			 });
			 back.setFocusPainted(false);
			 back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			 back.setForeground(Color.WHITE);
			 back.setBackground(Color.BLACK);
			 back.setBounds(187, 474, 139, 34);
			 frame.getContentPane().add(back);
			 table_1.getColumnModel().getColumn(0).setPreferredWidth(81);
			 table_1.getColumnModel().getColumn(1).setPreferredWidth(86);
			 table_1.getColumnModel().getColumn(2).setPreferredWidth(109);
			 table_1.getColumnModel().getColumn(3).setPreferredWidth(51);
			 table_1.getColumnModel().getColumn(4).setPreferredWidth(94);
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		 
		 
	}
}
