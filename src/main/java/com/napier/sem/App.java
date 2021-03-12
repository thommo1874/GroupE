/*
  Adding MongoDb Content into code as per Lab 2 Instructions 13 Feb CT
 */
package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract employee salary information
        ArrayList<country> countries = a.getPopulations();

        // Print salary report
        a.printPopulations(countries);

        // Test the size of the returned data
        System.out.println(countries.size());

        // Disconnect from database
        a.disconnect();
    }
        /**
         * Connection to MySQL database.
         */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect ()
    {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Gets all countries and populations.
     * @return A list of all countries and populations, or null if there is an error.
     */
    public ArrayList<country> getPopulations()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Population "
                            + "FROM country "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country country2 = new country();
                country2.Code = rset.getString("country.Code");
                country2.Name = rset.getString("country.Name");
                country2.Population = rset.getInt("country.Population");
                countries.add(country2);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Prints a list of countries.
     * @param countries list of countries to print.
     */
    public void printPopulations(ArrayList<country> countries)
    {
        // Print header
        System.out.printf("%-5s %-40s %-15s", "Code", "Name", "Population");
        // Loop over all countries in the list
        for (country country2 : countries)
        {
            String country_string =
                    String.format("%-10s %-40s %-15s",
                            country2.Code, country2.Name, country2.Population);
            System.out.println(country_string);
        }
    }
    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect ()
    {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
