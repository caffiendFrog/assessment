package com.caffiendfrog.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by sophia on 10/23/17.
 */
public class MySqlProviderTest {
    private final static Logger logger = LogManager.getLogger(MySqlProviderTest.class);


    //TODO Add test that drops the database and test create
    //TODO Ability to use test database
    /**
     * Basic test to connect to database, regardless if the db exists or not
     */
    @Test
    public void testConnectToDatabase() {
        MySqlProvider connectionProvider = MySqlProvider.getInstance();
        try {
            connectionProvider.connectToDb();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            fail();
        }
    }

    @Test
    public void testCreateTable() {
        MySqlProvider connectionProvider = MySqlProvider.getInstance();
        try {
            connectionProvider.connectToDb();
            connectionProvider.connectToTable();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            fail();
        }
    }
}
