package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        City city2 = app.getCity(1);
        assertEquals(city2.iD, 1);
        assertEquals(city2.name, "Kabul");
        assertEquals(city2.countryCode, "AFG");
        assertEquals(city2.district, "Kabol");
        assertEquals(city2.population, 1780000);
    }
    @Test
    void testGetCountry() {
        Country country2 = app.getCountry("ABW");
        assertEquals(country2.code, "ABW");
        assertEquals(country2.name, "Aruba");
        assertEquals(country2.continent, "North America");
        assertEquals(country2.region, "Caribbean");
        assertEquals(country2.surfaceArea, 193.00);
        assertEquals(country2.indepYear, (Integer) 0);
        assertEquals(country2.population, 103000);
        assertEquals(country2.lifeExpectancy, 78.0);
        assertEquals(country2.gnp, 828.00);
        assertEquals(country2.gnpOld, 793.00);
        assertEquals(country2.localName, "Aruba");
        assertEquals(country2.governmentForm, "Nonmetropolitan Territory of The Netherlands");
        assertEquals(country2.headOfState, "Beatrix");
        assertEquals(country2.capital, 129);
        assertEquals(country2.code2, "AW");
    }

    @Test
    void testGetLanguage() {
        CountryLanguage countryLanguage2 = app.getLanguage( "ABW");
        assertEquals(countryLanguage2.countryCode, "ABW");
        assertEquals(countryLanguage2.language, "Dutch");
        assertEquals(countryLanguage2.isOfficial, "T");
        assertEquals(countryLanguage2.percentage, 5.0);
    }
}
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