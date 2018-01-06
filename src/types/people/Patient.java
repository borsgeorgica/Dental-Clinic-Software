package types.people;
import java.sql.Date;
import types.Address;

public class Patient {

    private String title;
    private String name;
    private String surname;
    private Date dob;
    private String phoneNumber;
    private String planName;
    private Address address;
    private int id;

    private boolean healthCarePlan;

    /**
     * @param title
     * @param name
     * @param surname
     * @param dob
     * @param phoneNumber
     * @param healthCarePlan
     */
    public Patient(String title, String name, String surname, Date dob, String phoneNumber, boolean healthCarePlan,
            String planName, Address address) {
        super();
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.healthCarePlan = healthCarePlan;
        this.planName = planName;
        this.address = address;
    }

    public Patient(String title, String name, String surname, Date dob, String phoneNumber, boolean healthCarePlan,
            String planName, Address address, int id) {

        this(title, name, surname, dob, phoneNumber, healthCarePlan, planName, address);
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
     * @return the planName
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * @param planName
     *            the planName to set
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname
     *            the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob
     *            the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     *            the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the healthCarePlan
     */
    public boolean isHealthCarePlan() {
        return healthCarePlan;
    }

    /**
     * @param healthCarePlan
     *            the healthCarePlan to set
     */
    public void setHealthCarePlan(boolean healthCarePlan) {
        this.healthCarePlan = healthCarePlan;
    }

    public void updatePatientInformation(String title, String name, String surname, Date dob, String phoneNumber,
            boolean healthCarePlan) {
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.healthCarePlan = healthCarePlan;
    }

}
