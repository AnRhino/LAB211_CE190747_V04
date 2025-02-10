/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertdoctor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * V04 - Doctor management program
 *
 * @author Nguyen Ho Phuoc An - CE190747
 * 
 * Last modified: 3/2/2025
 */
/**
 * InsertForm class provides the user interface for inserting a new doctor.
 */
public class InsertForm extends JFrame {

    // Center panel for labels and text fields
    private final JPanel centerPanel = new JPanel(); // Panel to hold labels and text fields

    // Labels for input fields
    private final JLabel lbCode = new JLabel("Code: "); // Label for doctor's code
    private final JLabel lbName = new JLabel("Name: "); // Label for doctor's name
    private final JLabel lbSpecialization = new JLabel("Specialization: "); // Label for doctor's specialization
    private final JLabel lbAvailability = new JLabel("Availability: "); // Label for doctor's availability
    private final JPanel lablePanel = new JPanel(); // Panel to hold labels

    // Text fields for user input
    private final JTextField tfCode = new JTextField(15); // Text field for entering doctor's code
    private final JTextField tfName = new JTextField(15); // Text field for entering doctor's name
    private final JTextField tfSpecialization = new JTextField(15); // Text field for entering doctor's specialization
    private final JTextField tfAvailability = new JTextField(15); // Text field for entering doctor's availability
    private final JPanel textFieldPanel = new JPanel(); // Panel to hold text fields

    // Listener for handling insert actions
    private final InsertListener insertListener = new InsertListener(this);
    // Buttons for menu and insert actions
    private final JButton btnMenu = new JButton("Menu"); // Button to navigate to the menu
    private final JButton btnInsert = new JButton("Insert"); // Button to insert a new doctor
    private final JPanel buttonPanel = new JPanel(); // Panel to hold buttons

    /**
     * Sets up the window for the insert form.
     */
    private void setupWindow() {
        // Set the title of the window
        this.setTitle("Insert Doctor");
        // Center the window on the screen
        this.setLocationRelativeTo(null);
        // Set the default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout manager for the window
        this.setLayout(new BorderLayout());
        // Add labels and text fields to the window
        addLablesAndTextFields();
        // Add buttons to the window
        addButtons();
        // Pack the components within the window
        this.pack();
        // Set the size of the window
        this.setSize(320, this.getHeight());
    }

    /**
     * Adds labels and text fields to the center panel.
     */
    private void addLablesAndTextFields() {
        // Call method to add labels
        addLabels();
        // Call method to add text fields
        addTextFields();
        // Set the layout for the center panel
        centerPanel.setLayout(new FlowLayout());
        // Add the label panel to the center panel
        centerPanel.add(lablePanel);
        // Add the text field panel to the center panel
        centerPanel.add(textFieldPanel);
        // Add the center panel to the window
        this.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Adds labels to the form.
     */
    private void addLabels() {
        // Set the layout for the label panel
        lablePanel.setLayout(new GridLayout(4, 1));
        // Add the code label to the label panel
        lablePanel.add(lbCode);
        // Add the name label to the label panel
        lablePanel.add(lbName);
        // Add the specialization label to the label panel
        lablePanel.add(lbSpecialization);
        // Add the availability label to the label panel
        lablePanel.add(lbAvailability);
    }

    /**
     * Adds text fields to the form.
     */
    private void addTextFields() {
        // Set the layout for the text field panel
        textFieldPanel.setLayout(new GridLayout(4, 1));
        // Add the code text field to the text field panel
        textFieldPanel.add(tfCode);
        // Add the name text field to the text field panel
        textFieldPanel.add(tfName);
        // Add the specialization text field to the text field panel
        textFieldPanel.add(tfSpecialization);
        // Add the availability text field to the text field panel
        textFieldPanel.add(tfAvailability);
    }

    /**
     * Adds buttons to the form.
     */
    private void addButtons() {
        // Set the layout for the button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        // Add action listener to the menu button
        btnMenu.addActionListener(insertListener);
        // Add action listener to the insert button
        btnInsert.addActionListener(insertListener);
        // Add the menu button to the button panel
        buttonPanel.add(btnMenu);
        // Add the insert button to the button panel
        buttonPanel.add(btnInsert);
        // Add the button panel to the window
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Navigates back to the menu.
     */
    void goMenu() {
        // Dispose of the current window
        this.dispose();
        // Create a new instance of the menu form
        menu.MenuForm menuForm = new menu.MenuForm();
        // Run the menu form
        menuForm.run();
    }

    /**
     * Runs the insert form.
     */
    public void run() {
        // Set up the window
        setupWindow();
        // Make the window visible
        this.setVisible(true);
    }

    /**
     * Gets the code entered in the text field.
     * 
     * @return The code as a string.
     */
    String getCodeFromTextField() {
        // Return the text from the code text field
        return tfCode.getText();
    }

    /**
     * Gets the name entered in the text field.
     * 
     * @return The name as a string.
     */
    String getNameFromTextField() {
        // Return the text from the name text field
        return tfName.getText();
    }

    /**
     * Gets the specialization entered in the text field.
     * 
     * @return The specialization as a string.
     */
    String getSpecializationFromTextField() {
        // Return the text from the specialization text field
        return tfSpecialization.getText();
    }

    /**
     * Gets the availability entered in the text field.
     * 
     * @return The availability as a string.
     */
    String getAvailabilityFromTextField() {
        // Return the text from the availability text field
        return tfAvailability.getText();
    }
}
