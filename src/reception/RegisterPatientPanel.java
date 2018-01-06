/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reception;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import types.people.Patient;
import types.Address;
import connection.BackEndWrite;

/**
 *
 * @author alexandrabutoi
 */
public class RegisterPatientPanel extends javax.swing.JPanel {

    /**
     * @return the HealthcarePlan
     */
    public javax.swing.ButtonGroup getHealthcarePlan() {
        return HealthcarePlan;
    }

    /**
     * @param HealthcarePlan
     *            the HealthcarePlan to set
     */
    public void setHealthcarePlan(javax.swing.ButtonGroup HealthcarePlan) {
        this.HealthcarePlan = HealthcarePlan;
    }

    /**
     * @return the Title
     */
    public javax.swing.ButtonGroup getTitle() {
        return Title;
    }

    /**
     * @param Title
     *            the Title to set
     */
    public void setTitle(javax.swing.ButtonGroup Title) {
        this.Title = Title;
    }

    /**
     * @return the cityTextField
     */
    public javax.swing.JTextField getCityTextField() {
        return cityTextField;
    }

    /**
     * @param cityTextField
     *            the cityTextField to set
     */
    public void setCityTextField(javax.swing.JTextField cityTextField) {
        this.cityTextField = cityTextField;
    }

    /**
     * @return the districtTextField
     */
    public javax.swing.JTextField getDistrictTextField() {
        return districtTextField;
    }

    /**
     * @param districtTextField
     *            the districtTextField to set
     */
    public void setDistrictTextField(javax.swing.JTextField districtTextField) {
        this.districtTextField = districtTextField;
    }

    /**
     * @return the dobFormattedTextField
     */
    public javax.swing.JTextField getdobFormattedTextField() {
        return dobFormattedTextField;
    }

    /**
     * @param dobFormattedTextField
     *            the dobFormattedTextField to set
     */
    public void setdobFormattedTextField(javax.swing.JFormattedTextField dobFormattedTextField) {
        this.dobFormattedTextField = dobFormattedTextField;
    }

    /**
     * @return the firstNameTextField
     */
    public javax.swing.JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    /**
     * @param firstNameTextField
     *            the firstNameTextField to set
     */
    public void setFirstNameTextField(javax.swing.JTextField firstNameTextField) {
        this.firstNameTextField = firstNameTextField;
    }

    /**
     * @return the houseTextField
     */
    public javax.swing.JTextField getHouseTextField() {
        return houseTextField;
    }

    /**
     * @param houseTextField
     *            the houseTextField to set
     */
    public void setHouseTextField(javax.swing.JTextField houseTextField) {
        this.houseTextField = houseTextField;
    }

