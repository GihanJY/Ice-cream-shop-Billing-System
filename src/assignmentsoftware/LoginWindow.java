package assignmentsoftware;

import connection.DbConnection; // Get DataBase Connection
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginWindow extends javax.swing.JFrame {
    
    private String userName;
    private String passWord;

    public LoginWindow() {
        initComponents();
        start();
    }
    
    private void start(){
        this.setTitle("Ice Cream Shop");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        SoftwareIcon si = new SoftwareIcon();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(si.getSoftwareIcon())));
    }
    
    private void perform_Login(){
        userName = Username_field.getText();
        passWord = new String(Password_Field.getPassword());

        if (userName.equals("") || passWord.equals("")){
            JOptionPane.showMessageDialog(null, "The username or password field is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            DbConnection con = new DbConnection();
            String query = "SELECT * FROM users WHERE username = '"+userName+"'and userpassword = '"+ passWord +"'";
            ResultSet rs = con.getResultSet(query);

            if(rs.next()){
                MainWindow mw = new MainWindow(userName);
                mw.setExtendedState(JFrame.MAXIMIZED_BOTH);
                mw.getDataFromDB("select * from icecream", mw.getMainTable());
                mw.setLocationRelativeTo(null);
                mw.setSize(1540, 820);
                mw.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Username or password wrong..", "Error", JOptionPane.ERROR_MESSAGE);
                Username_field.setText("");
                Password_Field.setText("");
            }
            con.closeResources();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Username_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        Password_Field = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(246, 215, 136));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Log in");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Username");

        Username_field.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password");

        LoginButton.setBackground(new java.awt.Color(60, 161, 155));
        LoginButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Log in");
        LoginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        Password_Field.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        Password_Field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Password_FieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Username_field)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Password_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Username_field, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        perform_Login();
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void Password_FieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Password_FieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            perform_Login();
        }
    }//GEN-LAST:event_Password_FieldKeyPressed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField Password_Field;
    private javax.swing.JTextField Username_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
