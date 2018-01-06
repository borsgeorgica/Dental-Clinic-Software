/* Written by Georgica Bors */

package connection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Time;

import types.Address;
import types.Appointment;
import types.HealthCarePlan;
import types.Treatment;
import types.people.Partner;
import types.people.Patient;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BackEndWrite {

    private Connection db_connection = null;

    /**
     * @param db_connection
     */
    public BackEndWrite() {

        this.db_connection = DatabaseConnection.getConnection();
    }

    public void close() {
        DatabaseConnection.closeConnection();
    }

    //

    public void registerPatient(Patient patient) {
        // patient
        String title = patient.getTitle();
        String name = patient.getName();
        String surname = patient.getSurname();
        Date dob = patient.getDob();
        String phoneNumber = patient.getPhoneNumber();
        String planName = patient.getPlanName();
        boolean healthCarePlan = patient.isHealthCarePlan();

        if (!healthCarePlan)
            planName = "NOPLAN";

        Address address = patient.getAddress();

        int houseNumber = address.getHouseNumber();
        String streetName = address.getStreetName();
        String districtName = address.getDistrictName();
        String cityName = address.getCityName();
        String postcode = address.getPostcode();

        try {

            // First create the address
            // check whether the address exists already in the db
            String query = "SELECT id_address FROM address WHERE " + "(house_number = ? AND postcode = ?)";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, houseNumber);
            preparedStmt.setString(2, postcode);

            ResultSet rs = preparedStmt.executeQuery();
            int addressId = 1;
            if (rs.next()) {
                addressId = rs.getInt("id_address");

            } else {
                query = "insert into address (house_number, street_name, town_name, city_name, postcode)"
                        + "values(?, ?, ?, ?, ?)";

                preparedStmt = db_connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                preparedStmt.setInt(1, houseNumber);
                preparedStmt.setString(2, streetName);
                preparedStmt.setString(3, districtName);
                preparedStmt.setString(4, cityName);
                preparedStmt.setString(5, postcode);

                preparedStmt.executeUpdate();
                rs = preparedStmt.getGeneratedKeys();
                if (rs.next()) {
                    addressId = rs.getInt(1);
                }

            }

            // insert into patient

            query = " insert into patient (title, first_name, last_name, dob, phone_number, plan_name, address)"
                    + " values ( ?, ?, ?, ?, ?, ?, ?)";

            preparedStmt = db_connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setString(1, title);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, surname);
            preparedStmt.setDate(4, dob);
            preparedStmt.setString(5, phoneNumber);
            preparedStmt.setString(6, planName);
            preparedStmt.setInt(7, addressId);

            preparedStmt.execute();
            int last_inserted_id = 0;
            rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                last_inserted_id = rs.getInt(1);
            }

            if (healthCarePlan) {
                // insert into personal hcp
                query = " insert into personal_hcp (start_date, plan_name, id_patient)" + " values ( ?, ?, ?)";
                preparedStmt = db_connection.prepareStatement(query);
                // Get current date
                Date date = new Date(System.currentTimeMillis());
                preparedStmt.setDate(1, date);
                preparedStmt.setString(2, planName);
                preparedStmt.setInt(3, last_inserted_id);

                preparedStmt.execute();
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void updatePatient(Patient patient) {

        Date date = new Date(System.currentTimeMillis());
        String phoneNumber = patient.getPhoneNumber();
        String planName = patient.getPlanName();
        String title = patient.getTitle();
        String firstName = patient.getName();
        String surname = patient.getSurname();
        Date dob = patient.getDob();
        boolean healthCarePlan = patient.isHealthCarePlan();
        int patientId = patient.getId();

        Address address = patient.getAddress();
        int houseNumber = address.getHouseNumber();
        String streetName = address.getStreetName();
        String districtName = address.getDistrictName();
        String cityName = address.getCityName();
        String postcode = address.getPostcode();
        int addressId = address.getId();

        try {
            // update hcp
            if (healthCarePlan) {
                String query = "UPDATE personal_hcp SET start_date=?, plan_name=?  WHERE id_patient=?";

                PreparedStatement preparedStmt = db_connection.prepareStatement(query);

                preparedStmt.setDate(1, date);
                preparedStmt.setString(2, planName);
                preparedStmt.setInt(3, patientId);

                int rowsInserted = preparedStmt.executeUpdate();
                if (rowsInserted > 0)
                    System.out.println("An existing hcp was updated successfully!");
            }

            // update patient
            String query = "UPDATE patient SET title=?, first_name=?, last_name=?, dob=?,  phone_number=?, plan_name=?  WHERE id_patient=?";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setString(1, title);
            preparedStmt.setString(2, firstName);
            preparedStmt.setString(3, surname);
            preparedStmt.setDate(4, dob);
            preparedStmt.setString(5, phoneNumber);
            preparedStmt.setString(6, planName);
            preparedStmt.setInt(7, patientId);

            int rowsInserted = preparedStmt.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("An existing patient was updated successfully!");

            query = "UPDATE address SET house_number=?, street_name=?, town_name=?, city_name=?, postcode=? WHERE id_address=?";

            preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setInt(1, houseNumber);
            preparedStmt.setString(2, streetName);
            preparedStmt.setString(3, districtName);
            preparedStmt.setString(4, cityName);
            preparedStmt.setString(5, postcode);
            preparedStmt.setInt(6, addressId);

            rowsInserted = preparedStmt.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("An existing address has been updated successfully!");

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    public void deletePatient(Patient patient) {

        int patientId = patient.getId();
        Address address = patient.getAddress();
        int addressId = address.getId();
        boolean healthCarePlan = patient.isHealthCarePlan();

        try {
            // delete hcp
            PreparedStatement preparedStmt;
            if (healthCarePlan) {
                String query = "DELETE FROM personal_hcp WHERE id_patient=?";

                preparedStmt = db_connection.prepareStatement(query);

                preparedStmt.setInt(1, patientId);

                int rowsDeleted = preparedStmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("A hcp was deleted successfully!");
                }

            }

            // delete appointment
            String query = "DELETE FROM appointment WHERE id_patient=?";

            preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setInt(1, patientId);

            int rowsDeleted = preparedStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An appointment was deleted successfully!");
            }

            // delete row from patient
            query = "DELETE FROM patient WHERE id_patient=?";

            preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setInt(1, patientId);

            rowsDeleted = preparedStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A patient was deleted successfully!");
            }

            // check if address is being used by another patient
            query = "SELECT id_patient FROM patient WHERE " + "(address = ?)";

            preparedStmt = db_connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, addressId);

            ResultSet rs = preparedStmt.executeQuery();
            int count = 0;

            while (rs.next()) {
                count++;
                System.out.println("Count is: " + count);
            }

            if (count == 0) {
                query = "DELETE FROM address WHERE id_address =?";

                preparedStmt = db_connection.prepareStatement(query);

                preparedStmt.setInt(1, addressId);

                rowsDeleted = preparedStmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("An address was deleted successfully!");
                }
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void createGeneralPlan(HealthCarePlan plan) {
        String name = plan.getName();
        int price = plan.getMonthlyPayment();
        int checkups = plan.getNumberOfCheckUps();
        int hygiene = plan.getNumberOfHygieneVisits();
        int repairs = plan.getNumberOfRepairs();
        boolean under18 = plan.isUnder18();

        try {

            String query = "insert into general_plans (plan_name, price, checkups, hygine, repairs, u_18)"
                    + "values(?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, price);
            preparedStmt.setInt(3, checkups);
            preparedStmt.setInt(4, hygiene);
            preparedStmt.setInt(5, repairs);
            preparedStmt.setBoolean(6, under18);

            int rowsInserted = preparedStmt.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("A new general plan has been added successfully!");

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void selectAllGeneralPlans() {
        // create the java statement
        try {

            String query = "SELECT * FROM general_plans";

            Statement st = db_connection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String name = rs.getString("plan_name");
                int price = rs.getInt("price");
                int checkups = rs.getInt("checkups");
                int hygiene = rs.getInt("hygine");
                int repairs = rs.getInt("repairs");
                boolean under18 = rs.getBoolean("u_18");

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s\n", name, price, checkups, hygiene, repairs, under18);

            }
            st.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    public void createAppointment(Appointment appointment) {

        Patient patient = appointment.getPatient();
        Partner partener = appointment.getPartner();
        Date date = appointment.getDate();
        Time startTime = appointment.getStartTime();
        Time endTime = appointment.getEndTime();
        int patientId = patient.getId();
        int partnerId = partener.getId();

        try {

            String query = "insert into appointment (date, start_time, end_time, id_patient, id_partner)"
                    + "values(?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setDate(1, date);
            preparedStmt.setTime(2, startTime);
            preparedStmt.setTime(3, endTime);
            preparedStmt.setInt(4, patientId);
            preparedStmt.setInt(5, partnerId);

            int rowsInserted = preparedStmt.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("A new appointment plan has been added successfully!");

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void deleteAppointment(Appointment appointment) {

        int appointmentId = appointment.getId();

        try {

            // delete row from patient
            String query = "DELETE FROM appointment WHERE id_appointment=?";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setInt(1, appointmentId);

            int rowsDeleted = preparedStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An appointment was deleted successfully!");
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void addTreatmentType(Treatment treatment) {

        String name = treatment.getName();
        int cost = treatment.getCost();
        int length = treatment.getLength();
        int partnerType = treatment.getPartnerType();
        int treatmentType = treatment.getTreatmentType();
        boolean includedHCP = treatment.isIncludedHCP();

        try {

            String query = "insert into treatment (treatment_name, cost, length, partner_type, treatment_type, hp_included)"
                    + "values(?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, cost);
            preparedStmt.setInt(3, length);
            preparedStmt.setInt(4, partnerType);
            preparedStmt.setInt(5, treatmentType);
            preparedStmt.setBoolean(6, includedHCP);

            int rowsInserted = preparedStmt.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("A new treatment has been added successfully!");

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    public void addTreatmentToAppointment(Appointment appointment, Treatment treatment) {
        String treatmentName = treatment.getName();
        int appointmentId = appointment.getId();

        try {
            String query = "insert into appointment_treatments (id_appointment, treatment_name)" + "values(?, ?)";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setInt(1, appointmentId);
            preparedStmt.setString(2, treatmentName);

            int rowsInserted = preparedStmt.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("A treatment has been added to an appointment successfully!");
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    public void addTreatmentToAppointment(Appointment appointment, String treatmentName) {

        int appointmentId = appointment.getId();

        try {
            String query = "insert into appointment_treatments (id_appointment, treatment_name)" + "values(?, ?)";

            PreparedStatement preparedStmt = db_connection.prepareStatement(query);

            preparedStmt.setInt(1, appointmentId);
            preparedStmt.setString(2, treatmentName);

            int rowsInserted = preparedStmt.executeUpdate();
            if (rowsInserted > 0)
                System.out.println("A treatment has been added to an appointment successfully!");
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
