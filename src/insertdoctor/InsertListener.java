/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertdoctor;

import database.DoctorDatabase;
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
 * InsertListener class handles actions for the InsertForm.
 */
class InsertListener implements ActionListener {

    // Reference to the InsertForm
    private final InsertForm form;

    /**
     * Constructor for InsertListener.
     * 
     * @param form The InsertForm associated with this listener.
     */
    public InsertListener(InsertForm form) {
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
            case "Insert":
                // Retrieve the doctor's code from the text field
                String code = form.getCodeFromTextField();
                // Retrieve the doctor's name from the text field
                String name = form.getNameFromTextField();
                // Retrieve the doctor's specialization from the text field
                String specialization = form.getSpecializationFromTextField();
                // Retrieve the doctor's availability from the text field
                String availability = form.getAvailabilityFromTextField();
                // Check if all input fields are valid
                String error = DoctorDatabase.checkAllValid(code, name, specialization, availability);
                // Check for validation errors
                if (error != null) {
                    // Show error message if validation fails
                    JOptionPane.showMessageDialog(null, error);
                } else {
                    // Add the new doctor to the database
                    DoctorDatabase.addDoctor(code, name, specialization, availability);
                    // Show success message
                    JOptionPane.showMessageDialog(null, "Inserted successfully!");
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
