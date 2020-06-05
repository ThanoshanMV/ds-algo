package searching.binarySearch;

public class BinarySearch {

    /**
     * Binary Search Algorithm
     *
     * In BSA, we get the mid element from the input and
     * check if it's the one we're looking for or
     * based on the mid element we have to determine whether the
     * toFind is in the first half or in second half.
     *
     * For BSA, data should be sorted.
     *
     * @param toFind:   city to search
     * @param airports: Airport type array
     * @return: return code associated with city or null
     */
    public static String findAirportCode(String toFind, Airport[] airports) {
        int low = 0, high = airports.length-1;
        int mid;
        while(low <= high){
            // mid = (low + high)/2 will cause overflow for larger low and high values.
            mid = low + (high-low)/2;
            int compare = toFind.compareTo(airports[mid].getCity());
            if(compare < 0){
                high = mid-1;
            }
            else if (compare > 0){
                low = mid+1;
            }
            else {
                return airports[mid].getCode();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Airport[] airport = new Airport[7];
        airport[0] = new Airport("Colombo", "Sri Lanka", "CLM");
        airport[1] = new Airport("Lagos", "Nigeria", "LOS");
        airport[2] = new Airport("Los Angels", "America", "LA");
        airport[3] = new Airport("Montreal", "Canada", "YMX");
        airport[4] = new Airport("New Delhi", "India", "NDE");
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
