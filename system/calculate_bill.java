package electricity.billing.system;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class calculate_bill extends JFrame implements ActionListener{
    JLabel nameText,addressText;
    TextField unitText;
    Choice meternumCho,monthCho;
    JButton submit,cancel;

    calculate_bill(){
        super("Calculate Bill System");

        JPanel panel= new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 650, 400); 
        panel.setBackground(new Color(214,195,247));
        add(panel);

        
        // Heading Label
        JLabel heading = new JLabel("Calculate Electricity Bill");
     
        heading.setBounds(70, 10, 300, 30);  // Adjusted height for better visibility
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));   
        panel.add(heading);
        
        // Meter Number Label
        JLabel meternum = new JLabel("Meter Number");
        meternum.setBounds(50, 80, 150, 30);  // Adjusted y-coordinate and width for spacing
        panel.add(meternum);

        meternumCho=new  Choice();
        try {
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("SELECT * FROM new_customer");

            while (resultSet.next()) {
                meternumCho.add(resultSet.getString("meter_no"));
                
            }
            } catch (Exception E) {
            E.printStackTrace();
            }
        
    
        meternumCho.setBounds(200,80,100,20);
        panel.add(meternumCho);

        JLabel name=new JLabel("Name");
        name.setBounds(50,120,100,20);
        panel.add(name);

        
        nameText= new JLabel("");
        nameText.setBounds(200,120,150,20);
        panel.add(nameText);

        JLabel address=new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText=new JLabel("");
        addressText.setBounds(200,160,150,20);
        panel.add(addressText);

        try {
            database c=new database();
            ResultSet resultSet= c.statement.executeQuery("SELECT * FROM new_customer WHERE meter_no ='"+meternumCho.getSelectedItem()+"'");
            while (resultSet.next()) {
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));
                }
            
        } catch (Exception E) {
            E.printStackTrace();
            
        }

        meternumCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                try {
                    database c=new database();
                    ResultSet resultSet=c.statement.executeQuery("SELECT * FROM new_customer WHERE meter_no='"+meternumCho.getSelectedItem()+"'");
                    while(resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));

                    }

                    
                } catch (Exception E) {
                   E.printStackTrace();
                }
            }

        });

        JLabel unitconsumed=new JLabel("Unit Consumed");
        unitconsumed.setBounds(50,200,100,20);
        panel.add(unitconsumed);

        unitText=new TextField();
        unitText.setBounds(200,200,150,20);
        panel.add(unitText);

        JLabel month=new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        monthCho=new Choice();
       
        monthCho.add("January");
        monthCho.add("February");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.add("September");
        monthCho.add("October");
        monthCho.add("November");
        monthCho.add("December");
        monthCho.setBounds(200,240,150,20);
        panel.add(monthCho);

        submit=new JButton("Submit");
        submit.setBounds(80,300,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(220,300,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        panel.add(cancel);
        
        setLayout(new BorderLayout());
        add(panel,"Center");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/budget.png"));
        Image image=imageIcon.getImage().getScaledInstance(250, 200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel imagLabel = new JLabel(imageIcon1);
        add(imagLabel,"East");


        setSize(650,400);
        setLocation(400,200);
        setVisible(true);


    } @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==submit) {
            String smeterNo= meternumCho.getSelectedItem();
            String sunit=unitText.getText();
            String  smonth=monthCho.getSelectedItem();

            int totalBill=0;
            int units=Integer.parseInt(sunit);
            String query_tax="select * from tax ";
            try{
                database c = new database();
                ResultSet resultSet= c.statement.executeQuery(query_tax);
                while (resultSet.next()) {
                    totalBill+= units*Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill+=Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill+=Integer.parseInt(resultSet.getString("service_charge"));
                    totalBill+=Integer.parseInt(resultSet.getString("swacch_bharat"));
                    totalBill+=Integer.parseInt(resultSet.getString("fixed_tax"));
                    
                    }
                    


                    
                
            }
            catch(Exception E){
                E.printStackTrace();
            }

            String query_total_bill="insert into bill values ('"+smeterNo+"','"+smonth+"','"+sunit+"','"+totalBill+"','Not Paid')";
            try{
                database c=new database();
                c.statement.executeUpdate(query_total_bill);

                JOptionPane.showMessageDialog(null,"CustomerBill Updated Sucessfully");
                setVisible(false);

            }
            catch(Exception E){
                E.printStackTrace();
            }
            

            


            
        } else {
            setVisible(false);
            
        }
     
    }
    
    public static void main(String[] args) {
        new calculate_bill();
        
    }
   
    
}
