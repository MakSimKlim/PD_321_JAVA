package org.openjfx.academyfx_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    static String connectionString = String.format(    // добавлено
            "jdbc:sqlserver://%s:1433;"                // добавлено
                    + "database=PD_212;"
                    + "user=PHP;"
                    + "password=111;"
                    + "ConnectTimeout=30;"
                    + "Encrypt=True;"
                    + "TrustServerCertificate=True;"
                    + "ApplicationIntent=ReadWrite;"
                    + "MultiSubnetFailover=False;",
            System.getenv("COMPUTERNAME") // добавлено: Автоматически подставит имя текущего ПК
    );
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