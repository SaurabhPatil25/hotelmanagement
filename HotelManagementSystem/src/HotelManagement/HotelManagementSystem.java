package HotelManagement;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class HotelManagementSystem extends JFrame {
	
	 HotelManagementSystem(){
		 setSize(1366, 565);   // size of frame
		 setLocation(100,100);   // location of frame on desktop
		 setLayout(null); 
		 
		 
		 ImageIcon i1 = new ImageIcon("icon/first.jpg");   // importing image 
		 JLabel image = new JLabel(i1);                  
		 add(image);
		 image.setBounds(0,  0, 1366 , 565);     // location x, location y , width , height
		 
		 
		 JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		 image.add(text);
		 text.setBounds(20, 430 , 700 ,50);
		 text.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		
		 
		 setVisible(true);
	 }

	public static void main(String[] args) {
		new HotelManagementSystem();

	}

}
