package com.caffiendfrog.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by sophia on 10/23/17.
 */
public class MySqlProvider {
    private static final MySqlProvider INSTANCE = new MySqlProvider();
    private static final Log logger = LogFactory.getLog(MySqlProvider.class);

    // connection information
    private static final String jdbc = "jdbc:mysql://";
    private static final String localhost = "localhost:3306";
    private static final String dbName = "acc";
    private static final String dbUser = "test_user";
    private static final String dbPassword = "pw";

    private static final String jdbcUrl = jdbc + localhost;
    private static final String dbUrl = jdbcUrl + "/" + dbName;

    private static final String createSql = "CREATE DATABASE IF NOT EXISTS " + dbName;

    private boolean createDb = false;
    private static Connection connection;

    public static MySqlProvider getInstance() { return INSTANCE; }

    public static Connection getConnection() { return connection;  }

    protected void connectToDb() throws SQLException {
        connection =  DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
        PreparedStatement stmt = connection.prepareStatement(createSql);
        stmt.execute();
        connection.setCatalog(dbName);
    }

    protected void connectToTable() throws Exception {
        String createCmd = "CREATE TABLE if NOT EXISTS test_table (" +
                "c1 INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "c2 VARCHAR(100))";
        PreparedStatement stmt = connection.prepareStatement(createCmd);
        stmt.execute();
    }

    protected void shutdown() {
        try {
            if (connection != null) {
                logger.info("Shutting down database connection to: [" + dbUrl + "]");
                connection.close();
                connection = null;
            }
        } catch (Exception e) {
            logger.error("There was a problem shutting down the connection: ", e);
        } catch (Throwable t) {
            // Supposedly this is on a separate thread? according to ei code, might not be the case anymore
            logger.warn(t);
        }
    }
}
