package electricity.billing.system;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class bill_details extends JFrame {
    String meter;

    bill_details(String meter){
        this.meter=meter;
        //super("Bill Details");
        setSize(700,550);
        setLocation(400,150);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);

        JTable table=new JTable();

        try {
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("SELECT * FROM bill WHERE meter_no= '"+meter+"'");
           // String query_bill="select * from bill where meter_no= '" + meter + "'";
           // ResultSet resultSet=c.statement.executeQuery(query_bill);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error in the query"+e.getMessage());
            e.printStackTrace();
        }

        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,0,700,500);
        add(sp);



        setVisible(true);




    }
    public static void main(String args[]){
        new bill_details(" ");
    } 
    
}
