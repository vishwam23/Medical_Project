import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class InsertDb extends JFrame implements ActionListener 
{
 Connection conn;
 PreparedStatement pst;
 ResultSet rs;   
 
 
JTextField un,cn,em,upd;    
JButton btn,btn2,btn3,btn4;
JTable tbl;
JComboBox cb1,cb2;
JRadioButton rb1,rb2;
    
InsertDb()
{
    setLayout(null);
  
    
    un=new JTextField();
    un.setBounds(100,100,150,20);
    add(un);
    
     
    cn=new JTextField();
    cn.setBounds(100,150,150,20);
    add(cn);
    
     
    em=new JTextField();
    em.setBounds(100,200,150,20);
    add(em);
    
    
    
     
    btn=new JButton("Save");
    btn.setBounds(150,250,100,20);
    add(btn);
    
    btn2=new JButton("Refresh");
    btn2.setBounds(150,350,100,20);
    add(btn2);
    
    btn3=new JButton("Update");
    btn3.setBounds(150,450,100,20);
    add(btn3);
    
    btn4=new JButton("Delete");
    btn4.setBounds(150,550,100,20);
    add(btn4);
    
    cb2=new JComboBox();
    cb2.setBounds(300,600,100,20);
    cb2.addItem("Select");
    add(cb2);
    
    try
    {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","");
       
        
        pst=conn.prepareStatement("select name from record");
        rs=pst.executeQuery();
        while(rs.next())
        {
            cb2.addItem(rs.getString(1));
                
        }
        
    }
    catch(Exception e)
    {
        
        
    }
    
    
    
    cb1=new JComboBox();
    cb1.setBounds(150,550,100,20);
    cb1.addItem("Select");
   add(cb1);
   
 
    try
    {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","");
       
        
        pst=conn.prepareStatement("select name from record");
        rs=pst.executeQuery();
        while(rs.next())
        {
            cb1.addItem(rs.getString(1));
                
        }
        
    }
    catch(Exception e)
    {
        
        
    }
 
    upd=new JTextField();
    upd.setBounds(350,550,100,20);
    add(upd);
    
   rb1=new JRadioButton("Male");
   rb1.setBounds(450,600,100,20);
   add(rb1);
    
    rb2=new JRadioButton("Female");
   rb2.setBounds(550,600,100,20);
   add(rb2);
    ButtonGroup bg=new ButtonGroup();
    bg.add(rb1);
    bg.add(rb2);
           
    
    String col[]={"Name","Contact","Email","Gender"};
    Object data[][]=new Object[500][4];
    int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
    int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
    tbl=new JTable(data,col);
    JScrollPane jsp=new JScrollPane(tbl,v,h);
    jsp.setBounds(300,100,350,250);
    add(jsp);
  
    try
    {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
     conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","");
        pst=conn.prepareStatement("select * from record");
        rs=pst.executeQuery();
        int r=0;
       while(rs.next())
       {
          data[r][0]=rs.getString(1);
          data[r][1]=rs.getString(2);
          data[r][2]=rs.getString(3);
          data[r][3]=rs.getString(4);
           r++;
       }
       
    }
    catch(Exception e)
    {
        
        
    }
    
    
    
    
    btn.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
    btn4.addActionListener(this);
      setSize(700,700);
    setVisible(true);
}
    
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==btn)
    {
      try
      {
            String aa=un.getText().toString();
            String bb=cn.getText().toString();
            String cc=em.getText().toString();
            String dd="";
            if(rb1.isSelected())
            {
                dd="Male";
            }
            else
            {
                dd="Female";
            }
       if(aa.trim().equals("")||bb.equals("")||cc.trim().equals(""))
       {
           JOptionPane.showMessageDialog(this,"Please Enter The Details");
       }
       else
       {
     Class.forName("com.mysql.jdbc.Driver").newInstance();
     conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","");
     pst=conn.prepareStatement("insert into record values(?,?,?,?)");
     pst.setString(1,aa);
     pst.setString(2,bb);
     pst.setString(3,cc);
     pst.setString(4,dd);
     int j=pst.executeUpdate();
     if(j>0)
     {
         
         JOptionPane.showMessageDialog(this,"Data Saved Successfully");
         un.setText("");
         cn.setText("");
         em.setText("");
         un.requestFocus();
     }
     else
     {
         JOptionPane.showMessageDialog(this,"Data Not Saved Successfully");
     }
           
           
           
       }
      }
        catch(Exception e)
        {
            System.out.println("Error Is "+e);
              
        }
        
        
    }
    if(ae.getSource()==btn2)
    {
        InsertDb obj=new InsertDb();
        setVisible(false);
        
    }
    if(ae.getSource()==btn3)
    {
          try
                 {
                     String updated=upd.getText().toString();
                   String name=cb1.getSelectedItem().toString();
                   
                  if(updated.trim().equals(""))
                  {
                      JOptionPane.showMessageDialog(this,"Please Enter The Contact To Be Updated");
                  }
                else
                  {
                pst=conn.prepareStatement("update record set contact=? where name=?");
                
                pst.setString(1,updated);
                pst.setString(2,name);
                
                int h=pst.executeUpdate();
                
                if(h>0)
                {
                    JOptionPane.showMessageDialog(this,"Contact Updated");
                     upd.setText("");
                     cb1.setSelectedIndex(0);
                }
                else
                    JOptionPane.showMessageDialog(this,"Contact Not Updated");
            }
                 }
            catch(Exception e)
            {
                System.out.println("The error is "+e);
            }
        
        
    }
    
    if(ae.getSource()==btn4)
    {
       try{
            try
            {
                String p=cb2.getSelectedItem().toString();
                
                
                 
                 pst=conn.prepareStatement("delete from record where name=? ");
                 pst.setString(1, p);
                 int j=pst.executeUpdate();
                 if(j>0)
                 {
                     JOptionPane.showMessageDialog(this," Successfully Deleted");
                 }
                 else
                     JOptionPane.showMessageDialog(this," Not Deleted");
                 
                     cb1.setSelectedIndex(0);
            }
            catch(Exception e)
            {
                System.out.println("The error is "+e);
            }

           
           
       }
        catch(Exception e)
        {
            
        }
        
        
    }
    
    
   
}
    public static void main(String args[])
    {
        InsertDb obj=new InsertDb();
    }
}
