import javax.swing.*;
public class Checkout extends JFrame 
{
    JLabel zip,shipp,pay,off;
    JButton btn1,btn2;
    JTextField post;
    JComboBox cb1;
  JRadioButton rb1,rb2,rb3;
  JCheckBox c1,c2;
    
      Checkout()//constructor
      {
        setLayout(null);
        zip=new JLabel("Postalcode");
        zip.setBounds(100,100,100,20);
        add(zip);
        
        post=new JTextField();
        post.setBounds(200,100,130,20);
        add(post);
        
        shipp=new JLabel("Shipping Method");
        shipp.setBounds(100,150,100,20);
        add(shipp);
        
        cb1=new JComboBox();
        cb1.setBounds(200, 150,130,20);
        cb1.addItem("Select");
        cb1.addItem("1 Day Shipping");
        cb1.addItem("2 Day Shipping");
        cb1.addItem("3 Day Shipping");
        add(cb1);
        
         pay=new JLabel("Payment");
        pay.setBounds(100,200,100,20);
        add(pay);
        
        rb1=new JRadioButton("Credit Card");
        rb1.setBounds(200,200,130,20);
        add(rb1);
        
         
        rb2=new JRadioButton("Netbanking");
        rb2.setBounds(330,200,130,20);
        add(rb2);
        
        rb3=new JRadioButton("COD");
        rb3.setBounds(460,200,130,20);
        add(rb3);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        
        c1=new JCheckBox("SignUp For Email Offers");
        c1.setBounds(100,250,180,20);
        add(c1);
        
           c2=new JCheckBox("Gift Wrap");
        c2.setBounds(300,250,180,20);
        add(c2);
        
        btn1=new JButton("Order Now");
        btn1.setBounds(300,300,120,20);
        add(btn1);
        
        setSize(700,500);
        setTitle("My First Page");
        setVisible(true);
          
      }
    public static void main(String args[])
    {
        Checkout ck=new Checkout();
    }
}
