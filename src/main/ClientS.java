package main;

import classes.Entry;
import classes.Settings;
import classes.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import packets.closeAppPacket;
import packets.deleteAccountPacket;
import packets.loginPacket;
import packets.loginResponsePacket;
import packets.signupPacket;


public class ClientS extends javax.swing.JFrame {    
    static Connection DBConnection; // connection to the database
    private Socket socket = null;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private HashMap<Date, ArrayList<Entry>> ENTRIES;
    private User USER;
    private Settings SETTINGS;
    private boolean loggedIn = false;
    private Date selectedDate = new Date(Calendar.getInstance().getTimeInMillis()); //today
    
    public ClientS() {
        connectToServer();        
        initComponents();  
        
        ImageIcon img = new ImageIcon("diamond_64px.png");
        this.setIconImage(img.getImage());
        dialogBox.setIconImage(img.getImage());
        changePasswordDialog.setIconImage(img.getImage());
        deleteAccountDialog.setIconImage(img.getImage());
        eraseEverythingDialog.setIconImage(img.getImage());
        addEntryDialog.setIconImage(img.getImage());
        
        dialogBox.setVisible(true);
        jDateChooser2.setDate(Calendar.getInstance().getTime());
        appearancePageLoad();
    }
    
    public boolean connectToServer(){
        try {
            socket = new Socket("localhost", 65535);            
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();        
            JOptionPane.showMessageDialog(null, "Could not connect to server. Try again later.");
            return false;
        }
      
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        dialogBox = new javax.swing.JDialog();
        loginContainer = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginUsernameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        switchToSignupButton = new javax.swing.JButton();
        loginErrorLabel = new javax.swing.JLabel();
        loginPasswordField = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        signupPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        signupUsernameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        switchToLoginButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        signupErrorLabel = new javax.swing.JLabel();
        signupPasswordField = new javax.swing.JPasswordField();
        confirmSignupPasswordField = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        changePasswordDialog = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dialogOldPasswordField = new javax.swing.JPasswordField();
        dialogNewPasswordField = new javax.swing.JPasswordField();
        dialogConfirmPasswordField = new javax.swing.JPasswordField();
        dialogSavePasswordButton = new javax.swing.JButton();
        dialogCancelPasswordButton = new javax.swing.JButton();
        changePasswordErrorLabel = new javax.swing.JLabel();
        deleteAccountDialog = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        deleteAccountPasswordField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        cancelDeleteAccountButton = new javax.swing.JButton();
        deleteAccountErrorLabel = new javax.swing.JLabel();
        eraseEverythingDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        eraseEverythingPasswordField = new javax.swing.JPasswordField();
        saveEraseEverythingButton = new javax.swing.JButton();
        cancelEraseEverythingButton = new javax.swing.JButton();
        eraseEverythingErrorLabel = new javax.swing.JLabel();
        addEntryDialog = new javax.swing.JDialog();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        newEntryTextArea = new javax.swing.JTextArea();
        newEntryTitleField = new javax.swing.JTextField();
        saveNewEntryButton = new javax.swing.JButton();
        cancelNewEntryButton = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        newEntryHourSpinner = new com.toedter.components.JSpinField();
        newEntryMinSpinner = new com.toedter.components.JSpinField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        newEntryAddPhotoButton = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        newEntryLocationField = new javax.swing.JTextField();
        newEntryPhotoPathLabel = new javax.swing.JLabel();
        deletePhotoCheckbox = new javax.swing.JCheckBox();
        saveModficationsButton = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        profileButton = new javax.swing.JButton();
        calendarButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        appearancelButton = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        profilePanel = new javax.swing.JPanel();
        chooseProfilePicButton = new javax.swing.JButton();
        profilePicLabel = new javax.swing.JLabel();
        profileNameField = new javax.swing.JTextField();
        profileBirthdateField = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        settingsPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        changePasswordButton = new javax.swing.JButton();
        eraseAllDataButton = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();
        appearancePanel = new javax.swing.JPanel();
        theme0Label = new javax.swing.JLabel();
        theme1Label = new javax.swing.JLabel();
        theme3Label = new javax.swing.JLabel();
        theme2Label = new javax.swing.JLabel();
        theme0Button = new javax.swing.JButton();
        theme1Button = new javax.swing.JButton();
        theme2Button = new javax.swing.JButton();
        theme3Button = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        calendarPanel = new javax.swing.JPanel();
        calendarContainerPanel = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        timelinePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        addEntryButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        timelineContainerPanel = new javax.swing.JPanel();

        dialogBox.setTitle("Login");
        dialogBox.setLocation(new java.awt.Point(500, 150));
        dialogBox.setMaximumSize(new java.awt.Dimension(445, 542));
        dialogBox.setMinimumSize(new java.awt.Dimension(445, 542));
        dialogBox.setModal(true);
        dialogBox.setPreferredSize(new java.awt.Dimension(445, 542));
        dialogBox.setResizable(false);
        dialogBox.setSize(new java.awt.Dimension(329, 490));
        dialogBox.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                dialogBoxComponentShown(evt);
            }
        });
        dialogBox.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                dialogBoxWindowDeactivated(evt);
            }
        });
        dialogBox.getContentPane().setLayout(new java.awt.CardLayout());

        loginContainer.setMaximumSize(new java.awt.Dimension(445, 542));
        loginContainer.setMinimumSize(new java.awt.Dimension(445, 542));
        loginContainer.setPreferredSize(new java.awt.Dimension(445, 542));
        loginContainer.setLayout(new java.awt.CardLayout());

        loginPanel.setBackground(new java.awt.Color(169, 102, 119));
        loginPanel.setMaximumSize(new java.awt.Dimension(445, 542));
        loginPanel.setMinimumSize(new java.awt.Dimension(445, 542));
        loginPanel.setPreferredSize(new java.awt.Dimension(445, 542));

        jLabel1.setBackground(new java.awt.Color(232, 224, 213));
        jLabel1.setFont(new java.awt.Font("Freestyle Script", 0, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(232, 224, 213));
        jLabel1.setText("Diary App");

        jLabel2.setBackground(new java.awt.Color(232, 224, 213));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(232, 224, 213));
        jLabel2.setText("Username:");

        jLabel3.setBackground(new java.awt.Color(232, 224, 213));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(232, 224, 213));
        jLabel3.setText("Login");

        loginUsernameField.setBackground(new java.awt.Color(169, 102, 119));
        loginUsernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginUsernameField.setForeground(new java.awt.Color(232, 224, 213));
        loginUsernameField.setBorder(null);
        loginUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameFieldActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(232, 224, 213));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(232, 224, 213));
        jLabel4.setText("Password:");

        loginButton.setBackground(new java.awt.Color(212, 201, 209));
        loginButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        switchToSignupButton.setBackground(new java.awt.Color(169, 102, 119));
        switchToSignupButton.setText("Switch to Signup");
        switchToSignupButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        switchToSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToSignupButtonActionPerformed(evt);
            }
        });

        loginErrorLabel.setBackground(new java.awt.Color(153, 0, 0));
        loginErrorLabel.setForeground(new java.awt.Color(153, 0, 0));
        loginErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        loginPasswordField.setBackground(new java.awt.Color(169, 102, 119));
        loginPasswordField.setForeground(new java.awt.Color(232, 224, 213));
        loginPasswordField.setBorder(null);

        jSeparator1.setBackground(new java.awt.Color(212, 201, 209));

        jSeparator2.setBackground(new java.awt.Color(212, 201, 209));

        jLabel26.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\ProiectJava\\Lock_32px.png")); // NOI18N

        jLabel27.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\ProiectJava\\Gender Neutral User_32px.png")); // NOI18N

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(122, 122, 122))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1)
                                .addGroup(loginPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(loginUsernameField))
                                .addGroup(loginPanelLayout.createSequentialGroup()
                                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(loginPasswordField))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGap(6, 6, 6)))
                            .addComponent(loginErrorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(switchToSignupButton)))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel3)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(switchToSignupButton)
                .addGap(40, 40, 40))
        );

        loginContainer.add(loginPanel, "card2");

        signupPanel.setBackground(new java.awt.Color(169, 102, 119));
        signupPanel.setMaximumSize(new java.awt.Dimension(445, 542));
        signupPanel.setMinimumSize(new java.awt.Dimension(445, 542));
        signupPanel.setPreferredSize(new java.awt.Dimension(445, 542));

        jLabel5.setFont(new java.awt.Font("Freestyle Script", 0, 70)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(232, 224, 213));
        jLabel5.setText("Diary App");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(232, 224, 213));
        jLabel6.setText("Username:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(232, 224, 213));
        jLabel7.setText("Signup");

        signupUsernameField.setBackground(new java.awt.Color(169, 102, 119));
        signupUsernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupUsernameField.setForeground(new java.awt.Color(232, 224, 213));
        signupUsernameField.setBorder(null);
        signupUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupUsernameFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(232, 224, 213));
        jLabel8.setText("Password:");

        signupButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupButton.setText("Sign up");
        signupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        switchToLoginButton.setBackground(new java.awt.Color(169, 102, 119));
        switchToLoginButton.setText("Switch to Login");
        switchToLoginButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        switchToLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToLoginButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(232, 224, 213));
        jLabel9.setText("Confirm password:");

        signupErrorLabel.setForeground(new java.awt.Color(153, 0, 0));
        signupErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        signupPasswordField.setBackground(new java.awt.Color(169, 102, 119));
        signupPasswordField.setForeground(new java.awt.Color(232, 224, 213));
        signupPasswordField.setBorder(null);

        confirmSignupPasswordField.setBackground(new java.awt.Color(169, 102, 119));
        confirmSignupPasswordField.setForeground(new java.awt.Color(232, 224, 213));
        confirmSignupPasswordField.setBorder(null);

        jSeparator3.setBackground(new java.awt.Color(212, 201, 209));

        jSeparator4.setBackground(new java.awt.Color(212, 201, 209));

        jSeparator5.setBackground(new java.awt.Color(212, 201, 209));

        jLabel28.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\ProiectJava\\Gender Neutral User_32px.png")); // NOI18N

        jLabel29.setText("jLabel28");

        jLabel30.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\ProiectJava\\Lock_32px.png")); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\ProiectJava\\Password_32px.png")); // NOI18N

        javax.swing.GroupLayout signupPanelLayout = new javax.swing.GroupLayout(signupPanel);
        signupPanel.setLayout(signupPanelLayout);
        signupPanelLayout.setHorizontalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel5))
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(signupPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(signupPasswordField))
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(signupPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(signupUsernameField)))))
                        .addGap(101, 101, 101))
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(switchToLoginButton)
                            .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(signupPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(confirmSignupPasswordField))
                                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(signupPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(signupErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        signupPanelLayout.setVerticalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signupUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signupPasswordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmSignupPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(switchToLoginButton)
                .addGap(23, 23, 23))
        );

        loginContainer.add(signupPanel, "card2");

        dialogBox.getContentPane().add(loginContainer, "card4");

        dialogBox.getAccessibleContext().setAccessibleParent(null);

        changePasswordDialog.setTitle("Change password");
        changePasswordDialog.setBackground(new java.awt.Color(90, 110, 147));
        changePasswordDialog.setIconImage(null);
        changePasswordDialog.setIconImages(null);
        changePasswordDialog.setLocation(new java.awt.Point(500, 150));
        changePasswordDialog.setModal(true);
        changePasswordDialog.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        changePasswordDialog.setSize(new java.awt.Dimension(400, 300));

        jLabel12.setBackground(new java.awt.Color(90, 110, 147));
        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Change Password");

        jLabel13.setText("Old password:");

        jLabel14.setText("New password:");

        jLabel15.setText("Confirm password:");

        dialogSavePasswordButton.setText("Save");
        dialogSavePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogSavePasswordButtonActionPerformed(evt);
            }
        });

        dialogCancelPasswordButton.setText("Cancel");

        javax.swing.GroupLayout changePasswordDialogLayout = new javax.swing.GroupLayout(changePasswordDialog.getContentPane());
        changePasswordDialog.getContentPane().setLayout(changePasswordDialogLayout);
        changePasswordDialogLayout.setHorizontalGroup(
            changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePasswordDialogLayout.createSequentialGroup()
                .addGroup(changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(changePasswordDialogLayout.createSequentialGroup()
                        .addContainerGap(72, Short.MAX_VALUE)
                        .addGroup(changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dialogOldPasswordField)
                            .addComponent(dialogNewPasswordField)
                            .addComponent(dialogConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(changePasswordDialogLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(dialogCancelPasswordButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dialogSavePasswordButton)))
                .addGap(88, 88, 88))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePasswordDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePasswordDialogLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePasswordDialogLayout.createSequentialGroup()
                        .addComponent(changePasswordErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        changePasswordDialogLayout.setVerticalGroup(
            changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordDialogLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(dialogOldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(dialogNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(dialogConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changePasswordErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(changePasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dialogCancelPasswordButton)
                    .addComponent(dialogSavePasswordButton))
                .addGap(26, 26, 26))
        );

        deleteAccountDialog.setTitle("Delete account");
        deleteAccountDialog.setBackground(new java.awt.Color(255, 102, 102));
        deleteAccountDialog.setIconImage(null);
        deleteAccountDialog.setIconImages(null);
        deleteAccountDialog.setLocation(new java.awt.Point(500, 150));
        deleteAccountDialog.setMinimumSize(new java.awt.Dimension(383, 361));
        deleteAccountDialog.setModal(true);
        deleteAccountDialog.setResizable(false);
        deleteAccountDialog.setSize(new java.awt.Dimension(383, 361));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(214, 217, 223));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("You are about to permanently delete your account. Keep in mind that you will not be able to reactivate your account and all the data will be lost.\n\nIf you still want to delete your account, please enter your password and click \"Delete my Account\".\n");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel16.setText("Enter password:");

        jButton1.setText("Delete my Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancelDeleteAccountButton.setText("Cancel");
        cancelDeleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDeleteAccountButtonActionPerformed(evt);
            }
        });

        deleteAccountErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout deleteAccountDialogLayout = new javax.swing.GroupLayout(deleteAccountDialog.getContentPane());
        deleteAccountDialog.getContentPane().setLayout(deleteAccountDialogLayout);
        deleteAccountDialogLayout.setHorizontalGroup(
            deleteAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteAccountDialogLayout.createSequentialGroup()
                .addGroup(deleteAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deleteAccountDialogLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(deleteAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(deleteAccountErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(deleteAccountDialogLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteAccountPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(deleteAccountDialogLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(cancelDeleteAccountButton)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        deleteAccountDialogLayout.setVerticalGroup(
            deleteAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteAccountDialogLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(deleteAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(deleteAccountPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteAccountErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(deleteAccountDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cancelDeleteAccountButton))
                .addGap(37, 37, 37))
        );

        eraseEverythingDialog.setTitle("Erase everything");
        eraseEverythingDialog.setIconImage(null);
        eraseEverythingDialog.setIconImages(null);
        eraseEverythingDialog.setLocation(new java.awt.Point(550, 150));
        eraseEverythingDialog.setMinimumSize(new java.awt.Dimension(383, 349));
        eraseEverythingDialog.setModal(true);
        eraseEverythingDialog.setResizable(false);
        eraseEverythingDialog.setSize(new java.awt.Dimension(383, 349));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(214, 217, 223));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("You are about to permanently erase all the data from your account. \n\nIf you still want to erase everything, please enter your password and click \"Erase all data\".\n");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel17.setText("Enter password:");

        saveEraseEverythingButton.setText("Erase all data");
        saveEraseEverythingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEraseEverythingButtonActionPerformed(evt);
            }
        });

        cancelEraseEverythingButton.setText("Cancel");
        cancelEraseEverythingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEraseEverythingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eraseEverythingDialogLayout = new javax.swing.GroupLayout(eraseEverythingDialog.getContentPane());
        eraseEverythingDialog.getContentPane().setLayout(eraseEverythingDialogLayout);
        eraseEverythingDialogLayout.setHorizontalGroup(
            eraseEverythingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eraseEverythingDialogLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(eraseEverythingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addGroup(eraseEverythingDialogLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eraseEverythingPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eraseEverythingDialogLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(cancelEraseEverythingButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eraseEverythingErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveEraseEverythingButton)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        eraseEverythingDialogLayout.setVerticalGroup(
            eraseEverythingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eraseEverythingDialogLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(eraseEverythingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(eraseEverythingPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(eraseEverythingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eraseEverythingErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eraseEverythingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelEraseEverythingButton)
                        .addComponent(saveEraseEverythingButton)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        addEntryDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addEntryDialog.setTitle("Entry");
        addEntryDialog.setIconImage(null);
        addEntryDialog.setIconImages(null);
        addEntryDialog.setLocation(new java.awt.Point(500, 50));
        addEntryDialog.setModal(true);
        addEntryDialog.setPreferredSize(new java.awt.Dimension(550, 604));
        addEntryDialog.setResizable(false);
        addEntryDialog.setSize(new java.awt.Dimension(550, 604));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel18.setText("Timeline Entry");

        newEntryTextArea.setColumns(20);
        newEntryTextArea.setRows(5);
        jScrollPane3.setViewportView(newEntryTextArea);

        saveNewEntryButton.setText("Save");
        saveNewEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNewEntryButtonActionPerformed(evt);
            }
        });

        cancelNewEntryButton.setText("Cancel");
        cancelNewEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNewEntryButtonActionPerformed(evt);
            }
        });

        jLabel19.setText("Time: ");

        jLabel20.setText("Hour");

        jLabel21.setText("Min");

        newEntryHourSpinner.setMaximum(23);
        newEntryHourSpinner.setMinimum(0);

        newEntryMinSpinner.setMaximum(59);
        newEntryMinSpinner.setMinimum(0);

        jLabel22.setText("Title:");

        jLabel23.setText("Enter your text:");

        newEntryAddPhotoButton.setText("Add Photo");
        newEntryAddPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryAddPhotoButtonActionPerformed(evt);
            }
        });

        jLabel24.setText("Location: ");

        deletePhotoCheckbox.setText("Delete photo");

        saveModficationsButton.setText("Save modifications");
        saveModficationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveModficationsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addEntryDialogLayout = new javax.swing.GroupLayout(addEntryDialog.getContentPane());
        addEntryDialog.getContentPane().setLayout(addEntryDialogLayout);
        addEntryDialogLayout.setHorizontalGroup(
            addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEntryDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                        .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newEntryHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newEntryMinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newEntryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel21))))
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newEntryLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEntryDialogLayout.createSequentialGroup()
                        .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(0, 191, Short.MAX_VALUE))
                                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                                        .addComponent(newEntryAddPhotoButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deletePhotoCheckbox)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newEntryPhotoPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(cancelNewEntryButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveModficationsButton)
                                .addGap(18, 18, 18)
                                .addComponent(saveNewEntryButton)
                                .addGap(63, 63, 63)))
                        .addGap(68, 68, 68))))
            .addGroup(addEntryDialogLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        addEntryDialogLayout.setVerticalGroup(
            addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEntryDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(15, 15, 15)
                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEntryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                        .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEntryDialogLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newEntryMinSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(newEntryHourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(newEntryLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEntryAddPhotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newEntryPhotoPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletePhotoCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveNewEntryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelNewEntryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveModficationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel31.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\ProiectJava\\Lock_32px.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diary App");
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(1200, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        MenuPanel.setBackground(new java.awt.Color(128, 78, 105));
        MenuPanel.setLayout(new java.awt.GridBagLayout());

        profileButton.setBackground(new java.awt.Color(181, 196, 201));
        profileButton.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        profileButton.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\Design\\Icons\\Gender Neutral User_32px.png")); // NOI18N
        profileButton.setToolTipText("Profile");
        profileButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        profileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        profileButton.setPreferredSize(new java.awt.Dimension(70, 55));
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        MenuPanel.add(profileButton, gridBagConstraints);

        calendarButton.setBackground(new java.awt.Color(181, 196, 201));
        calendarButton.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        calendarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Calendar_32px.png"))); // NOI18N
        calendarButton.setToolTipText("Calendar");
        calendarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        calendarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calendarButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        calendarButton.setPreferredSize(new java.awt.Dimension(70, 55));
        calendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        MenuPanel.add(calendarButton, gridBagConstraints);

        settingsButton.setBackground(new java.awt.Color(181, 196, 201));
        settingsButton.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        settingsButton.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\ProiectJava\\Settings_32px.png")); // NOI18N
        settingsButton.setToolTipText("Settings");
        settingsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        settingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        settingsButton.setPreferredSize(new java.awt.Dimension(70, 55));
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        MenuPanel.add(settingsButton, gridBagConstraints);

        appearancelButton.setBackground(new java.awt.Color(181, 196, 201));
        appearancelButton.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        appearancelButton.setIcon(new javax.swing.ImageIcon("D:\\FMI\\AN2\\Sem2\\MDS\\ProiectJava\\Change Theme_32px.png")); // NOI18N
        appearancelButton.setToolTipText("Change theme");
        appearancelButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        appearancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        appearancelButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        appearancelButton.setPreferredSize(new java.awt.Dimension(70, 55));
        appearancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appearancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        MenuPanel.add(appearancelButton, gridBagConstraints);

        getContentPane().add(MenuPanel, java.awt.BorderLayout.WEST);

        ContentPanel.setLayout(new java.awt.CardLayout());

        profilePanel.setBackground(new java.awt.Color(44, 61, 81));
        profilePanel.setMaximumSize(new java.awt.Dimension(1250, 1383));
        profilePanel.setMinimumSize(new java.awt.Dimension(1250, 1383));
        profilePanel.setPreferredSize(new java.awt.Dimension(1250, 1383));
        profilePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePanelMouseClicked(evt);
            }
        });

        chooseProfilePicButton.setBackground(new java.awt.Color(181, 196, 201));
        chooseProfilePicButton.setForeground(new java.awt.Color(44, 61, 81));
        chooseProfilePicButton.setText("Choose profile pic");
        chooseProfilePicButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseProfilePicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseProfilePicButtonActionPerformed(evt);
            }
        });

        profilePicLabel.setBackground(new java.awt.Color(255, 204, 204));

        profileNameField.setEditable(false);
        profileNameField.setBackground(new java.awt.Color(44, 61, 81));
        profileNameField.setForeground(new java.awt.Color(232, 224, 213));
        profileNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        profileNameField.setText("Your Name Here");
        profileNameField.setBorder(null);
        profileNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                profileNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                profileNameFieldFocusLost(evt);
            }
        });

        profileBirthdateField.setEditable(false);
        profileBirthdateField.setBackground(new java.awt.Color(44, 61, 81));
        profileBirthdateField.setForeground(new java.awt.Color(232, 224, 213));
        profileBirthdateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        profileBirthdateField.setText("Your Birthdate Here");
        profileBirthdateField.setBorder(null);
        profileBirthdateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                profileBirthdateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                profileBirthdateFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                .addContainerGap(483, Short.MAX_VALUE)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileBirthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooseProfilePicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(392, 392, 392))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chooseProfilePicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(profileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileBirthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(864, Short.MAX_VALUE))
        );

        ContentPanel.add(profilePanel, "card2");

        settingsPanel.setBackground(new java.awt.Color(44, 61, 81));
        settingsPanel.setPreferredSize(new java.awt.Dimension(1156, 690));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(232, 224, 213));
        jLabel11.setText("Account Settings");

        changePasswordButton.setBackground(new java.awt.Color(181, 196, 201));
        changePasswordButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        changePasswordButton.setForeground(new java.awt.Color(44, 61, 81));
        changePasswordButton.setText("Change password");
        changePasswordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        eraseAllDataButton.setBackground(new java.awt.Color(181, 196, 201));
        eraseAllDataButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        eraseAllDataButton.setForeground(new java.awt.Color(44, 61, 81));
        eraseAllDataButton.setText("Erase all data from my account");
        eraseAllDataButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eraseAllDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseAllDataButtonActionPerformed(evt);
            }
        });

        deleteAccountButton.setBackground(new java.awt.Color(181, 196, 201));
        deleteAccountButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        deleteAccountButton.setForeground(new java.awt.Color(44, 61, 81));
        deleteAccountButton.setText("Delete my account");
        deleteAccountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteAccountButton)
                    .addComponent(eraseAllDataButton)
                    .addComponent(changePasswordButton)
                    .addComponent(jLabel11))
                .addContainerGap(627, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel11)
                .addGap(52, 52, 52)
                .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eraseAllDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1056, Short.MAX_VALUE))
        );

        ContentPanel.add(settingsPanel, "card2");

        appearancePanel.setBackground(new java.awt.Color(44, 61, 81));
        appearancePanel.setMaximumSize(new java.awt.Dimension(1156, 690));
        appearancePanel.setMinimumSize(new java.awt.Dimension(1156, 690));
        appearancePanel.setPreferredSize(new java.awt.Dimension(1156, 690));

        theme0Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        theme1Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        theme3Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        theme2Label.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        theme0Button.setBackground(new java.awt.Color(181, 196, 201));
        theme0Button.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        theme0Button.setForeground(new java.awt.Color(44, 61, 81));
        theme0Button.setText("Apply");
        theme0Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        theme0Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme0ButtonActionPerformed(evt);
            }
        });

        theme1Button.setBackground(new java.awt.Color(181, 196, 201));
        theme1Button.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        theme1Button.setForeground(new java.awt.Color(44, 61, 81));
        theme1Button.setText("Apply");
        theme1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        theme1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme1ButtonActionPerformed(evt);
            }
        });

        theme2Button.setBackground(new java.awt.Color(181, 196, 201));
        theme2Button.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        theme2Button.setForeground(new java.awt.Color(44, 61, 81));
        theme2Button.setText("Apply");
        theme2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        theme2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme2ButtonActionPerformed(evt);
            }
        });

        theme3Button.setBackground(new java.awt.Color(181, 196, 201));
        theme3Button.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        theme3Button.setForeground(new java.awt.Color(44, 61, 81));
        theme3Button.setText("Apply");
        theme3Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        theme3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme3ButtonActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(232, 224, 213));
        jLabel33.setText("Choose a theme");

        javax.swing.GroupLayout appearancePanelLayout = new javax.swing.GroupLayout(appearancePanel);
        appearancePanel.setLayout(appearancePanelLayout);
        appearancePanelLayout.setHorizontalGroup(
            appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appearancePanelLayout.createSequentialGroup()
                .addGroup(appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appearancePanelLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(appearancePanelLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(theme0Button)
                                .addGap(233, 233, 233)
                                .addComponent(theme1Button))
                            .addGroup(appearancePanelLayout.createSequentialGroup()
                                .addGroup(appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(theme0Label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(theme2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(appearancePanelLayout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(theme2Button)))
                                .addGap(52, 52, 52)
                                .addGroup(appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(theme3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(appearancePanelLayout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(theme3Button))
                                    .addComponent(theme1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(appearancePanelLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel33)))
                .addContainerGap(525, Short.MAX_VALUE))
        );
        appearancePanelLayout.setVerticalGroup(
            appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appearancePanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel33)
                .addGap(55, 55, 55)
                .addGroup(appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(theme1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(theme0Label, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(theme0Button)
                    .addComponent(theme1Button))
                .addGap(42, 42, 42)
                .addGroup(appearancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appearancePanelLayout.createSequentialGroup()
                        .addComponent(theme2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(theme2Button))
                    .addGroup(appearancePanelLayout.createSequentialGroup()
                        .addComponent(theme3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(theme3Button)))
                .addContainerGap(802, Short.MAX_VALUE))
        );

        ContentPanel.add(appearancePanel, "card2");

        calendarPanel.setBackground(new java.awt.Color(44, 61, 81));
        calendarPanel.setLayout(new java.awt.BorderLayout());

        calendarContainerPanel.setBackground(new java.awt.Color(44, 61, 81));
        calendarContainerPanel.setMaximumSize(new java.awt.Dimension(170, 127));
        calendarContainerPanel.setMinimumSize(new java.awt.Dimension(170, 127));
        calendarContainerPanel.setPreferredSize(new java.awt.Dimension(180, 127));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(181, 196, 201));
        jLabel25.setText("Choose a date");

        jDateChooser2.setBackground(new java.awt.Color(44, 61, 81));
        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setMaximumSize(new java.awt.Dimension(150, 30));
        jDateChooser2.setMinimumSize(new java.awt.Dimension(150, 30));
        jDateChooser2.setPreferredSize(new java.awt.Dimension(150, 30));
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout calendarContainerPanelLayout = new javax.swing.GroupLayout(calendarContainerPanel);
        calendarContainerPanel.setLayout(calendarContainerPanelLayout);
        calendarContainerPanelLayout.setHorizontalGroup(
            calendarContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarContainerPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calendarContainerPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        calendarContainerPanelLayout.setVerticalGroup(
            calendarContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarContainerPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel25)
                .addGap(34, 34, 34)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        calendarPanel.add(calendarContainerPanel, java.awt.BorderLayout.WEST);

        timelinePanel.setBackground(new java.awt.Color(226, 186, 197));
        timelinePanel.setMaximumSize(new java.awt.Dimension(950, 500));
        timelinePanel.setMinimumSize(new java.awt.Dimension(950, 500));
        timelinePanel.setPreferredSize(new java.awt.Dimension(940, 500));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("Timeline");

        addEntryButton.setBackground(new java.awt.Color(181, 196, 201));
        addEntryButton.setForeground(new java.awt.Color(44, 61, 81));
        addEntryButton.setText("Add entry");
        addEntryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryButtonActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(226, 186, 197));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        timelineContainerPanel.setBackground(new java.awt.Color(226, 186, 197));
        timelineContainerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        timelineContainerPanel.setAutoscrolls(true);
        timelineContainerPanel.setLayout(new javax.swing.BoxLayout(timelineContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane4.setViewportView(timelineContainerPanel);

        javax.swing.GroupLayout timelinePanelLayout = new javax.swing.GroupLayout(timelinePanel);
        timelinePanel.setLayout(timelinePanelLayout);
        timelinePanelLayout.setHorizontalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addGroup(timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(timelinePanelLayout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(jLabel10))
                    .addGroup(timelinePanelLayout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(addEntryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        timelinePanelLayout.setVerticalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addEntryButton)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );

        calendarPanel.add(timelinePanel, java.awt.BorderLayout.CENTER);

        ContentPanel.add(calendarPanel, "card2");

        getContentPane().add(ContentPanel, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void appearancePageLoad() {
        int width = theme0Label.getWidth();
        int height = theme0Label.getHeight();
        ImageIcon icon;
        
        icon = new ImageIcon("theme0.jpg");
        theme0Label.setIcon(scaleImage(icon, width, height));
        
        icon = new ImageIcon("theme1.jpg");
        theme1Label.setIcon(scaleImage(icon, width, height));
        
        icon = new ImageIcon("theme2.jpg");
        theme2Label.setIcon(scaleImage(icon, width, height));
        
        icon = new ImageIcon("theme3.jpg");
        theme3Label.setIcon(scaleImage(icon, width, height));
    }
    
    private void changeCard(String card) {
        ContentPanel.removeAll();
        switch(card){
            case "profile": ContentPanel.add(profilePanel);
                     break;
            case "calendar": ContentPanel.add(calendarPanel);
                     break;
            case "settings":  ContentPanel.add(settingsPanel);
                     break;
            case "appearance": ContentPanel.add(appearancePanel);
                     break;            
        }
        ContentPanel.repaint();
        ContentPanel.revalidate();
    }
    
    private void changeCardDialog(String card) {
        loginContainer.removeAll();
        switch(card){
            case "login": loginContainer.add(loginPanel);
                     break;
            case "signup": loginContainer.add(signupPanel);
                     break;          
        }
        loginContainer.repaint();
        loginContainer.revalidate();
    }
    
    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        changeCard("profile");
    }//GEN-LAST:event_profileButtonActionPerformed

    private void calendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarButtonActionPerformed
        changeCard("calendar");
        addEntriesForDate(selectedDate);
    }//GEN-LAST:event_calendarButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        changeCard("settings");
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void appearancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appearancelButtonActionPerformed
        changeCard("appearance");
    }//GEN-LAST:event_appearancelButtonActionPerformed

    private void loginUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUsernameFieldActionPerformed

    private void applyTheme(int nr) {
        // TODO colors for each theme
        Color c1, c2, c3;
        switch(nr) {
            case 1: c1 = Color.decode("#453832");
                    c2 = Color.decode("#4C5E4B");
                    c3 = Color.decode("#B3BEB1");
                    break;                   
            case 2: c1 = Color.decode("#472E46");
                    c2 = Color.decode("#8B3B49");
                    c3 = Color.decode("#F4E5C5");
                    break;  
            case 3: c1 = Color.decode("#68495D");
                    c2 = Color.decode("#B98B7F");
                    c3 = Color.decode("#F6F1DF");
                    break;       
            default: c1 = Color.decode("#2C3D51"); // fundal
                     c2 = Color.decode("#804E69"); // menu
                     c3 = Color.decode("#E2BAC5"); // fundal timeline
                     break;
        }
        dialogBox.setBackground(c3);
        changePasswordDialog.setBackground(c3);
        deleteAccountDialog.setBackground(c3);
        eraseEverythingDialog.setBackground(c3);
        addEntryDialog.setBackground(c3);
        
        MenuPanel.setBackground(c2);
        
        profilePanel.setBackground(c1);
        profileNameField.setBackground(c1);
        profileBirthdateField.setBackground(c1);
        
        timelinePanel.setBackground(c3);
        timelineContainerPanel.setBackground(c3);
        
        settingsPanel.setBackground(c1);
        
        appearancePanel.setBackground(c1);
    }
    
    private void loadProfile() {
        // profile pic
        int width = profilePicLabel.getWidth();
        int height = profilePicLabel.getHeight();
        profilePicLabel.setIcon(scaleImage(USER.getProfilePic(), width, height));
        
        // name
        profileNameField.setText(USER.getName());
        
        // birthdate
        profileBirthdateField.setText(USER.getBirthdate().toString());
    }
    
    private void loadSettings() {
        // TODO check Send Reminders checkbox if 1
        
        // apply previously selected theme
        applyTheme(SETTINGS.getTheme());
        
        // TODO show which theme is selected on Appearance panel
    }
    
    private void loadAll() {
        loadProfile();
        loadSettings();
        
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            String user = loginUsernameField.getText();
            String pass = String.valueOf(loginPasswordField.getPassword());
            
            loginPacket p = new loginPacket(user, pass);
            oos.writeObject(p);
            oos.flush();
            loginResponsePacket message = (loginResponsePacket) ois.readObject();
            
            if(message.getUser() != null) {
                loggedIn = true;
                ENTRIES = message.getEntries();
                USER = message.getUser();
                SETTINGS = message.getSettings();
                
                System.out.println(USER + "\n" + SETTINGS + "\n" + ENTRIES);
                dialogBox.dispose();
                
                loadAll();              
            }            
            else {
                loginErrorLabel.setText("Credentials are incorrect!");
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    // if we close the login modal we exit the app
    private void dialogBoxWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogBoxWindowDeactivated
        if(loggedIn == false)
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            //this.dispose();
    }//GEN-LAST:event_dialogBoxWindowDeactivated

    private void signupUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signupUsernameFieldActionPerformed

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        try {
            String user = signupUsernameField.getText();
            String pass = String.valueOf(signupPasswordField.getPassword());
            String conf_pass = String.valueOf(confirmSignupPasswordField.getPassword());
            
            if(!(Objects.equals(pass, conf_pass))) {
                signupErrorLabel.setText("Passwords do not match!");
                return;
            }
            
            if(user.equals("") || pass.equals("") || conf_pass.equals("")) {
                signupErrorLabel.setText("Please fill all fields!");
                return;
            }
            
            signupPacket p = new signupPacket(user, pass);
            oos.writeObject(p);
            oos.flush();
            int msg = (int) ois.readObject();
            
            if(msg == 1) {
                JOptionPane.showMessageDialog(null, "User successfully created!");
                loginUsernameField.setText("");
                loginPasswordField.setText("");
                changeCardDialog("login");
                signupUsernameField.setText("");
                signupPasswordField.setText("");
                confirmSignupPasswordField.setText("");
                return;
            }
            if(msg == -1) {
                signupErrorLabel.setText("Username already exists.");
                return;
            }
            JOptionPane.showMessageDialog(null, "Error at signing up.");
            
        } catch (IOException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signupButtonActionPerformed

    private void switchToSignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToSignupButtonActionPerformed
        signupUsernameField.setText("");
        signupPasswordField.setText("");
        confirmSignupPasswordField.setText("");
        changeCardDialog("signup");
    }//GEN-LAST:event_switchToSignupButtonActionPerformed

    private void switchToLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToLoginButtonActionPerformed
        loginUsernameField.setText("");
        loginPasswordField.setText("");
        changeCardDialog("login");
    }//GEN-LAST:event_switchToLoginButtonActionPerformed

    // scales image to width w and height h
    public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w) {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h) {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    
    private void chooseProfilePicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseProfilePicButtonActionPerformed
        JFileChooser profilePicChooser = new JFileChooser();
        int result = profilePicChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = profilePicChooser.getSelectedFile();
            try {
                int width = profilePicLabel.getWidth();
                int height = profilePicLabel.getHeight();
                ImageIcon profilePic = scaleImage(new ImageIcon(ImageIO.read(file)), width, height);
                
                profilePicLabel.setIcon(profilePic);
                profilePicLabel.setHorizontalTextPosition(JLabel.CENTER);
                USER.setProfilePic(profilePic);System.out.println(profilePic);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        profilePicChooser.revalidate();
        profilePicChooser.repaint();
    }//GEN-LAST:event_chooseProfilePicButtonActionPerformed

    private void dialogSavePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogSavePasswordButtonActionPerformed
        String old_pass = String.valueOf(dialogOldPasswordField.getPassword()); 
        String new_pass = String.valueOf(dialogNewPasswordField.getPassword()); 
        String conf_pass = String.valueOf(dialogConfirmPasswordField.getPassword());
        
        if(old_pass.equals("") || !(old_pass.equals(USER.getPassword()))) {
            changePasswordErrorLabel.setText("Old password incorrect!");
            return;
        }
        if(new_pass.equals("") || conf_pass.equals("") || !new_pass.equals(conf_pass)) {
            changePasswordErrorLabel.setText("New password and confirmation password do not match!");
            return;
        }         
        
        USER.setPassword(new_pass);
        JOptionPane.showMessageDialog(null, "Password successfully changed.");
        changePasswordDialog.dispose();
        
        dialogOldPasswordField.setText("");
        dialogNewPasswordField.setText("");
        dialogConfirmPasswordField.setText("");
    }//GEN-LAST:event_dialogSavePasswordButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        changePasswordDialog.setVisible(true);
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    private void profileNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileNameFieldFocusGained
        profileNameField.setEditable(true);
    }//GEN-LAST:event_profileNameFieldFocusGained

    private void profileNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileNameFieldFocusLost
        profileNameField.setEditable(false);
        // save
        USER.setName(profileNameField.getText());
    }//GEN-LAST:event_profileNameFieldFocusLost

    private void profilePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseClicked
        // textfields will lose focus
        profilePanel.requestFocus();
    }//GEN-LAST:event_profilePanelMouseClicked

    private void profileBirthdateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileBirthdateFieldFocusGained
        profileBirthdateField.setEditable(true);
    }//GEN-LAST:event_profileBirthdateFieldFocusGained

    private void profileBirthdateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileBirthdateFieldFocusLost
        profileBirthdateField.setEditable(false);
        // save
        USER.setBirthdate(Date.valueOf(profileBirthdateField.getText()));
    }//GEN-LAST:event_profileBirthdateFieldFocusLost

    private void eraseAllDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseAllDataButtonActionPerformed
        eraseEverythingDialog.setVisible(true);
    }//GEN-LAST:event_eraseAllDataButtonActionPerformed

    private void deleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountButtonActionPerformed
        deleteAccountPasswordField.setText("");
        deleteAccountDialog.setVisible(true);
    }//GEN-LAST:event_deleteAccountButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String pass = String.valueOf(deleteAccountPasswordField.getPassword()); 
        if(!pass.equals(USER.getPassword())) {
            deleteAccountErrorLabel.setText("Incorrect password");
            return;
        }
        
        // password is correct so we send according packet
        try {
            deleteAccountPacket p = new deleteAccountPacket(USER.getId());
            oos.writeObject(p);
            oos.flush();
            
            int response = (int) ois.readObject();
            if(response == 1) {
                JOptionPane.showMessageDialog(null, "Account successfully deleted. Application will automatically close.");
                deleteAccountDialog.dispose();   
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                
                loggedIn = false;
            }
            else {
                JOptionPane.showMessageDialog(null, "Error at deleting account.");
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelDeleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDeleteAccountButtonActionPerformed
        deleteAccountDialog.dispose();
    }//GEN-LAST:event_cancelDeleteAccountButtonActionPerformed

    private void saveEraseEverythingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEraseEverythingButtonActionPerformed
        String pass = String.valueOf(eraseEverythingPasswordField.getPassword()); 
        if(!pass.equals(USER.getPassword())) {
            eraseEverythingErrorLabel.setText("Incorrect password");
            return;
        }
        
        // password is correct so we reset data to defaults data 
        eraseEverythingErrorLabel.setText("");
        // set all entries removed
        Iterator it = ENTRIES.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            ArrayList<Entry> entries = (ArrayList<Entry>) pair.getValue();
            Iterator<Entry> iter = entries.iterator();

            while (iter.hasNext()) {
                Entry e = iter.next();

                if(e.getId() <= 0) {
                    iter.remove();
                } 
                else {
                    e.setRemoved(true);
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "All entries were successfully deleted.");
        eraseEverythingDialog.dispose();
    }//GEN-LAST:event_saveEraseEverythingButtonActionPerformed

    private void cancelEraseEverythingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEraseEverythingButtonActionPerformed
        eraseEverythingDialog.dispose();
    }//GEN-LAST:event_cancelEraseEverythingButtonActionPerformed

    private void newEntryAddPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryAddPhotoButtonActionPerformed
        JFileChooser profilePicChooser = new JFileChooser();
        int result = profilePicChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = profilePicChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            newEntryPhotoPathLabel.setText(path);
        }
        
        profilePicChooser.revalidate();
        profilePicChooser.repaint();
    }//GEN-LAST:event_newEntryAddPhotoButtonActionPerformed

    private void addEntriesForDate(Date date) {
        timelineContainerPanel.removeAll();
        revalidate();
        repaint();
        if(ENTRIES.get(date) != null) { 
            ArrayList<Entry> entries = ENTRIES.get(date);
            Collections.sort(entries, (a,b) -> a.getTime().compareTo(b.getTime())); 
            for(Entry e: entries)
            {
                if(!e.isRemoved()) {
                    EntryPanel panel = new EntryPanel(e);

                    panel.loadData();
                    panel.setVisible(true);             
                    timelineContainerPanel.add(Box.createRigidArea(new Dimension(500, 30))); // space after each entry panel
                    timelineContainerPanel.add(panel);
                     
                    revalidate();
                    repaint();  
                }                    
            } 
        }        
    }
    
    private void saveNewEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNewEntryButtonActionPerformed
        String title = newEntryTitleField.getText();
        String text = newEntryTextArea.getText();
        String location = newEntryLocationField.getText();
        String path = newEntryPhotoPathLabel.getText();
        Time time = new Time(newEntryHourSpinner.getValue(), newEntryMinSpinner.getValue(), 0);
        ImageIcon entryPic = null;
        
        if(!path.equals("")) {
            File file = new File(path);
        
            try {
                int width = 240;
                int height = 150;
                entryPic = scaleImage(new ImageIcon(ImageIO.read(file)), width, height);            
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Entry newEntry = new Entry(0, title, text, selectedDate, time, entryPic, location, false);
        // add it to ENTRIES
        if(ENTRIES.get(newEntry.getDate()) != null) { // the date already exists in the hashmap
            ArrayList<Entry> en = ENTRIES.get(newEntry.getDate());
            en.add(newEntry);
            
            Collections.sort(en, (a,b) -> a.getTime().compareTo(b.getTime())); 
            ENTRIES.put(newEntry.getDate(), en);
        }
        else {
            ArrayList<Entry> en = new ArrayList<>();
            en.add(newEntry);   
            ENTRIES.put(newEntry.getDate(), en);
        }
        addEntriesForDate(newEntry.getDate());
        addEntryDialog.dispose();
    }//GEN-LAST:event_saveNewEntryButtonActionPerformed

    private void addEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryButtonActionPerformed
        setAddEntryFields("", "", 0, 0, "", "");
        saveModficationsButton.setVisible(false);
        saveNewEntryButton.setVisible(true);
        deletePhotoCheckbox.setVisible(false);
        addEntryDialog.setVisible(true);
        
    }//GEN-LAST:event_addEntryButtonActionPerformed

    private void saveModficationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveModficationsButtonActionPerformed
        int id = editingEntryId;
        
        String title = newEntryTitleField.getText();
        String text = newEntryTextArea.getText();
        String location = newEntryLocationField.getText();
        boolean delPhoto = deletePhotoCheckbox.isSelected();
        String path = newEntryPhotoPathLabel.getText();
        Time time = new Time(newEntryHourSpinner.getValue(), newEntryMinSpinner.getValue(), 0);
        ImageIcon entryPic = null;
        
        ArrayList<Entry> entries = ENTRIES.get(selectedDate);
        for(Entry e : entries) {
            if(e.getId() == id) {
                e.setTitle(title);
                e.setText(text);
                e.setLocation(location);
                e.setTime(time);
                if(!path.equals("")) {
                    File file = new File(path);

                    try {
                        int width = 240;
                        int height = 150;
                        entryPic = scaleImage(new ImageIcon(ImageIO.read(file)), width, height);            
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
                if(delPhoto)
                    e.setPic(null);
                e.setAdded(false);
            }
        }
        Collections.sort(entries, (a,b) -> a.getTime().compareTo(b.getTime())); 
        ENTRIES.put(selectedDate, entries);
        
        addEntriesForDate(selectedDate);
        addEntryDialog.dispose();
    }//GEN-LAST:event_saveModficationsButtonActionPerformed

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        if(jDateChooser2.getDate() != null) {            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(new Date(jDateChooser2.getDate().getTime()));
            Date d = Date.valueOf(date);
            addEntriesForDate(d);
            selectedDate = d;
        }           
        
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void cancelNewEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNewEntryButtonActionPerformed
        addEntryDialog.dispose();
    }//GEN-LAST:event_cancelNewEntryButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            closeAppPacket p = new closeAppPacket(ENTRIES, USER, SETTINGS);
            oos.writeObject(p);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void theme0ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme0ButtonActionPerformed
        SETTINGS.setTheme(0);
        applyTheme(0);
    }//GEN-LAST:event_theme0ButtonActionPerformed

    private void theme1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme1ButtonActionPerformed
        SETTINGS.setTheme(1);
        applyTheme(1);
    }//GEN-LAST:event_theme1ButtonActionPerformed

    private void theme2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme2ButtonActionPerformed
        SETTINGS.setTheme(2);
        applyTheme(2);
    }//GEN-LAST:event_theme2ButtonActionPerformed

    private void theme3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme3ButtonActionPerformed
        SETTINGS.setTheme(3);
        applyTheme(3);
    }//GEN-LAST:event_theme3ButtonActionPerformed

    private void dialogBoxComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_dialogBoxComponentShown
        loginUsernameField.setText("");
        loginPasswordField.setText("");
        signupUsernameField.setText("");
        signupPasswordField.setText("");
        confirmSignupPasswordField.setText("");
    }//GEN-LAST:event_dialogBoxComponentShown

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientS().setVisible(true);
            }
        });
        
    }

    private void setAddEntryFields(String title, String location, int h, int m, String text, String path) {
        newEntryTitleField.setText(title);
        newEntryLocationField.setText(location);
        newEntryHourSpinner.setValue(h);
        newEntryMinSpinner.setValue(m);
        newEntryTextArea.setText(text);
        newEntryPhotoPathLabel.setText(path);
    }
    
    // ======================================================
    private int editingEntryId = 0;
    private class EntryPanel extends javax.swing.JPanel {

        private Entry entry;

        public EntryPanel(Entry entry) {
            this.entry = entry;
            initComponents();
        }

        public JButton getDeleteEntryButton() {
            return deleteEntryButton;
        }

        public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
            int nw = icon.getIconWidth();
            int nh = icon.getIconHeight();

            if(icon.getIconWidth() > w) {
              nw = w;
              nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
            }

            if(nh > h) {
              nh = h;
              nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
            }

            return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
        }

        public void loadData(){
            entryTitleLabel.setText(entry.getTitle());
            entryTextArea.setText(entry.getText());
            entryLocationLabel.setText(entry.getLocation());
            entryTimeLabel.setText(entry.getTime().toString());

            if(entry.getPic() != null) {
                int width = 240;
                int height = 150;
                entryImageLabel.setPreferredSize(new Dimension(width, height));
               
                entryImageLabel.setIcon(scaleImage(entry.getPic(), width, height));
                this.setPreferredSize(new Dimension(width, 500));
                
                this.validate();
            }
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        entryTextArea = new javax.swing.JTextArea();
        entryTitleLabel = new javax.swing.JLabel();
        entryTimeLabel = new javax.swing.JLabel();
        entryImageLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        editEntryButton = new javax.swing.JButton();
        deleteEntryButton = new javax.swing.JButton();
        entryLocationLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(44, 61, 81));
        setMaximumSize(new java.awt.Dimension(646, 455));
        setMinimumSize(new java.awt.Dimension(646, 290));
        setPreferredSize(new java.awt.Dimension(646, 290));

        entryTextArea.setEditable(false);
        entryTextArea.setBackground(new java.awt.Color(232, 224, 213));
        entryTextArea.setColumns(20);
        entryTextArea.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        entryTextArea.setForeground(new java.awt.Color(44, 61, 81));
        entryTextArea.setLineWrap(true);
        entryTextArea.setRows(5);
        entryTextArea.setText("amdbba da;lmd/lnk\nd\nd\na\nd\na");
        entryTextArea.setWrapStyleWord(true);
        entryTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        entryTextArea.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jScrollPane1.setViewportView(entryTextArea);

        entryTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entryTitleLabel.setForeground(new java.awt.Color(181, 196, 201));
        entryTitleLabel.setText("Title here");

        entryTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entryTimeLabel.setForeground(new java.awt.Color(181, 196, 201));
        entryTimeLabel.setText("Time here");

        jSeparator1.setForeground(new java.awt.Color(232, 224, 213));

        editEntryButton.setBackground(new java.awt.Color(181, 196, 201));
        editEntryButton.setForeground(new java.awt.Color(44, 61, 81));
        editEntryButton.setText("...");
        editEntryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEntryButtonActionPerformed(evt);
            }
        });

        deleteEntryButton.setBackground(new java.awt.Color(181, 196, 201));
        deleteEntryButton.setForeground(new java.awt.Color(44, 61, 81));
        deleteEntryButton.setText("X");
        deleteEntryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEntryButtonActionPerformed(evt);
            }
        });

        entryLocationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        entryLocationLabel.setForeground(new java.awt.Color(181, 196, 201));
        entryLocationLabel.setText("Location here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(entryTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(editEntryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteEntryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(entryTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                                .addComponent(entryLocationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(entryImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(entryTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editEntryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(deleteEntryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(entryTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryLocationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(entryImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>  
    
        private void deleteEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
            this.setVisible(false);
            int id = this.getEntry().getId();
            ArrayList<Entry> entries = ENTRIES.get(selectedDate);
            Iterator<Entry> iter = entries.iterator();

            while (iter.hasNext()) {
                Entry e = iter.next();
                if(e.getId() == id) {                                        
                    e.setRemoved(true);
                    if(e.getId() <= 0)
                        iter.remove();
                } 
            }

            Collections.sort(entries, (a,b) -> a.getTime().compareTo(b.getTime())); 
            ENTRIES.put(selectedDate, entries);
            addEntriesForDate(selectedDate);
        }  
                
        private void editEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {
            saveModficationsButton.setVisible(true);
            saveNewEntryButton.setVisible(false);
            editingEntryId = entry.getId();            
            setAddEntryFields(entry.getTitle(), entry.getLocation(), entry.getTime().getHours(), entry.getTime().getMinutes(), entry.getText(), "");
            deletePhotoCheckbox.setVisible(true);
            addEntryDialog.setVisible(true);
        }  

        public Entry getEntry() {
            return this.entry;
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton deleteEntryButton;
        private javax.swing.JButton editEntryButton;
        private javax.swing.JLabel entryImageLabel;
        private javax.swing.JLabel entryLocationLabel;
        private javax.swing.JTextArea entryTextArea;
        private javax.swing.JLabel entryTimeLabel;
        private javax.swing.JLabel entryTitleLabel;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JSeparator jSeparator1;
        // End of variables declaration                   
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton addEntryButton;
    private javax.swing.JDialog addEntryDialog;
    private javax.swing.JPanel appearancePanel;
    private javax.swing.JButton appearancelButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton calendarButton;
    private javax.swing.JPanel calendarContainerPanel;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JButton cancelDeleteAccountButton;
    private javax.swing.JButton cancelEraseEverythingButton;
    private javax.swing.JButton cancelNewEntryButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JDialog changePasswordDialog;
    private javax.swing.JLabel changePasswordErrorLabel;
    private javax.swing.JButton chooseProfilePicButton;
    private javax.swing.JPasswordField confirmSignupPasswordField;
    private javax.swing.JButton deleteAccountButton;
    private javax.swing.JDialog deleteAccountDialog;
    private javax.swing.JLabel deleteAccountErrorLabel;
    private javax.swing.JPasswordField deleteAccountPasswordField;
    private javax.swing.JCheckBox deletePhotoCheckbox;
    private javax.swing.JDialog dialogBox;
    private javax.swing.JButton dialogCancelPasswordButton;
    private javax.swing.JPasswordField dialogConfirmPasswordField;
    private javax.swing.JPasswordField dialogNewPasswordField;
    private javax.swing.JPasswordField dialogOldPasswordField;
    private javax.swing.JButton dialogSavePasswordButton;
    private javax.swing.JButton eraseAllDataButton;
    private javax.swing.JDialog eraseEverythingDialog;
    private javax.swing.JLabel eraseEverythingErrorLabel;
    private javax.swing.JPasswordField eraseEverythingPasswordField;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginContainer;
    private javax.swing.JLabel loginErrorLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JTextField loginUsernameField;
    private javax.swing.JButton newEntryAddPhotoButton;
    private com.toedter.components.JSpinField newEntryHourSpinner;
    private javax.swing.JTextField newEntryLocationField;
    private com.toedter.components.JSpinField newEntryMinSpinner;
    private javax.swing.JLabel newEntryPhotoPathLabel;
    private javax.swing.JTextArea newEntryTextArea;
    private javax.swing.JTextField newEntryTitleField;
    private javax.swing.JTextField profileBirthdateField;
    private javax.swing.JButton profileButton;
    private javax.swing.JTextField profileNameField;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JButton saveEraseEverythingButton;
    private javax.swing.JButton saveModficationsButton;
    private javax.swing.JButton saveNewEntryButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel signupErrorLabel;
    private javax.swing.JPanel signupPanel;
    private javax.swing.JPasswordField signupPasswordField;
    private javax.swing.JTextField signupUsernameField;
    private javax.swing.JButton switchToLoginButton;
    private javax.swing.JButton switchToSignupButton;
    private javax.swing.JButton theme0Button;
    private javax.swing.JLabel theme0Label;
    private javax.swing.JButton theme1Button;
    private javax.swing.JLabel theme1Label;
    private javax.swing.JButton theme2Button;
    private javax.swing.JLabel theme2Label;
    private javax.swing.JButton theme3Button;
    private javax.swing.JLabel theme3Label;
    private javax.swing.JPanel timelineContainerPanel;
    private javax.swing.JPanel timelinePanel;
    // End of variables declaration//GEN-END:variables

}
