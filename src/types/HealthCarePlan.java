package types;
public class HealthCarePlan {

    private String name;
    private int monthlyPayment;
    private int numberOfCheckUps;
    private int numberOfHygieneVisits;
    private int numberOfRepairs;
    private boolean under18;

    /**
     * @param name
     * @param monthlyPayment
     * @param numberOfCheckUps
     * @param numberOfHygieneVisits
     * @param numberOfRepairs
     */
    public HealthCarePlan(String name, int monthlyPayment, int numberOfCheckUps, int numberOfHygieneVisits,
            int numberOfRepairs, boolean under18) {
        super();
        this.name = name;
        this.monthlyPayment = monthlyPayment;
        this.numberOfCheckUps = numberOfCheckUps;
        this.numberOfHygieneVisits = numberOfHygieneVisits;
        this.numberOfRepairs = numberOfRepairs;
        this.under18 = under18;
    }

    /**
     * @return the under18
     */
    public boolean isUnder18() {
        return under18;
    }

    /**
     * @param under18 the under18 to set
     */
    public void setUnder18(boolean under18) {
        this.under18 = under18;
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
     * @return the monthlyPayment
     */
    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * @param monthlyPayment
     *            the monthlyPayment to set
     */
    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    /**
     * @return the numberOfCheckUps
     */
    public int getNumberOfCheckUps() {
        return numberOfCheckUps;
    }

    /**
     * @param numberOfCheckUps
     *            the numberOfCheckUps to set
     */
    public void setNumberOfCheckUps(int numberOfCheckUps) {
        this.numberOfCheckUps = numberOfCheckUps;
    }

    /**
     * @return the numberOfHygieneVisits
     */
    public int getNumberOfHygieneVisits() {
        return numberOfHygieneVisits;
    }

    /**
     * @param numberOfHygieneVisits
     *            the numberOfHygieneVisits to set
     */
    public void setNumberOfHygieneVisits(int numberOfHygieneVisits) {
        this.numberOfHygieneVisits = numberOfHygieneVisits;
    }

    /**
     * @return the numberOfRepairs
     */
    public int getNumberOfRepairs() {
        return numberOfRepairs;
    }

    /**
     * @param numberOfRepairs
     *            the numberOfRepairs to set
     */
    public void setNumberOfRepairs(int numberOfRepairs) {
        this.numberOfRepairs = numberOfRepairs;
    }

    public void updatePlan(String name, int monthlyPayment, int numberOfCheckUps, int numberOfHygieneVisits,
            int numberOfRepairs) {

        this.name = name;
        this.monthlyPayment = monthlyPayment;
        this.numberOfCheckUps = numberOfCheckUps;
        this.numberOfHygieneVisits = numberOfHygieneVisits;
        this.numberOfRepairs = numberOfRepairs;
    }

}
