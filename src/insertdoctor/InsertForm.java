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
    private final InsertListener insertListener = new InsertListener(this); // Listener for insert actions
    // Buttons for menu and insert actions
    private final JButton btnMenu = new JButton("Menu"); // Button to navigate to the menu
    private final JButton btnInsert = new JButton("Insert"); // Button to insert a new doctor
    private final JPanel buttonPanel = new JPanel(); // Panel to hold buttons

    /**
     * Sets up the window for the insert form.
     */
    private void setupWindow() {
        this.setTitle("Insert Doctor");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        addLablesAndTextFields();
        addButtons();
        this.pack();
        this.setSize(320, this.getHeight());
    }

    /**
     * Adds labels and text fields to the center panel.
     */
    private void addLablesAndTextFields() {
        addLabels();
        addTextFields();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(lablePanel);
        centerPanel.add(textFieldPanel);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Adds labels to the form.
     */
    private void addLabels() {
        lablePanel.setLayout(new GridLayout(4, 1));
        lablePanel.add(lbCode);
        lablePanel.add(lbName);
        lablePanel.add(lbSpecialization);
        lablePanel.add(lbAvailability);
    }

    /**
     * Adds text fields to the form.
     */
    private void addTextFields() {
        textFieldPanel.setLayout(new GridLayout(4, 1));
        textFieldPanel.add(tfCode);
        textFieldPanel.add(tfName);
        textFieldPanel.add(tfSpecialization);
        textFieldPanel.add(tfAvailability);
    }

    /**
     * Adds buttons to the form.
     */
    private void addButtons() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        btnMenu.addActionListener(insertListener);
        btnInsert.addActionListener(insertListener);
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnInsert);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Navigates back to the menu.
     */
    void goMenu() {
        this.dispose();
        menu.MenuForm menuForm = new menu.MenuForm();
        menuForm.run();
    }

    /**
     * Runs the insert form.
     */
    public void run() {
        setupWindow();
        this.setVisible(true);
    }

    /**
     * Gets the code entered in the text field.
     * 
     * @return The code as a string.
     */
    String getCodeFromTextField() {
        return tfCode.getText();
    }

    /**
     * Gets the name entered in the text field.
     * 
     * @return The name as a string.
     */
    String getNameFromTextField() {
        return tfName.getText();
    }

    /**
     * Gets the specialization entered in the text field.
     * 
     * @return The specialization as a string.
     */
    String getSpecializationFromTextField() {
        return tfSpecialization.getText();
    }

    /**
     * Gets the availability entered in the text field.
     * 
     * @return The availability as a string.
     */
    String getAvailabilityFromTextField() {
        return tfAvailability.getText();
    }
}
