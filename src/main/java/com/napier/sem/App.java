package com.napier.sem;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get Employee
        country country2 = a.getCountry("ABW");
        // Display results
        a.displayCountry(country2);

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
        public void connect()
        {
            try
            {
                // Load Database driver
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Could not load SQL driver");
                System.exit(-1);
            }

            int retries = 10;
            for (int i = 0; i < retries; ++i)
            {
                System.out.println("Connecting to database...");
                try
                {
                    // Wait a bit for db to start
                    Thread.sleep(30000);
                    // Connect to database
                    con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                    System.out.println("Successfully connected");
                    break;
                }
                catch (SQLException sqle)
                {
                    System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                    System.out.println(sqle.getMessage());
                }
                catch (InterruptedException ie)
                {
                    System.out.println("Thread interrupted? Should not happen.");
                }
            }
        }
    public country getCountry(String Code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population "
                            + "FROM country "
                            + "WHERE Code = " + Code;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new Country if valid.
            // Check one is returned
            if (rset.next())
            {
                country country2 = new country();
                country2.Code = rset.getString("Code");
                country2.Name = rset.getString("Name");
                country2.Continent = rset.getString("Population");
                country2.Region = rset.getString("Population");
                country2.SurfaceArea = rset.getInt("Population");
                country2.IndepYear = rset.getInt("Population");
                country2.Population = rset.getInt("Population");
                country2.LifeExpectancy = rset.getInt("Population");
                country2.GNP = rset.getInt("Population");
                country2.GNPOld = rset.getInt("Population");
                country2.LocalName = rset.getString("Population");
                country2.GovernmentForm = rset.getString("Population");
                country2.HeadOfState = rset.getString("Population");
                country2.Capital = rset.getInt("Population");
                country2.Code2 = rset.getString("Population");
                return country2;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }

    public void displayCountry(country country2)
    {
        if (country2 != null)
        {
            System.out.println(
                    country2.Code + " "
                            + country2.Name + " "
                            + country2.Continent + "\n"
                            + country2.Population + "\n");
        }
    }
        /**
         * Disconnect from the MySQL database.
         */
        public void disconnect()
        {
            if (con != null)
            {
                try
                {
                    // Close connection
                    con.close();
                }
                catch (Exception e)
                {
                    System.out.println("Error closing connection to database");
                }
            }
        }
}