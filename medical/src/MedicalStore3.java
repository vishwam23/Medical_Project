//package medicalstore;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class MedicalStore3 extends JFrame implements ActionListener
{
Connection conn;
PreparedStatement pst;
ResultSet rs;

JTable tb1;    
ImageIcon i1;
JButton bt1,bt2,bt3,bt4,bt5;
JLabel l1;   
JTextField t1;
    
MedicalStore3()
{
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    setContentPane(new JLabel(new ImageIcon("sky.jpg")));    
    
    
    i1=new ImageIcon("697.jpg");
    
    l1=new JLabel("",i1,JLabel.CENTER);
    l1.setBounds(0,0,390,177);
    add(l1);
    
    bt1=new JButton("Insert Medicines");
    bt1.setBounds(20,250,150,20);
    add(bt1);
    
    bt2=new JButton("Update Medicines");
    bt2.setBounds(20,300,150,20);
    add(bt2);
    
    bt3=new JButton("Delete Medicines");
    bt3.setBounds(20,350,150,20);
    add(bt3);
    
    
    
     bt4=new JButton("Back");
    bt4.setBounds(20,600,150,50);
    add(bt4);
    
    t1=new JTextField();
    t1.setBounds(450,70,700,20);
    add(t1);
   
    
   // bt5=new JButton("Search");
    //bt5.setBounds(1180,70,100,20);
    //add(bt5);
    
    String colhead[]={"ProductName","CompanyName","ProductCategory","ProductQuantity","ProductPrice"};
    Object data[][]=new Object[500][5];
    
    tb1=new JTable(data,colhead);
    int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
    int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
    
    JScrollPane jsp=new JScrollPane(tb1,v,h);
    jsp.setBounds(450,250,700,400);
    add(jsp);
    
    try
       {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           conn=DriverManager.getConnection("jdbc:mysql://localhost/my_medical","root","");
           pst=conn.prepareStatement("Select * from makku");
           rs=pst.executeQuery();
           int r=0;
           while(rs.next())
           {
               data[r][0]=rs.getString(1);
               data[r][1]=rs.getString(2);
               data[r][2]=rs.getString(3);
               data[r][3]=rs.getString(4);
               data[r][4]=rs.getString(5);
               r++;
           }    
           }
    catch(Exception e)
    {
            
    }
    
    
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    bt3.addActionListener(this);
    bt4.addActionListener(this);
 
    
    
    setSize(1500,750);
    setTitle("Medicines");
    setVisible(true);   
}
    
    
      


public void actionPerformed(ActionEvent ae)
{
     if(ae.getSource()==bt1)
    {
      Insert im=new Insert();
      setVisible(false);
       
    }
    
     
     if(ae.getSource()==bt2)
     {
          updateproduct up=new updateproduct();
          setVisible(false);
          
     }
     if(ae.getSource()==bt3)
     {
         delete dl=new delete();
         setVisible(false);
         
     }
    
    if(ae.getSource()==bt4)
    {
         MedicalStore2 aa=new MedicalStore2();
          setVisible(false);
    }
}
      
public static void main(String args[])
{
    MedicalStore3 ms3=new MedicalStore3();
   ms3.setDefaultCloseOperation(EXIT_ON_CLOSE);     
}  
}
