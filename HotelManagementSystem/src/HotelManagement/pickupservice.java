package HotelManagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pickupservice {

	 JFrame frame;
	 private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pickupservice window = new pickupservice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pickupservice() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(250, 200, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel searchlable = new JLabel("Search for Driver");
		searchlable.setForeground(Color.RED);
		searchlable.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		searchlable.setBounds(427, 22, 242, 43);
		frame.getContentPane().add(searchlable);
		
		final Choice BTT = new Choice();
		BTT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		BTT.setBackground(Color.WHITE);
		BTT.setBounds(187, 103, 195, 36);
		frame.getContentPane().add(BTT);
		
		try {
			Conn cs = new Conn();
			String Query = "select car_model from driver";
			ResultSet s = cs.s.executeQuery(Query);
			while(s.next()) {
				BTT.add(s.getString("car_model"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		 JLabel BT = new JLabel("Car Brand :");
		BT.setBackground(Color.WHITE);
		BT.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		BT.setBounds(44, 103, 137, 36);
		frame.getContentPane().add(BT);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(44, 193, 89, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(182, 193, 68, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGender.setBounds(318, 193, 89, 25);
		frame.getContentPane().add(lblGender);
		
		JLabel lblNewLabel_1_1 = new JLabel("Car Company");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(458, 193, 142, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblCarModel = new JLabel("Car Model");
		lblCarModel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCarModel.setBounds(595, 193, 108, 25);
		frame.getContentPane().add(lblCarModel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Availability");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(732, 193, 98, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Location");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(869, 193, 108, 25);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(44, 228, 967, 228);
		frame.getContentPane().add(table);
		try {
			
			Conn c = new Conn();
			String query = "select * from driver";
			ResultSet rs = c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Reception window = new Reception();
				window.frame.setVisible(true);
			}
		});
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setFocusPainted(false);
		back.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		back.setBounds(443, 476, 119, 36);
		frame.getContentPane().add(back);
		
		JButton search = new JButton("Search");
		search.setFocusPainted(false);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Conn c = new Conn();
					String query = "select * from driver where car_model = '"+BTT.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception ae) {
					ae.printStackTrace();
				}
				
				
			}
		});
		search.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		search.setForeground(Color.WHITE);
		search.setBackground(Color.BLACK);
		search.setBounds(669, 103, 112, 30);
		frame.getContentPane().add(search);
		
		
		
		
	}
}
