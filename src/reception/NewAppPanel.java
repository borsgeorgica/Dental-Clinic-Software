package reception;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

import connection.BackEndRead;
import connection.BackEndWrite;
import types.Address;
import types.Appointment;
import types.people.Partner;
import types.people.Patient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandrabutoi
 */
public class NewAppPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewAppPanel
     */
    public NewAppPanel() {
        initComponents();

    }

    private boolean checkFreeSlot(Appointment app) {

        Partner part = app.getPartner();
        Date date = app.getDate();
        LocalTime startTime = app.getStartTime().toLocalTime();
        LocalTime endTime = app.getEndTime().toLocalTime();
        // get all appointments for that day for that partner
        BackEndRead read = new BackEndRead();

        ArrayList<Appointment> appointments = read.getPartnersDaysAppointments(date, part);
        appointments.sort(AppointmentComparator);
        boolean free = true;
        for (Appointment existingApp : appointments) {

            if (startTime.isAfter(existingApp.getStartTime().toLocalTime())
                    && startTime.isBefore(existingApp.getEndTime().toLocalTime()))
                free = false;
            else if (!endTime.isBefore(existingApp.getStartTime().toLocalTime())
                    && !endTime.isAfter(existingApp.getEndTime().toLocalTime()))
                free = false;

        }

        return free;

    }

    public static Comparator<Appointment> AppointmentComparator = new Comparator<Appointment>() {

        public int compare(Appointment app1, Appointment app2) {

            LocalTime startTime1 = app1.getStartTime().toLocalTime();
            LocalTime startTime2 = app2.getStartTime().toLocalTime();

            // ascending order
            if (startTime1.isBefore(startTime2))
                return -1;
            else if (startTime1.equals(startTime2))
                return 0;
            else
                return 1;

        }

    };

    /*
     * public Appointment getInfo() { return new
     * Appointment((Date)dateTextField.getValue(),
     * (Time)startTimeTextField.getValue(), (Time)endTimeTextField.getValue(),
     * //patient based on name, //partner ); }
     * 
     * 
     * 
     */
    public Appointment getInfo() throws ParseException {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(df.parse(String.valueOf(dateTextField.getText())).getTime());

        DateFormat timeFormatter = new SimpleDateFormat("HH:mm");
        Time startTime = new Time(timeFormatter.parse(startTimeTextField.getText()).getTime());
        Time endTime = new Time(timeFormatter.parse(endTimeTextField.getText()).getTime());

        int patientId = Integer.parseInt(patientTextField.getText());
        int partnerId;
        if (dentistRadioButton.isSelected())
            partnerId = 1;
        else
            partnerId = 2;

        BackEndRead read = new BackEndRead();

        Partner partner = read.getPartnerFromId(partnerId);
        Patient patient = read.getPatientFromId(patientId);
        return new Appointment(date, startTime, endTime, patient, partner);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    private void initComponents() {

        Doctor = new javax.swing.ButtonGroup();
        addAppLabel = new javax.swing.JLabel();
        addAppButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        // dateTextField = new javax.swing.JFormattedTextField();
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        dateTextField = new javax.swing.JFormattedTextField(format);

        startTimeTextField = new javax.swing.JFormattedTextField();
        endTimeTextField = new javax.swing.JFormattedTextField();
        endTimeLabel = new javax.swing.JLabel();
        doctorLabel = new javax.swing.JLabel();
        dentistRadioButton = new javax.swing.JRadioButton();
        hygienistRadioButton = new javax.swing.JRadioButton();
        patientLabel = new javax.swing.JLabel();
        patientTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        addAppLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        addAppLabel.setLabelFor(this);
        addAppLabel.setText("Add New Appointment");

        addAppButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        addAppButton.setText("Add New Appointment");

        dateLabel.setText("Date");

        startTimeLabel.setText("Start Time");

        dateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextFieldActionPerformed(evt);
            }
        });

        startTimeTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        endTimeLabel.setText("End Time");

        doctorLabel.setText("Doctor");

        Doctor.add(dentistRadioButton);
        dentistRadioButton.setText("Dentist");
        dentistRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dentistRadioButtonActionPerformed(evt);
            }
        });

        Doctor.add(hygienistRadioButton);
        hygienistRadioButton.setText("Hygienist");

        patientLabel.setText("Patient ID");

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("The current slot is not empty. Please try again with a free slot!");
        jLabel1.setVisible(false);

        addAppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addAppButtonActionPerformed(evt);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(412, 412, 412).addComponent(addAppLabel).addGap(297,
                        378, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup().addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup().addComponent(startTimeLabel)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(startTimeTextField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(endTimeTextField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(patientTextField,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(dentistRadioButton))))
                                                .addGap(8, 8, 8).addComponent(hygienistRadioButton)
                                                .addGap(333, 333, 333))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(endTimeLabel).addComponent(doctorLabel)
                                                        .addComponent(patientLabel))
                                                .addGap(566, 566, 566))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup().addComponent(dateLabel).addGap(59, 59, 59)
                                                .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(384, 384, 384)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup()
                                                .addComponent(addAppButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(332, 332, 332))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup().addComponent(jLabel1).addGap(268, 268, 268)))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addGap(56, 56, 56).addComponent(addAppLabel).addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dateLabel).addComponent(dateTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startTimeLabel).addComponent(startTimeTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(endTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(endTimeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(doctorLabel).addComponent(dentistRadioButton)
                                .addComponent(hygienistRadioButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(patientLabel).addComponent(patientTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56).addComponent(jLabel1).addGap(29, 29, 29).addComponent(addAppButton,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)));
    }// </editor-fold>

    private void addAppButtonActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {// GEN-FIRST:event_regPatientButtonActionPerformed
        jLabel1.setVisible(false);
        BackEndWrite write = new BackEndWrite();

        if (checkFreeSlot(getInfo()))
            write.createAppointment(getInfo());
        else
            jLabel1.setVisible(true);

        repaint();
    }

    private void dateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void hygienistRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dentistRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.ButtonGroup Doctor;
    private javax.swing.JButton addAppButton;
    private javax.swing.JLabel addAppLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JFormattedTextField dateTextField;
    private javax.swing.JRadioButton dentistRadioButton;
    private javax.swing.JLabel doctorLabel;
    private javax.swing.JLabel endTimeLabel;
    private javax.swing.JFormattedTextField endTimeTextField;
    private javax.swing.JRadioButton hygienistRadioButton;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JTextField patientTextField;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JFormattedTextField startTimeTextField;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}
