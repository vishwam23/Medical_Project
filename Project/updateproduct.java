
package medicalstore;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class updateproduct extends JFrame implements ActionListener 
{
Connection c1;
PreparedStatement pst;
ResultSet rs;
    
ImageIcon i1;    
JLabel  l1,l2,l3;
JButton b1,b2;
JComboBox cb1;
JButton bt1,bt2,bt3;
JTextField t1,t2;
    
updateproduct()
{
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    setContentPane(new JLabel(new ImageIcon("sky.jpg")));
    
    l1=new JLabel("PRODUCT UPDATE");
    l1.setBounds(325,50,200,20);
    add(l1);
    l1.setFont(new Font("Arial Black",Font.BOLD,15));
    
    l2=new JLabel("Product Name");
    l2.setBounds(325,150,200,20);
    add(l2);
    
    cb1=new JComboBox();
    cb1.setBounds(440,150,125,20);
    add(cb1);
    cb1.addItem("Select");
    
    i1=new ImageIcon("well.jpg");
    
    l3=new JLabel("",i1,JLabel.CENTER);
    l3.setBounds(0,0,243,116);
    add(l3);
    
    
    t1=new JTextField();
    t1.setBounds(325,250,100,20);
    add(t1);
    
    bt1=new JButton("Update Price");
    bt1.setBounds(440,250,125,20);
    add(bt1);
    
    t2=new JTextField();
    t2.setBounds(325,300,100,20);
    add(t2);
    
    bt2=new JButton("Update Quantity");
    bt2.setBounds(440,300,125,20);
    add(bt2);
    
    bt3=new JButton("Back");
    bt3.setBounds(20,525,125,30);
    add(bt3);
    
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    bt3.addActionListener(this);
   
    
    setSize(800,600);
    setTitle("Product Update");
    setVisible(true);
    setLocation(300,100);
    setResizable(false);
            
}
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==bt1)
    {
        
        
    }
        if(ae.getSource()==bt2)
        {
                    
        }
   
    if(ae.getSource()==bt3)
    {
        MedicalStore3 ms3=new MedicalStore3();
        setVisible(false);
    }
}

public static void main(String args[])
{
    updateproduct up=new updateproduct();
    up.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}
