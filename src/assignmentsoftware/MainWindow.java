package assignmentsoftware;

import connection.DbConnection;
import custombutton.TableActionCellEditor;
import custombutton.TableActionCellRender;
import custombutton.TableActionEvent;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends javax.swing.JFrame {

    private int quantity = 1;
    private float subTotal = 0;
    private float Total = 0;
    private int Discount = 0;
    private int numberOfItems = 0;

    private final String UserName;

    public MainWindow(String un) {
        initComponents();
        
        this.UserName = un;
        start(un);
    }//constructor

    private void start(String un) {
        this.setTitle("Ice Cream Shop");
        SoftwareIcon si = new SoftwareIcon();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(si.getSoftwareIcon())));
        jLabel1.setText(un);
        getCurrentDate();
        getCurrentTime();
        PopupMenu.add(PopupPanel);
        
        TableActionEvent event = (int row) -> {
            if(BillTable.isEditing())
                BillTable.getCellEditor().stopCellEditing();
            DefaultTableModel model = (DefaultTableModel) BillTable.getModel();
            model.removeRow(row);
            numberOfItems -= 1;
        };
        BillTable.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }
    
    public JTable getMainTable() {
        return this.MainIceCreamTable;
    }

    public void getDataFromDB(String query, JTable table) {
        try {
            DbConnection con = new DbConnection();
            ResultSet rs = con.getResultSet(query);
            
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("idicecream"));
                String in = rs.getString("icecreamname");
                String price = rs.getString("price");
                String flv = rs.getString("flavor");
                String type = rs.getString("type");

                String tb[] = {id, in, price, flv, type};
                DefaultTableModel tbmdl = (DefaultTableModel) table.getModel();
                tbmdl.addRow(tb);
            }
            con.closeResources();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkIdentity() {
        String query = "SELECT username FROM users WHERE userid = 1 or userid = 2";

        try {
            DbConnection con = new DbConnection();
            ResultSet rs = con.getResultSet(query);
            
            while (rs.next()) {
                if (rs.getString("username").equals(UserName)) {
                    return true;
                }
            }
            con.closeResources();
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void UpdateAddRemoveItemTable() {
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) AddItemPanelTable.getModel();
        model.setRowCount(0);
        String query = "select * from icecream";
        getDataFromDB(query, AddItemPanelTable);
    }

    private void UpdateUserRegisterTable() {
        String query = "SELECT userid,username FROM users";

        try {
            DbConnection con = new DbConnection();
            ResultSet rs = con.getResultSet(query);

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("userid"));
                String name = rs.getString("username");

                String row[] = {id, name};
                DefaultTableModel tablemodel = (DefaultTableModel) UserTable.getModel();
                tablemodel.addRow(row);
            }
            con.closeResources();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    Timer t;
    SimpleDateFormat dataformat;

    private void getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat smFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dd = smFormat.format(date);
        DateLabel.setText(dd);
    }

    private void getCurrentTime() {
        t = new Timer(0, (ActionEvent e) -> {
            Date dt = new Date();
            dataformat = new SimpleDateFormat("hh:mm:ss a");
            String tt = dataformat.format(dt);
            
            TimeLabel.setText(tt);
        });
        t.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        PopupTable = new javax.swing.JTable();
        PopupMenu = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        TabbedPaneNavigator = new javax.swing.JTabbedPane();
        HomeTabbedPanePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ConesButton = new javax.swing.JButton();
        TubsButton = new javax.swing.JButton();
        ScoopsButton = new javax.swing.JButton();
        PopsicalsButton = new javax.swing.JButton();
        AllIceCreamButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        AddToBillTableButton = new javax.swing.JButton();
        MaxQTYButton = new javax.swing.JButton();
        QuantityLabel = new javax.swing.JLabel();
        MinQTYButton = new javax.swing.JButton();
        SelectedPrice = new javax.swing.JLabel();
        SelectedItem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainIceCreamTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        CheckOutButton = new javax.swing.JButton();
        CancelOrderButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        SubTotalLabel = new javax.swing.JLabel();
        SubTotalAmountLabel = new javax.swing.JLabel();
        DiscountLabel = new javax.swing.JLabel();
        DiscountAmountLabel = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        TotalValueLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        RegisterTabbedPanePanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        AddUserButton = new javax.swing.JButton();
        UserNameLabel = new javax.swing.JLabel();
        UserPasswordLabel = new javax.swing.JLabel();
        CmfUserPassword = new javax.swing.JLabel();
        NewUserNameField = new javax.swing.JTextField();
        UserPasswordField = new javax.swing.JTextField();
        CmfUserPasswordField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        RemoveUserButton = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        RmvUserNameField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        RmvAdminNameField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        RemoveUserPasswordField = new javax.swing.JPasswordField();
        ItemsTabbedPanePanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        AddItemButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        IceCreamNameField = new javax.swing.JTextField();
        IceCreamPriceField = new javax.swing.JTextField();
        IceCreamFlavorField = new javax.swing.JTextField();
        IceCreamTypeField = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        AddItemPanelTable = new javax.swing.JTable();
        RemoveItemButton = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        RemoveItemIDField = new javax.swing.JTextField();
        RemoveItemNameField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        HomeMenuItem = new javax.swing.JMenuItem();
        RegisterUsersMenuItem = new javax.swing.JMenuItem();
        AddRemoveMenuItem = new javax.swing.JMenuItem();
        LogOutMenuItem = new javax.swing.JMenuItem();

        PopupTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Code", "Name", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PopupTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PopupTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(PopupTable);

        javax.swing.GroupLayout PopupPanelLayout = new javax.swing.GroupLayout(PopupPanel);
        PopupPanel.setLayout(PopupPanelLayout);
        PopupPanelLayout.setHorizontalGroup(
            PopupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        PopupPanelLayout.setVerticalGroup(
            PopupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        PopupMenu.setFocusable(false);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TabbedPaneNavigator.setEnabled(false);

        HomeTabbedPanePanel.setBackground(new java.awt.Color(246, 215, 136));
        HomeTabbedPanePanel.setPreferredSize(new java.awt.Dimension(1539, 808));
        HomeTabbedPanePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(262, 664));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ice Cream types");

        ConesButton.setBackground(new java.awt.Color(51, 51, 51));
        ConesButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        ConesButton.setForeground(new java.awt.Color(255, 255, 255));
        ConesButton.setText("Cones");
        ConesButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ConesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        ConesButton.setMaximumSize(new java.awt.Dimension(50, 25));
        ConesButton.setMinimumSize(new java.awt.Dimension(50, 25));
        ConesButton.setPreferredSize(new java.awt.Dimension(50, 30));
        ConesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConesButtonActionPerformed(evt);
            }
        });

        TubsButton.setBackground(new java.awt.Color(51, 51, 51));
        TubsButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        TubsButton.setForeground(new java.awt.Color(255, 255, 255));
        TubsButton.setText("Tubs");
        TubsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TubsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        TubsButton.setMaximumSize(new java.awt.Dimension(50, 25));
        TubsButton.setMinimumSize(new java.awt.Dimension(50, 25));
        TubsButton.setPreferredSize(new java.awt.Dimension(50, 30));
        TubsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TubsButtonActionPerformed(evt);
            }
        });

        ScoopsButton.setBackground(new java.awt.Color(51, 51, 51));
        ScoopsButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        ScoopsButton.setForeground(new java.awt.Color(255, 255, 255));
        ScoopsButton.setText("Scoops");
        ScoopsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ScoopsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        ScoopsButton.setMaximumSize(new java.awt.Dimension(50, 25));
        ScoopsButton.setMinimumSize(new java.awt.Dimension(50, 25));
        ScoopsButton.setPreferredSize(new java.awt.Dimension(50, 30));
        ScoopsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScoopsButtonActionPerformed(evt);
            }
        });

        PopsicalsButton.setBackground(new java.awt.Color(51, 51, 51));
        PopsicalsButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        PopsicalsButton.setForeground(new java.awt.Color(255, 255, 255));
        PopsicalsButton.setText("Popsicals");
        PopsicalsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PopsicalsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        PopsicalsButton.setMaximumSize(new java.awt.Dimension(50, 25));
        PopsicalsButton.setMinimumSize(new java.awt.Dimension(50, 25));
        PopsicalsButton.setPreferredSize(new java.awt.Dimension(50, 30));
        PopsicalsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopsicalsButtonActionPerformed(evt);
            }
        });

        AllIceCreamButton.setBackground(new java.awt.Color(51, 51, 51));
        AllIceCreamButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        AllIceCreamButton.setForeground(new java.awt.Color(255, 255, 255));
        AllIceCreamButton.setText("All");
        AllIceCreamButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AllIceCreamButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        AllIceCreamButton.setMaximumSize(new java.awt.Dimension(50, 25));
        AllIceCreamButton.setMinimumSize(new java.awt.Dimension(50, 25));
        AllIceCreamButton.setPreferredSize(new java.awt.Dimension(50, 30));
        AllIceCreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllIceCreamButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(ConesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TubsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScoopsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PopsicalsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AllIceCreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addComponent(AllIceCreamButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TubsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ScoopsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PopsicalsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        HomeTabbedPanePanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 62, -1, 650));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(703, 664));

        AddToBillTableButton.setBackground(new java.awt.Color(51, 153, 255));
        AddToBillTableButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddToBillTableButton.setForeground(new java.awt.Color(255, 255, 255));
        AddToBillTableButton.setText("Add");
        AddToBillTableButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddToBillTableButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        AddToBillTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToBillTableButtonActionPerformed(evt);
            }
        });

        MaxQTYButton.setBackground(new java.awt.Color(153, 153, 153));
        MaxQTYButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MaxQTYButton.setForeground(new java.awt.Color(255, 255, 255));
        MaxQTYButton.setText("+");
        MaxQTYButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MaxQTYButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        MaxQTYButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxQTYButtonActionPerformed(evt);
            }
        });

        QuantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        MinQTYButton.setBackground(new java.awt.Color(153, 153, 153));
        MinQTYButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MinQTYButton.setForeground(new java.awt.Color(255, 255, 255));
        MinQTYButton.setText("-");
        MinQTYButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MinQTYButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        MinQTYButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinQTYButtonActionPerformed(evt);
            }
        });

        SelectedPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        SelectedItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        MainIceCreamTable.setBackground(new java.awt.Color(255, 255, 255));
        MainIceCreamTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainIceCreamTable.setForeground(new java.awt.Color(0, 0, 0));
        MainIceCreamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Flavor", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MainIceCreamTable.setRowHeight(25);
        MainIceCreamTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainIceCreamTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MainIceCreamTable);

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Item");

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Price");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search");

        SearchTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        SearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SelectedItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(SelectedPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(MinQTYButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(QuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MaxQTYButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AddToBillTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SelectedItem, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(MinQTYButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(QuantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(SelectedPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MaxQTYButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddToBillTableButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        HomeTabbedPanePanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 62, 719, 650));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        CheckOutButton.setBackground(new java.awt.Color(51, 153, 255));
        CheckOutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckOutButton.setForeground(new java.awt.Color(255, 255, 255));
        CheckOutButton.setText("Check out");
        CheckOutButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CheckOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        CheckOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutButtonActionPerformed(evt);
            }
        });

        CancelOrderButton.setBackground(new java.awt.Color(255, 51, 51));
        CancelOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelOrderButton.setText("Cancel");
        CancelOrderButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CancelOrderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        CancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelOrderButtonActionPerformed(evt);
            }
        });

        BillTable.setBackground(new java.awt.Color(255, 255, 255));
        BillTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price", "Quantity", "Amount", "Remove"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BillTable.setRowHeight(25);
        BillTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(BillTable);

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bill");

        SubTotalLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        SubTotalLabel.setForeground(new java.awt.Color(0, 0, 0));
        SubTotalLabel.setText("Sub Total");

        SubTotalAmountLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        SubTotalAmountLabel.setForeground(new java.awt.Color(0, 0, 0));
        SubTotalAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DiscountLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        DiscountLabel.setForeground(new java.awt.Color(0, 0, 0));
        DiscountLabel.setText("Discount");

        DiscountAmountLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        DiscountAmountLabel.setForeground(new java.awt.Color(0, 0, 0));
        DiscountAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TotalLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TotalLabel.setForeground(new java.awt.Color(0, 0, 0));
        TotalLabel.setText("Total");

        TotalValueLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TotalValueLabel.setForeground(new java.awt.Color(0, 0, 0));
        TotalValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DiscountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(CancelOrderButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubTotalAmountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(DiscountAmountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TotalValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(CheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubTotalLabel)
                    .addComponent(SubTotalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiscountLabel)
                    .addComponent(DiscountAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        HomeTabbedPanePanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1066, 62, -1, 650));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("un");
        HomeTabbedPanePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1415, 21, 91, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ice Cream Shop - POS");
        HomeTabbedPanePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 6, 600, -1));

        DateLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateLabel.setText("jLabel10");
        HomeTabbedPanePanel.add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 110, 60));

        TimeLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeLabel.setText("jLabel12");
        HomeTabbedPanePanel.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 110, 60));

        TabbedPaneNavigator.addTab("Home", HomeTabbedPanePanel);

        RegisterTabbedPanePanel.setBackground(new java.awt.Color(246, 215, 136));
        RegisterTabbedPanePanel.setForeground(new java.awt.Color(0, 0, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Register Users");

        AddUserButton.setBackground(new java.awt.Color(60, 161, 155));
        AddUserButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        AddUserButton.setForeground(new java.awt.Color(255, 255, 255));
        AddUserButton.setText("Add");
        AddUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserButtonActionPerformed(evt);
            }
        });

        UserNameLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        UserNameLabel.setText("Name");

        UserPasswordLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        UserPasswordLabel.setForeground(new java.awt.Color(0, 0, 0));
        UserPasswordLabel.setText("Password");

        CmfUserPassword.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        CmfUserPassword.setForeground(new java.awt.Color(0, 0, 0));
        CmfUserPassword.setText("Confirm Password");

        NewUserNameField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        UserPasswordField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        CmfUserPasswordField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        CmfUserPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CmfUserPasswordFieldKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(AddUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UserPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CmfUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addComponent(UserPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(197, 197, 197)
                                    .addComponent(CmfUserPasswordField))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(UserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(NewUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(69, 69, 69)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserNameLabel)
                    .addComponent(NewUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UserPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UserPasswordLabel)))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmfUserPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmfUserPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Unregister Users");

        UserTable.setBackground(new java.awt.Color(255, 255, 255));
        UserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        UserTable.setShowGrid(false);
        jScrollPane3.setViewportView(UserTable);

        RemoveUserButton.setBackground(new java.awt.Color(60, 161, 155));
        RemoveUserButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        RemoveUserButton.setForeground(new java.awt.Color(255, 255, 255));
        RemoveUserButton.setText("Remove");
        RemoveUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveUserButtonActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Name");

        RmvUserNameField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Admin Name");

        RmvAdminNameField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Admin Password");

        RemoveUserPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RemoveUserPasswordFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(RmvUserNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                .addGap(65, 65, 65))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RemoveUserButton)
                                    .addComponent(RmvAdminNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                    .addComponent(RemoveUserPasswordField))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(RmvUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(RmvAdminNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(RemoveUserPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(RemoveUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout RegisterTabbedPanePanelLayout = new javax.swing.GroupLayout(RegisterTabbedPanePanel);
        RegisterTabbedPanePanel.setLayout(RegisterTabbedPanePanelLayout);
        RegisterTabbedPanePanelLayout.setHorizontalGroup(
            RegisterTabbedPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterTabbedPanePanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        RegisterTabbedPanePanelLayout.setVerticalGroup(
            RegisterTabbedPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterTabbedPanePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(RegisterTabbedPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 667, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        TabbedPaneNavigator.addTab("Register", RegisterTabbedPanePanel);

        ItemsTabbedPanePanel.setBackground(new java.awt.Color(246, 215, 136));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(642, 504));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Add an item");

        AddItemButton.setBackground(new java.awt.Color(60, 161, 155));
        AddItemButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        AddItemButton.setForeground(new java.awt.Color(255, 255, 255));
        AddItemButton.setText("Add");
        AddItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemButtonActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Name");

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Price");

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Flavor");

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Type");

        IceCreamNameField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        IceCreamPriceField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        IceCreamFlavorField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        IceCreamTypeField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(AddItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IceCreamNameField)
                    .addComponent(IceCreamPriceField)
                    .addComponent(IceCreamFlavorField)
                    .addComponent(IceCreamTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(IceCreamNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(IceCreamPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(IceCreamFlavorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(IceCreamTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(648, 668));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Remove an item");

        AddItemPanelTable.setBackground(new java.awt.Color(255, 255, 255));
        AddItemPanelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Flavor", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(AddItemPanelTable);

        RemoveItemButton.setBackground(new java.awt.Color(60, 161, 155));
        RemoveItemButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        RemoveItemButton.setForeground(new java.awt.Color(255, 255, 255));
        RemoveItemButton.setText("Remove");
        RemoveItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveItemButtonActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("ID");

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Name");

        RemoveItemIDField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        RemoveItemNameField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RemoveItemButton)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(RemoveItemIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(RemoveItemNameField)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(RemoveItemIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(RemoveItemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(RemoveItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout ItemsTabbedPanePanelLayout = new javax.swing.GroupLayout(ItemsTabbedPanePanel);
        ItemsTabbedPanePanel.setLayout(ItemsTabbedPanePanelLayout);
        ItemsTabbedPanePanelLayout.setHorizontalGroup(
            ItemsTabbedPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemsTabbedPanePanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        ItemsTabbedPanePanelLayout.setVerticalGroup(
            ItemsTabbedPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemsTabbedPanePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(ItemsTabbedPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        TabbedPaneNavigator.addTab("Items", ItemsTabbedPanePanel);

        jMenu1.setText("Menu");

        HomeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        HomeMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignmentsoftware/Icons/Home.png"))); // NOI18N
        HomeMenuItem.setText("Home");
        HomeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(HomeMenuItem);

        RegisterUsersMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        RegisterUsersMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignmentsoftware/Icons/User.png"))); // NOI18N
        RegisterUsersMenuItem.setText("Add / Remove user");
        RegisterUsersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterUsersMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(RegisterUsersMenuItem);

        AddRemoveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        AddRemoveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignmentsoftware/Icons/Items.png"))); // NOI18N
        AddRemoveMenuItem.setText("Add / Remove items");
        AddRemoveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRemoveMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(AddRemoveMenuItem);

        LogOutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignmentsoftware/Icons/Logout.png"))); // NOI18N
        LogOutMenuItem.setText("LogOut");
        LogOutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(LogOutMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPaneNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, 1516, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPaneNavigator, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConesButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) MainIceCreamTable.getModel();
        model.setRowCount(0);
        String query = "select * from icecream where type= 'Cone'";
        getDataFromDB(query, MainIceCreamTable);
    }//GEN-LAST:event_ConesButtonActionPerformed

    private void CheckOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutButtonActionPerformed
        Date date = new Date();
        String headerText = "\t\tIce cream shop\n" + date + "\t" + UserName + "\n";
        String footerText = "\t\tThank You!\n\t\tCome Again";

        try {
            DefaultTableModel model = (DefaultTableModel) BillTable.getModel();
            JTextArea billArea = new JTextArea();
            billArea.setText(headerText);
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < (model.getColumnCount()) - 1; j++) {

                    Object value = model.getValueAt(i, j);
                    if (value!= null) {
                        billArea.setText(billArea.getText() + value.toString() + "\t");
                    } else {
                        billArea.setText(billArea.getText() + "No Data" + "\t");
                    }
                }
                billArea.setText(billArea.getText() + "\n");
            }
            billArea.setText(billArea.getText() + "\n-------------------------------------------------------\n");
            billArea.setText(billArea.getText() + "Subtotal :\t" + SubTotalAmountLabel.getText() + "\n");
            billArea.setText(billArea.getText() + "Discount :\t" +  DiscountAmountLabel.getText() + "\n");
            billArea.setText(billArea.getText() + "Total    :\t" +  TotalValueLabel.getText() + "\n");
            billArea.setText(billArea.getText() + "\n-------------------------------------------------------\n");
            billArea.setText(billArea.getText() + footerText);
            billArea.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Error printing: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CheckOutButtonActionPerformed

    private void MinQTYButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinQTYButtonActionPerformed
        if (quantity > 0) {
            quantity -= 1;
            QuantityLabel.setText(String.valueOf(quantity));
        }
    }//GEN-LAST:event_MinQTYButtonActionPerformed

    private void MaxQTYButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxQTYButtonActionPerformed
        quantity += 1;
        QuantityLabel.setText(String.valueOf(quantity));
    }//GEN-LAST:event_MaxQTYButtonActionPerformed

    private void AddToBillTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToBillTableButtonActionPerformed

        String selectedPriceText = SelectedPrice.getText();
        String quantityLabelText = QuantityLabel.getText();
        DefaultTableModel model = (DefaultTableModel) BillTable.getModel();

        if (!selectedPriceText.isEmpty() &&!quantityLabelText.isEmpty()){
            double selectedPrice = Double.parseDouble(selectedPriceText);
            int qty = Integer.parseInt(quantityLabelText);

            double amount = selectedPrice * qty;
            
            numberOfItems += Integer.valueOf(QuantityLabel.getText());

            model.addRow(new Object[]{SelectedItem.getText(), selectedPrice, qty, amount});
            BillTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        
            CalculateDiscount();
            CalculateSubtotal();
            CalculateTotal();
        }
    }//GEN-LAST:event_AddToBillTableButtonActionPerformed

    public void CalculateTotal() {
        double discountFactor = (100 - Discount) / 100.0;
        Total = (float) (discountFactor * subTotal);
        TotalValueLabel.setText(String.valueOf(Total));
    }

    public void CalculateSubtotal() {
        subTotal = 0;
        for(int i = 0; i < BillTable.getRowCount(); i++){
            int qty = (int) BillTable.getValueAt(i, 2);
            double price = (double) BillTable.getValueAt(i, 3);
            
            subTotal += (qty * price);
        }
        SubTotalAmountLabel.setText(String.valueOf(subTotal));
    }

    public void CalculateDiscount() {
        if (numberOfItems > 0 && numberOfItems < 5){
            Discount = 0;
        }
        if (numberOfItems >= 5 && numberOfItems < 10) {
            Discount = 2;
        }
        if (numberOfItems >= 10 && numberOfItems < 15) {
            Discount = 4;
        }
        if (numberOfItems >= 15) {
            Discount = 6;
        }
        DiscountAmountLabel.setText(String.valueOf(Discount));
    }

    private void ScoopsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScoopsButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) MainIceCreamTable.getModel();
        model.setRowCount(0);
        String query = "select * from icecream where type= 'Scoop'";
        getDataFromDB(query, MainIceCreamTable);
    }//GEN-LAST:event_ScoopsButtonActionPerformed

    private void AllIceCreamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllIceCreamButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) MainIceCreamTable.getModel();
        model.setRowCount(0);
        String query = "select * from icecream";
        getDataFromDB(query, MainIceCreamTable);
    }//GEN-LAST:event_AllIceCreamButtonActionPerformed

    private void TubsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TubsButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) MainIceCreamTable.getModel();
        model.setRowCount(0);
        String query = "select * from icecream where type= 'Tub'";
        getDataFromDB(query, MainIceCreamTable);
    }//GEN-LAST:event_TubsButtonActionPerformed

    private void PopsicalsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopsicalsButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) MainIceCreamTable.getModel();
        model.setRowCount(0);
        String query = "select * from icecream where type= 'Popsical'";
        getDataFromDB(query, MainIceCreamTable);
    }//GEN-LAST:event_PopsicalsButtonActionPerformed

    private void CancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelOrderButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) BillTable.getModel();
        model.setRowCount(0);

        quantity = 1;
        subTotal = 0;
        Total = 0;
        Discount = 0;
        numberOfItems = 0;

        SelectedItem.setText("");
        SelectedPrice.setText("");
        QuantityLabel.setText("");

        DiscountAmountLabel.setText(String.valueOf(Discount));
        SubTotalAmountLabel.setText(String.valueOf(subTotal));
        TotalValueLabel.setText(String.valueOf(Total));
    }//GEN-LAST:event_CancelOrderButtonActionPerformed

    private void HomeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeMenuItemActionPerformed
        if (checkIdentity()) {
            TabbedPaneNavigator.setSelectedIndex(0);
            DefaultTableModel model = (DefaultTableModel) MainIceCreamTable.getModel();
            model.setRowCount(0);
            getDataFromDB("select * from icecream", getMainTable());
        }
    }//GEN-LAST:event_HomeMenuItemActionPerformed

    private void RegisterUsersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterUsersMenuItemActionPerformed
        if (checkIdentity()) {
            TabbedPaneNavigator.setSelectedIndex(1);
            DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
            model.setRowCount(0);
            UpdateUserRegisterTable();
        }
    }//GEN-LAST:event_RegisterUsersMenuItemActionPerformed

    private void LogOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutMenuItemActionPerformed
        this.setVisible(false);
        LoginWindow lw = new LoginWindow();
        lw.setVisible(true);
    }//GEN-LAST:event_LogOutMenuItemActionPerformed

    private void AddRemoveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRemoveMenuItemActionPerformed
        if (checkIdentity()) {
            DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
            model.setRowCount(0);
            UpdateAddRemoveItemTable();
            TabbedPaneNavigator.setSelectedIndex(2);
        }
    }//GEN-LAST:event_AddRemoveMenuItemActionPerformed

    private void AddItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemButtonActionPerformed
        String name = IceCreamNameField.getText();
        String price = IceCreamPriceField.getText();
        String flavor = IceCreamFlavorField.getText();
        String type = IceCreamTypeField.getText();

        int id = 0;
        String maxID = "SELECT MAX(idicecream) FROM icecream";

        try {
            DbConnection con = new DbConnection();
            Statement st = con.getStatement();
            ResultSet rs = con.getResultSet(maxID);

            if (rs.next()) {
                id = rs.getInt(1);
            }
            id += 1;
            String query = "INSERT INTO icecream (idicecream, icecreamname, price, flavor, type) VALUES ('" + id + "','" + name + "','" + price + "','" + flavor + "','" + type + "')";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Item added successfully.");
            con.closeResources();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        IceCreamNameField.setText("");
        IceCreamPriceField.setText("");
        IceCreamFlavorField.setText("");
        IceCreamTypeField.setText("");
        UpdateAddRemoveItemTable();
    }//GEN-LAST:event_AddItemButtonActionPerformed

    private void RemoveItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveItemButtonActionPerformed
        String id = RemoveItemIDField.getText();
        String name = RemoveItemNameField.getText();

        String query = "DELETE FROM icecream WHERE idicecream = '" + id + "' AND icecreamname = '" + name + "'";

        try {
            DbConnection con = new DbConnection();
            Statement st = con.getStatement();

            st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Item removed successfully.");
            
            con.closeResources();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        UpdateAddRemoveItemTable();
    }//GEN-LAST:event_RemoveItemButtonActionPerformed

    private void RemoveUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUserButtonActionPerformed
        RemoveUserAction(); 
    }//GEN-LAST:event_RemoveUserButtonActionPerformed

    private void RemoveUserAction() throws HeadlessException {
        String name = RmvUserNameField.getText();
        String AdName = RmvAdminNameField.getText();
        String AdPwd = new String(RemoveUserPasswordField.getPassword());
        
        String verifyQuery = "SELECT * FROM users WHERE userid = 1 OR userid = 2";
        String query = "DELETE FROM users WHERE username = '" + name + "'";
        
        if (name.isEmpty() || AdName.isEmpty() || AdPwd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            DbConnection con = new DbConnection();
            ResultSet rs = con.getResultSet(verifyQuery);
            
            while (rs.next()) {
                if (rs.getString("username").equals(AdName) && rs.getString("userpassword").equals(AdPwd)) {
                    con.ExecuteUpdate(query);
                    JOptionPane.showMessageDialog(this, "User removed successfully.");
                    
                    RmvUserNameField.setText("");
                    RmvAdminNameField.setText("");
                    RemoveUserPasswordField.setText("");
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Admin credentials not correct!");
                }
            }
            con.closeResources();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);
        UpdateUserRegisterTable();
    }

    private void AddUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserButtonActionPerformed
        AddUserAction();
    }//GEN-LAST:event_AddUserButtonActionPerformed

    private void AddUserAction() throws HeadlessException {
        String nwUsername = NewUserNameField.getText();
        String nwPassword = UserPasswordField.getText();
        String conNewPassword = CmfUserPasswordField.getText();
        
        int userID = 0;
        String maxID = "SELECT MAX(userid) FROM users;";
        
        if (nwUsername.isEmpty() || nwPassword.isEmpty() || conNewPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (nwPassword.equals(conNewPassword)) {
            try {
                DbConnection con = new DbConnection();
                Statement st = con.getStatement();
                
                ResultSet rs = con.getResultSet(maxID);
                if (rs.next()) {
                    userID = rs.getInt(1);
                }
                userID += 1;
                
                String query = "INSERT INTO users (userid , username, userpassword) VALUES('" + userID + "','" + nwUsername + "','" + nwPassword + "')";
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "User added successfully.");
                
                NewUserNameField.setText("");
                UserPasswordField.setText("");
                CmfUserPasswordField.setText("");
                
                con.closeResources();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password does not match!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);
        UpdateUserRegisterTable();
    }

    private void MainIceCreamTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainIceCreamTableMouseClicked
        int selectedIndex = MainIceCreamTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) MainIceCreamTable.getModel();

        SelectedItem.setText(model.getValueAt(selectedIndex, 1).toString());
        SelectedPrice.setText(model.getValueAt(selectedIndex, 2).toString());
        quantity = 1;
        QuantityLabel.setText(String.valueOf(quantity));
    }//GEN-LAST:event_MainIceCreamTableMouseClicked

    private void SearchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyReleased
        try {
            DbConnection con = new DbConnection();

            String search = SearchTextField.getText().trim();
            if (!search.equals("")) {
                PopupMenu.show(SearchTextField, 0, SearchTextField.getHeight());

                String query = "SELECT * FROM icecream WHERE icecreamname LIKE '%" + search + "%'";
                ResultSet rs = con.getResultSet(query);

                DefaultTableModel tablemodel = (DefaultTableModel) PopupTable.getModel();
                tablemodel.setRowCount(0);

                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("idicecream"));
                    String name = rs.getString("icecreamname");
                    String price = rs.getString("price");

                    String tb[] = {id, name, price};
                    tablemodel.addRow(tb);
                }
                rs.close();
            }
            con.closeResources();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SearchTextFieldKeyReleased

    private void PopupTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PopupTableMouseClicked
        int selectedIndex = PopupTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) PopupTable.getModel();

        SelectedItem.setText(model.getValueAt(selectedIndex, 1).toString());
        SelectedPrice.setText(model.getValueAt(selectedIndex, 2).toString());
        quantity = 1;
        QuantityLabel.setText(String.valueOf(quantity));
    }//GEN-LAST:event_PopupTableMouseClicked

    private void CmfUserPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmfUserPasswordFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            AddUserAction();
    }//GEN-LAST:event_CmfUserPasswordFieldKeyPressed

    private void BillTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillTableMouseClicked
        // TODO add your handling code here:
        CalculateSubtotal();
        CalculateDiscount();
        CalculateTotal();
    }//GEN-LAST:event_BillTableMouseClicked

    private void RemoveUserPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RemoveUserPasswordFieldKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            RemoveUserAction();
    }//GEN-LAST:event_RemoveUserPasswordFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemButton;
    private javax.swing.JTable AddItemPanelTable;
    private javax.swing.JMenuItem AddRemoveMenuItem;
    private javax.swing.JButton AddToBillTableButton;
    private javax.swing.JButton AddUserButton;
    private javax.swing.JButton AllIceCreamButton;
    private javax.swing.JTable BillTable;
    private javax.swing.JButton CancelOrderButton;
    private javax.swing.JButton CheckOutButton;
    private javax.swing.JLabel CmfUserPassword;
    private javax.swing.JTextField CmfUserPasswordField;
    private javax.swing.JButton ConesButton;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DiscountAmountLabel;
    private javax.swing.JLabel DiscountLabel;
    private javax.swing.JMenuItem HomeMenuItem;
    private javax.swing.JPanel HomeTabbedPanePanel;
    private javax.swing.JTextField IceCreamFlavorField;
    private javax.swing.JTextField IceCreamNameField;
    private javax.swing.JTextField IceCreamPriceField;
    private javax.swing.JTextField IceCreamTypeField;
    private javax.swing.JPanel ItemsTabbedPanePanel;
    private javax.swing.JMenuItem LogOutMenuItem;
    private javax.swing.JTable MainIceCreamTable;
    private javax.swing.JButton MaxQTYButton;
    private javax.swing.JButton MinQTYButton;
    private javax.swing.JTextField NewUserNameField;
    private javax.swing.JButton PopsicalsButton;
    private javax.swing.JPopupMenu PopupMenu;
    private javax.swing.JPanel PopupPanel;
    private javax.swing.JTable PopupTable;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JPanel RegisterTabbedPanePanel;
    private javax.swing.JMenuItem RegisterUsersMenuItem;
    private javax.swing.JButton RemoveItemButton;
    private javax.swing.JTextField RemoveItemIDField;
    private javax.swing.JTextField RemoveItemNameField;
    private javax.swing.JButton RemoveUserButton;
    private javax.swing.JPasswordField RemoveUserPasswordField;
    private javax.swing.JTextField RmvAdminNameField;
    private javax.swing.JTextField RmvUserNameField;
    private javax.swing.JButton ScoopsButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel SelectedItem;
    private javax.swing.JLabel SelectedPrice;
    private javax.swing.JLabel SubTotalAmountLabel;
    private javax.swing.JLabel SubTotalLabel;
    private javax.swing.JTabbedPane TabbedPaneNavigator;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel TotalValueLabel;
    private javax.swing.JButton TubsButton;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JTextField UserPasswordField;
    private javax.swing.JLabel UserPasswordLabel;
    private javax.swing.JTable UserTable;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables

}
