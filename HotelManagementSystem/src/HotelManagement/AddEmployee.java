package HotelManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.nio.charset.CoderMalfunctionError;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class AddEmployee {

	 JFrame frame;
	 private JTextField nameT;
	 private JTextField ageT;
	 private JTextField salaryT;
	 private JTextField phoneT;
	 private JTextField emailT;
	 private JTextField aadharT;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee window = new AddEmployee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddEmployee() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(300, 200, 850, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel name = new JLabel("NAME      :");
		name.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		name.setBounds(34, 44, 128, 25);
		frame.getContentPane().add(name);
		
		nameT = new JTextField();
		nameT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nameT.setBounds(180, 44, 200, 28);
		frame.getContentPane().add(nameT);
		nameT.setColumns(10);
		
		JLabel age = new JLabel("AGE          :");
		age.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		age.setBounds(34, 92, 128, 25);
		frame.getContentPane().add(age);
		
		ageT = new JTextField();
		ageT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ageT.setColumns(10);
		ageT.setBounds(180, 92, 200, 28);
		frame.getContentPane().add(ageT);
		
		JLabel gender = new JLabel("GENDER  :");
		gender.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		gender.setBounds(34, 142, 128, 25);
		frame.getContentPane().add(gender);
		
		JLabel job = new JLabel("JOB           :");
		job.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		job.setBounds(34, 190, 128, 25);
		frame.getContentPane().add(job);
		
		JLabel salary = new JLabel("SALARY  :");
		salary.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		salary.setBounds(34, 239, 128, 25);
		frame.getContentPane().add(salary);
		
		salaryT = new JTextField();
		salaryT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		salaryT.setColumns(10);
		salaryT.setBounds(180, 239, 200, 28);
		frame.getContentPane().add(salaryT);
		
		JLabel phone = new JLabel("PHONE     :");
		phone.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		phone.setBounds(34, 287, 128, 25);
		frame.getContentPane().add(phone);
		
		phoneT = new JTextField();
		phoneT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phoneT.setColumns(10);
		phoneT.setBounds(180, 287, 200, 28);
		frame.getContentPane().add(phoneT);
		
		JLabel email = new JLabel("EMAIL      :");
		email.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		email.setBounds(34, 334, 128, 25);
		frame.getContentPane().add(email);
		
		emailT = new JTextField();
		emailT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		emailT.setColumns(10);
		emailT.setBounds(180, 334, 200, 28);
		frame.getContentPane().add(emailT);
		
		JLabel aadhar = new JLabel("AADHAR :");
		aadhar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		aadhar.setBounds(34, 382, 128, 25);
		frame.getContentPane().add(aadhar);
		
		aadharT = new JTextField();
		aadharT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		aadharT.setColumns(10);
		aadharT.setBounds(180, 382, 200, 28);
		frame.getContentPane().add(aadharT);
		
		
		
		
		
		final JRadioButton male = new JRadioButton("Male");
		male.setBackground(Color.WHITE);
		male.setFocusPainted(false);
		male.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		male.setBounds(180, 140, 83, 28);
		frame.getContentPane().add(male);
		
		final JRadioButton female = new JRadioButton("Female");
		female.setBackground(Color.WHITE);
		female.setFocusPainted(false);
		female.setForeground(Color.BLACK);
		female.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		female.setBounds(277, 140, 103, 28);
		frame.getContentPane().add(female);
		
		ButtonGroup bg = new ButtonGroup();  // to select only one - male or female
		bg.add(female);
		bg.add(male);
		

		 ImageIcon i1 = new ImageIcon("icon/tenth.jpg");   // importing image 
		 Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);                  
		 frame.getContentPane().add(image);
		 image.setBounds(390,  59, 446 , 410); 
		 
		 JButton closed = new JButton("CLOSE");
		 closed.setForeground(Color.WHITE);
		 closed.setBackground(Color.BLACK);
		 closed.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		frame.setVisible(false);
		 	}
		 });
		 closed.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 closed.setFocusPainted(false);
		 closed.setBounds(281, 433, 104, 36);
		 frame.getContentPane().add(closed);
		 
		 final JComboBox jobselect = new JComboBox();
		 jobselect.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 jobselect.setBackground(Color.WHITE);
		 jobselect.setModel(new DefaultComboBoxModel(new String[] {"[-- Select One --]", "Front Desk Cleark", "Accountant", "Porters", "Housekeeping ", "Room Service", "Chefs", "Waiter/Waitress", "Manager"}));
		 jobselect.setBounds(180, 190, 200, 28);
		 frame.getContentPane().add(jobselect);
		 
		 
		 JButton submit = new JButton("SUBMIT");
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					String name = nameT.getText();
					String age = ageT.getText();
					String salary = salaryT.getText();
					String phone =phoneT.getText();
					String email = emailT.getText();
					String aadhar =aadharT.getText();
					String gender = null;
					if(male.isSelected()) {
						gender = "Male";
					}else if(female.isSelected()) {
						gender = "Female";
					}
					
					String job = (String) jobselect.getSelectedItem();
					
					
					// validation
					
					if(name.equals("")) {
						JOptionPane.showMessageDialog(null , "Name Should not be Empty ! ");
						return;
					}
	                if(age.equals("")) {
	                	JOptionPane.showMessageDialog(null , "Age Should not be Empty ! ");
						return;
					}
	               
	               
	                if(job.equals("")) {
	                	JOptionPane.showMessageDialog(null , "Job role Should not be Empty ! ");
						return;
					}
	                
	                if(salary.equals("")) {
	                	JOptionPane.showMessageDialog(null , "Salary Should not be Empty ! ");
						return;
					}
	                if(phone.equals("")) {
	                	JOptionPane.showMessageDialog(null , "phone Should not be Empty ! ");
						return;
					}else if(phone.length()>10 ||  phone.length()<10) {
						JOptionPane.showMessageDialog(null , "Invalid Phone Number !");
						return;
					}
	                if(email.equals("")) {
	                	JOptionPane.showMessageDialog(null , "Email Should not be Empty !");
						return;
					}else if(!email.contains(".com") || !email.contains("@")){
						JOptionPane.showMessageDialog(null , "Invalid Email !");
						return;
					}
	                if(aadhar.equals("")) {
	                	JOptionPane.showMessageDialog(null , "Aadhar No Should not be Empty ! ");
						return;
					}else if(aadhar.length()>12 ||  aadhar.length()<12) {
						JOptionPane.showMessageDialog(null , "Invalid Aadhar Number !");
						return;
					}
					
					
					try {
						Conn conn = new Conn();
						
					
						
						String query = " insert into employee values('" + name + "', '"+age+"',  '"+gender +"', '"+job+"' ,'"+salary+"', '"+phone+"' ,'"+email+"', '"+aadhar+"')";
						conn.s.executeUpdate(query); 
						
						JOptionPane.showMessageDialog(null , " Employee added successfully");
						frame.setVisible(false);
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					
					
					
				}
			});
			submit.setForeground(Color.WHITE);
			submit.setBackground(Color.BLACK);
			submit.setFocusPainted(false);
			submit.setFont(new Font("Times New Roman", Font.BOLD, 20));
			submit.setBounds(152, 433, 119, 36);
			frame.getContentPane().add(submit);
			
			JLabel addEMployeee = new JLabel("ADD EMPLOYEE");
			addEMployeee.setForeground(Color.RED);
			addEMployeee.setBackground(Color.WHITE);
			addEMployeee.setFont(new Font("Times New Roman", Font.BOLD, 25));
			addEMployeee.setBounds(472, 10, 209, 49);
			frame.getContentPane().add(addEMployeee);
	}
}
