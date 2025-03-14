package electricity.billing.system;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;

public class payment_bill extends JFrame implements ActionListener {
    JButton back;
    String meter;

    public payment_bill(String meter) {
        super("Payment Sucess");
      
        
        
        this.meter = meter;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
         
        

        // Open the payment URL
        try {
           URI uri = new URI("https://paytm.com/electricity-bill-payment");
           Desktop.getDesktop().browse(uri);
            
           
        } catch (Exception e) {
            e.printStackTrace();
            j.setContentType("text/html");
            j.setText("<html>Error! Unable to open the payment page.</html>");
        }

       // JScrollPane pane = new JScrollPane();
        //add(pane);
       
      

        
       
       

        // Back button
        back = new JButton("CLICK HERE TO CHECK BILL STATUS");
        back.setBounds(520, 600, 400, 50);
        back.addActionListener(this);
        add(back);

        JLabel wait=new JLabel("Check Bill Payment Status ......");
        wait.setBounds(360,300,1000,100);
        wait.setFont(new Font("Tahoma", Font.BOLD, 50));
        wait.setForeground(Color.BLACK);
        add(wait);

        

       //new Test();
        //je.setVisible(false);

        getContentPane().setBackground(Color.lightGray);

       


        

        
        

      
       
    


        // Frame settings
        setLayout(null);
        setSize(1500, 1200);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() ==back){
           // new Test();
        back.setVisible(false);
        
        

        }
        // Display an intermediate frame before redirecting
        JFrame tempFrame = new JFrame("Redirecting...");
        JLabel message = new JLabel("Please Wait ,For Some Time ", SwingConstants.CENTER);
        tempFrame.getContentPane().setBackground(new Color(80, 204, 204));
        message.setFont(new Font("Tahoma", Font.BOLD, 16));
        tempFrame.add(message);

        
        
        


        tempFrame.setSize(400, 200);
        tempFrame.setLocationRelativeTo(null);
        tempFrame.setVisible(true);

        // Close tempFrame after 3000 milliseconds and open pay_bill frame
        Timer timer = new Timer(1000, event -> {
         tempFrame.setVisible(false);
            tempFrame.dispose();
            new pay_bill(meter); // Open the pay_bill frame
        setVisible(false);   // Close the current frame
        });
      timer.setRepeats(false); // Ensure it runs only once
        timer.start();
    }

    public static void main(String[] args) {
        new payment_bill(" ");
    }
}




