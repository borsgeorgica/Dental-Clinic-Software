package testing;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import connection.BackEndWrite;
import connection.DatabaseConnection;
import types.Address;
import types.Appointment;
import types.HealthCarePlan;
import types.people.Partner;
import types.people.Patient;

public class GeorogicaMain {

    public static void main(String[] args) throws ParseException {
        
        BackEndWrite write = new BackEndWrite();
        
        //create a patient 
        Address address = new Address(19, "West Street", "Sheffield", "Sheffield", "S1 5C2");
        address.setId(12);
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date sqlDate = new Date(df.parse("08-12-1996").getTime());
        Date currentDate = new Date(System.currentTimeMillis());
        
        Patient patient = new Patient("Miss","Adelina", "Dobrila",sqlDate , "07426785433",true, "planName" , address);
        patient.setId(14);
        
        
        HealthCarePlan plan = new HealthCarePlan("NOPLAN", 0,0,0,0, false);
        
        Partner partner = new Partner("Dr", "Matt", "Dentist");
        partner.setId(2);
        
        Time startTime = new Time(System.currentTimeMillis());
        Time endTime = new Time(System.currentTimeMillis());
        
        Appointment appointment = new Appointment(currentDate, startTime, endTime, patient, partner );
        appointment.setId(2);
 
        write.createAppointment(appointment);
        //write.deleteAppointment(appointment);
        
        // Close the connection // 
        DatabaseConnection.closeConnection();
     

    }

}