package com.swingForms;

import com.database.Connector;

import javax.swing.*;
import java.util.ArrayList;
public class SignupPage extends JFrame{
    private JPanel page;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField emailField;
    private JTextField usernameField;
    private JLabel welcome;
    private JLabel fname;
    private JLabel lname;
    private JLabel email;
    private JLabel username;
    private JLabel password;
    private JTextField phoneField;
    private JPasswordField passwordField;
    public JButton signupButton;
    private JPasswordField comfirmField;
    public Connector sqlHandler;
    private ArrayList usernames;

    public void storeData() {
        try {
            if (checkUsername()) {
                passwordField.setEchoChar('\u0000');
                sqlHandler.excute("insert into users value('" + fnameField.getText()
                        + "', '" + lnameField.getText() + "', " +
                        "'" + emailField.getText() + "', " +
                        "'" + usernameField.getText() + "', " +
                        "'" + passwordField.getText() + "', " +
                        "'" + phoneField.getText() + "');");
                passwordField.setEchoChar('*');
            }
            else {
                System.out.println("Username exits");
            }
        } catch (Exception e) {
            System.out.println("Failed to store given data");
        }
    }
    public boolean checkUsername() {
        try {
            usernames = sqlHandler.getUsernames();
            if (!usernames.contains(this.usernameField.getText())) {
                return true;
            }
        }
        catch (Exception e) {
            System.out.println("Failed to check username");
        }
        return false;
    }
    public SignupPage() {
        super("Registration");
        this.setUndecorated(true);
        this.pack();
        this.setContentPane(page);
        this.setResizable(false);
        this.setSize(500, 600);;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.signupButton.setBorder(null);
        this.fnameField.setBorder(null);
        this.lnameField.setBorder(null);
        this.emailField.setBorder(null);
        this.usernameField.setBorder(null);
        this.passwordField.setBorder(null);
        this.comfirmField.setBorder(null);
        this.phoneField.setBorder(null);
//        this.setVisible(true);
        sqlHandler = new Connector();
    }
}
