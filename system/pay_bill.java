package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class pay_bill extends JFrame implements ActionListener {
    Choice searchMonthCho;
    JButton pay,back;

    String meter;
    pay_bill( String meter){

        this.meter=meter;
        setSize(900,550);
        setLocation(300,150);
        setLayout(null);
        

        JLabel heading=new JLabel("Pay Bill");
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        heading.setBounds(120,5,400,30);
        add(heading);

        JLabel meterNumber= new JLabel("Meter Number");
        meterNumber.setBounds(35,80,200,20);
        add(meterNumber);

        JLabel meterNumberText=new JLabel("");
        meterNumberText.setBounds(300,80,200,20);
        add(meterNumberText);

        JLabel name= new JLabel("Name");
        name.setBounds(35,140,200,20);
        add(name);

        JLabel nameText=new JLabel("");
        nameText.setBounds(300,140,200,20);
        add(nameText);

        JLabel month=new JLabel("Month");
        month.setBounds(35,200,200,20);
        add(month);

        searchMonthCho=new Choice();
        //add(searchMonth);
        searchMonthCho.add(" ");
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");

        searchMonthCho.setBounds(300,200,150,20);
        add(searchMonthCho);

        //searchMonthCho.addActionListener(this);

        
        JLabel unit= new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        add(unit);

        JLabel unitText=new JLabel("");
        unitText.setBounds(300,260,200,20);
        add(unitText);

        JLabel totalBill= new JLabel("Total");
        totalBill.setBounds(35,320,200,20);
        add(totalBill);

        JLabel totalBillText=new JLabel("");
        totalBillText.setBounds(300,320,200,20);
        add(totalBillText);

        JLabel status= new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);

        JLabel statusText=new JLabel("");
        statusText.setBounds(300,380,200,20);
        statusText.setForeground(Color.RED);
        add(statusText);

        try {
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meter_no='"+meter+"'");
            while(resultSet.next()){

                meterNumberText.setText(meter);
                nameText.setText(resultSet.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        searchMonthCho.addItemListener(new ItemListener() {
            @Override
            public  void itemStateChanged(ItemEvent e){
                System.out.print(" **********************************************Item State Change");

                database c=new database();
                try {
                    ResultSet resultSet=c.statement.executeQuery("select* from bill where meter_no='"+meter+"'and month='"+searchMonthCho.getSelectedItem()+"'");
                    while(resultSet.next()){
                        unitText.setText(resultSet.getString("unit"));
                        totalBillText.setText(resultSet.getString("total_bill"));
                        statusText.setText(resultSet.getString("status"));





                    }
                } catch (Exception E) {
                    System.out.print("itemStateChanged Exception***************************");
                    E.printStackTrace();
                }
            }
        });

        pay= new JButton("PAY");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.white);
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);
 
        back= new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(230,460,100,25);
        back.addActionListener(this);
        add(back);
        


        setVisible(true);

    }

    @Override

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==pay){
            try {
                database c=new database();
                c.statement.executeUpdate("update bill set status = 'Paid' where meter_no='"+meter+"'and month='"+searchMonthCho.getSelectedItem()+"'");


                
            } catch (Exception E) {
                E.printStackTrace();
            }
             
             setVisible(false);
            new payment_bill(meter);
        }else{
                setVisible(false);
            }
        }
     
    public static void main(String args[] ){
        new pay_bill(" ");
    }
    
}
