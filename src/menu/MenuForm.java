/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * V04 - Doctor management program
 *
 * @author Nguyen Ho Phuoc An - CE190747
 * 
 * Last modified: 3/2/2025
 */
/**
 * MenuForm class provides the main menu interface for the application.
 */
public class MenuForm extends JFrame {

    // Button to insert a new doctor
    private final JButton btnInsertDoctor = new JButton("Insert Doctor");
    // Button to search for a doctor
    private final JButton btnSearchDoctor = new JButton("Search Doctor");
    // Button to update a doctor's information
    private final JButton btnUpdateDoctor = new JButton("Update Doctor");
    // Button to delete a doctor
    private final JButton btnDeleteDoctor = new JButton("Delete Doctor");
    // Button to exit the application
    private final JButton btnExit = new JButton("Exit");
    // Listener for menu actions
    private final MenuListener menuListener = new MenuListener(this);

    /**
     * Sets up the window for the menu form.
     */
    private void setupWindow() {
        // Set the title of the window
        this.setTitle("Doctor Management");
        // Center the window on the screen
        this.setLocationRelativeTo(null);
        // Set the default close operation
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set the layout manager
        this.setLayout(new GridLayout(5, 1, 0, 10));
        // Add buttons to the menu
        addButtons();
        // Pack the components within the window
        this.pack();
        // Set the size of the window
        this.setSize(370, this.getHeight());
    }

    /**
     * Adds buttons to the menu form.
     */
    private void addButtons() {
        // Add the button to insert a new doctor
        this.add(btnInsertDoctor);
        // Add action listener for inserting a new doctor
        btnInsertDoctor.addActionListener(menuListener);
        
        // Add the button to search for a doctor
        this.add(btnSearchDoctor);
        // Add action listener for searching a doctor
        btnSearchDoctor.addActionListener(menuListener);
        
        // Add the button to update a doctor's information
        this.add(btnUpdateDoctor);
        // Add action listener for updating a doctor's information
        btnUpdateDoctor.addActionListener(menuListener);
        
        // Add the button to delete a doctor
        this.add(btnDeleteDoctor);
        // Add action listener for deleting a doctor
        btnDeleteDoctor.addActionListener(menuListener);
        
        // Add the button to exit the application
        this.add(btnExit);
        // Add action listener for exiting the application
        btnExit.addActionListener(menuListener);
    }

    /**
     * Navigates to the insert doctor form.
     */
    void goInsert() {
        // Dispose of the current window
        this.dispose();
        // Create and run the insert form
        insertdoctor.InsertForm insertForm = new insertdoctor.InsertForm();
        insertForm.run();
    }

    /**
     * Navigates to the search doctor form.
     */
    void goSearch() {
        // Dispose of the current window
        this.dispose();
        // Create and run the search form
        searchdoctor.SearchForm searchForm = new searchdoctor.SearchForm();
        searchForm.run();
    }

    /**
     * Navigates to the update doctor form.
     */
    void goUpdate() {
        // Dispose of the current window
        this.dispose();
        // Create and run the update form
        updatedoctor.UpdateForm updateForm = new updatedoctor.UpdateForm();
        updateForm.run();
    }

    /**
     * Navigates to the delete doctor form.
     */
    void goDelete() {
        // Dispose of the current window
        this.dispose();
        // Create and run the delete form
        deletedoctor.DeleteForm deleteForm = new deletedoctor.DeleteForm();
        deleteForm.run();
    }

    /**
     * Runs the menu form.
     */
    public void run() {
        // Set up the window
        setupWindow();
        // Make the window visible
        this.setVisible(true);
    }
}
