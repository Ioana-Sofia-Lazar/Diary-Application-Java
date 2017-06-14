package main;

import classes.Entry;
import classes.Settings;
import classes.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        dialogBox.setVisible(true);
        jDateChooser2.setDate(Calendar.getInstance().getTime());
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
        newEntryAddPhotoButton1 = new javax.swing.JButton();
        newEntryAddPhotoButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        newEntryLocationField = new javax.swing.JTextField();
        newEntryPhotoPathLabel = new javax.swing.JLabel();
        deletePhotoCheckbox = new javax.swing.JCheckBox();
        saveModficationsButton = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        settingsPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        changePasswordButton = new javax.swing.JButton();
        eraseAllDataButton = new javax.swing.JButton();
        deleteAccountButton = new javax.swing.JButton();
        appearancePanel = new javax.swing.JPanel();
        calendarPanel = new javax.swing.JPanel();
        calendarContainerPanel = new javax.swing.JPanel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        timelinePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        addEntryButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        timelineContainerPanel = new javax.swing.JPanel();

        dialogBox.setTitle("Login");
        dialogBox.setLocation(new java.awt.Point(50, 50));
        dialogBox.setMaximumSize(new java.awt.Dimension(329, 411));
        dialogBox.setModal(true);
        dialogBox.setPreferredSize(new java.awt.Dimension(329, 411));
        dialogBox.setResizable(false);
        dialogBox.setSize(new java.awt.Dimension(329, 490));
        dialogBox.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                dialogBoxWindowDeactivated(evt);
            }
        });
        dialogBox.getContentPane().setLayout(new java.awt.CardLayout());

        loginContainer.setLayout(new java.awt.CardLayout());

        loginPanel.setMaximumSize(new java.awt.Dimension(329, 411));
        loginPanel.setMinimumSize(new java.awt.Dimension(329, 411));

        jLabel1.setFont(new java.awt.Font("Freestyle Script", 0, 70)); // NOI18N
        jLabel1.setText("Diary App");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Login");

        loginUsernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Password:");

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        switchToSignupButton.setText("Switch to Signup");
        switchToSignupButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        switchToSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToSignupButtonActionPerformed(evt);
            }
        });

        loginErrorLabel.setForeground(new java.awt.Color(204, 0, 0));
        loginErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(1965, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(1933, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(switchToSignupButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(loginPasswordField)))
                            .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(loginErrorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)))
                .addGap(42, 42, 42))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(switchToSignupButton)
                .addContainerGap(1227, Short.MAX_VALUE))
        );

        loginContainer.add(loginPanel, "card2");

        signupPanel.setMaximumSize(new java.awt.Dimension(329, 411));
        signupPanel.setMinimumSize(new java.awt.Dimension(329, 411));

        jLabel5.setFont(new java.awt.Font("Freestyle Script", 0, 70)); // NOI18N
        jLabel5.setText("Diary App");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Username:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Signup");

        signupUsernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupUsernameFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Password:");

        signupButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signupButton.setText("Sign up");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        switchToLoginButton.setText("Switch to Login");
        switchToLoginButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        switchToLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToLoginButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Confirm password:");

        javax.swing.GroupLayout signupPanelLayout = new javax.swing.GroupLayout(signupPanel);
        signupPanel.setLayout(signupPanelLayout);
        signupPanelLayout.setHorizontalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                        .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(signupUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(signupPasswordField)
                                    .addComponent(confirmSignupPasswordField))
                                .addGap(8, 8, 8))
                            .addComponent(switchToLoginButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(signupErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signupButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(62, 62, 62))))
        );
        signupPanelLayout.setVerticalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signupUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signupPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(confirmSignupPasswordField))
                .addGap(37, 37, 37)
                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(switchToLoginButton)
                .addContainerGap())
        );

        loginContainer.add(signupPanel, "card2");

        dialogBox.getContentPane().add(loginContainer, "card4");

        dialogBox.getAccessibleContext().setAccessibleParent(null);

        changePasswordDialog.setModal(true);
        changePasswordDialog.setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        changePasswordDialog.setSize(new java.awt.Dimension(400, 300));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
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

        deleteAccountDialog.setModal(true);
        deleteAccountDialog.setSize(new java.awt.Dimension(383, 361));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("You are about to permanently delete your account. Keep in mind that you will not be able to reactivate your account and all the data will be lost.\n\nIf you still want to delete your account, please enter your password and click \"Delete my Account\".\n");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
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
                            .addGroup(deleteAccountDialogLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteAccountPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deleteAccountErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(deleteAccountDialogLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
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

        eraseEverythingDialog.setModal(true);
        eraseEverythingDialog.setSize(new java.awt.Dimension(383, 343));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
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
                .addContainerGap(49, Short.MAX_VALUE))
        );

        addEntryDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addEntryDialog.setModal(true);
        addEntryDialog.setSize(new java.awt.Dimension(505, 604));

        jLabel18.setText("New Timeline Entry");

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

        newEntryAddPhotoButton1.setText("Add Audio");
        newEntryAddPhotoButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryAddPhotoButton1ActionPerformed(evt);
            }
        });

        newEntryAddPhotoButton2.setText("Add Video");
        newEntryAddPhotoButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryAddPhotoButton2ActionPerformed(evt);
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
                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                        .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel18))
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addContainerGap()
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
                                                .addComponent(jLabel21)))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEntryDialogLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(cancelNewEntryButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveModficationsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveNewEntryButton)
                                .addGap(93, 93, 93))
                            .addGroup(addEntryDialogLayout.createSequentialGroup()
                                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newEntryLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addEntryDialogLayout.createSequentialGroup()
                                        .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(newEntryAddPhotoButton)
                                            .addComponent(newEntryAddPhotoButton1)
                                            .addComponent(newEntryAddPhotoButton2))
                                        .addGap(99, 99, 99)
                                        .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(newEntryPhotoPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(deletePhotoCheckbox))))
                                .addGap(0, 29, Short.MAX_VALUE)))))
                .addContainerGap())
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
                    .addComponent(newEntryAddPhotoButton)
                    .addComponent(newEntryPhotoPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletePhotoCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newEntryAddPhotoButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newEntryAddPhotoButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(addEntryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveNewEntryButton)
                    .addComponent(cancelNewEntryButton)
                    .addComponent(saveModficationsButton))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(1200, 650));
        setSize(new java.awt.Dimension(1200, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        MenuPanel.setBackground(new java.awt.Color(255, 102, 102));
        MenuPanel.setLayout(new java.awt.GridBagLayout());

        profileButton.setText("Profile");
        profileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        profileButton.setPreferredSize(new java.awt.Dimension(100, 40));
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

        calendarButton.setText("Calendar");
        calendarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calendarButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        calendarButton.setPreferredSize(new java.awt.Dimension(100, 40));
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

        settingsButton.setText("Settings");
        settingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        settingsButton.setPreferredSize(new java.awt.Dimension(100, 40));
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

        appearancelButton.setText("Appearance");
        appearancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        appearancelButton.setMargin(new java.awt.Insets(10, 5, 10, 5));
        appearancelButton.setPreferredSize(new java.awt.Dimension(100, 40));
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

        profilePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePanelMouseClicked(evt);
            }
        });

        chooseProfilePicButton.setText("Choose profile pic");
        chooseProfilePicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseProfilePicButtonActionPerformed(evt);
            }
        });

        profilePicLabel.setBackground(new java.awt.Color(255, 204, 204));

        profileNameField.setEditable(false);
        profileNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        profileNameField.setText("Your Name Here");
        profileNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                profileNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                profileNameFieldFocusLost(evt);
            }
        });

        profileBirthdateField.setEditable(false);
        profileBirthdateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        profileBirthdateField.setText("Your Birthdate Here");
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
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                        .addComponent(chooseProfilePicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(profileBirthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(311, 311, 311))))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseProfilePicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(profileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileBirthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        ContentPanel.add(profilePanel, "card2");

        jLabel11.setText("Account Settings");

        changePasswordButton.setText("Change password");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        eraseAllDataButton.setText("Erase all data from my account");
        eraseAllDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseAllDataButtonActionPerformed(evt);
            }
        });

        deleteAccountButton.setText("Delete my account");
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
                .addGap(293, 293, 293)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteAccountButton)
                    .addComponent(eraseAllDataButton)
                    .addComponent(changePasswordButton)
                    .addComponent(jLabel11))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel11)
                .addGap(52, 52, 52)
                .addComponent(changePasswordButton)
                .addGap(18, 18, 18)
                .addComponent(eraseAllDataButton)
                .addGap(18, 18, 18)
                .addComponent(deleteAccountButton)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        ContentPanel.add(settingsPanel, "card2");

        appearancePanel.setBackground(new java.awt.Color(0, 0, 204));
        appearancePanel.setLayout(new java.awt.GridBagLayout());
        ContentPanel.add(appearancePanel, "card2");

        calendarPanel.setBackground(new java.awt.Color(153, 102, 255));
        calendarPanel.setLayout(new java.awt.BorderLayout());

        calendarContainerPanel.setMaximumSize(new java.awt.Dimension(101, 30));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
        calendarContainerPanel.add(jDateChooser2);

        calendarPanel.add(calendarContainerPanel, java.awt.BorderLayout.WEST);

        timelinePanel.setBackground(new java.awt.Color(102, 255, 102));
        timelinePanel.setMaximumSize(new java.awt.Dimension(800, 500));
        timelinePanel.setMinimumSize(new java.awt.Dimension(800, 500));
        timelinePanel.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Timeline");

        addEntryButton.setText("Add entry");
        addEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryButtonActionPerformed(evt);
            }
        });

        timelineContainerPanel.setAutoscrolls(true);
        timelineContainerPanel.setLayout(new javax.swing.BoxLayout(timelineContainerPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane4.setViewportView(timelineContainerPanel);

        javax.swing.GroupLayout timelinePanelLayout = new javax.swing.GroupLayout(timelinePanel);
        timelinePanel.setLayout(timelinePanelLayout);
        timelinePanelLayout.setHorizontalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addGroup(timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(timelinePanelLayout.createSequentialGroup()
                            .addGap(301, 301, 301)
                            .addComponent(addEntryButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timelinePanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel10)
                            .addGap(23, 23, 23)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        timelinePanelLayout.setVerticalGroup(
            timelinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timelinePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEntryButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        calendarPanel.add(timelinePanel, java.awt.BorderLayout.CENTER);

        ContentPanel.add(calendarPanel, "card2");

        getContentPane().add(ContentPanel, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        Color c1, c2;
        switch(nr) {
            case 0: c1 = Color.decode("#ffffff");
        }
        
        // TODO change components colors
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
                
                dialogBox.setVisible(false);
                
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
            this.dispose();
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
            
            signupPacket p = new signupPacket(user, pass);
            oos.writeObject(p);
            oos.flush();
            int msg = (int) ois.readObject();
            
            if(msg == 1) {
                JOptionPane.showMessageDialog(null, "User successfully created!");
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
                USER.setProfilePic(profilePic);
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
                JOptionPane.showMessageDialog(null, "Account successfully deleted.");
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
        ENTRIES = new HashMap<>();
        
        JOptionPane.showMessageDialog(null, "All entries were successfully deleted.");
        eraseEverythingDialog.dispose();
    }//GEN-LAST:event_saveEraseEverythingButtonActionPerformed

    private void cancelEraseEverythingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEraseEverythingButtonActionPerformed
        eraseEverythingDialog.dispose();
    }//GEN-LAST:event_cancelEraseEverythingButtonActionPerformed

    private void newEntryAddPhotoButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryAddPhotoButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newEntryAddPhotoButton1ActionPerformed

    private void newEntryAddPhotoButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryAddPhotoButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newEntryAddPhotoButton2ActionPerformed

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
        timelineContainerPanel.removeAll();System.out.println("!" + ENTRIES);
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
            }
        }
        Collections.sort(entries, (a,b) -> a.getTime().compareTo(b.getTime())); 
        ENTRIES.put(selectedDate, entries);System.out.println(ENTRIES);
        
        addEntriesForDate(selectedDate);
        addEntryDialog.dispose();
    }//GEN-LAST:event_saveModficationsButtonActionPerformed

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        if(jDateChooser2.getDate() != null) {
            System.out.println(ENTRIES);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(ENTRIES.get(Date.valueOf("2017-06-14")));
            //System.out.println(ENTRIES.get(dateFormat.format(Date.valueOf("2017-06-14"))));
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginContainer;
    private javax.swing.JLabel loginErrorLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JTextField loginUsernameField;
    private javax.swing.JButton newEntryAddPhotoButton;
    private javax.swing.JButton newEntryAddPhotoButton1;
    private javax.swing.JButton newEntryAddPhotoButton2;
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
    private javax.swing.JPanel timelineContainerPanel;
    private javax.swing.JPanel timelinePanel;
    // End of variables declaration//GEN-END:variables
    
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
                
                this.revalidate();
                this.repaint();
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

            setBackground(new java.awt.Color(255, 51, 51));
            setMaximumSize(new java.awt.Dimension(646, 290));
            setMinimumSize(new java.awt.Dimension(646, 290));

            entryTextArea.setEditable(false);
            entryTextArea.setColumns(20);
            entryTextArea.setLineWrap(true);
            entryTextArea.setRows(5);
            entryTextArea.setWrapStyleWord(true);
            jScrollPane1.setViewportView(entryTextArea);

            entryTitleLabel.setText("Title here");

            entryTimeLabel.setText("Time here");

            editEntryButton.setText("...");

            deleteEntryButton.setText("X");
            deleteEntryButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteEntryButtonActionPerformed(evt);
                }
            });
            editEntryButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    editEntryButtonActionPerformed(evt);
                }
            });

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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addComponent(editEntryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteEntryButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(entryTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                                    .addComponent(entryLocationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(entryImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(entryTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editEntryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(deleteEntryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(13, 13, 13)
                    .addComponent(entryTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(entryLocationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(entryImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
        }// </editor-fold>                        

        private void deleteEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
            this.setVisible(false);
            int id = this.getEntry().getId();
            ArrayList<Entry> entries = ENTRIES.get(selectedDate);
            for(Entry e : entries) {
                if(e.getId() == id) {                                        
                    e.setRemoved(true);
                    if(e.getId() <= 0)
                        entries.remove(e);
                }                    
            }
            Collections.sort(entries, (a,b) -> a.getTime().compareTo(b.getTime())); 
            ENTRIES.put(selectedDate, entries);System.out.println(ENTRIES);
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

}
