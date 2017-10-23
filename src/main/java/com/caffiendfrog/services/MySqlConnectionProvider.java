package com.caffiendfrog.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by sophia on 10/23/17.
 */
public class MySqlConnectionProvider {
    private static final MySqlConnectionProvider INSTANCE = new MySqlConnectionProvider();
    private static final Log logger = LogFactory.getLog(MySqlConnectionProvider.class);

    // connection information
    private static final String jdbc = "jdbc:mysql://";
    private static final String localhost = "localhost:3306";
    private static final String dbName = "acc";
    private static final String dbUser = "test_user";
    private static final String dbPassword = "pw";

    private static final String createSql = "CREATE DATABASE IF NOT EXISTS " + dbName;

    private boolean createDb = false;
    private Connection connection;

    public static MySqlConnectionProvider getInstance() { return INSTANCE; }

    protected void connectToDb() throws SQLException {
        connection =  DriverManager.getConnection(localhost, dbUser, dbPassword);
        PreparedStatement stmt = connection.prepareStatement(createSql);
        stmt.execute();
    }
}
