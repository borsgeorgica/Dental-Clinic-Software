package reception;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandrabutoi
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
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

        regPatientButton = new javax.swing.JButton();
        findPatientButton = new javax.swing.JButton();
        appointmentsButton = new javax.swing.JButton();
        newAppointmentButton = new javax.swing.JButton();
        findAppointmentButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(137, 137, 138));
        setPreferredSize(new java.awt.Dimension(1000, 90));

        regPatientButton.setBackground(new java.awt.Color(234, 244, 244));
        regPatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_patient.png"))); // NOI18N
        regPatientButton.setText("Register Patient");

        findPatientButton.setBackground(new java.awt.Color(234, 244, 244));
        findPatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/find_patient.png"))); // NOI18N
        findPatientButton.setText("Find Patient");

        appointmentsButton.setBackground(new java.awt.Color(234, 244, 244));
        appointmentsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appointments.png"))); // NOI18N
        appointmentsButton.setText("Appointments");

        newAppointmentButton.setBackground(new java.awt.Color(234, 244, 244));
        newAppointmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_appointment.png"))); // NOI18N
        newAppointmentButton.setText("New Appointment");

        findAppointmentButton.setBackground(new java.awt.Color(234, 244, 244));
        findAppointmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/find_appointment.png"))); // NOI18N
        findAppointmentButton.setText("Find Appointment");
        findAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findAppointmentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap().addComponent(appointmentsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newAppointmentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findAppointmentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(regPatientButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findPatientButton).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
                javax.swing.GroupLayout.Alignment.LEADING,
                layout.createSequentialGroup().addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(regPatientButton).addComponent(findPatientButton)
                                .addComponent(appointmentsButton).addComponent(newAppointmentButton)
                                .addComponent(findAppointmentButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void findAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_findAppointmentButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_findAppointmentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appointmentsButton;
    private javax.swing.JButton findAppointmentButton;
    private javax.swing.JButton findPatientButton;
    private javax.swing.JButton newAppointmentButton;
    private javax.swing.JButton regPatientButton;
    // End of variables declaration//GEN-END:variables
}
