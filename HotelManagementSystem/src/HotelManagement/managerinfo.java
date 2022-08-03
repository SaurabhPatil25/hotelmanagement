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

public class managerinfo {

	JFrame frame;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerinfo window = new managerinfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public managerinfo() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(250, 200, 1056, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(15, 21, 100, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBackground(Color.WHITE);
		lblAge.setBounds(140, 21, 82, 30);
		frame.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBackground(Color.WHITE);
		lblGender.setBounds(267, 21, 100, 30);
		frame.getContentPane().add(lblGender);
		
		JLabel lblJob = new JLabel("Job role");
		lblJob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblJob.setBackground(Color.WHITE);
		lblJob.setBounds(394, 21, 74, 30);
		frame.getContentPane().add(lblJob);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSalary.setBackground(Color.WHITE);
		lblSalary.setBounds(522, 21, 64, 30);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblPhoneNumber = new JLabel("Phone  ");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhoneNumber.setBackground(Color.WHITE);
		lblPhoneNumber.setBounds(649, 21, 90, 30);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblAdharNumber = new JLabel("Adhar ");
		lblAdharNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAdharNumber.setBackground(Color.WHITE);
		lblAdharNumber.setBounds(905, 21, 82, 30);
		frame.getContentPane().add(lblAdharNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(778, 21, 64, 30);
		frame.getContentPane().add(lblEmail);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(Color.WHITE);
		table.setBounds(10, 61, 1022, 421);
		frame.getContentPane().add(table);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee where job ='Manager'");
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
		btnNewButton.setBounds(469, 500, 111, 35);
		frame.getContentPane().add(btnNewButton);
	}

}
