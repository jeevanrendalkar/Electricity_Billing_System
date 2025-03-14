package electricity.billing.system;

import javax.swing.*;

//import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.proteanit.sql.DbUtils;

public class customer_details extends JFrame implements ActionListener{
    Choice searchMeterCho, searchNameCho;
    JTable table;
    JButton search,print,cancel;
    customer_details()
    {
        super("Customer Details");
        getContentPane().setBackground(new Color(192,186,254));
        setSize(700,500);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);

        

        JLabel searchMeter= new JLabel("Search By Meter Number ");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);

        searchMeterCho=new Choice();
        searchMeterCho.setBounds(180,20,150,20);
        add(searchMeterCho);

        JLabel searchName = new JLabel("Search By Name");
        searchName.setBounds(400, 20, 100, 20); // Adjusted width for better text visibility
        add(searchName); 

        searchNameCho=new Choice();
        searchNameCho.setBounds(500,20,170,20);
        add(searchNameCho);


        search=new JButton("Search");
        search.setBackground(Color.blue);
        search.setForeground(Color.white);
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(Color.orange);
        print.addActionListener(this);
        add(print);

        cancel=new JButton("Cancel");
        cancel.setBounds(600,70,80,20);
        cancel.setBackground(Color.lightGray);
        cancel.addActionListener(this);
        add(cancel);

       table=new JTable();
        try {
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.WHITE);
        add(scrollPane);


        
        
        try {// ha block Search Meter cha ahe 
            database c= new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
                searchMeterCho.add(resultSet.getString("meter_no"));
            }
            
        } catch (Exception e) {
          e.printStackTrace();

        }

        
        
        try {  // ha block Search Name  cha ahe 
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()) {
                searchNameCho.add(resultSet.getString("name"));
                 }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource()==search)
            {
                String query_search= "select * from new_customer where meter_no='"+searchMeterCho.getSelectedItem()+"'and name='"+searchNameCho.getSelectedItem()+"'" ;
                try 
                {
                    database  c= new database();
                    ResultSet resultSet=c.statement.executeQuery(query_search);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                 
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }else if(e.getSource()==print){
                try{
                    table.print();
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }else{
                setVisible(false);
            }
                
        
        }       
        
    
    public static void main(String args[]) {
      new customer_details();

    }
}


 



