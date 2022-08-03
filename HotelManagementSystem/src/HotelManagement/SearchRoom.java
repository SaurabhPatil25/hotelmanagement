package HotelManagement;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JCheckBox;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom {

	 JFrame frame;
	private JComboBox BTT;
	private JTable table;
	Conn c ;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRoom window = new SearchRoom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SearchRoom() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(250, 200, 1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel search = new JLabel("Search for Room");
		search.setForeground(Color.RED);
		search.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		search.setBounds(424, 38, 242, 30);
		frame.getContentPane().add(search);
		
		BTT = new JComboBox();
		BTT.setModel(new DefaultComboBoxModel(new String[] {"All","Single Bed", "Double Bed"}));
		BTT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		BTT.setBackground(Color.WHITE);
		BTT.setBounds(160, 106, 150, 30);
		frame.getContentPane().add(BTT);
		
		JLabel BT = new JLabel("Bed Type :");
		BT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		BT.setBounds(44, 103, 90, 36);
		frame.getContentPane().add(BT);
		
		final JCheckBox available = new JCheckBox("Only Display Available");
		available.setBackground(Color.WHITE);
		available.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		available.setBounds(446, 106, 242, 30);
		frame.getContentPane().add(available);
		
		 JLabel lblNewLabel = new JLabel("Room Number");
		 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 lblNewLabel.setBounds(27, 174, 144, 25);
		 frame.getContentPane().add(lblNewLabel);
		 
		 JLabel lblAvaibility = new JLabel("Availability");
		 lblAvaibility.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 lblAvaibility.setBounds(222, 174, 155, 25);
		 frame.getContentPane().add(lblAvaibility);
		 
		 JLabel lblCleaningStatus = new JLabel("Cleaning Status");
		 lblCleaningStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 lblCleaningStatus.setBounds(420, 174, 155, 25);
		 frame.getContentPane().add(lblCleaningStatus);
		 
		 JLabel lblPrice = new JLabel("Price");
		 lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 lblPrice.setBounds(616, 174, 150, 25);
		 frame.getContentPane().add(lblPrice);
		 
		 JLabel lbl1BedType = new JLabel("Bed Type");
		 lbl1BedType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 lbl1BedType.setBounds(815, 174, 150, 25);
		 frame.getContentPane().add(lbl1BedType);
		
		
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(27, 199, 985, 283);
		frame.getContentPane().add(table);
		
		JButton sear = new JButton("Search");
		sear.setFocusPainted(false);
		sear.setForeground(Color.WHITE);
		sear.setBackground(Color.BLACK);
		sear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					c = new Conn();
					
					if(available.isSelected() && (String)BTT.getSelectedItem() == "All"){
						String query ="select * from rooms where AvailbleStatus ='Available'";
						ResultSet rs = c.s.executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} else if(available.isSelected()) {
						String query ="select * from rooms where BedType = '"+(String)BTT.getSelectedItem()+"' and AvailbleStatus ='Available' ";
						ResultSet rs = c.s.executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}else if((String)BTT.getSelectedItem() == "All") {
		            	String query ="select * from rooms";
						ResultSet rs = c.s.executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(rs));
		            }else {
		            	String query ="select * from rooms where BedType = '"+(String)BTT.getSelectedItem()+"'  ";
						ResultSet rs = c.s.executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(rs));
		            }
					
					
					
				}catch(Exception ae) {
					ae.printStackTrace();
				}
				
			}
		});
		sear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sear.setBounds(798, 106, 111, 30);
		frame.getContentPane().add(sear);
		
		

		try {
			
			
			c = new Conn();
			
			String query ="select * from rooms";
			ResultSet rs = c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
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
			btnNewButton.setBounds(477, 514, 111, 30);
			frame.getContentPane().add(btnNewButton);
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
