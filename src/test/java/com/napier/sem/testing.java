package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class testing
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printCityPopulationsTestNull()
    {
        app.printCityPopulations(null);
    }

    @Test
    void printCityPopulationsTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        app.printCityPopulations(cities);
    }

    @Test
    void printCityPopulationsTestContainsNull()
    {
        ArrayList<city> cities = new ArrayList<city>();
        cities.add(null);
        app.printCityPopulations(cities);
    }

    @Test
    void printCityPopulations()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city city2 = new city();
        city2.ID = 1;
        city2.Name = "Kabul";
        city2.CountryCode = "AFG";
        city2.District = "Kabol";
        city2.Population = 1780000;
        cities.add(city2);
        app.printCityPopulations(cities);
    }
}
