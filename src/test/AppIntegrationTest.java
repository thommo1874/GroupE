package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCityPopulations()
    {
        city city2 = app.getCityPopulations(1);
        assertEquals(city2.ID, 1);
        assertEquals(city2.Name, "Kabul");
        assertEquals(city2.CountryCode, "AFG");
        assertEquals(city2.District, "Kabol");
        assertEquals(city2.Population, 1780000);
    }
}