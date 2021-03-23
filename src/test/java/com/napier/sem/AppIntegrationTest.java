package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCity() {
        city city2 = app.getCity(1);
        assertEquals(city2.ID, 1);
        assertEquals(city2.Name, "Kabul");
        assertEquals(city2.CountryCode, "AFG");
        assertEquals(city2.District, "Kabol");
        assertEquals(city2.Population, 1780000);
    }
}
/**    @Test
    void testGetCountry()
    {
        country country2 = app.getCountry("ZWE");
        assertEquals(country2.Code, "ZWE");
        assertEquals(country2.Name, "Zimbabwe");
        assertEquals(country2.Continent, "Africa");
        assertEquals(country2.Region, "Eastern Africa");
        assertEquals(country2.SurfaceArea, 390757.00);
        assertEquals(country2.IndepYear, 1980);
        assertEquals(country2.Population, 11669000);
        assertEquals(country2.LifeExpectancy, 37.8);
        assertEquals(country2.GNP, 5951.00);
        assertEquals(country2.GNPOld, 8670.00);
        assertEquals(country2.LocalName, "Zimbabwe");
        assertEquals(country2.GovernmentForm, "Republic");
        assertEquals(country2.HeadOfState, "Robert G. Mugabe");
        assertEquals(country2.Capital, 4068);
        assertEquals(country2.Code2, "ZW");
    }
*/
/**    @Test
    void testGetLanguage()
    {
        countrylanguage countrylanguage2 = app.getLanguage("ZWE");
        assertEquals(countrylanguage2.CountryCode, "ZWE");
        assertEquals(countrylanguage2.Language, "Shona");
        assertEquals(countrylanguage2.IsOfficial, "F");
        assertEquals(countrylanguage2.Percentage, 72.1);
    }*/
/**    @Test
    void testAddCity() {
        city city2 = new city();
        city2.Name = "TestCity";
        city2.CountryCode = "TCC";
        city2.District = "TestDistrict";
        city2.Population = 1234567;
        app.addCity(city2);
        assertEquals(city2.Name, "TestCity");
        assertEquals(city2.CountryCode, "TCC");
        assertEquals(city2.District, "TestDistrict");
        assertEquals(city2.Population, 1234567);

    }
 */