/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletedoctor;

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
 */
/**
 * DeleteForm class provides the user interface for deleting a doctor.
 */
public class DeleteForm extends JFrame {

    // UI components
    private final JTextField tfCode = new JTextField(); // Text field for entering the doctor's code
    private final JPanel infoPanel = new JPanel(); // Panel to display doctor information

    private final JButton btnMenu = new JButton("Menu"); // Button to navigate to the menu
    private final JButton btnFind = new JButton("Find"); // Button to find a doctor
    private final JButton btnDelete = new JButton("Delete"); // Button to delete a doctor
    private final JPanel buttonPanel = new JPanel(); // Panel to hold buttons

    /**
     * Sets up the window for the delete form.
     */
    private void setupWindow() {
        // Set the title of the window
        this.setTitle("Update Doctor");
        // Center the window on the screen
        this.setLocationRelativeTo(null);
        // Set the default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout manager
        this.setLayout(new BorderLayout());
        // Add the information panel
        addInfoPanel();
        // Add the button panel
        addButtonPanel();
        // Add action listeners to the buttons
        addDeleteListener(new DeleteListener(this));
        // Customize the size of the window
        customeSize();
    }

    /**
     * Customizes the size of the window.
     */
    private void customeSize() {
        // Pack the components within the window
        this.pack();
        // Set the size of the window
        this.setSize(330, this.getHeight());
    }

    /**
     * Adds the information panel to the form.
     */
    private void addInfoPanel() {
        // Set the layout for the info panel
        infoPanel.setLayout(new GridLayout(1, 2));
        // Add label and text field for code
        infoPanel.add(new JLabel("Code: "));
        infoPanel.add(tfCode);
        // Add the info panel to the center of the window
        this.add(infoPanel, BorderLayout.CENTER);
    }

    /**
     * Adds the button panel to the form.
     */
    private void addButtonPanel() {
        // Set the layout for the button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        // Add buttons to the button panel
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnFind);
        // Add the button panel to the south of the window
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Adds action listeners to the buttons.
     * 
     * @param listener The listener to be added.
     */
    private void addDeleteListener(DeleteListener listener) {
        // Add action listeners to the buttons
        btnDelete.addActionListener(listener);
        btnFind.addActionListener(listener);
        btnMenu.addActionListener(listener);
    }

    /**
     * Runs the delete form.
     */
    public void run() {
        // Set up the window
        setupWindow();
        // Make the window visible
        this.setVisible(true);
    }

    /**
     * Displays the information of the doctor to be deleted.
     * 
     * @param code           The code of the doctor.
     * @param name           The name of the doctor.
     * @param specialization The specialization of the doctor.
     * @param availability   The availability of the doctor.
     */
    void showInformation(String code, String name, String specialization, String availability) {
        // Set the layout for the info panel
        infoPanel.setLayout(new GridLayout(5, 2, 0, 5));
        // Remove the text field for code
        infoPanel.remove(tfCode);
        // Add the code label
        infoPanel.add(new JLabel(code));
        // Add labels for other doctor details
        infoPanel.add(new JLabel("Name: "));
        infoPanel.add(new JLabel(name));
        infoPanel.add(new JLabel("Specialization: "));
        infoPanel.add(new JLabel(specialization));
        infoPanel.add(new JLabel("Availability: "));
        infoPanel.add(new JLabel(availability));
        // Remove the find button and add the delete button
        buttonPanel.remove(btnFind);
        buttonPanel.add(btnDelete);
        // Customize the size of the window
        customeSize();
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
     * Navigates back to the menu.
     */
    void goMenu() {
        // Dispose of the current window
        this.dispose();
        // Create and run the menu form
        menu.MenuForm menuForm = new menu.MenuForm();
        menuForm.run();
    }
}
