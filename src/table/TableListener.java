/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * V04 - Doctor management program
 *
 * @author Nguyen Ho Phuoc An - CE190747
 * 
 * Last modified: 3/2/2025
 */
/**
 * TableListener class handles actions for the TableForm.
 */
public class TableListener implements ActionListener {

    // Reference to the TableForm
    private final TableForm form;

    /**
     * Constructor for TableListener.
     * 
     * @param form The TableForm associated with this listener.
     */
    public TableListener(TableForm form) {
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
            case "Search again":
                // Navigate back to the search form
                form.goSearch();
                break;
            case "Menu":
                // Navigate back to the menu
                form.goMenu();
                break;
        }
    }
}