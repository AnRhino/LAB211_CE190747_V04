/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatedoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * V04 - Doctor management program
 *
 * @author Nguyen Ho Phuoc An - CE190747
 *
 * Last modified: 3/2/2025
 */
/**
 * UpdateListener class handles actions for the UpdateForm.
 */
public class UpdateListener implements ActionListener {

    // Reference to the UpdateForm
    private final UpdateForm form;
    // Doctor object to be updated
    private database.Doctor doctor;

    /**
     * Constructor for UpdateListener.
     *
     * @param form The UpdateForm associated with this listener.
     */
    public UpdateListener(UpdateForm form) {
        // Initialize the form reference
        this.form = form;
    }

    /**
     * Handles button click events.
     *
     * @param e The action event triggered by button clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch based on the action command
        switch (e.getActionCommand()) {
            case "Find":
                // Find the doctor by code
                doctor = database.DoctorDatabase.findByCode(form.getCodeFromTextField());
                // Check if doctor was found
                if (doctor == null) {
                    // Show error message if not found
                    JOptionPane.showMessageDialog(null, "Code not found!");
                } else {
                    // Show the doctor's information
                    form.showInformation(doctor.getCode(), doctor.getName(), doctor.getSpecialization(),
                            doctor.getAvailability() + "");
                }
                break;
            case "Update":
                // Get the doctor's code
                String code = doctor.getCode();
                // Get the name from the text field
                String name = form.getNameFromTextField();
                // Get the specialization from the text field
                String specialization = form.getSpecializationFromTextField();
                // Get the availability from the text field
                String availability = form.getAvailabilityFromTextField();
                // Check if all input fields are valid
                String error = database.DoctorDatabase.checkAllValid(null, name, specialization, availability);
                // Check for validation errors
                if (error != null) {
                    // Show error message if validation fails
                    JOptionPane.showMessageDialog(null, error);
                } else {
                    // Update the doctor's information in the database
                    database.DoctorDatabase.updateDoctor(code, name, specialization, availability);
                    // Show success message
                    JOptionPane.showMessageDialog(null, "Updated successfully!");
                    // Navigate back to the menu
                    form.goMenu();
                }
                break;
            case "Menu":
                // Navigate back to the menu
                form.goMenu();
                break;
        }
    }
}
