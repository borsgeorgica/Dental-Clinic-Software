package types;
public class Address {

    private int houseNumber;
    private String streetName;
    private String districtName;
    private String cityName;
    private String postcode;
    private int id;


    /**
     * @param houseNumber
     * @param streetName
     * @param districtName
     * @param cityName
     * @param postcode
     */
    public Address(int houseNumber, String streetName, String districtName, String cityName, String postcode) {
        super();
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.districtName = districtName;
        this.cityName = cityName;
        this.postcode = postcode;
    }

    public Address(int houseNumber, String streetName, String districtName, String cityName, String postcode, int id) {
        this(houseNumber, streetName, districtName, cityName, postcode);
        this.id = id;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the houseNumber
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * @param houseNumber
     *            the houseNumber to set
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName
     *            the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName
     *            the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName
     *            the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode
     *            the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void updateAddress(int houseNumber, String streetName, String districtName, String cityName,
            String postcode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.districtName = districtName;
        this.cityName = cityName;
        this.postcode = postcode;
    }

}
