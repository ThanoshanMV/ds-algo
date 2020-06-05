package searching.linearSearch;

public class LinearSearch {

    /**
     * Linear Search Algorithm
     *
     * In Linear Search Algorithm, we start searching elements
     * from the beginning to the end,
     * one by one.
     *
     * @param toFind:   city to search
     * @param airports: Airport type array
     * @return: return code associated with city or null
     */
    public static String findAirportCode(String toFind, Airport[] airports) {
        int index = 0;
        while (index < airports.length) {
            if (airports[index].getCity().equals(toFind)) {
                return airports[index].getCode();
            }
            index++;
        }
        return null;
    }

    public static void main(String[] args) {
        Airport[] airport = new Airport[7];
        airport[0] = new Airport("Montreal", "Canada", "YMX");
        airport[1] = new Airport("Lagos", "Nigeria", "LOS");
        airport[2] = new Airport("Colombo", "Sri Lanka", "CLM");
        airport[3] = new Airport("New Delhi", "India", "NDE");
        airport[4] = new Airport("Los Angels", "America", "LA");
        airport[5] = new Airport("New York", "America", "NY");
        airport[6] = new Airport("Sydney", "Australia", "SYD");

        String cityName = "New York";
        String codeToFind = findAirportCode(cityName, airport);
        if (codeToFind != null) {
            System.out.println(cityName + " Airport Code is " + codeToFind);
        } else {
            System.out.println("City is not found");
        }

    }
}

class Airport {
    private String city;
    private String country;
    private String code;

    public Airport(String city, String country, String code) {
        this.setCity(city);
        this.setCountry(country);
        this.setCode(code);
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
