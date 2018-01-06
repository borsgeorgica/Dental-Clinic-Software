package types;
public class Treatment {
	
	private String name;
	private int cost;
	private int length;
	private int partnerType;
	private int treatmentType;
	private boolean includedHCP;
	
	/**
	 * @param name
	 * @param cost
	 * @param length
	 * @param partnerType
	 * @param treatmentType
	 * @param includedHCP
	 */
	public Treatment(String name, int cost, int length, int partnerType, int treatmentType, boolean includedHCP) {
		this.name = name;
		this.cost = cost;
		this.length = length;
		this.partnerType = partnerType;
		this.treatmentType = treatmentType;
		this.includedHCP = includedHCP;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the partnerType
	 */
	public int getPartnerType() {
		return partnerType;
	}

	/**
	 * @param partnerType the partnerType to set
	 */
	public void setPartnerType(int partnerType) {
		this.partnerType = partnerType;
	}

	/**
	 * @return the treatmentType
	 */
	public int getTreatmentType() {
		return treatmentType;
	}

	/**
	 * @param treatmentType the treatmentType to set
	 */
	public void setTreatmentType(int treatmentType) {
		this.treatmentType = treatmentType;
	}

	/**
	 * @return the includedHCP
	 */
	public boolean isIncludedHCP() {
		return includedHCP;
	}

	/**
	 * @param includedHCP the includedHCP to set
	 */
	public void setIncludedHCP(boolean includedHCP) {
		this.includedHCP = includedHCP;
	}
	
	
	
	
}
