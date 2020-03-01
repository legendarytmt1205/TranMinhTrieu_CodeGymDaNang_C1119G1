package com.aptech.ulti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tuann
 */
public final class MSSQLConnection{
    private static Connection con = null;
    private static final String url = "jdbc:sqlserver://";
    private static final String serverName = "localhost";
    private static final String portNumber = "1433";
    private static final String database = "loginJdbc";
    private static final String username = "sa";
    private static final String password = "123";

    public MSSQLConnection() {
        
    }
    public static String getConnectionUrl() {
        return url + serverName + ":" + portNumber + "; databaseName="
                + database + "; username=" + username + "; password=" + password;
    }


    public Connection getConnection() throws Exception {

        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(getConnectionUrl());
        } catch (Exception e) {
            con = null;
            throw new Exception(e.getMessage());
        }
        return con;
    }

    public boolean execute(String strQuery) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            st.execute(strQuery);

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return false;
        } finally {
            conn.close();
        }
        return true;
    }

    public ResultSet query(String strSQL) throws Exception {
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            if (conn != null){
                System.out.println("--------------connection success---------------------");
            }else{
                System.out.println("-------------connection fail--------------");
            }
            Statement st = conn.createStatement();
            rs = st.executeQuery(strSQL);
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        } finally {

        }
        return rs;
    }


}
