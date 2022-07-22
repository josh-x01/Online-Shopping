package com.swingForms;

import com.database.Connector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public JTextField phoneField;
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
    public boolean passwordMatch() {
        passwordField.setEchoChar('\u0000');
        comfirmField.setEchoChar('\u0000');
        if (passwordField.getText().equals(comfirmField.getText())) {
            passwordField.setEchoChar('*');
            comfirmField.setEchoChar('*');
            return true;
        }
        else {
            passwordField.setEchoChar('*');
            comfirmField.setEchoChar('*');
            return false;
        }
    }
    public boolean checkRequiredField() {
        passwordField.setEchoChar('\u0000');
        if (fnameField.getText().equals("") || lnameField.getText().equals("") ||
                emailField.getText().equals("") || usernameField.getText().equals("") ||
                passwordField.getText().equals("")
        ) {passwordField.setEchoChar('*'); return false;}
        passwordField.setEchoChar('*');
        return true;
    }
//    public boolean validPhoneNumber() {
//        if(phoneField.getText().length() != 10) return false;
//        if(phoneField.getText().contains()) return false;
//    }


    public boolean isValidMobileNo()
    {
        String s = phoneField.getText();

        // The given argument to compile() method
        // is regular expression. With the help of
        // regular expression we can validate mobile
        // number.
        // The number should be of 10 digits.

        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d{10}$");

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression for which
        // object of Matcher class is created
        Matcher m = p.matcher(s);

        // Returning boolean value
        return (m.matches());
    }
    public boolean isValidEmail()
    {
        String email = emailField.getText();
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
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
        this.passwordField.setEchoChar('*');
        this.comfirmField.setEchoChar('*');
//        this.setVisible(true);
        sqlHandler = new Connector();
        phoneField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
