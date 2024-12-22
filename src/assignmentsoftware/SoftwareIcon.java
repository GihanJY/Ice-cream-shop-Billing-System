package assignmentsoftware;

import java.net.URL;
import javax.swing.JOptionPane;

public class SoftwareIcon extends javax.swing.JFrame{
    private String image_url;

    public String getSoftwareIcon(){
        try{
            URL imageUrl = getClass().getResource("/assignmentsoftware/Icons/icon.png");

            if (imageUrl == null) {
                JOptionPane.showMessageDialog(null, "icon.png not found in classpath.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                image_url = "/assignmentsoftware/Icons/icon.png";
            }
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, "Error: " + error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return image_url;
    }
}
