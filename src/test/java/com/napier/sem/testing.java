package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class testing
{
    static App app;
    //static city city;

    @BeforeAll
    static void init()
    {
        app = new App();
        //city = new city();
    }

    @Test
    void printCityPopulationsTestNull()
    {
        app.printCityPopulations(null);
    }

    @Test
    void printCityPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<>();
        app.printCityPopulations(cities);
    }

    @Test
    void printCityPopulationsTestContainsNull()
    {
        ArrayList<city> cities = new ArrayList<>();
        cities.add(null);
        app.printCityPopulations(cities);
    }

    @Test
    void printCityPopulations()
    {
        ArrayList<city> cities = new ArrayList<>();
        city city2 = new city();
        city2.ID = 1;
        city2.Name = "Kabul";
        city2.CountryCode = "AFG";
        city2.District = "Kabol";
        city2.Population = 1780000;
        cities.add(city2);
        app.printCityPopulations(cities);
    }
    @Test
    void printCityContPopulationsTestNull()
    {
        app.printCityContPopulations(null);
    }

    @Test
    void printCityContPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<>();
        app.printCityContPopulations(cities);
    }

    @Test
    void printCityContPopulationsTestContainsNull()
    {
        ArrayList<city> cities = new ArrayList<>();
        cities.add(null);
        app.printCityContPopulations(cities);
    }
    @Test
    void printCityContPopulations()
    {
        ArrayList<city> cities = new ArrayList<>();
        city city2 = new city();
        city2.ID = 1;
        city2.Name = "Kabul";
        city2.CountryCode = "AFG";
        city2.District = "Kabol";
        city2.Population = 1780000;
        cities.add(city2);
        app.printCityContPopulations(cities);
    }
    @Test
    void printCityRegPopulationsTestNull()
    {
        app.printCityRegPopulations(null);
    }

    @Test
    void printCityRegPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<>();
        app.printCityRegPopulations(cities);
    }

    @Test
    void printCityRegPopulationsTestContainsNull()
    {
        ArrayList<city> cities = new ArrayList<>();
        cities.add(null);
        app.printCityRegPopulations(cities);
    }
    @Test
    void printCityRegPopulations()
    {
        ArrayList<city> cities = new ArrayList<>();
        city city2 = new city();
        city2.ID = 1;
        city2.Name = "Kabul";
        city2.CountryCode = "AFG";
        city2.District = "Kabol";
        city2.Population = 1780000;
        cities.add(city2);
        app.printCityRegPopulations(cities);
    }
    @Test
    void printCityCountryPopulationsTestNull()
    {
        app.printCityCountryPopulations(null);
    }

    @Test
    void printCityCountryPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<>();
        app.printCityCountryPopulations(cities);
    }

    @Test
    void printCityCountryPopulationsTestContainsNull()
    {
        ArrayList<city> cities = new ArrayList<>();
        cities.add(null);
        app.printCityCountryPopulations(cities);
    }
    @Test
    void printCityCountryPopulations()
    {
        ArrayList<city> cities = new ArrayList<>();
        city city2 = new city();
        city2.ID = 1;
        city2.Name = "Kabul";
        city2.CountryCode = "AFG";
        city2.District = "Kabol";
        city2.Population = 1780000;
        cities.add(city2);
        app.printCityCountryPopulations(cities);
    }
    @Test
    void printCityDistrictPopulationsTestNull()
    {
        app.printCityDistrictPopulations(null);
    }

    @Test
    void printCityDistrictPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<>();
        app.printCityDistrictPopulations(cities);
    }

    @Test
    void printCityDistrictPopulationsTestContainsNull()
    {
        ArrayList<city> cities = new ArrayList<>();
        cities.add(null);
        app.printCityDistrictPopulations(cities);
    }
    @Test
    void printCityDistrictPopulations()
    {
        ArrayList<city> cities = new ArrayList<>();
        city city2 = new city();
        city2.ID = 1;
        city2.Name = "Kabul";
        city2.CountryCode = "AFG";
        city2.District = "Kabol";
        city2.Population = 1780000;
        cities.add(city2);
        app.printCityDistrictPopulations(cities);
    }
    @Test
    void printCapitalCityPopulationsTestNull()
    {
        app.printCapitalCityPopulations(null);
    }

    @Test
    void printCapitalCityPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<>();
        app.printCapitalCityPopulations(cities);
    }

    @Test
    void printCapitalCityPopulationsTestContainsNull()
    {
        ArrayList<city> cities = new ArrayList<>();
        cities.add(null);
        app.printCapitalCityPopulations(cities);
    }
    @Test
    void printCapitalCityPopulations()
    {
        ArrayList<city> cities = new ArrayList<>();
        city city2 = new city();
        city2.ID = 1;
        city2.Name = "Kabul";
        city2.CountryCode = "AFG";
        city2.District = "Kabol";
        city2.Population = 1780000;
        cities.add(city2);
        app.printCapitalCityPopulations(cities);
    }
    @Test
    void printCapitalCityContPopulationsTestNull()
    {
        app.printCapitalCityContPopulations(null);
    }

    @Test
    void printCapitalCityContPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<>();
        app.printCapitalCityContPopulations(cities);
    }
    @Test
    void printPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<>();
        app.printCityPopulations(cities);
    }
    @Test
    void printCapitalCityContPopulations()
    {
        ArrayList<city> cities = new ArrayList<>();
        city city2 = new city();
        city2.ID = 1;
        city2.Name = "Kabul";
        city2.CountryCode = "AFG";
        city2.District = "Kabol";
        city2.Population = 1780000;
        cities.add(city2);
        app.printCapitalCityContPopulations(cities);
    }
}
