package HotelManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class department {

	 JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					department window = new department();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public department() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(350, 200, 800, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.white);
		
		JLabel department = new JLabel("Department");
		department.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		department.setBackground(Color.WHITE);
		department.setBounds(150, 25, 177, 28);
		frame.getContentPane().add(department);
		
		JLabel budget = new JLabel("Budget");
		budget.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		budget.setBackground(Color.WHITE);
		budget.setBounds(515, 25, 177, 28);
		frame.getContentPane().add(budget);
		
		table = new JTable();
		table.setBounds(80, 77, 659, 369);
		frame.getContentPane().add(table);
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from department");
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
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back.setBounds(324, 482, 111, 35);
		frame.getContentPane().add(back);
	}
}
