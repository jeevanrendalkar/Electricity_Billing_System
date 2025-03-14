package electricity.billing.system;
// import java.awt.Component;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;
import java.sql.ResultSet;






public class Login extends JFrame implements ActionListener {
    JTextField userText,passwordText;
    Choice loginChoice;
   // Choice sloginChoice = new Choice(); // Ensure this is done


    JButton loginButton,cancelButton,signupButton;
  
    

    Login(){
        super("LOGIN❤️");
        getContentPane().setBackground(Color.WHITE);
        JLabel username= new JLabel("UserName");
        username.setBounds(300,60,100,20);
        add(username);

        userText=new JTextField();
        userText.setBounds(400,60,150,20);
        add(userText);

        JLabel password =new JLabel ("Password");
        password.setBounds(300,100,100,20 );
        add(password);

        passwordText=new JPasswordField();
        passwordText.setBounds(400,100,150,20);
        add(passwordText);

        JLabel loggin =new JLabel("Loggin In As ");
        loggin.setBounds(300,140,100,20);
        add(loggin);


         loginChoice = new java.awt.Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 140, 150, 20);
        add(loginChoice);


        loginButton = new JButton("Login");
        loginButton.setBounds (330,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton =new JButton ("Cancel");
        cancelButton.setBounds (460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton =new JButton ("Sign Up");
        signupButton.setBounds (400,220,100,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/Splash/Profile.jpeg"));
        java.awt.Image profileTow = profileOne.getImage().getScaledInstance(270,270,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTow);
        JLabel profileLabel = new JLabel(fprofileOne);
        profileLabel.setBounds(0,0,270,270);
        add(profileLabel); 

        setSize(640,300);
        setLocation(400,200);
        setLayout(null);  
        setVisible(true);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
        String susername = userText.getText();
        String spassword = passwordText.getText();
        String suser =loginChoice.getSelectedItem();

        try {
            database c = new database(); 
          
             String query = "SELECT * FROM Signup WHERE username='" + susername +"' and password='" + spassword + "' and usertype='" + suser + "' ";

           ResultSet resultSet = c.statement.executeQuery(query);
           
            
            if(resultSet.next()) {
                String meter = resultSet.getString("meter_no");

                setVisible(false);

                new main_class(suser,meter);   
                //JOptionPane.showMessageDialog(null, " Login Sucessfully");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Login");
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }else if(e.getSource()==cancelButton){

        setVisible(false);

    }else if(e.getSource()==signupButton){
        setVisible(false);
        new Signup();
        }
        

    }
    
    public static void main(String arg[]){

        new Login();
     

        }


  
    }

    

