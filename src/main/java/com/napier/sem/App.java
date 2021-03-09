package com.napier.sem;

import java.sql.*;


public class App {
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Get City
        city city2 = a.getCity(1);
        // Display results
        a.displayCity(city2);

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

    public city getCity(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM city "
                            + "WHERE ID = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next())
            {
                city city2 = new city();
                city2.ID = rset.getInt("ID");
                city2.Name = rset.getString("Name");
                city2.CountryCode = rset.getString("CountryCode");
                city2.District = rset.getString("District");
                city2.Population = rset.getInt("Population");
                return city2;
            } else
                return null;
        }
        catch (Exception e)
        {
          System.out.println(e.getMessage());
          System.out.println("Failed to get employee details");
         return null;
        }
    }

    public void displayCity(city city2)
    {
        if (city2 != null)
        {
            System.out.println(
                    city2.ID + " "
                            + city2.Name + " "
                            + city2.CountryCode + "\n"
                            + city2.District + "\n"
                            + "Population:" + city2.Population + "\n");
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