    /**
     * @return the lastNameTextField
     */
    public javax.swing.JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    /**
     * @param lastNameTextField
     *            the lastNameTextField to set
     */
    public void setLastNameTextField(javax.swing.JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    /**
     * @return the missRadioButton
     */
    public javax.swing.JRadioButton getMissRadioButton() {
        return missRadioButton;
    }

    /**
     * @param missRadioButton
     *            the missRadioButton to set
     */
    public void setMissRadioButton(javax.swing.JRadioButton missRadioButton) {
        this.missRadioButton = missRadioButton;
    }

    /**
     * @return the mrRadioButton
     */
    public javax.swing.JRadioButton getMrRadioButton() {
        return mrRadioButton;
    }

    /**
     * @param mrRadioButton
     *            the mrRadioButton to set
     */
    public void setMrRadioButton(javax.swing.JRadioButton mrRadioButton) {
        this.mrRadioButton = mrRadioButton;
    }

    /**
     * @return the mrsRadioButton
     */
    public javax.swing.JRadioButton getMrsRadioButton() {
        return mrsRadioButton;
    }

    /**
     * @param mrsRadioButton
     *            the mrsRadioButton to set
     */
    public void setMrsRadioButton(javax.swing.JRadioButton mrsRadioButton) {
        this.mrsRadioButton = mrsRadioButton;
    }

    /**
     * @return the msRadioButton
     */
    public javax.swing.JRadioButton getMsRadioButton() {
        return msRadioButton;
    }

    /**
     * @param msRadioButton
     *            the msRadioButton to set
     */
    public void setMsRadioButton(javax.swing.JRadioButton msRadioButton) {
        this.msRadioButton = msRadioButton;
    }

    /**
     * @return the phoneTextField
     */
    public javax.swing.JTextField getPhoneTextField() {
        return phoneTextField;
    }

    /**
     * @param phoneTextField
     *            the phoneTextField to set
     */
    public void setPhoneTextField(javax.swing.JTextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }

    /**
     * @return the plan1RadioButton
     */
    public javax.swing.JRadioButton getPlan1RadioButton() {
        return plan1RadioButton;
    }

    /**
     * @param plan1RadioButton
     *            the plan1RadioButton to set
     */
    public void setPlan1RadioButton(javax.swing.JRadioButton plan1RadioButton) {
        this.plan1RadioButton = plan1RadioButton;
    }

    /**
     * @return the plan2RadioButton
     */
    public javax.swing.JRadioButton getPlan2RadioButton() {
        return plan2RadioButton;
    }

    /**
     * @param plan2RadioButton
     *            the plan2RadioButton to set
     */
    public void setPlan2RadioButton(javax.swing.JRadioButton plan2RadioButton) {
        this.plan2RadioButton = plan2RadioButton;
    }

    /**
     * @return the plan3RadioButton
     */
    public javax.swing.JRadioButton getPlan3RadioButton() {
        return plan3RadioButton;
    }

    /**
     * @param plan3RadioButton
     *            the plan3RadioButton to set
     */
    public void setPlan3RadioButton(javax.swing.JRadioButton plan3RadioButton) {
        this.plan3RadioButton = plan3RadioButton;
    }

    /**
     * @return the plan4RadioButton
     */
    public javax.swing.JRadioButton getPlan4RadioButton() {
        return plan4RadioButton;
    }

    /**
     * @param plan4RadioButton
     *            the plan4RadioButton to set
     */
    public void setPlan4RadioButton(javax.swing.JRadioButton plan4RadioButton) {
        this.plan4RadioButton = plan4RadioButton;
    }

    /**
     * @return the postcodeTextField
     */
    public javax.swing.JTextField getPostcodeTextField() {
        return postcodeTextField;
    }

    /**
     * @param postcodeTextField
     *            the postcodeTextField to set
     */
    public void setPostcodeTextField(javax.swing.JTextField postcodeTextField) {
        this.postcodeTextField = postcodeTextField;
    }

    /**
     * @return the regPatButton
     */
    public javax.swing.JButton getRegPatButton() {
        return regPatButton;
    }

    /**
     * @param regPatButton
     *            the regPatButton to set
     */
    public void setRegPatButton(javax.swing.JButton regPatButton) {
        this.regPatButton = regPatButton;
    }

    /**
     * @return the streetTextField
     */
    public javax.swing.JTextField getStreetTextField() {
        return streetTextField;
    }

    /**
     * @param streetTextField
     *            the streetTextField to set
     */
    public void setStreetTextField(javax.swing.JTextField streetTextField) {
        this.streetTextField = streetTextField;
    }

    /**
     * Creates new form RegisterPatientPanel
     */
    public RegisterPatientPanel() {
        initComponents();
    }

    /**
     * 
     * @return patient's title
     */
    private String getPatientTitle() {
        if (missRadioButton.isSelected())
            return missRadioButton.getText();
        if (msRadioButton.isSelected())
            return msRadioButton.getText();
        if (mrsRadioButton.isSelected())
            return mrsRadioButton.getText();
        if (mrRadioButton.isSelected())
            return mrRadioButton.getText();
        return null;
    }

    /**
     * 
     * @return if the patient is on a HCP
     */
    private boolean hasPlan() {
        if (plan1RadioButton.isSelected())
            return true;
        if (plan2RadioButton.isSelected())
            return true;
        if (plan3RadioButton.isSelected())
            return true;
        return plan4RadioButton.isSelected();
    }

    /**
     * 
     * @return the name of the HCP
     */
    private String getPatientPlan() {
        if (plan1RadioButton.isSelected())
            return plan1RadioButton.getText();
        if (plan2RadioButton.isSelected())
            return plan2RadioButton.getText();
        if (plan3RadioButton.isSelected())
            return plan3RadioButton.getText();
        if (plan4RadioButton.isSelected())
            return plan4RadioButton.getText();
        return "NOPLAN";
    }

    /**
     * gets information from fields and returns a new Patient
     * 
     * @return new Patient
     * @throws ParseException
     */
    public Patient getInfo() throws ParseException {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dob = new Date(df.parse(String.valueOf(dobFormattedTextField.getText())).getTime());
        return new Patient(getPatientTitle(), firstNameTextField.getText(), lastNameTextField.getText(), dob,
                phoneTextField.getText(), hasPlan(), getPatientPlan(),
                new Address(Integer.parseInt(houseTextField.getText()), streetTextField.getText(),
                        districtTextField.getText(), cityTextField.getText(), postcodeTextField.getText()));
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

        Title = new javax.swing.ButtonGroup();
        HealthcarePlan = new javax.swing.ButtonGroup();
        titleLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        registerLabel = new javax.swing.JLabel();
        mrRadioButton = new javax.swing.JRadioButton();
        msRadioButton = new javax.swing.JRadioButton();
        mrsRadioButton = new javax.swing.JRadioButton();
        addressLabel = new javax.swing.JLabel();
        missRadioButton = new javax.swing.JRadioButton();
        streetLabel = new javax.swing.JLabel();
        houseLabel = new javax.swing.JLabel();
        districtLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        postcodeLabel = new javax.swing.JLabel();
        streetTextField = new javax.swing.JTextField();
        houseTextField = new javax.swing.JTextField();
        districtTextField = new javax.swing.JTextField();
        cityTextField = new javax.swing.JTextField();
        postcodeTextField = new javax.swing.JTextField();
        dobLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        planLabel = new javax.swing.JLabel();

        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        // javax.swing.JFormattedTextField dateTextField = new
        // javax.swing.JFormattedTextField(format);
        dobFormattedTextField = new javax.swing.JFormattedTextField(format);

        phoneTextField = new javax.swing.JTextField();
        plan1RadioButton = new javax.swing.JRadioButton();
        plan2RadioButton = new javax.swing.JRadioButton();
        plan3RadioButton = new javax.swing.JRadioButton();
        plan4RadioButton = new javax.swing.JRadioButton();
        regPatButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setText("Title");

        firstNameLabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        registerLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        registerLabel.setText("Register Patient");

        Title.add(mrRadioButton);
        mrRadioButton.setText("MR");
        mrRadioButton.setToolTipText("");

        Title.add(msRadioButton);
        msRadioButton.setText("MS");

        Title.add(mrsRadioButton);
        mrsRadioButton.setText("MRS");
        mrsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrsRadioButtonActionPerformed(evt);
            }
        });

        addressLabel.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        addressLabel.setText("Address");

        Title.add(missRadioButton);
        missRadioButton.setText("MISS");

        streetLabel.setText("Street ");

        houseLabel.setText("House Number");

        districtLabel.setText("District");

        cityLabel.setText("City");

        postcodeLabel.setText("Postcode");

        districtTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                districtTextFieldActionPerformed(evt);
            }
        });

        dobLabel.setText("Date of Birth");

        phoneLabel.setText("Phone Number");

        planLabel.setText("Healthcare Plan");

        // dobFormattedTextField.setFormatterFactory(new
        // javax.swing.text.DefaultFormatterFactory(new
        // javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        HealthcarePlan.add(plan1RadioButton);
        plan1RadioButton.setText("NHS Free Plan");

        HealthcarePlan.add(plan2RadioButton);
        plan2RadioButton.setText("Maintenance Plan");

        HealthcarePlan.add(plan3RadioButton);
        plan3RadioButton.setText("Oral Health Plan");

        HealthcarePlan.add(plan4RadioButton);
        plan4RadioButton.setText("Dental Repair Plan");

        regPatButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        regPatButton.setText("Register Patient");

        regPatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    regPatButtonActionPerformed(evt);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                        .createSequentialGroup().addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lastNameLabel)
                                .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(dobLabel).addComponent(phoneLabel).addComponent(planLabel))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(plan1RadioButton).addComponent(plan2RadioButton)
                                .addComponent(plan3RadioButton).addComponent(plan4RadioButton)
                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dobFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lastNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(firstNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup().addComponent(mrRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(msRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mrsRadioButton)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(missRadioButton)))
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addressLabel)
                                .addGroup(layout.createSequentialGroup().addGap(111, 111, 111).addGroup(layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(streetLabel).addComponent(houseLabel).addComponent(districtLabel)
                                        .addComponent(cityLabel).addComponent(postcodeLabel)).addGap(34, 34, 34)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(streetTextField).addComponent(houseTextField)
                                                .addComponent(districtTextField)
                                                .addComponent(cityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 177,
                                                        Short.MAX_VALUE)
                                                .addComponent(postcodeTextField)))))
                        .addGroup(layout.createSequentialGroup().addGap(412, 412, 412).addComponent(registerLabel))
                        .addGroup(layout.createSequentialGroup().addGap(404, 404, 404).addComponent(regPatButton,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addGap(56, 56, 56).addComponent(registerLabel).addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(titleLabel).addComponent(mrRadioButton).addComponent(msRadioButton)
                                .addComponent(mrsRadioButton).addComponent(missRadioButton).addComponent(addressLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(firstNameLabel)
                                .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(streetLabel).addComponent(streetTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lastNameLabel)
                                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(houseLabel).addComponent(houseTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(districtLabel)
                                .addComponent(districtTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dobLabel).addComponent(dobFormattedTextField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cityLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(phoneLabel)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(planLabel).addComponent(plan1RadioButton).addComponent(postcodeLabel)
                                .addComponent(postcodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plan2RadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plan3RadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plan4RadioButton).addGap(73, 73, 73).addComponent(regPatButton,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)));
    }// </editor-fold>//GEN-END:initComponents

    private void regPatButtonActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {// GEN-FIRST:event_regPatientButtonActionPerformed
        // TODO add your handling code here:
        // System.exit(0);
        BackEndWrite write = new BackEndWrite();
        write.registerPatient(this.getInfo());

        repaint();
    }// GEN-LAST:event_regPatientButtonActionPerformed

    private void mrsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mrsRadioButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mrsRadioButtonActionPerformed

    private void districtTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_districtTextFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_districtTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup HealthcarePlan;
    private javax.swing.ButtonGroup Title;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel districtLabel;
    private javax.swing.JTextField districtTextField;

    private javax.swing.JFormattedTextField dobFormattedTextField;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel houseLabel;
    private javax.swing.JTextField houseTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JRadioButton missRadioButton;
    private javax.swing.JRadioButton mrRadioButton;
    private javax.swing.JRadioButton mrsRadioButton;
    private javax.swing.JRadioButton msRadioButton;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JRadioButton plan1RadioButton;
    private javax.swing.JRadioButton plan2RadioButton;
    private javax.swing.JRadioButton plan3RadioButton;
    private javax.swing.JRadioButton plan4RadioButton;
    private javax.swing.JLabel planLabel;
    private javax.swing.JLabel postcodeLabel;
    private javax.swing.JTextField postcodeTextField;
    private javax.swing.JButton regPatButton;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
