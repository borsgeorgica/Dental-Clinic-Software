package reception;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import connection.BackEndRead;
import types.Appointment;
import types.people.Partner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandrabutoi
 */
public class CalendarPanel extends javax.swing.JPanel {

    /**
     * Creates new form CalendarPanel
     */
    public CalendarPanel(boolean dentist) {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        this.startDate = getMondayDate();
        this.endDate = getFridayDate();
        this.dentist = dentist;
    }

    private Date getMondayDate() {
        LocalDateTime thisWeeksMonday = LocalDateTime.now().with(DayOfWeek.MONDAY);

        Date date = Date.valueOf(thisWeeksMonday.toLocalDate());

        System.out.println(date);

        return date;

    }

    private Date getFridayDate() {
        LocalDateTime thisWeeksMonday = LocalDateTime.now().with(DayOfWeek.FRIDAY);
        Date date = Date.valueOf(thisWeeksMonday.toLocalDate());

        System.out.println(date);

        return date;
    }

    public void prepareAppointmentsDentist() {
        // Set Date Range
        String dateRange = "Week " + this.startDate.toString() + " - " + this.endDate.toString();
        getjLabel1().setText(dateRange);
        getjLabel1().setText(dateRange);

        // Get all dates for the week
        LocalDate start = this.startDate.toLocalDate();
        LocalDate end = this.endDate.toLocalDate();
        List<Date> totalWeekDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalWeekDates.add(Date.valueOf(start));
            start = start.plusDays(1);
        }
        // Get appointments for every day of the week - Dentist
        Partner dentist = new Partner(1, "Dr", "Matt", "Dentist");
        BackEndRead read = new BackEndRead();
        int count = 1;
        for (Date date : totalWeekDates) {

            ArrayList<Appointment> appointments = read.getPartnersDaysAppointments(date, dentist);
            displayAppointments(appointments, count);
            count++;
        }
    }

    public void prepareAppointmentsHygienist() {
        // Set Date Range
        String dateRange = "Week " + this.startDate.toString() + " - " + this.endDate.toString();
        getjLabel1().setText(dateRange);
        getjLabel1().setText(dateRange);

        // Get all dates for the week
        LocalDate start = this.startDate.toLocalDate();
        LocalDate end = this.endDate.toLocalDate();
        List<Date> totalWeekDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalWeekDates.add(Date.valueOf(start));
            start = start.plusDays(1);
        }

        // Get appointments for every day of the week - Hygienist
        Partner hygienist = new Partner(1, "Dr", "Emily", "Hygine");
        BackEndRead read = new BackEndRead();

        int count = 1;
        for (Date date : totalWeekDates) {

            ArrayList<Appointment> appointments = read.getPartnersDaysAppointments(date, hygienist);
            displayAppointments(appointments, count);
            count++;
        }
    }

    public void displayAppointments(ArrayList<Appointment> appointments, int day) {
        for (Appointment app : appointments) {
            LocalTime startTime = app.getStartTime().toLocalTime();
            LocalTime endTime = app.getEndTime().toLocalTime();

            String name = app.getPatient().getName() + " " + app.getPatient().getSurname();

            for (int i = 0; i < model.getRowCount(); i++) {

                if (model.getValueAt(i, 0) != null) {
                    LocalTime currentTime = LocalTime.parse((CharSequence) model.getValueAt(i, 0));
                    // Date date = new Date(sdf.parse(model.getValueAt(i, 0).toString()).getTime());
                    // long cTime = currentTime.getLong();
                    if (!currentTime.isBefore(startTime) && currentTime.isBefore(endTime)) {
                        model.setValueAt(name, i, day);
                    }
                } else {
                    System.out.println("Row " + i + " is null");
                }

            }

        }

    }

    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 1; j < model.getColumnCount(); j++) {
                model.setValueAt("", i, j);
            }
        }
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1
     *            the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 550));

        jButton1.setText("<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(">>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Week 19/11/2017-24/11/2017");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { "09:00", null, null, null, null, null }, { "09:20", null, null, null, null, null },
                        { "09:40", null, null, null, null, null }, { "10:00", null, null, null, null, null },
                        { "10:20", null, null, null, null, null }, { "10:40", null, null, null, null, null },
                        { "11:00", null, null, null, null, null }, { "11:20", null, null, null, null, null },
                        { "11:40", null, null, null, null, null }, { "12:00", null, null, null, null, null },
                        { "12:20", null, null, null, null, null }, { "12:40", null, null, null, null, null },
                        { "13:00", null, null, null, null, null }, { "13:20", null, null, null, null, null },
                        { "13:40", null, null, null, null, null }, { "14:00", null, null, null, null, null },
                        { "14:20", null, null, null, null, null }, { "14:40", null, null, null, null, null },
                        { "15:00", null, null, null, null, null }, { "15:20", null, null, null, null, null },
                        { "15:40", null, null, null, null, null }, { "16:00", null, null, null, null, null },
                        { "16:20", null, null, null, null, null }, { "16:40", null, null, null, null, null } },
                new String[] { "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup().addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel1).addGap(289, 289, 289).addComponent(jButton2)))
                        .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton1).addComponent(jLabel1).addComponent(jButton2))
                                        .addGap(39, 39, 39)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(73, Short.MAX_VALUE)));
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        this.cleanTable();
        this.startDate = Date.valueOf(this.startDate.toLocalDate().minusDays(7));
        this.endDate = Date.valueOf(this.endDate.toLocalDate().minusDays(7));
        if (dentist)
            prepareAppointmentsDentist();
        else
            prepareAppointmentsHygienist();

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        this.cleanTable();
        this.startDate = Date.valueOf(this.startDate.toLocalDate().plusDays(7));
        this.endDate = Date.valueOf(this.endDate.toLocalDate().plusDays(7));
        if (dentist)
            prepareAppointmentsDentist();
        else
            prepareAppointmentsHygienist();

    }// GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private DefaultTableModel model;
    private Date startDate;
    private Date endDate;
    private boolean dentist;

    // End of variables declaration//GEN-END:variables
}
