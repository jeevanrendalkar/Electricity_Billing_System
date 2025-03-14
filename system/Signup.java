package electricity.billing.system;

import java.awt.*;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent; 
import javax.swing.*;




public class Signup extends JFrame implements ActionListener{
    Choice loginASCho;
    TextField meterText,EmpolyerText,userNameText,nameText,passwordText;
    JButton create,back;
    

    Signup(){
        super("Signup Page");
        getContentPane().setBackground(new Color(168, 203, 255));
        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30, 50, 125, 20);
        add(createAs);


        loginASCho=new Choice();
        loginASCho.setBounds(170,50,125,20);
        loginASCho.add("Admin");
        loginASCho.add("Customer");
        add(loginASCho);

        JLabel meterNo = new JLabel("MeterNumber");
        meterNo.setBounds(30,90,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170,100,125,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel Empolyer = new JLabel("Employer Id");
       Empolyer.setBounds(30,100,125,20);
       Empolyer.setVisible(true);
        add(Empolyer);

        EmpolyerText = new TextField();
        EmpolyerText.setBounds(170,100,125,20);
        EmpolyerText.setVisible(true);
        add(EmpolyerText);

        JLabel userName=new JLabel("UserName ");
        userName.setBounds(30,140,125,20);
        add(userName);

        userNameText =new TextField();
        userNameText.setBounds(170,140,125,20);
        add(userNameText);

        meterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e){

            }
            @Override
            public void focusLost(FocusEvent e){
                try {
                    database c=new database();
                    ResultSet resultSet=c.statement.executeQuery("select * from signup where meter_no='"+meterText.getText()+"'");
                    if(resultSet.next()){
                        nameText.setText(resultSet.getString("name"));

                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });




        JLabel name=new JLabel("Name ");
        name.setBounds(30,180,125,20);
        add(name);

        nameText=new TextField();
        nameText.setBounds(170,180,125,20);
        add(nameText);

        JLabel password =new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

         passwordText=new TextField();
         passwordText.setBounds(170,220,125,20);
         add(passwordText);

         loginASCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                String user = loginASCho.getSelectedItem();
                
                if(user.equals("Customer")){

                    Empolyer.setVisible(false);
                    EmpolyerText.setVisible(false);
                   // nameText.setEditable(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                }
                else{
                    Empolyer.setVisible(true);
                    EmpolyerText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }

         }
        }
        );

        create =new JButton("Create");
         create.setBackground(new Color(66, 127, 219));
        create.setBounds(50,285,100,25);
        create.setForeground(Color.black);
        create.addActionListener(this);
        add(create);

        back=new JButton("Back");
        back.setBackground(new Color(66,127,219)); 
        back.setForeground(Color.black);
        back.setBounds(180,285,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon boyIcon= new ImageIcon(ClassLoader.getSystemResource("icon/Splash/boy.png"));
        java.awt.Image boyImg= boyIcon.getImage().getScaledInstance(250,250,java.awt.Image.SCALE_DEFAULT);
        ImageIcon boyIcon2=new ImageIcon(boyImg);
        JLabel boyLabel=new JLabel(boyIcon2);
        boyLabel.setBounds(300,20,250,250);
        add(boyLabel);


        setSize(600,380);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
    if(e.getSource()== create)
    {
       

         String sloginAs=loginASCho.getSelectedItem();
         //TextField nameText = new TextField();
         String susername=userNameText.getText();
         String sname=nameText.getText();
         String spassword=passwordText.getText();
         String smeter=meterText.getText();

        try {
            database c= new database();
            String query=null;
            if(sloginAs.equals("Admin")){
            query = "INSERT INTO Signup VALUE('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+sloginAs+"')";
            }
            else{
                query="update Signup set username='"+susername+"',password='"+spassword+"',usertype='"+sloginAs+"' where meter_no='"+smeter+"' ";
            }
             c.statement.executeUpdate(query);
             JOptionPane.showMessageDialog(null, " Account Created Sucessfully !! ");
             setVisible(false);
             new Login();
            
            
        } catch (Exception E) {
            E.printStackTrace();
           
            
        }


   
    }else if (e.getSource()==back){
        setVisible(false);
        new Login();

    }


}




       
       


    

    public static void main(String args[]){
        new Signup();
    }

   

    
}
