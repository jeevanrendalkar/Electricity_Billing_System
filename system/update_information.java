package electricity.billing.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;


public class update_information extends JFrame implements ActionListener {
   JLabel nametext ,meterText;

    JTextField  addressText,cityText,stateText,emailText,phoneText;

    String meter;
    JButton update ,cancel;
    update_information(String meter){
        super("Update Information");
        this.meter=meter;
        
        setBounds(400,150,777,450);
        getContentPane().setBackground(new Color(229,255,227));
        setLayout(null);
        

        JLabel heading=new  JLabel("Update Customer Information");
        heading.setBounds(50,10,400,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel name =new JLabel("Name:");
        name.setBounds(30,70,100,20);
        add(name);

        JLabel nameText=new JLabel("  ");
        nameText.setBounds(150,70,200,20);
        add(nameText);

        JLabel meterNo =new JLabel("Meter No:");
        meterNo.setBounds(30,110,100,20);
        add(meterNo);

        JLabel meterText=new JLabel(" ");
        meterText.setBounds(150,110,100,20);
        add(meterText);
 
        JLabel address = new JLabel("Address");
        address.setBounds(30,150,100,20);
        add(address);

        addressText=new JTextField();
        addressText.setBounds(150,150,200,20);
        add(addressText);

        JLabel city=new JLabel("City");
        city.setBounds(30,190,100,20);
        add(city);

        cityText=new JTextField();
        cityText.setBounds(150,190,200,20);
        add(cityText);

        JLabel state =new JLabel("State");
        state.setBounds(30,230,100,20);
        add(state);

        stateText=new JTextField();
        stateText.setBounds(150,230,200,20);
        add(stateText);

        JLabel email=new JLabel("Email :");
        email.setBounds(30,270,100,20);
        add(email);
    
        emailText=new JTextField();
        emailText.setBounds(150,270,200,20);
        add(emailText);

        JLabel phone=new JLabel("Phone No");
        phone.setBounds(30,310,200,20);
        add(phone);

        phoneText=new JTextField(" ");
        phoneText.setBounds(150,310,200,20);
        add(phoneText);

        try {
            database c=new database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no='"+meter+"'");
            if(resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                meterText.setText(resultSet.getString("meter_no"));
                addressText.setText(resultSet.getString("address"));
                cityText.setText(resultSet.getString("city"));
                stateText.setText(resultSet.getString("state"));
                emailText.setText(resultSet.getString("email"));
                phoneText.setText(resultSet.getString("phone_no"));


            }
        } catch (Exception E) {
             E.printStackTrace();
        }

        update=new JButton("Update");
        update.setBounds(50,360,120,25);
        update.setBackground(new Color(33,106,145));
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setBounds(50,360,120,25);
        add(update);
        

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.gray);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,360,120,25);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("Icon/update.png"));
        Image image=imageIcon.getImage().getScaledInstance(400, 410,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1= new ImageIcon(image);
        JLabel imgLabel=new JLabel(imageIcon1);
        imgLabel.setBounds(360,0,400,410);
        add(imgLabel);
         
        setVisible(true);








    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==update){
            String saddress=addressText.getText();
            String scity=cityText.getText();
            String sstate=stateText.getText();
            String semail=emailText.getText();
            String sphone=phoneText.getText();

            try {
               database c= new database();
              
                c.statement.executeUpdate("update new_customer set address='"+saddress+"',city='"+scity+"',state='"+sstate+"',email='"+semail+"',phone_no='"+sphone+"'WHERE meter_no= '"+meter+"'");
                JOptionPane.showMessageDialog(null, "Information Upadate Sucessful");
                setVisible(false);

            }  catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error updating information: " + ex.getMessage());
                ex.printStackTrace();
            // catch (Exception E) {
               // E.printStackTrace();

            }
        }else{
            setVisible(false);
        }


        }


public static void main(String args[]){
    new update_information(" ");
}
}
