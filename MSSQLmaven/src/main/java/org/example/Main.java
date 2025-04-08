package org.example;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //Для подключения к DB нужно:
        // скачать/распаковать sqljdbc_12.8.1.0_rus.zip и прочитать install.txt
        // установить драйвер в проект из папки:
        // C:\Program Files\Microsoft JDBC DRIVER 12.8 for SQL Server\rus\jars
        // В IntelliJ: File → Project Structure → Libraries → "+" → Java → укажите путь к JAR
        // Добавьте DLL для аутентификации
        // Из скачанного архива драйвера возьмите файл
        // Для 64-bit: auth/x64/mssql-jdbc_auth-12.8.0.x64.dll
        // Для 32-bit: auth/x86/mssql-jdbc_auth-12.8.0.x86.dll
        // Поместите его в:
        // C:\Windows\System32 (для 64-bit)
        // C:\Windows\SysWOW64 (для 32-bit)
        // Откройте SQL Server Configuration Manager
        // Разверните: Сетевая конфигурация SQL Server → Протоколы для MSSQLSERVER
        // Включите TCP/IP (правой кнопкой → Включить)
        // Запустите/Перезапустите SQL Server через:
        // Windows: Пуск → Службы → найдите SQL Server (MSSQLSERVER) → Запустить

        String connectionString = "jdbc:sqlserver://EVEREST:1433;"
                + "database=PD_212;"
                + "user=PHP;"
                + "password=111;"
                + "ConnectTimeout=30;"
                + "Encrypt=True;"
                + "TrustServerCertificate=True;"
                + "ApplicationIntent=ReadWrite;"
                + "MultiSubnetFailover=False;";

        //try(Connection connection = DriverManager.getConnection(connectionString))
        try
        {
            //if(connection!=null);
            //System.out.println("\nПодключение успешно установлено!");
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();//Открывает соединение

            ResultSet results = statement.executeQuery("SELECT * FROM Directions");
            while (results.next())
            {
                byte id = results.getByte("direction_id");
                String name = results.getString("direction_name");
                System.out.println(id+"\t\t"+name);
            }

            connection.close();//закрывает соединение

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}