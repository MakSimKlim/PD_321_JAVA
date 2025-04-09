package org.example;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static String connectionString = "jdbc:sqlserver://EVEREST:1433;"
            + "database=PD_212;"
            + "user=PHP;"
            + "password=111;"
            + "ConnectTimeout=30;"
            + "Encrypt=True;"
            + "TrustServerCertificate=True;"
            + "ApplicationIntent=ReadWrite;"
            + "MultiSubnetFailover=False;";
    static Connection connection;

    public static void main(String[] args) {

        System.out.println(connectionString);
        try
        {
            connection = DriverManager.getConnection((connectionString));
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }

        //Connector connector = new Connector(connectionString);
        //connector.Select("SELECT * FROM Students JOIN Groups ON ([group]=group_id)");
        String query = "SELECT " +
                "FORMATMESSAGE(N'%s %s %s', last_name, first_name, middle_name) AS N'Студент', " +
                "group_name," +
                "direction_name " +
                "FROM Students JOIN Groups ON ([group]=group_id) JOIN Directions ON (direction=direction_id)";
        Select(query);
        Select("SELECT * FROM Directions");
    }
        public static void Select (String query)
        {
            try {
                Statement statement = connection.createStatement();//Открывает соединение????

                //ResultSet results = statement.executeQuery("SELECT * FROM Directions");
                ResultSet results = statement.executeQuery(query);
                //нужно вытащить имена полей
                ResultSetMetaData metaData = results.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.println(metaData.getColumnName(i) + "\t\t" + metaData.getColumnClassName(i));
                }
                System.out.println();
                while (results.next()) {
                /*byte id = results.getByte("direction_id");
                String name = results.getString("direction_name");
                System.out.println(id+"\t\t"+name);*/
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        System.out.print(results.getObject(i) + "\t");
                    }
                    System.out.println();
                }
                results.close();
                //connection.close();//Закрывает то, что открыл Statement
                //если закрыть, то последующие Select() НЕ будут работать
            }
            catch (SQLException e)
            {
                System.err.println(e.getMessage());
            }

        }

}