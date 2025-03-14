package electricity.billing.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Image;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // Requires rs2xml.jar

import java.awt.*;

import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.DbUtils;

import java .awt.Choice;
import java.awt.Color;

public class deposite_details extends JFrame implements ActionListener{
    Choice searchMeterCho,searchMonthCho;
    JButton search,print,cancel;
    JTable table;
    

    deposite_details(){
        

        super("Deposite Details");

        setSize(700,500);
        getContentPane().setBackground(new Color(192,186,254));
        setLocation(400,200);
        setVisible(true);
        setLayout(null);

        JLabel searchMeter= new JLabel("Search By Meter Number");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);

        searchMeterCho=new Choice();
        searchMeterCho.setBounds(180,20,150,20);
        add(searchMeterCho);

        JLabel searchMonth=new JLabel("Search By Name");
        searchMonth.setBounds(400,20,100,20);
        add(searchMonth);

        searchMonthCho=new Choice();
        //add(searchMonth);
        
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
        
       // panel.add(monthCho);
        searchMonthCho.setBounds(520,20,150,20);
        add(searchMonthCho);

        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.BLUE);
        search.addActionListener(this);
        search.setForeground(Color.white);
        add(search);

        print=new JButton("Print");
        ImageIcon printImg=new ImageIcon(ClassLoader.getSystemResource("icon/printer.png"));
        Image printImage=printImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        print.setIcon(new ImageIcon(printImage));
        print.setBounds(120,70,100,20);
        print.setBackground(Color.yellow);
        print.addActionListener(this);
        add(print);

        cancel =new JButton("Cancel");
        cancel.setBounds(600,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        table =new JTable();
        try {
            database c =new database();
            ResultSet resultSet=c.statement.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane);



        try { //ha sreach by meter cha ahe 
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer");
            while (resultSet.next()) {
                searchMeterCho.add(resultSet.getString("meter_no"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       

    }



    
    @Override
    
    public void actionPerformed(ActionEvent e){
    
       
        if(e.getSource()== search){
            String  query_search="select * from bill where meter_no='"+searchMeterCho.getSelectedItem()+"'and month='"+searchMonthCho.getSelectedItem()+"'";
            try {
                database c=new database();
                ResultSet resultSet=c.statement.executeQuery(query_search);
                
                table.setModel(DbUtils.resultSetToTableModel(resultSet)); 
            } catch (Exception E) {
                E.printStackTrace();
            }

            
        }else if(e.getSource()==print){
            try {
            table.print();
            
           } catch (Exception E) {
              E.printStackTrace();
            }
        }else{
            setVisible(false);



        }

    }


    
    public static void main(String args[])
    {
        new deposite_details();
    } 

}
    

