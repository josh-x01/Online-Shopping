package com.swingForms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import com.shopping.ShoppingPage;


public class LoginPage extends JFrame {
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signin;
    private JButton signup;
    private JLabel username;
    private JLabel password;
    private JButton closeButton;
    private JLabel welcome;
    private JCheckBox showPassword;
    byte counter = 0;
    private JFrame signupPage;
    private JFrame errorPage;

    public void changeWelcome() {
        this.welcome.setText("Now you can login in with new account");
    }
    public boolean validUser() {
        ArrayList<String> accouts = ((SignupPage) signupPage).sqlHandler.getUsernames();
        if (accouts.contains(usernameField.getText())) {
            return true;
        }
        else {return false;}
    }

    public byte verifyAccount() {
        Hashtable<String, String> accounts = ((SignupPage) signupPage).sqlHandler.verifyAccount();
        if(validUser()) {
            if (accounts.get(String.valueOf(usernameField.getText())).equals(passwordField.getText())) {
                return 0;
            } else {
                return 1;
            }
        }
        return -1;
    }
    public void loginChecker() {
        switch (verifyAccount()) {
            case 0:
                LoginPage.super.dispose();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ShoppingPage().setVisible(true);
                    }
                });
                break;
            case 1:
                ((ErrorFrame) errorPage).messageField.setText("Incorrect Password");
                errorPage.setSize(230, 200);
                errorPage.setVisible(true);
                break;
            case -1:
                ((ErrorFrame) errorPage).messageField.setText("Username not found! Please create an account");
                errorPage.setSize(400, 200);
                errorPage.setVisible(true);
                break;
        }
    }
    public void signupChecker() {
        if (!((SignupPage) signupPage).checkRequiredField()) {
            ((ErrorFrame ) errorPage).messageField.setText("All fields are required except mobile number");
            errorPage.setSize(400, 160);
            errorPage.setVisible(true);
            return;
        }
        if (!((SignupPage) signupPage).isValidEmail()) {
            ((ErrorFrame) errorPage).messageField.setText("Invalid Email address!");
            errorPage.setSize(230, 160);
            errorPage.setVisible(true);
            return;
        }
        if (!((SignupPage) signupPage).checkUsername()) {
            ((ErrorFrame ) errorPage).messageField.setText("Username exists");
            errorPage.setSize(220, 160);
            errorPage.setVisible(true);
            return;
        }
        if (!((SignupPage) signupPage).passwordMatch()) {
            ((ErrorFrame) errorPage).messageField.setText("Password don't match!");
            errorPage.setSize(230, 160);
            errorPage.setVisible(true);
            return;
        }
        if (!((SignupPage) signupPage).isValidMobileNo()) {
            ((ErrorFrame) errorPage).messageField.setText("Invalid mobile number!");
            errorPage.setSize(230, 160);
            errorPage.setVisible(true);
            return;
        }
        signupPage.dispose();

        LoginPage.super.setVisible(true);
        ((SignupPage) signupPage).storeData();
        changeWelcome();
    }
    public LoginPage() {
        super("Swing demo");
        this.setUndecorated(true);
        this.pack();
//        LineBorder lb = new LineBorder(new Color(43,45,65), 8, true);
        this.setContentPane(panel);
        this.setResizable(false);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        signupPage = new SignupPage();
        errorPage = new ErrorFrame();
        errorPage.setVisible(false);
        this.passwordField.setEchoChar('*');
        this.passwordField.setBorder(null);
        this.usernameField.setBorder(null);
        this.showPassword.setBorder(null);
        this.signin.setBorder(null);
        this.signup.setBorder(null);
        this.closeButton.setBorder(null);
        this.passwordField.setEchoChar('*');
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((SignupPage) signupPage).sqlHandler.close();
                System.exit(0);
            }
        });
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter % 2 == 0) {
                    passwordField.setEchoChar('\u0000');
                } else {
                    passwordField.setEchoChar('*');
                }
                counter += 1;
            }
        });
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage.super.setVisible(false);
                signupPage.setVisible(true);
            }
        });
        ((SignupPage) signupPage).signupButton.addActionListener(new ActionListener() {
            //                    @Override
            public void actionPerformed(ActionEvent e) {
                signupChecker();;
            }
        });
        ((SignupPage) signupPage).phoneField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signupChecker();
            }
        });

        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginChecker();
            }
        });
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginChecker();
            }
        });
    }
}