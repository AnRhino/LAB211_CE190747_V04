/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * V04 - Doctor management program
 * 
 * @author Nguyen Ho Phuoc An - CE190747
 */
/**
 * TableForm class displays the search results in a table format.
 */
public class TableForm extends JFrame {

    // Table to display data
    private final JTable jTable;
    // Scroll pane for the table
    private final JScrollPane jScrollPane;

    // Buttons for menu and search again actions
    private final JButton btnMenu = new JButton("Menu"); // Button to navigate to the menu
    private final JButton btnSearchAgain = new JButton("Search again"); // Button to search again
    private final JPanel buttonPanel = new JPanel(); // Panel to hold buttons

    // Listener for handling table actions
    private final TableListener tableListener = new TableListener(this); // Listener for table actions

    /**
     * Constructor for TableForm.
     * 
     * @param data   The data to be displayed in the table.
     * @param header The headers for the table columns.
     */
    public TableForm(String[][] data, String[] header) {
        // Initialize the table with data and headers
        jTable = new JTable(data, header);
        // Create a scroll pane for the table
        jScrollPane = new JScrollPane(jTable);
    }

    /**
     * Adds buttons to the table form.
     */
    private void addButtons() {
        // Set the layout for the button panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        // Add action listeners to the buttons
        btnMenu.addActionListener(tableListener);
        btnSearchAgain.addActionListener(tableListener);
        // Add buttons to the panel
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnSearchAgain);
        // Add the button panel to the south of the window
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Sets up the window for the table form.
     */
    private void setupWindow() {
        // Set the title of the window
        this.setTitle("Table Doctor");
        // Center the window on the screen
        this.setLocationRelativeTo(null);
        // Set the default close operation
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set the layout manager
        this.setLayout(new BorderLayout());
        // Add the table to the center of the window
        this.add(jScrollPane, BorderLayout.CENTER);
        // Add buttons to the form
        addButtons();
        // Pack the components within the window
        this.pack();
        // Set the size of the window
        this.setSize(Math.max(315, this.getWidth()), this.getHeight());
    }

    /**
     * Runs the table form.
     */
    public void run() {
        // Set up the window
        setupWindow();
        // Make the window visible
        this.setVisible(true);
    }

    /**
     * Navigates back to the search form.
     */
    void goSearch() {
        // Dispose of the current window
        this.dispose();
        // Create and run the search form
        searchdoctor.SearchForm searchForm = new searchdoctor.SearchForm();
        searchForm.run();
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
