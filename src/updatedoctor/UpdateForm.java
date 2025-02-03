/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatedoctor;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * UpdateForm class provides the user interface for updating a doctor's information.
 */
public class UpdateForm extends JFrame {

    // UI components
    private final JLabel lbCode = new JLabel("Code: ");
    private final JTextField tfCode = new JTextField();
    private final JPanel codePanel = new JPanel();

    private final JLabel lbName = new JLabel("Name: ");
    private final JTextField tfName = new JTextField();
    private final JPanel namePanel = new JPanel();

    private final JLabel lbSpecialization = new JLabel("Specialization: ");
    private final JTextField tfSpecialization = new JTextField();
    private final JPanel specializationPanel = new JPanel();

    private final JLabel lbAvailability = new JLabel("Availability: ");
    private final JTextField tfAvailability = new JTextField();
    private final JPanel availabilityPanel = new JPanel();

    private final JButton btnMenu = new JButton("Menu");
    private final JButton btnFind = new JButton("Find");
    private final JButton btnUpdate = new JButton("Update");
    private final JPanel buttonPanel = new JPanel();

    /**
     * Adds the code panel to the form.
     */
    private void addCodePanel() {
        // Set the layout for the code panel
        codePanel.setLayout(new GridLayout(1, 2));
        // Add label and text field for code
        codePanel.add(lbCode);
        codePanel.add(tfCode);
        // Add the code panel to the form
        this.add(codePanel);
    }

    /**
     * Adds the name panel to the form.
     * @param name The name to display.
     */
    private void addNamePanel(String name) {
        // Set the layout for the name panel
        namePanel.setLayout(new GridLayout(1, 2));
        // Add label and text field for name
        namePanel.add(lbName);
        namePanel.add(tfName);
        // Set the text field with the name
        tfName.setText(name);
        // Add the name panel to the form
        this.add(namePanel);
    }

    /**
     * Adds the specialization panel to the form.
     * @param specialization The specialization to display.
     */
    private void addSpecializationPanel(String specialization) {
        // Set the layout for the specialization panel
        specializationPanel.setLayout(new GridLayout(1, 2));
        // Add label and text field for specialization
        specializationPanel.add(lbSpecialization);
        specializationPanel.add(tfSpecialization);
        // Set the text field with the specialization
        tfSpecialization.setText(specialization);
        // Add the specialization panel to the form
        this.add(specializationPanel);
    }

    /**
     * Adds the availability panel to the form.
     * @param availability The availability to display.
     */
    private void addAvailabilityPanel(String availability) {
        // Set the layout for the availability panel
        availabilityPanel.setLayout(new GridLayout(1, 2));
        // Add label and text field for availability
        availabilityPanel.add(lbAvailability);
        availabilityPanel.add(tfAvailability);
        // Set the text field with the availability
        tfAvailability.setText(availability);
        // Add the availability panel to the form
        this.add(availabilityPanel);
    }

    /**
     * Adds the button panel to the form.
     */
    private void addButtonPanel() {
        // Set the layout for the button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        // Add buttons to the panel
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnFind);
        // Add the button panel to the form
        this.add(buttonPanel);
    }

    /**
     * Adds action listeners to the buttons.
     * @param listener The listener to be added.
     */
    private void addUpdateListener(UpdateListener listener) {
        // Add action listeners to the buttons
        btnFind.addActionListener(listener);
        btnMenu.addActionListener(listener);
        btnUpdate.addActionListener(listener);
    }

    /**
     * Sets up the window for the update form.
     */
    private void setupWindow() {
        // Set the title of the window
        this.setTitle("Update Doctor");
        // Center the window on the screen
        this.setLocationRelativeTo(null);
        // Set the default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout manager
        this.setLayout(new GridLayout(5, 1, 0, 10));
        // Add panels to the form
        addCodePanel();
        addButtonPanel();
        // Add action listeners to the buttons
        addUpdateListener(new UpdateListener(this));
        // Pack the components within the window
        this.pack();
        // Set the size of the window
        this.setSize(330, this.getHeight());
    }

    /**
     * Runs the update form.
     */
    public void run() {
        // Set up the window
        setupWindow();
        // Make the window visible
        this.setVisible(true);
    }

    /**
     * Displays the information of the doctor to be updated.
     * @param code The code of the doctor.
     * @param name The name of the doctor.
     * @param specialization The specialization of the doctor.
     * @param availability The availability of the doctor.
     */
    void showInformation(String code, String name, String specialization, String availability) {
        // Remove the text field for code
        codePanel.remove(tfCode);
        // Add the code label
        codePanel.add(new JLabel(code));
        // Remove the button panel
        this.remove(buttonPanel);
        // Add name, specialization, and availability panels
        addNamePanel(name);
        addSpecializationPanel(specialization);
        addAvailabilityPanel(availability);
        // Remove the find button and add the update button
        buttonPanel.remove(btnFind);
        buttonPanel.add(btnUpdate);
        // Add the button panel back to the form
        this.add(buttonPanel);
        // Make the window visible
        this.setVisible(true);
    }

    /**
     * Navigates back to the menu.
     */
    void goMenu() {
        // Dispose of the current window
        this.dispose();
        // Create and run the menu form
        menu.MenuForm menuForm = new menu.MenuForm();
        menuForm.run();
    }

    /**
     * Gets the code entered in the text field.
     * @return The code as a string.
     */
    String getCodeFromTextField() {
        // Return the text from the code text field
        return tfCode.getText();
    }

    /**
     * Gets the name entered in the text field.
     * @return The name as a string.
     */
    String getNameFromTextField() {
        // Return the text from the name text field
        return tfName.getText();
    }

    /**
     * Gets the specialization entered in the text field.
     * @return The specialization as a string.
     */
    String getSpecializationFromTextField() {
        // Return the text from the specialization text field
        return tfSpecialization.getText();
    }

    /**
     * Gets the availability entered in the text field.
     * @return The availability as a string.
     */
    String getAvailabilityFromTextField() {
        // Return the text from the availability text field
        return tfAvailability.getText();
    }
}
