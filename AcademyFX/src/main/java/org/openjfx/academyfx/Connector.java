package org.example.academyfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private final Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public Connector(String string) throws SQLException
    {
        this.connection = DriverManager.getConnection(string);
    }
    public void closeConnection()throws SQLException
    {
        connection.close();
    }


}
