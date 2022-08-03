package HotelManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class customerinfo {

	 JFrame frame;
	 private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerinfo window = new customerinfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public customerinfo() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(150, 200, 1300, 603);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Document");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(15, 21, 100, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAge = new JLabel("Document Number");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBackground(Color.WHITE);
		lblAge.setBounds(167, 21, 178, 30);
		frame.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Name");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBackground(Color.WHITE);
		lblGender.setBounds(327, 21, 118, 30);
		frame.getContentPane().add(lblGender);
		
		JLabel lblJob = new JLabel("Gender");
		lblJob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblJob.setBackground(Color.WHITE);
		lblJob.setBounds(488, 21, 118, 30);
		frame.getContentPane().add(lblJob);
		
		JLabel lblSalary = new JLabel("Country");
		lblSalary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSalary.setBackground(Color.WHITE);
		lblSalary.setBounds(643, 21, 118, 30);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblPhoneNumber = new JLabel("Room Number");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhoneNumber.setBackground(Color.WHITE);
		lblPhoneNumber.setBounds(803, 21, 130, 30);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblAdharNumber = new JLabel("Ammount");
		lblAdharNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAdharNumber.setBackground(Color.WHITE);
		lblAdharNumber.setBounds(1122, 21, 100, 30);
		frame.getContentPane().add(lblAdharNumber);
		
		JLabel lblEmail = new JLabel("Check-In-Time");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(961, 21, 151, 30);
		frame.getContentPane().add(lblEmail);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		table.setBounds(10, 61, 1270, 421);
		frame.getContentPane().add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customerr");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Reception window = new Reception();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(593, 505, 111, 35);
		frame.getContentPane().add(btnNewButton);
		
		
	}

}
