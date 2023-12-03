
//package medicalstore;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Insert extends JFrame implements ActionListener 
{
   Connection conn;
   PreparedStatement pst;
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5;
    ImageIcon i1;
    JButton bt1,bt2;
    
Insert()
{
    setLayout(null);
    getContentPane().setBackground(Color.white);
    setContentPane(new JLabel(new ImageIcon("sky.jpg")));
    
    i1=new ImageIcon("images.jpg");
    
    l1=new JLabel("",i1,JLabel.CENTER);
    l1.setBounds(10,30,204,204);
    add(l1);
    
    l2=new JLabel("NEW PRODUCT");
    l2.setBounds(325,50,200,20);
    add(l2);
    l2.setFont(new Font("ArialBlack",Font.BOLD,17));
    
     l3=new JLabel("Product Name");
    l3.setBounds(325,150,200,20);
    add(l3);
    
    t1=new JTextField();
    t1.setBounds(460,150,100,20);
    add(t1);
    
     l4=new JLabel("Company Name");
    l4.setBounds(325,200,200,20);
    add(l4);
    
     
    t2=new JTextField();
    t2.setBounds(460,200,100,20);
    add(t2);
    
     l5=new JLabel("Product Category");
    l5.setBounds(325,250,200,20);
    add(l5);
    
     
    t3=new JTextField();
    t3.setBounds(460,250,100,20);
    add(t3);
    
     l6=new JLabel("Product Quantity");
    l6.setBounds(325,300,200,20);
    add(l6);
    
     
    t4=new JTextField();
    t4.setBounds(460,300,100,20);
    add(t4);
    
    l7=new JLabel("Product Price");
    l7.setBounds(325,350,200,20);
    add(l7);
    
     
    t5=new JTextField();
    t5.setBounds(460,350,100,20);
    add(t5);
    
    bt1=new JButton("Insert");
    bt1.setBounds(370,430,80,20);
    add(bt1);
    
    bt2=new JButton("Back");
    bt2.setBounds(460,430,80,20);
    add(bt2);
    
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    
    setSize(800,600);
    setTitle("Insert Medicines");
    setVisible(true);
    setLocation(300,100);
    setResizable(false);
}

public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==bt1)
    {
        try{
            String name=t1.getText().toString();
             String company=t2.getText().toString();
              String category=t3.getText().toString();
               String quantity=t4.getText().toString();
                String price=t5.getText().toString();
                if(name.trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please enter the product name");
                }
                else if(company.trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please enter the product company");
                }
                else if(category.trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please enter the product category");
                }
                else if(quantity.trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please enter the product quantity");
                }
                else if(price.trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please enter the product price");
                }
                else
                {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn=DriverManager.getConnection("jdbc:mysql://localhost/my_medical","root","");
                    pst=conn.prepareStatement("insert into makku values(?,?,?,?,?)");
                    pst.setString(1,name);
                    pst.setString(2,company);
                    pst.setString(3,category);
                    pst.setString(4,quantity);
                    pst.setString(5,price);
                    int j=pst.executeUpdate();
                    if(j>0)
                    {
                      JOptionPane.showMessageDialog(this,"DATA SAVED SUCCESSFULLY");
                      t1.setText("");
                      t2.setText("");
                      t3.setText("");
                      t4.setText("");
                      t5.setText("");
                 t1.requestFocus();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"DATA NOT SAVED");
                    }
                    }
                }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    if(ae.getSource()==bt2)
    {
         MedicalStore3 ms3=new MedicalStore3();
         setVisible(false);
    }
}
    
public static void main(String args[])
{
   
    Insert im=new Insert();
    im.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
}
}
