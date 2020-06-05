package sorting.builtinSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuiltInSort {
    public static void main(String[] args) {
        List<Airport> airport = new ArrayList<Airport>();
        airport.add(new Airport("Colombo", "Sri Lanka", "CLM"));
        airport.add(new Airport("Lagos", "Nigeria", "LOS"));
        airport.add(new Airport("Los Angels", "America", "LA"));
        airport.add(new Airport("Montreal", "Canada", "YMX"));
        airport.add(new Airport("New Delhi", "India", "NDE"));
        airport.add(new Airport("New York", "America", "NY"));
        airport.add(new Airport("Sydney", "Australia", "SYD"));

        System.out.println("Before Java's built-in Sort: ");
        for(Airport a : airport){
            System.out.print(a.getCountry()+" , ");
        }
        System.out.println("");
        Collections.sort(airport);
        System.out.println("After Java's buil-in Sort: ");
        for(Airport a: airport){
            System.out.print(a.getCountry()+" , ");
        }
    }
}

/**
 * Using Comparable interface to tell Java in which way we want to
 * compare Airport Object
 */
class Airport implements Comparable<Airport>{
    private String city;
    private String country;
    private String code;

    public Airport(String city, String country, String code) {
        this.setCity(city);
        this.setCountry(country);
        this.setCode(code);
    }

    /**
     * Implementing Comparable interface's compareTo method.
     *
     * @param other: Airport Object
     * @return -1 or 0 or 1
     */
    public int compareTo(Airport other){
        // sorts the Airport objects based on country
        return this.country.compareTo(other.getCountry());
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

