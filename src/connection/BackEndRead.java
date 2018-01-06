/* Written by Sam Clowes  */
package connection;

import java.sql.*;
import java.util.ArrayList;

import types.Address;
import types.Appointment;
import types.HealthCarePlan;
import types.Treatment;
import types.people.Partner;
import types.people.Patient;

public class BackEndRead {

    private Connection db_connection = null;
    private String db_name = null;

    /**
     * @param db_connection
     */
    public BackEndRead() {

        this.db_connection = DatabaseConnection.getConnection();
        this.db_name = DatabaseConnection.getDb();
    }

    public Patient getPatientFromId(Integer id) { // get a patient

        String stringId = id.toString();
        Patient returnPatient = null;
        Address returnAddress = null;

        try {

            String query = "SELECT patient.title, patient.first_name, patient.last_name, patient.dob, patient.phone_number, "
                    + "patient.plan_name, address.house_number, address.street_name, address.town_name,address.city_name,"
                    + "address.postcode FROM patient, address WHERE patient.address = address.id_address AND "
                    + "patient.id_patient = " + stringId;

            Statement stmt = db_connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String title = rs.getString("title");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phone_number");
                String planName = rs.getString("plan_name");

                int houseNumber = rs.getInt("house_number");
                String street = rs.getString("street_name");
                String town = rs.getString("town_name");
                String city = rs.getString("city_name");
                String postcode = rs.getString("postcode");

                // check to see if the patient has a dataplan
                boolean planBool = true;
                if (planName == "null") {
                    planBool = false;
                }

                returnAddress = new Address(houseNumber, street, town, city, postcode);
                returnPatient = new Patient(title, fname, lname, dob, phoneNumber, planBool, planName, returnAddress,
                        id);
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return returnPatient;

    }

    public Partner getPartnerFromId(Integer id) { // get a partner

        String stringId = id.toString();
        Partner returnPartner = null;

        try {

            String query = "SELECT partner.title, partner.first_name, partner.last_name"

                    + " FROM partner WHERE " + "partner.id_partner = " + stringId;

            Statement stmt = db_connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String title = rs.getString("title");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                return new Partner(id, title, fname, lname);

            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return returnPartner;

    }

    public ArrayList<Patient> getPatientList(String name, String surname) {

        ArrayList<Patient> patientList = new ArrayList<Patient>();
        Patient returnPatient = null;
        Address returnAddress = null;

        try {

            String query = "SELECT patient.id_patient, patient.title, patient.first_name, patient.last_name, patient.dob, patient.phone_number, "
                    + "patient.plan_name, address.house_number, address.street_name, address.town_name,address.city_name,"
                    + "address.postcode FROM patient, address WHERE patient.address = address.id_address AND "
                    + "patient.first_name = '" + name + "' AND patient.last_name = '" + surname + "'";

            Statement stmt = db_connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id_patient");
                String title = rs.getString("title");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                Date dob = rs.getDate("dob");
                String phoneNumber = rs.getString("phone_number");
                String planName = rs.getString("plan_name");

                int houseNumber = rs.getInt("house_number");
                String street = rs.getString("street_name");
                String town = rs.getString("town_name");
                String city = rs.getString("city_name");
                String postcode = rs.getString("postcode");

                // check to see if the patient has a dataplan
                boolean planBool = true;
                if (planName == "NOPLAN") {
                    planBool = false;
                }

                returnAddress = new Address(houseNumber, street, town, city, postcode);
                returnPatient = new Patient(title, fname, lname, dob, phoneNumber, planBool, planName, returnAddress,
                        id);
                patientList.add(returnPatient);
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return patientList;

    }

    public Integer getPartnerId(Partner partner) {

        Integer returnId = -1;

        try {

            String query = "SELECT id_partner FROM partner WHERE title='" + partner.getTitle() + "' AND first_name='"
                    + partner.getName() + "' AND last_name='" + partner.getSurname() + "'";

            Statement stmt = db_connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id_partner");

                // PRINTS TO CHECK
                System.out.println(id);

                returnId = id;

            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return returnId;
    }

    public ArrayList<Appointment> getPartnersDaysAppointments(Date day, Partner partner) {

        Date searchDate = day;

        ArrayList<Appointment> returnList = new ArrayList<Appointment>();
        Appointment appointment;
        Patient patient;
        String partnerId = getPartnerId(partner).toString();

        try {

            String query = "SELECT id_appointment, start_time, end_time, id_patient FROM appointment WHERE"
                    + " date = ? AND id_partner = ?";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setDate(1, searchDate);
            preparedStmt.setString(2, partnerId);

            ResultSet rs;

            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_appointment");
                Time stime = rs.getTime("start_time");
                Time etime = rs.getTime("end_time");
                int patientId = rs.getInt("id_patient");

                patient = getPatientFromId(patientId);
                appointment = new Appointment(id, searchDate, stime, etime, patient, partner);
                returnList.add(appointment);
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return returnList;

    }

    public ArrayList<Treatment> getAppointmentsTreatments(Appointment appointment) {

        ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
        Treatment returnTreatment;

        try {

            String query = "SELECT treatment.treatment_name, treatment.cost, treatment.length, "
                    + "treatment.partner_type, treatment.treatment_type, treatment.hp_included "
                    + "FROM treatment, appointment_treatments WHERE appointment_treatments.treatment_name = "
                    + "treatment.treatment_name AND id_appointment = ?";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setInt(1, appointment.getId());

            ResultSet rs;

            rs = preparedStmt.executeQuery();
            while (rs.next()) {

                String name = rs.getString("treatment_name");
                int cost = rs.getInt("cost");
                int length = rs.getInt("length");
                int partnerType = rs.getInt("partner_type");
                int treatmentType = rs.getInt("treatment_type");
                int hpIncludedInt = rs.getInt("hp_included");

                Boolean includedHCP = true;
                if (hpIncludedInt == 0) {
                    includedHCP = false;
                }

                returnTreatment = new Treatment(name, cost, length, partnerType, treatmentType, includedHCP);
                treatmentList.add(returnTreatment);
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return treatmentList;
    }

    public ArrayList<Treatment> getAllTreatments() {

        ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
        Treatment returnTreatment;

        try {

            String query = "SELECT * FROM treatment";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);
            ResultSet rs;

            rs = preparedStmt.executeQuery();
            while (rs.next()) {

                String name = rs.getString("treatment_name");
                int cost = rs.getInt("cost");
                int length = rs.getInt("length");
                int partnerType = rs.getInt("partner_type");
                int treatmentType = rs.getInt("treatment_type");
                int hpIncludedInt = rs.getInt("hp_included");

                Boolean includedHCP = true;
                if (hpIncludedInt == 0) {
                    includedHCP = false;
                }

                returnTreatment = new Treatment(name, cost, length, partnerType, treatmentType, includedHCP);
                treatmentList.add(returnTreatment);
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return treatmentList;

    }

    public Partner getPartnerFormLogin(String username, String password) {

        Partner partner = null;

        try {

            String query = "SELECT title, first_name, last_name FROM partner WHERE username = ? AND password = ?";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(1, password);

            ResultSet rs;

            rs = preparedStmt.executeQuery();
            while (rs.next()) {

                String title = rs.getString("title");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");

                partner = new Partner(title, fname, lname);

            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return partner;

    }

    public Date getPatientsHcpStartDate(Patient patient) {

        Date startDate = null;
        int id = patient.getId();

        try {
            String query = "SELECT start_date FROM personal_hcp WHERE id_patient = ?";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);
            ResultSet rs;

            preparedStmt.setInt(1, id);

            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                startDate = rs.getDate("start_date");

                // PRINTS TO CHECK
                System.out.println(startDate);
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return startDate;

    }

    public ArrayList<HealthCarePlan> getAllHeathCarePlans() {

        ArrayList<HealthCarePlan> hcpList = new ArrayList<HealthCarePlan>();
        HealthCarePlan hcp;

        try {
            String query = "SELECT * FROM general_plans";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);
            ResultSet rs;

            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                String planName = rs.getString("plan_name");
                int price = rs.getInt("price");
                int checkups = rs.getInt("checkups");
                int hygine = rs.getInt("hygine");
                int repairs = rs.getInt("repairs");
                int under18 = rs.getInt("u_18");

                boolean u18 = true;
                if (under18 == 0) {
                    u18 = false;
                }

                hcp = new HealthCarePlan(planName, price, checkups, hygine, repairs, u18);
                hcpList.add(hcp);

            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return hcpList;
    }

    public void close() {
        DatabaseConnection.closeConnection();
    }

}
