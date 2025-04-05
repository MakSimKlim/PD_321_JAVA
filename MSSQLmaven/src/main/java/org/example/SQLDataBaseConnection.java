package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseConnection {
    String connectionString = "Data Source=VANYACOMP;Initial Catalog=PD_212;Integrated Security=True;Connect Timeout=30;Encrypt=True;Trust Server Certificate=True;Application Intent=ReadWrite;Multi Subnet Failover=False";
    Connection connection;
    public SQLDataBaseConnection()
    {
        try(Connection connection = DriverManager.getConnection(connectionString))
        {
            this.connection = connection;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}
