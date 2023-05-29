package com.example;

import java.sql.*;


/**
 * Hello world!
 *
 */
public class Connection
{
    java.sql.Connection conn;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;


    public Connection() throws Exception{
        conn =  DriverManager.getConnection("jdbc:mysql://localhost/namapass", "root", "");
        statement = conn.createStatement();
    }

    public void delete(String tabel, int id) throws Exception {
        preparedStatement = conn.prepareStatement("DELETE FROM ? WHERE id = ?");
        preparedStatement.setString(1, tabel);
        preparedStatement.setInt(2, id);
    }

    public void executeStatement(String query) throws Exception {
        statement.execute(query);
    }

    public ResultSet executeQuery(String query) throws Exception {
        return statement.executeQuery(query);
    }

    public PreparedStatement getPreparedStatement(String query) throws Exception {
        preparedStatement = conn.prepareStatement(query);
        return preparedStatement;
    }

}
