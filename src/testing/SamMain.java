package testing;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import connection.BackEndRead;
import connection.BackEndWrite;
import connection.DatabaseConnection;
import types.Address;
import types.Appointment;
import types.Treatment;
import types.people.Dentist;
import types.people.Patient;
import connection.BackEndRead;



public class SamMain {

    public static void main(String[] args) {

        BackEndWrite write = new BackEndWrite();
        BackEndRead read = new BackEndRead();
        
        
        //create a patient 
        Address address = new Address(72, "Lawrence Street", "Sheffield", "Yorkshire", "S4 9AU");
        Date date = Date.valueOf("2017-11-23");
        Time startTime = new Time(System.currentTimeMillis());
        Time endTime = new Time(System.currentTimeMillis());
        Patient patient = new Patient("Mr","Jack", "Smith", date, "07756984264",true, "PlanName", address);
        //HealthCarePlan plan = new HealthCarePlan("planName", 20, 3,3,3, true);
        //write.createGeneralPlan(plan);
        //write.registerPatient(patient);
        
        //write.registerPatient();
        
        Dentist d = new Dentist("Dr","Matt","Dentist");
        
        //int id = read.getPartnerId(d);
        
        //read.getPartnersDaysAppointments(date, d);
        
        Appointment a = new Appointment(1,date,startTime,endTime,patient,d);
        ArrayList<Treatment> lis = read.getAppointmentsTreatments(a);
      
        
        //ArrayList<Patient> ps = read.getPatientList("Georgica", "Bors");
        //System.out.println(ps.size());
        //Patient p = read.getPatientFromId(10);
        //System.out.println(p.getName());
        
        DatabaseConnection.closeConnection();

    }

}
