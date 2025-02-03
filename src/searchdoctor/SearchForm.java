/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchdoctor;

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
 * SearchForm class provides the user interface for searching doctors.
 */
public class SearchForm extends JFrame {
    // UI components
    private final JLabel lbSearch = new JLabel("Find what: "); // Label for search input
    private final JTextField tfSearchText = new JTextField(); // Text field for entering search text
    private final JPanel searchPanel = new JPanel(); // Panel to hold search components

    private final SearchListener searchListener = new SearchListener(this); // Listener for search actions
    private final JButton btnMenu = new JButton("Menu"); // Button to navigate to the menu
    private final JButton btnSearch = new JButton("Search"); // Button to initiate search
    private final JPanel buttonPanel = new JPanel(); // Panel to hold buttons

    /**
     * Adds the search panel to the form.
     */
    private void addSearchPanel() {
        searchPanel.setLayout(new GridLayout(1, 2));
        searchPanel.add(lbSearch);
        searchPanel.add(tfSearchText);
        this.add(searchPanel);
    }

    /**
     * Adds buttons to the form.
     */
    private void addButtons() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        btnMenu.addActionListener(searchListener);
        btnSearch.addActionListener(searchListener);
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnSearch);
        this.add(buttonPanel);
    }

    /**
     * Sets up the window for the search form.
     */
    private void setupWindow() {
        this.setTitle("Search Doctor");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        addSearchPanel();
        addButtons();
        this.pack();
        this.setSize(325, this.getHeight());
    }

    /**
     * Runs the search form.
     */
    public void run() {
        setupWindow();
        this.setVisible(true);
    }

    /**
     * Navigates to the results table after searching.
     */
    void goTable() {
        this.dispose();
        String[] header = { "Code", "Name", "Specialization", "Availability" };
        String[][] data = database.DoctorDatabase.searchDoctor(tfSearchText.getText());
        table.TableForm searchTable = new table.TableForm(data, header);
        searchTable.run();
    }

    /**
     * Navigates back to the menu.
     */
    void goMenu() {
        this.dispose();
        menu.MenuForm menuForm = new menu.MenuForm();
        menuForm.run();
    }
}
