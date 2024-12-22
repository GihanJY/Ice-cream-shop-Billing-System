package connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DbConnection {
    
    private static DbConnection instance;

    private final String configFilePath = ".\\src\\connection\\database_config.txt";
    private final Path absolutePath;
    private final String path;
    
    private String url;
    private String username;
    private String password;
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public static DbConnection getInstance() { // Singleton design pattern
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }
    
    public DbConnection(){
        
        absolutePath = Paths.get(configFilePath).toAbsolutePath();
        path = absolutePath.toString();
        
        this.getInfo();
        this.CreateConnection();
        this.CreateStatement();
    }
    
    private void CreateConnection(){
        try{
            con = DriverManager.getConnection(url, username, password);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void CreateStatement(){
        try{
            if (con != null){
                st = con.createStatement();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet getResultSet(String query) throws SQLException{
        if (st != null){
            rs = st.executeQuery(query);
        }
        else{
            throw new SQLException("Statement is not created");
        }
        return rs;
    }
    
    public Statement getStatement(){
        return st;
    }
    
    public void ExecuteUpdate(String query) throws SQLException{
        st.executeUpdate(query);
    }
    
    public void closeResources() throws SQLException{
        if (rs != null)
            rs.close();
        if (st != null)
            st.close();
        if (con != null)
            con.close();
    }
    
    // get path, username and password
    private void getInfo(){
        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferReader = new BufferedReader(reader);
            String line;
            
            try {
                while ((line = bufferReader.readLine()) != null){
                    String[] keyValue = line.split("=");
                    
                    String key = keyValue[0];
                    String value = keyValue[1];
                    
                    switch (key){
                        case "URL" -> url = value;
                        case "Username" -> username = value;
                        case "Password" -> password = value;
                    }
                }
            } 
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            // Close buffer reader
            try {
                bufferReader.close();
            } 
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error closing buffer reader: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            // Close file reader
            try {
                reader.close();
            } 
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error closing file reader: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
