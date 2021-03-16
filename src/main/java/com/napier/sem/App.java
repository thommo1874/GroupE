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

        // Extract country population information
        ArrayList<country> countries = a.getPopulations();

        // Print salary report
        a.printPopulations(countries);

        // Print salary report
        a.printContPops(countries);

        // Print populations by region report
        a.printRegPops(countries);

        // Print populations by region report
        a.printTopPops(countries);

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
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country country2 = new country();
                country2.Code = rset.getString("country.Code");
                country2.Name = rset.getString("country.Name");
                country2.Continent = rset.getString("country.Continent");
                country2.Region = rset.getString("country.Region");
                country2.Population = rset.getInt("country.Population");
                country2.Capital = rset.getInt("country.Capital");
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
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (country country2 : countries)
        {
            String country_string =
                    String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                            country2.Code, country2.Name, country2.Continent, country2.Region, country2.Population, country2.Capital);
            System.out.println(country_string);
        }
    }
    /**
     * Prints a list of countries with population ordered by continent.
     * @param countries list of countries to print.
     */
    public void printContPops(ArrayList<country> countries)
    {
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (country country2 : countries)
        {
            String country_string =
                    String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                            country2.Code, country2.Name, country2.Continent, country2.Region, country2.Population, country2.Capital);
            System.out.println(country_string);
        }
    }
    /**
     * Prints a list of countries with population ordered by region.
     * @param countries list of countries to print.
     */
    public void printRegPops(ArrayList<country> countries)
    {
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (country country2 : countries)
        {
            String country_string =
                    String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                            country2.Code, country2.Name, country2.Continent, country2.Region, country2.Population, country2.Capital);
            System.out.println(country_string);
        }
    }
    /**
     /* Prints a list of countries with population ordered by region.
     /* @param countries list of countries to print.
     */
    public void printTopPops(ArrayList<country> countries)
    {
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        //Loop over all countries in the list
        for (country country2 : countries)
        {
            String country_string =
                    String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                           country2.Code, country2.Name, country2.Continent, country2.Region, country2.Population, country2.Capital);
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