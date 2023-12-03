import javax.swing.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener
{
    JLabel lb1,lb2;
    JTextField name,password;
    JButton btn1,btn2;
    Login()
    {
    setLayout(null);
    
    lb1=new JLabel("Username");
        lb1.setBounds(10,50,100,20);
        add(lb1);
    
         lb2=new JLabel("Password");
        lb2.setBounds(10,100,100,20);
        add(lb2);
    
        name=new JTextField();
        name.setBounds(110,50,100,20);
        add(name);
    
        password=new JTextField();
        password.setBounds(110,100,100,20);
        add(password);
    
          btn1=new JButton("Login");
        btn1.setBounds(110,150,100,20);
        add(btn1);
    
    btn1.addActionListener(this);
        
        
        
setSize(450,250);
setTitle("Login");
setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn1)
        {
            String aa=name.getText().toString();
            String bb=password.getText().toString();
         if(aa.equals("Admin") && bb.equals("Admin123"))
         {
              Checkout ck=new Checkout();
              setVisible(false);
         }
            
        }
        
        
    }
    
    
    public static void main(String args[])
    {
        Login lg=new Login();
    }
}
