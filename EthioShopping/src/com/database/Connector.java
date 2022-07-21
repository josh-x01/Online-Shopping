package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Connector {
    public static final String DB_NAME = "shopping";
    public static final String USER = "root";
    public static final String CONNECTION_PASSWORD = "risktaker";
    public static final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/" + DB_NAME;
    public static final String TABLE_NAME = "user";
    public static final String FIRST_NAME = "First Name";
    public static final String LAST_NAME= "Last Name";
    public static final String EMAIL = "E-mail";
    public static final String USER_NAME= "Username";
    public static final String PASSWORD = "Password";
    public static final String PHONE =  "Phone";

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, CONNECTION_PASSWORD);
            statement = connection.createStatement();
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database");
            return false;
        }
    }
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection");;
        }
    }
    public void excute(String sql) {
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void display(String sql) {
        try {
            statement.execute(sql);
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(FIRST_NAME) +
                        " " + resultSet.getString(LAST_NAME) +
                        " " + resultSet.getString(EMAIL) +
                        " " + resultSet.getString(USER_NAME) +
                        " " + resultSet.getString(PASSWORD) +
                        " " + resultSet.getString(PHONE));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Connector () {
        this.open();
        try {
            statement.execute("use shopping;");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public  ArrayList<String> getUsernames() {
        try {
            ArrayList<String> usernames = new ArrayList<>();
            statement.execute("select * from users");
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                usernames.add(resultSet.getString(USER_NAME));
            }
            return usernames;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Hashtable<String, String> verifyAccount() {
        try {
            Hashtable<String, String> verify = new Hashtable<>();
            statement.execute("select * from users");
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                verify.put(resultSet.getString(USER_NAME), resultSet.getString(PASSWORD));
            }
            return verify;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
