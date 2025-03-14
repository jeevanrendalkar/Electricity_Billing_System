package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
 

public class main_class extends JFrame implements ActionListener{
    String acctype; 
    String meter_pass;
   // String meter;
    main_class( String acctype,String meter_pass){
        this.acctype=acctype;
        this.meter_pass=meter_pass;
        //this.meter=meter;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image=imageIcon.getImage().getScaledInstance(1370,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel=new JLabel(imageIcon2);
        add(imageLabel);

      
      
       JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu=new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));
     //   menuBar.add(menu);

        JMenuItem newcustomer=new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon customerImg=new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerImage=customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customerImage));
        newcustomer.addActionListener(this);
        menu.add(newcustomer);


        JMenuItem customerdetails=new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon customerdetailsImg=new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerdetailsImage=customerdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(customerdetailsImage));
        customerdetails.addActionListener(this);
        menu.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospace",Font.PLAIN,14));
        ImageIcon depositdetailImg= new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image depositdetailsImage= depositdetailImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(depositdetailsImage));
        depositdetails.addActionListener(this);
        menu.add(depositdetails);


       JMenuItem  calculatebill=new JMenuItem("Calculated Bill");
       calculatebill.setFont(new Font("monospace",Font.PLAIN,14));
       ImageIcon calculteImg=new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
       Image calculateImage=calculteImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       calculatebill.setIcon(new ImageIcon(calculateImage));
       calculatebill.addActionListener(this);
       menu.add(calculatebill);
        

      
       JMenu info =new JMenu("Information");
       info.setFont(new Font("serif",Font.PLAIN,15));
      // menuBar.add(info);

       JMenuItem upinfo=new JMenuItem("Update Information");
       upinfo.setFont(new Font("monospace",Font.PLAIN,14));
       ImageIcon upinfoImg= new ImageIcon( ClassLoader.getSystemResource("icon/refresh.png"));
       Image upinfoImage=upinfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       upinfo.setIcon(new ImageIcon(upinfoImage));
       upinfo.addActionListener(this);
       info.add(upinfo);

       JMenuItem viewInfo=new JMenuItem("View Information");
       viewInfo.setFont(new Font("monospace",Font.PLAIN,14));
       ImageIcon viewInfoImg= new ImageIcon( ClassLoader.getSystemResource("icon/information.png"));
       Image viewInfoImage=viewInfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       viewInfo.setIcon(new ImageIcon(viewInfoImage));
       viewInfo.addActionListener(this);
       info.add(viewInfo);

       JMenu user = new JMenu("User");
       user.setFont(new Font("serif",Font.PLAIN,15));
      // menuBar.add(user);

       JMenuItem paybill=new JMenuItem("Pay Bill");
       paybill.setFont(new Font("monospace",Font.PLAIN,14));
       ImageIcon paybillImg = new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
       Image paybillImage=paybillImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       paybill.setIcon(new ImageIcon(paybillImage));
       paybill.addActionListener(this);
       user.add(paybill);

       JMenuItem billdetails=new JMenuItem("Bill Details");
       paybill.setFont(new Font("monospace",Font.PLAIN,14));
       ImageIcon billdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/detail.png"));
       Image billdetailsImage=billdetailsImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       billdetails.setIcon(new ImageIcon(billdetailsImage));
       billdetails.addActionListener(this);
       user.add(billdetails);

       JMenu bill=new JMenu("Bill");
       bill.setFont(new Font("serif",Font.PLAIN,15));
     //  menuBar.add(bill);

       JMenuItem genbill=new JMenuItem("Generate Bill");
       genbill.setFont(new Font("monospace",Font.PLAIN,14));
       ImageIcon genbillImg = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
       Image genbillImage=genbillImg.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       genbill.setIcon(new ImageIcon(genbillImage));
       genbill.addActionListener(this);
       bill.add(genbill);

       JMenu utility=new JMenu("Utility");
       utility.setFont(new Font("serif",Font.PLAIN,15));
     //  menuBar.add(utility);

       JMenuItem notepad=new JMenuItem("Notepad");
       notepad.setFont(new Font("monospace",Font.PLAIN,15));
       ImageIcon notepadImg= new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
       Image notepadImage= notepadImg.getImage().getScaledInstance(20,20 ,Image.SCALE_DEFAULT);
       notepad.setIcon(new ImageIcon(notepadImage));
       notepad.addActionListener(this);
       utility.add(notepad);

       JMenuItem calculator = new JMenuItem("Calculator");
       calculator.setFont(new Font("monospace",Font.PLAIN,15));
       ImageIcon calculatorImg= new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
       Image calculatorImage= calculatorImg.getImage().getScaledInstance(20,20 ,Image.SCALE_DEFAULT);
       calculator.setIcon(new ImageIcon(calculatorImage));
       calculator.addActionListener(this);
      // calculator.setBackground(nColor.BLUE);
       utility.add(calculator);

       JMenu exit=new JMenu("Exit");
       exit.setFont(new Font("serif",Font.PLAIN,15));
       menuBar.add(exit);

       JMenuItem eexit = new JMenuItem("Exit");
       eexit.setFont(new Font("monospace",Font.PLAIN,15));
       ImageIcon eexitImg= new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
       Image exitImage= eexitImg.getImage().getScaledInstance(20,20 ,Image.SCALE_DEFAULT);
       eexit.setIcon(new ImageIcon(exitImage));
       eexit.addActionListener(this);
       exit.add(eexit);




       if(acctype.equals("Admin")){
        menuBar.add(menu);
       }
        else{
            menuBar.add(bill);
            menuBar.add(user);

        menuBar.add(info);
        
       }
       menuBar.add(utility);
       menuBar.add(exit);
       
       
       
       setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
      String msg =e.getActionCommand();
      if(msg.equals("New Customer")){

        new newCustomer();
      }else if(msg.equals("Customer Details")){

        new customer_details();

      }else if(msg.equals("Deposit Details")){
        new deposite_details();
      }else if(msg.equals("Calculated Bill")){
      new calculate_bill();
      }else if (msg.equals("View Information")){
        new view_information(meter_pass);

      }else if(msg.equals("Update Information")){

        new update_information(meter_pass);
      }else if(msg.equals("Bill Details")){
         new bill_details(meter_pass);
      
      }else if(msg.equals("Calculator")){
        
        try {
          Runtime.getRuntime().exec("calc.exe");
        } catch (Exception E) {
           E.printStackTrace();
        }
      }else if (msg.equals("Notepad")){

      try {
        Runtime.getRuntime().exec("notepad.exe");
      } catch (IOException e1) {
        
        e1.printStackTrace();
      }
      
      }else if(msg.equals("Pay Bill")){
          new pay_bill(meter_pass);
      }else if(msg.equals("Generate Bill")){
        new generate_bill(meter_pass);
      }
      
      
      
      
      else if(msg.equals("Utility")){
        //new utility()


      }else if(msg.equals("Exit")){
        setVisible(false);
       // new Login();
      }


    }
    public static void main(String[] args) {
        new main_class(" "," ");
        
    }
    
}
