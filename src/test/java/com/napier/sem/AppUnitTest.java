package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppUnitTest {
    static App app;
    //static city city;

    @BeforeAll
    static void init() {
        app = new App();
        //city = new city();
    }

    //Country Based Unit Tests
    @Test
    void printPopulationsTestNull() {
        app.printPopulations(null);
    }

    @Test
    void printPopulationsTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printPopulations(countries);
    }

    @Test
    void printPopulationsTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printPopulations(countries);
    }

    @Test
    void printPopulations() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printPopulations(countries);
    }

    @Test
    void printContPopsTestNull() {
        app.printContPops(null);
    }

    @Test
    void printContPopsTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printContPops(countries);
    }

    @Test
    void printContPopsTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printContPops(countries);
    }

    @Test
    void printContPops() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printContPops(countries);
    }

    @Test
    void printRegPopsTestNull() {
        app.printRegPops(null);
    }

    @Test
    void printRegPopsTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printRegPops(countries);
    }

    @Test
    void printRegPopsTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printRegPops(countries);
    }

    @Test
    void printRegPops() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printRegPops(countries);
    }

    @Test
    void printTopPopsTestNull() {
        app.printTopPops(null);
    }

    @Test
    void printTopPopsTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printTopPops(countries);
    }

    @Test
    void printTopPopsTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printTopPops(countries);
    }

    @Test
    void printTopPops() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printTopPops(countries);
    }

    @Test
    void printTopContPopsTestNull() {
        app.printTopContPops(null);
    }

    @Test
    void printTopContPopsTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printTopContPops(countries);
    }

    @Test
    void printTopContPopsTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printTopContPops(countries);
    }

    @Test
    void printTopContPops() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printTopContPops(countries);
    }

    @Test
    void printTopRegPopsTestNull() {
        app.printTopRegPops(null);
    }

    @Test
    void printTopRegPopsTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printTopRegPops(countries);
    }

    @Test
    void printTopRegPopsTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printTopRegPops(countries);
    }

    @Test
    void printTopRegPops() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printTopRegPops(countries);
    }

    //City Based Unit Tests
    @Test
    void printCityPopulationsTestNull() {
        app.printCityPopulations(null);
    }

    @Test
    void printCityPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCityPopulations(cities);
    }

    @Test
    void printCityPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCityPopulations(cities);
    }

    @Test
    void printCityPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printCityPopulations(cities);
    }

    @Test
    void printCityContPopulationsTestNull() {
        app.printCityContPopulations(null);
    }

    @Test
    void printCityContPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCityContPopulations(cities);
    }

    @Test
    void printCityContPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCityContPopulations(cities);
    }

    @Test
    void printCityContPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printCityContPopulations(cities);
    }

    @Test
    void printCityRegPopulationsTestNull() {
        app.printCityRegPopulations(null);
    }

    @Test
    void printCityRegPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCityRegPopulations(cities);
    }

    @Test
    void printCityRegPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCityRegPopulations(cities);
    }

    @Test
    void printCityRegPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printCityRegPopulations(cities);
    }

    @Test
    void printCityCountryPopulationsTestNull() {
        app.printCityCountryPopulations(null);
    }

    @Test
    void printCityCountryPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCityCountryPopulations(cities);
    }

    @Test
    void printCityCountryPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCityCountryPopulations(cities);
    }

    @Test
    void printCityCountryPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printCityCountryPopulations(cities);
    }

    @Test
    void printCityDistrictPopulationsTestNull() {
        app.printCityDistrictPopulations(null);
    }

    @Test
    void printCityDistrictPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCityDistrictPopulations(cities);
    }

    @Test
    void printCityDistrictPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCityDistrictPopulations(cities);
    }

    @Test
    void printCityDistrictPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printCityDistrictPopulations(cities);
    }

    @Test
    void printTop20CityPopulationsTestNull() {
        app.printTop20CityPopulations(null);
    }

    @Test
    void printTop20CityPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTop20CityPopulations(cities);
    }

    @Test
    void printTop20CityPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printTop20CityPopulations(cities);
    }

    @Test
    void printTop20CityPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printTop20CityPopulations(cities);
    }

    @Test
    void printTop10CityContPopulationsTestNull() {
        app.printTop20CityContPopulations(null);
    }

    @Test
    void printTop10CityContPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTop20CityContPopulations(cities);
    }

    @Test
    void printTop10CityContPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printTop20CityContPopulations(cities);
    }

    @Test
    void printTop10CityContPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printTop20CityContPopulations(cities);
    }

    @Test
    void printTop20CityRegPopulationsTestNull() {
        app.printTop20CityRegPopulations(null);
    }

    @Test
    void printTop20CityRegPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTop20CityRegPopulations(cities);
    }

    @Test
    void printTop20CityRegPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printTop20CityRegPopulations(cities);
    }

    @Test
    void printTop20CityRegPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printTop20CityRegPopulations(cities);
    }

    @Test
    void printTop20CityCountryPopulationsTestNull() {
        app.printTop20CityCountryPopulations(null);
    }

    @Test
    void printTop20CityCountryPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTop20CityCountryPopulations(cities);
    }

    @Test
    void printTop20CityCountryPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printTop20CityCountryPopulations(cities);
    }

    @Test
    void printTop20CityCountryPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printTop20CityCountryPopulations(cities);
    }

    @Test
    void printTop20CityDistPopulationsTestNull() {
        app.printTop20CityDistPopulations(null);
    }

    @Test
    void printTop20CityDistPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTop20CityDistPopulations(cities);
    }

    @Test
    void printTop20CityDistPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printTop20CityDistPopulations(cities);
    }

    @Test
    void printTop20CityDistPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printTop20CityDistPopulations(cities);
    }

    @Test
    void printCapitalCityPopulationsTestNull() {
        app.printCapitalCityPopulations(null);
    }

    @Test
    void printCapitalCityPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCapitalCityPopulations(cities);
    }

    @Test
    void printCapitalCityPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCapitalCityPopulations(cities);
    }

    @Test
    void printCapitalCityPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printCapitalCityPopulations(cities);
    }

    @Test
    void printCapitalCityContPopulationsTestNull() {
        app.printCapitalCityContPopulations(null);
    }

    @Test
    void printCapitalCityContPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCapitalCityContPopulations(cities);
    }

    @Test
    void printCapitalCityContPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCapitalCityContPopulations(cities);
    }

    @Test
    void printCapitalCityContPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printCapitalCityContPopulations(cities);
    }

    @Test
    void printCapitalCityRegPopulationsTestNull() {
        app.printCapitalCityRegPopulations(null);
    }

    @Test
    void printCapitalCityRegPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCapitalCityRegPopulations(cities);
    }

    @Test
    void printCapitalCityRegPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCapitalCityRegPopulations(cities);
    }

    @Test
    void printCapitalCityRegPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printCapitalCityRegPopulations(cities);
    }

    @Test
    void printTopCapitalCityPopulationsTestNull() {
        app.printTopCapitalCityPopulations(null);
    }

    @Test
    void printTopCapitalCityPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTopCapitalCityPopulations(cities);
    }

    @Test
    void printTopCapitalCityPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTopCapitalCityPopulations(cities);
    }

    @Test
    void printTopCapitalCityPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printTopCapitalCityPopulations(cities);
    }

    @Test
    void printTopCapitalCityContPopulationsTestNull() {
        app.printTopCapitalCityContPopulations(null);
    }

    @Test
    void printTopCapitalCityContPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTopCapitalCityContPopulations(cities);
    }

    @Test
    void printTopCapitalCityContPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printTopCapitalCityContPopulations(cities);
    }

    @Test
    void printTopCapitalCityContPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printTopCapitalCityContPopulations(cities);
    }

    @Test
    void printTopCapitalCityRegPopulationsTestNull() {
        app.printTopCapitalCityRegPopulations(null);
    }

    @Test
    void printTopCapitalCityRegPopulationsTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printTopCapitalCityRegPopulations(cities);
    }

    @Test
    void printTopCapitalCityRegPopulationsTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printTopCapitalCityRegPopulations(cities);
    }

    @Test
    void printTopCapitalCityRegPopulations() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printTopCapitalCityRegPopulations(cities);
    }

    @Test
    void printWorldPopTestNull() {
        app.printWorldPop(null);
    }

    @Test
    void printWorldPopTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printWorldPop(countries);
    }

    @Test
    void printWorldPopTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printWorldPop(countries);
    }

    @Test
    void printWorldPop() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printWorldPop(countries);
    }
    @Test
    void printWorldPopContTestNull() {
        app.printWorldPopConts(null);
    }

    @Test
    void printWorldPopContTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printWorldPopConts(countries);
    }

    @Test
    void printWorldPopContsTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printWorldPopConts(countries);
    }

    @Test
    void printWorldPopConts() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printWorldPopConts(countries);
    }

    @Test
    void printWorldPopRegTestNull() {
        app.printWorldPopReg(null);
    }

    @Test
    void printWorldPopRegTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printWorldPopReg(countries);
    }

    @Test
    void printWorldPopRegTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printWorldPopReg(countries);
    }

    @Test
    void printWorldPopReg() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country2 = new Country();
        country2.code = "AGO";
        country2.name = "Angola";
        country2.continent = "Africa";
        country2.region = "Central Africa";
        country2.surfaceArea = 1246700.00;
        country2.indepYear = 1975;
        country2.population = 12878000;
        country2.lifeExpectancy = 38.3;
        country2.gnp = 6648.00;
        country2.gnpOld = 7984.00;
        country2.localName = "Angola";
        country2.governmentForm = "Republic";
        country2.headOfState = "José Eduardo dos Santos";
        country2.capital = 56;
        country2.code2 = "AO";
        countries.add(country2);
        app.printWorldPopReg(countries);
    }

    @Test
    void printWorldPopDistTestNull() {
        app.printWorldPopDist(null);
    }

    @Test
    void printWorldPopDistTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printWorldPopDist(cities);
    }

    @Test
    void printWorldPopDistTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printWorldPopDist(cities);
    }

    @Test
    void printWorldPopDist() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printWorldPopDist(cities);
    }
    @Test
    void printWorldPopCityTestNull() {
        app.printWorldPopCity(null);
    }

    @Test
    void printWorldPopCityTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printWorldPopCity(cities);
    }

    @Test
    void printWorldPopCityTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printWorldPopCity(cities);
    }

    @Test
    void printWorldPopCity() {
        ArrayList<City> cities = new ArrayList<>();
        City city2 = new City();
        city2.iD = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;
        cities.add(city2);
        app.printWorldPopCity(cities);
    }
}


