package org.example;

import java.sql.*;

public class Connector  {
    String connectionString;
    Connection connection;
    public Connector(String connectionString)
    {
        this.connectionString = connectionString;
        try
        {
            connection = DriverManager.getConnection(connectionString);
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

    }
    public int Scalar(String query)
    {
        int scalar = -1;
        try(Statement statement = connection.createStatement())//если Statement запихнуть в try то он сам закроется без close
        {
            scalar = statement.executeUpdate(query);
            System.out.println(scalar);
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return scalar;
    }
    public void Select (String query)
    {
        try
        {
            Statement statement = connection.createStatement();//Открывает соединение????

            //ResultSet results = statement.executeQuery("SELECT * FROM Directions");
            ResultSet results = statement.executeQuery(query);
            //нужно вытащить имена полей
            ResultSetMetaData metaData = results.getMetaData();
            for(int i=1; i <= metaData.getColumnCount(); i++)
            {
                System.out.println(metaData.getColumnName(i)+"\t\t" + metaData.getColumnClassName(i));
            }
            System.out.println();
            while (results.next())
            {
                //byte id = results.getByte("direction_id");
                //String name = results.getString("direction_name");
                //System.out.println(id+"\t\t"+name);
                for(int i=1; i<=metaData.getColumnCount(); i++)
                {
                    System.out.print(results.getObject(i)+"\t");
                }
                System.out.println();
            }
            results.close();
            //connection.close();//Закрывает то, что открыл Statement
            //если закрыть, то последующие Select() НЕ будут работать
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

    }


}
