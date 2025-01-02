package com.example.case_md3.util;

import java.sql.Connection;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try (Connection connection = Database.getConnection()) {
            if (connection != null) {
                System.out.println("Database connection successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
