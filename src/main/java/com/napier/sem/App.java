package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * This Application has been built to deliver a range of City, Country and Language reports
 * These reports are generally sorted by population
 * There is also code to manage the required data base connection
 */
public class App {
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:33060");
        }
        else
        {
            a.connect(args[0]);
        }

        // Get City
        City city2 = a.getCity(1);
        // Display results
        a.displayCity(city2);

        // Get Country
        Country country2 = a.getCountry("ABW");
        // Display results
        a.displayCountry(country2);

        // Get Country Language
        CountryLanguage countryLanguage2 = a.getLanguage("");
        // Display results
        a.displayCountryLanguage(countryLanguage2);

        /**
         * Country Related Reports Section
         */


         //Extract country population information
         ArrayList<Country> countries = a.getPopulations();

         //Get Country Information Reports Task IDs 1 - 6

         //Print country population report Task ID 1
         a.printPopulations(countries);

         //Print continent population report Task ID 2
         a.printContPops(countries);

         //Print populations by region report Task ID 3
         a.printRegPops(countries);

         //Print top 10 populations by country report Task ID 4
         a.printTopPops(countries);

         //Print top 10 populations by continent report - set to Europe Task ID 5
         a.printTopContPops(countries);

         //Print top 10 populations by region report - set to North America Task ID 6
         a.printTopRegPops(countries);

         //Test the size of the returned data
         System.out.println(countries.size());

        /**
         * City Related Reports Section
         */

        // Extract country population information
        ArrayList<City> cities = a.getCityPopulations();

        // Get City Information Reports Task IDs 7 - 16

        // Print city population report Task ID 7
        a.printCityPopulations(cities);

        // Print city population report grouped by continent Task ID 8
        a.printCityContPopulations(cities);

        // Print city population report grouped by region Task ID 9
        a.printCityRegPopulations(cities);

        // Print city population report grouped by country Task ID 10
        a.printCityCountryPopulations(cities);

        // Print city population report grouped by country Task ID 11
        a.printCityDistrictPopulations(cities);

        // Print top 20 city population report Task ID 12
        a.printTop20CityPopulations(cities);

        // Print top 20 city population report grouped by continent - set to Asia Task ID 13
        a.printTop20CityContPopulations(cities);

        // Print top 20 city population report grouped by region - set to Caribbean Task ID 14
        a.printTop20CityRegPopulations(cities);

        // Print top 20 city population report grouped by country - set to United States Task ID 15
        a.printTop20CityCountryPopulations(cities);

        // Print top 20 city population report grouped by district - set to Punjab Task ID 16
        a.printTop20CityDistPopulations(cities);

        /**
         * Capital City Related Reports Section
         */

        // Print city population report grouped by country
        //a.printCapitalCityPopulations(cities);

        // Print city population report grouped by country
        //a.printCapitalCityContPopulations(cities);


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
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
     */
        public ArrayList<Country> getPopulations()
        {
            try
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM city, country "
                            + "WHERE country.Capital = city.id AND country.Region = 'Middle East' "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT 10 ";


                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<Country> countries = new ArrayList<Country>();
                while (rset.next())
                {
                    Country country2 = new Country();
                    country2.code = rset.getString("country.Code");
                    country2.name = rset.getString("country.Name");
                    country2.continent = rset.getString("country.Continent");
                    country2.region = rset.getString("country.Region");
                    country2.population = rset.getInt("country.Population");
                    country2.capitalName = rset.getString("city.Name");
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
    public void printPopulations(ArrayList<Country> countries)
    {
        // Check list is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country2 : countries)
        {
            if (country2 == null)
                continue;
        String country_string =
            String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                country2.code, country2.name, country2.continent, country2.region, country2.population, country2.capitalName);
        System.out.println(country_string);
        }
    }
    /**
     * Prints a list of countries with population ordered by continent.
     * @param countries list of countries to print.
     */
    public void printContPops(ArrayList<Country> countries)
    {
        // Check list is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country2 : countries)
        {
            if (country2 == null)
                continue;
        String country_string =
            String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                country2.code, country2.name, country2.continent, country2.region, country2.population, country2.capitalName);
        System.out.println(country_string);
        }
    }
    /**
     * Prints a list of countries with population ordered by region.
     * @param countries list of countries to print.
     */
    public void printRegPops(ArrayList<Country> countries)
    {
        // Check list is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country2 : countries)
        {
            if (country2 == null)
                continue;
        String country_string =
            String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                country2.code, country2.name, country2.continent, country2.region, country2.population, country2.capitalName);
        System.out.println(country_string);
        }
    }
    /**
    /* Prints a list of countries with top 10 highest populations.
     * @param countries list of countries to print.
     */
    public void printTopPops(ArrayList<Country> countries)
    {
        // Check list is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        //Loop over all countries in the list
        for (Country country2 : countries)
        {
            if (country2 == null)
                continue;
        String country_string =
            String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                country2.code, country2.name, country2.continent, country2.region, country2.population, country2.capitalName);
        System.out.println(country_string);
        }
    }
    /**
     /* Prints a list of countries with top 10 highest populations.
     * @param countries list of countries to print.
     */
    public void printTopContPops(ArrayList<Country> countries)
    {
        // Check list is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        //Loop over all countries in the list
        for (Country country2 : countries)
        {
            if (country2 == null)
                continue;
            String country_string =
                    String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                            country2.code, country2.name, country2.continent, country2.region, country2.population, country2.capitalName);
            System.out.println(country_string);
        }
    }
    /**
     /* Prints a list of the top ten countries with highest populations within a Region
     * @param countries list of countries to print.
     */
    public void printTopRegPops(ArrayList<Country> countries)
    {
        // Check list is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-50s %-20s %-30s %-15s %-20s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        //Loop over all countries in the list
        for (Country country2 : countries)
        {
            if (country2 == null)
                continue;
            String country_string =
                    String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                            country2.code, country2.name, country2.continent, country2.region, country2.population, country2.capitalName);
            System.out.println(country_string);
        }
    }
    /**
     * Gets all cities and populations.
     * @return A list of all cities and populations, or null if there is an error.
     */
    public ArrayList<City> getCityPopulations()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND city.District = 'Punjab' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT 20";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next())
            {
                City city2 = new City();
                city2.name = rset.getString("city.Name");
                city2.country = rset.getString("country.Name");
                city2.district = rset.getString("city.District");
                city2.population = rset.getInt("city.Population");
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
     * Prints a list of cities by population decreasing.
     * @param cities list of countries to print.
     */
    public void printCityPopulations(ArrayList<City> cities)
    {
        // Check list is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-40s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-25s %-40s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }
    /**public void addCity(city city2)
     {
     try
     {
     Statement stmt = con.createStatement();
     String strUpdate =
     "INSERT INTO city (Name, CountryCode, District, Population) " +
     "VALUES ('city2.Name', 'city2.CountryCode', 'city2.District', 'city2.Population')";
     stmt.execute(strUpdate);
     }
     catch (Exception e)
     {
     System.out.println(e.getMessage());
     System.out.println("Failed to add city");
     }
     }
     */

    /**
     * Prints a list of cities.
     * @param //cities list of countries to print.
     */
    public City getCity(int ID)
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
                City city2 = new City();
                city2.iD = rset.getInt("ID");
                city2.name = rset.getString("Name");
                city2.countryCode = rset.getString("CountryCode");
                city2.district = rset.getString("District");
                city2.population = rset.getInt("Population");
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

    public void displayCity(City city2)
    {
        if (city2 != null)
        {
            System.out.println(
                    city2.iD + " "
                            + city2.name + " "
                            + city2.countryCode + "\n"
                            + city2.district + "\n"
                            + city2.population + "\n");
        }
    }
    /**
     * Prints a list of countries.
     * @param //cities list of countries to print.
     * @return
     */
    public Country getCountry(String Code) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 "
                            + "FROM country "
                            + "WHERE Code = " + "Code";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next()) {
                Country country2 = new Country();
                country2.code = rset.getString("country.Code");
                country2.name = rset.getString("country.Name");
                country2.continent = rset.getString("country.Continent");
                country2.region = rset.getString("country.Region");
                country2.surfaceArea = rset.getInt("country.SurfaceArea");
                country2.indepYear = rset.getInt("country.IndepYear");
                country2.population = rset.getInt("country.Population");
                country2.lifeExpectancy = rset.getInt("country.LifeExpectancy");
                country2.gnp = rset.getInt("country.GNP");
                country2.gnpOld = rset.getInt("country.GNPOld");
                country2.localName = rset.getString("country.LocalName");
                country2.governmentForm = rset.getString("country.GovernmentForm");
                country2.headOfState = rset.getString("country.HeadOfState");
                country2.capital = rset.getInt("country.Capital");
                country2.code2 = rset.getString("country.Code2");
                return country2;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountry(Country country2)
    {
        if (country2 != null)
        {
            System.out.println(
                country2.code + " "
                + country2.name + " "
                + country2.continent + "\n"
                + country2.region + "\n"
                + country2.surfaceArea + "\n"
                + country2.indepYear + "\n"
                + country2.population + "\n"
                + country2.lifeExpectancy + "\n"
                + country2.gnp + "\n"
                + country2.gnpOld + "\n"
                + country2.localName + "\n"
                + country2.governmentForm + "\n"
                + country2.headOfState + "\n"
                + country2.capital + "\n"
                + country2.code2 + "\n");
        }
 }
 /**
 * Prints a list of countries.
 * @param //cities list of countries to print.
 * @return
 */
    public CountryLanguage getLanguage(String Code)
     {
     try
     {
     // Create an SQL statement
     Statement stmt = con.createStatement();
     // Create string for SQL statement
     String strSelect =
     "SELECT CountryCode, Language, IsOfficial, Percentage "
     + "FROM countrylanguage "
     + "WHERE CountryCode = " + "CountryCode";
     // Execute SQL statement
     ResultSet rset = stmt.executeQuery(strSelect);
     // Return new city if valid.
     // Check one is returned
     if (rset.next())
     {
     CountryLanguage countryLanguage2 = new CountryLanguage();
     countryLanguage2.countryCode = rset.getString("CountryCode");
     countryLanguage2.language = rset.getString("Language");
     countryLanguage2.isOfficial = rset.getString("IsOfficial");
     countryLanguage2.percentage = rset.getInt("Percentage");
     return countryLanguage2;
     }
     else
     return null;
     }
     catch (Exception e)
     {
     System.out.println(e.getMessage());
     System.out.println("Failed to get language details");
     return null;
     }
     }
      public void displayCountryLanguage(CountryLanguage countryLanguage2)
     {
     if (countryLanguage2 != null)
     {
     System.out.println(
     countryLanguage2.countryCode + " "
     + countryLanguage2.language + " "
     + countryLanguage2.isOfficial + "\n"
     + countryLanguage2.percentage + "\n");
     }
     }



    /**
     * Prints a list of cities.
     * @param cities list of cities to print.
     */
    public void printCityContPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-40s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-25s %-40s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a list of cities.
     * @param cities list of cities to print.
     */
    public void printCityRegPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-40s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-25s %-40s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a list of cities.
     * @param cities list of cities to print.
     */
    public void printCityCountryPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-40s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-25s %-40s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a list of cities sorted by district pop desc.
     * @param cities list of cities to print.
     */
    public void printCityDistrictPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-40s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-25s %-40s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }


    /**
     * Prints a top twenty list of cities by pop decreasing.
     * @param cities list of countries to print.
     */
    public void printTop20CityPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-40s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-25s %-40s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }

    /**
     * Prints a top ten list of cities within a named continent by pop decreasing.
     * @param cities list of countries to print.
     */
    public void printTop20CityContPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-40s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-25s %-40s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }

    /**
     * Prints a top ten list of cities within a named continent by pop decreasing.
     * @param cities list of countries to print.
     */
    public void printTop20CityRegPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-30s %-25s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-30s %-25s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }

    /**
     * Prints a top twenty list of cities within a named country by pop decreasing.
     * @param cities list of countries to print.
     */
    public void printTop20CityCountryPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-30s %-25s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-30s %-25s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }
    /**
     * Prints a top twenty list of cities within a named district by pop decreasing.
     * @param cities list of countries to print.
     */
    public void printTop20CityDistPopulations(ArrayList<City> cities)
    {
        // Check city is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-30s %-25s %-25s %-12s \n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city2 : cities)
        {
            if (city2 == null)
                continue;
            String city_string =
                    String.format("%-30s %-25s %-25s %-12s",
                            city2.name, city2.country, city2.district, city2.population);
            System.out.println(city_string);
        }
    }

    /**
     * Prints a list of capital cities by pop decreasing.
     * @param cities list of countries to print.
     */
    /**public void printCapitalCityPopulations(ArrayList<City> cities)
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
     for (City city2 : cities)
     {
     if (city2 == null)
     continue;
     String city_string =
     String.format("%-5s %-35s %-5s %-20s %-12s",
     city2.iD, city2.name, city2.countryCode, city2.district, city2.population);
     System.out.println(city_string);
     }
     }
     /**
     * Prints a list of capital cities within a specific continent by pop decreasing.
     * @param cities list of countries to print.
     */
    /**public void printCapitalCityContPopulations(ArrayList<City> cities)
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
     for (City city2 : cities)
     {
     if (city2 == null)
     continue;
     String city_string =
     String.format("%-5s %-35s %-5s %-20s %-12s",
     city2.iD, city2.name, city2.countryCode, city2.district, city2.population);
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