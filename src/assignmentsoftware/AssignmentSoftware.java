package assignmentsoftware;

import javax.swing.SwingUtilities;

public class AssignmentSoftware {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                LoginWindow lw = new LoginWindow();
                lw.setVisible(true);
            }
        });
    }
}
