/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchdoctor;

import java.awt.FlowLayout; // Import FlowLayout for layout management
import java.awt.GridLayout; // Import GridLayout for layout management
import javax.swing.JButton; // Import JButton for button creation
import javax.swing.JFrame; // Import JFrame for window creation
import javax.swing.JLabel; // Import JLabel for label creation
import javax.swing.JPanel; // Import JPanel for panel creation
import javax.swing.JTextField; // Import JTextField for text input

/**
 * V04 - Doctor management program
 *
 * @author Nguyen Ho Phuoc An - CE190747
 * 
 * Last modified: 3/2/2025
 */
/**
 * SearchForm class provides the user interface for searching doctors.
 */
public class SearchForm extends JFrame {
    // Label for search input
    private final JLabel lbSearch = new JLabel("Find what: "); 
    // Text field for entering search text
    private final JTextField tfSearchText = new JTextField(); 
    // Panel to hold search components
    private final JPanel searchPanel = new JPanel(); 
    // Listener for search actions
    private final SearchListener searchListener = new SearchListener(this); 
    // Button to navigate to the menu
    private final JButton btnMenu = new JButton("Menu"); 
    // Button to initiate search
    private final JButton btnSearch = new JButton("Search"); 
    // Panel to hold buttons
    private final JPanel buttonPanel = new JPanel(); 

    /**
     * Adds the search panel to the form.
     */
    private void addSearchPanel() {
        // Set the layout for search panel
        searchPanel.setLayout(new GridLayout(1, 2)); 
        // Add label to search panel
        searchPanel.add(lbSearch); 
        // Add text field to search panel
        searchPanel.add(tfSearchText); 
        // Add search panel to the form
        this.add(searchPanel); 
    }

    /**
     * Adds buttons to the form.
     */
    private void addButtons() {
        // Set the layout for button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0)); 
        // Add action listener to menu button
        btnMenu.addActionListener(searchListener); 
        // Add action listener to search button
        btnSearch.addActionListener(searchListener); 
        // Add buttons to the button panel
        buttonPanel.add(btnMenu); 
        buttonPanel.add(btnSearch); 
        // Add button panel to the form
        this.add(buttonPanel); 
    }

    /**
     * Sets up the window for the search form.
     */
    private void setupWindow() {
        // Set the title of the window
        this.setTitle("Search Doctor"); 
        // Center the window on the screen
        this.setLocationRelativeTo(null); 
        // Set the default close operation
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        // Set layout manager
        this.setLayout(new GridLayout(2, 1)); 
        // Add search panel to the form
        addSearchPanel(); 
        // Add buttons to the form
        addButtons(); 
        // Pack the components within the window
        this.pack(); 
        // Set the size of the window
        this.setSize(325, this.getHeight()); 
    }

    /**
     * Runs the search form.
     */
    public void run() {
        // Set up the window
        setupWindow(); 
        // Make the window visible
        this.setVisible(true); 
    }

    /**
     * Navigates to the results table after searching.
     */
    void goTable() {
        // Dispose of the current window
        this.dispose(); 
        // Define table headers
        String[] header = { "Code", "Name", "Specialization", "Availability" }; 
        // Search for doctors
        String[][] data = database.DoctorDatabase.searchDoctor(tfSearchText.getText()); 
        // Create table form with results
        table.TableForm searchTable = new table.TableForm(data, header); 
        // Run the table form
        searchTable.run(); 
    }

    /**
     * Navigates back to the menu.
     */
    void goMenu() {
        // Dispose of the current window
        this.dispose(); 
        // Create a new menu form
        menu.MenuForm menuForm = new menu.MenuForm(); 
        // Run the menu form
        menuForm.run(); 
    }
}
