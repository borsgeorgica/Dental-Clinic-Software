package types;
import java.sql.Date;
import java.sql.Time;

import types.people.Partner;
import types.people.Patient;

public class Appointment {
    
    private int id;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Patient patient;
    private Partner partner;
    
    /**
     * @param date
     * @param startTime
     * @param endTime
     * @param treatmentType
     * @param treatmentCost
     */
    public Appointment(int id, Date date, Time startTime, Time endTime, Patient patient, Partner partner) {
        this(date, startTime, endTime, patient, partner);
        this.id = id;
    }
    
    public Appointment(Date date, Time startTime, Time endTime, Patient patient, Partner partner) {
        super();
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.patient = patient;
        this.partner = partner;
    }
    
    
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * @return the startTime
     */
    public Time getStartTime() {
        return startTime;
    }
    
    /**
     * @param startTime
     *            the startTime to set
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    
    /**
     * @return the endTime
     */
    public Time getEndTime() {
        return endTime;
    }
    
    /**
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }
    
    
    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    /**
     * @return the partner
     */
    public Partner getPartner() {
        return partner;
    }
    
    
    /**
     * @param partner the partner to set
     */
    public void setPartner(Partner partner) {
        this.partner = partner;
    }
    
    
    
    
}
