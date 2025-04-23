package org.openjfx.academyfx_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String connectionString =
            //"jdbc:sqlserver://localhost:1433;" +
            //"jdbc:sqlserver://EVEREST:1433;" +
            "jdbc:sqlserver://VANYACOMP:1433;" +
                    "database=PD_212;" +
                    "user=PHP;" +
                    "password=111;" +
                    "Connect Timeout=30;Encrypt=True;" +
                    "TrustServerCertificate=True;";
    private static Connection connection;
    Connector()throws SQLException
    {
        connection = DriverManager.getConnection(connectionString);
    }
    /*public static Connection getConnection() {
        return connection;
    }*/
    Connector(String string)throws SQLException
    {
        Connector.connectionString = string;
        connection = DriverManager.getConnection(string);
    }
    public void closeConnection()throws SQLException
    {
        connection.close();
    }
    public static Connection getConnection()
    {
        return connection;
    }
    public static String getConnectionString()
    {
        return connectionString;
    }
}