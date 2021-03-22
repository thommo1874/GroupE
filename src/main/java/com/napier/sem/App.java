package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect("localhost:33060");

        /** Country Related Reports
        // Extract country population information
        ArrayList<country> countries = a.getPopulations();

        // Print country population report
        a.printPopulations(countries);

        // Print continent population report
        a.printContPops(countries);

        // Print populations by region report
        a.printRegPops(countries);

        // Print top 10 populations by country report
        a.printTopPops(countries);

        // Test the size of the returned data
        System.out.println(countries.size());
*/
        // Extract country population information
        ArrayList<city> cities = a.getCityPopulations();

        // Get City Information

        // Print city population report
        a.printCityPopulations(cities);

        // Print city population report grouped by continent
        a.printCityContPopulations(cities);

        // Print city population report grouped by region
        a.printCityRegPopulations(cities);

        // Print city population report grouped by country
        a.printCityCountryPopulations(cities);

        // Print city population report grouped by country
        a.printCityDistrictPopulations(cities);

        // Print city population report grouped by country
        a.printCapitalCityPopulations(cities);

        // Print city population report grouped by country
        a.printCapitalCityContPopulations(cities);

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
    public void connect (String location)
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
    /** Country Reports
     * Gets all countries and populations.
     * @return A list of all countries and populations, or null if there is an error.

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
                            + "GROUP BY country.Continent"
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
     * @param //countries list of countries to print.

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
     * @param //countries list of countries to print.

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
     * @param //countries list of countries to print.

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
     /* Prints a list of countries with top 10 highest populations.
     /* @param countries list of countries to print.

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
     * Gets all cities and populations.
     * @return A list of all cities and populations, or null if there is an error.
     */
    public ArrayList<city> getCityPopulations()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital AND country.Continent = 'Europe' "
                            + "ORDER BY city.Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> cities = new ArrayList<>();
            while (rset.next())
            {
                city city2 = new city();
                city2.ID = rset.getInt("city.ID");
                city2.Name = rset.getString("city.Name");
                city2.CountryCode = rset.getString("city.CountryCode");
                city2.District = rset.getString("city.District");
                city2.Population = rset.getInt("city.Population");
                cities.add(city2);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Prints a list of countries.
     * @param cities list of countries to print.
*/
    public void printCityPopulations(ArrayList<city> cities)
    {
        // Check list is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
    // Print header
    System.out.printf("%-5s %-35s %-5s %-20s %-12s \n", "ID", "Name", "Code", "District", "Population");
    // Loop over all cities in the list
    for (city city2 : cities)
    {
        if (city2 == null)
            continue;
    String city_string =
    String.format("%-5s %-35s %-5s %-20s %-12s",
    city2.ID, city2.Name, city2.CountryCode, city2.District, city2.Population);
    System.out.println(city_string);
    }
    }
    /**
     * Prints a list of countries.
     * @param //cities list of countries to print.
     */
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
                city2.CountryCode = rset.getString("Country Code");
                city2.District = rset.getString("District");
                city2.Population = rset.getInt("Population");
                return city2;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
    /**
     * Prints a list of countries.
     * @param cities list of countries to print.
     */
    public void printCityContPopulations(ArrayList<city> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-5s %-35s %-5s %-20s %-12s \n", "ID", "Name", "Code", "District", "Population");
        // Loop over all cities in the list
        for (city city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-5s %-35s %-5s %-20s %-12s",
                            city2.ID, city2.Name, city2.CountryCode, city2.District, city2.Population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a list of countries.
     * @param cities list of countries to print.
     */
    public void printCityRegPopulations(ArrayList<city> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-5s %-35s %-5s %-20s %-12s \n", "ID", "Name", "Code", "District", "Population");
        // Loop over all cities in the list
        for (city city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-5s %-35s %-5s %-20s %-12s",
                            city2.ID, city2.Name, city2.CountryCode, city2.District, city2.Population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a list of countries.
     * @param cities list of countries to print.
     */
    public void printCityCountryPopulations(ArrayList<city> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-5s %-35s %-5s %-20s %-12s \n", "ID", "Name", "Code", "District", "Population");
        // Loop over all cities in the list
        for (city city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-5s %-35s %-5s %-20s %-12s",
                            city2.ID, city2.Name, city2.CountryCode, city2.District, city2.Population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a list of countries sorted by district pop desc.
     * @param cities list of countries to print.
     */
    public void printCityDistrictPopulations(ArrayList<city> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-5s %-35s %-5s %-20s %-12s \n", "ID", "Name", "Code", "District", "Population");
        // Loop over all cities in the list
        for (city city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-5s %-35s %-5s %-20s %-12s",
                            city2.ID, city2.Name, city2.CountryCode, city2.District, city2.Population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a list of capital cities by pop decreasing.
     * @param cities list of countries to print.
     */
    public void printCapitalCityPopulations(ArrayList<city> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-5s %-35s %-5s %-20s %-12s \n", "ID", "Name", "Code", "District", "Population");
        // Loop over all cities in the list
        for (city city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-5s %-35s %-5s %-20s %-12s",
                            city2.ID, city2.Name, city2.CountryCode, city2.District, city2.Population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a list of capital cities within a specific continent by pop decreasing.
     * @param cities list of countries to print.
     */
    public void printCapitalCityContPopulations(ArrayList<city> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-5s %-35s %-5s %-20s %-12s \n", "ID", "Name", "Code", "District", "Population");
        // Loop over all cities in the list
        for (city city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-5s %-35s %-5s %-20s %-12s",
                            city2.ID, city2.Name, city2.CountryCode, city2.District, city2.Population);
            System.out.println(city_string);
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