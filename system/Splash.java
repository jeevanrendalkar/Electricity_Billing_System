package electricity.billing.system;
import javax.swing.*;
public class Splash extends JFrame
{
    Splash()   {
        System.out.println("Inside Splash Start");

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/Splash/Splash.png"));
        java.awt.Image imageOne =imageIcon.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 =new ImageIcon(imageOne);

        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);
        

        setSize(700,500);
        setLocation(420,200 );
        setVisible(true); 
        try{
            Thread.sleep(3000);
            setVisible(false);

           

        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("Inside Splash end");




    }        
public static void main(String[] args) {
   System.out.println("Someone  Has Started the application");
   
    new Splash();
    new Login();
}
    
}