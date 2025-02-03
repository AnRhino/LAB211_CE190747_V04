/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchdoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * V04 - Doctor management program
 * 
 * @author Nguyen Ho Phuoc An - CE190747
 */
/**
 * SearchListener class handles actions for the SearchForm.
 */
class SearchListener implements ActionListener {

    // Reference to the SearchForm
    private final SearchForm form;

    /**
     * Constructor for SearchListener.
     * 
     * @param form The SearchForm associated with this listener.
     */
    public SearchListener(SearchForm form) {
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
            case "Search":
                // Navigate to the results table
                form.goTable();
                break;
            case "Menu":
                // Navigate back to the menu
                form.goMenu();
                break;
        }
    }
}
