package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/cc jdbc?user=root";

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to DB");

            String sql = "select * from notebook";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String subject = rs.getString ("subject");
                String note = rs.getString( "note");
                String created_at = rs.getTimestamp("created_at").toString();
                System.out.println(id + " " + subject + " - " + note + " - " + created_at);
            }
            String sql1 = "INSERT INTO notebook (id, subject, note, created_at) VALUES ('0', 'SQL1', 'Delete from ... löscht alles aus der Tabelle', current_timestamp());";
            Statement stmt = connection.createStatement();

            stmt.executeUpdate(sql1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

