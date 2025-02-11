/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletedoctor;

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
 * DeleteListener class handles actions for the DeleteForm.
 */
public class DeleteListener implements ActionListener {

    // Reference to the DeleteForm
    private final DeleteForm form;
    // Doctor object to be deleted
    private database.Doctor doctor;

    /**
     * Constructor for DeleteListener.
     *
     * @param form The DeleteForm associated with this listener.
     */
    public DeleteListener(DeleteForm form) {
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
                // Get the code from the text field
                String code = form.getCodeFromTextField();
                // Find the doctor by code
                doctor = database.DoctorDatabase.findByCode(code);
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
            case "Delete":
                // Prompt for confirmation
                String confirm = JOptionPane.showInputDialog(null,
                        "To confirm, type \"" + doctor.getCode() + "\" in the box below");
                // Check if confirm is null
                if (confirm == null) {
                    break; // Break switch statement
                } else if (confirm.equals(doctor.getCode())) { // Check if confirmation matches the doctor's code
                    // Delete the doctor from the database
                    database.DoctorDatabase.deleteDoctor(doctor.getCode());
                    // Show success message
                    JOptionPane.showMessageDialog(null, "Deleted successfully!");
                    // Navigate back to the menu
                    form.goMenu();
                } else {
                    // Show error message if confirmation fails
                    JOptionPane.showMessageDialog(null, "Deletion failed!");
                }
                break;
            case "Menu":
                // Navigate back to the menu
                form.goMenu();
                break;
        }
    }

}
