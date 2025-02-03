/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MenuListener class handles actions for the MenuForm.
 */
class MenuListener implements ActionListener {

    // Reference to the MenuForm
    private final MenuForm form;

    /**
     * Constructor for MenuListener.
     * @param form The MenuForm associated with this listener.
     */
    public MenuListener(MenuForm form) {
        // Initialize the form reference
        this.form = form;
    }

    /**
     * Handles button click events.
     * @param e The action event triggered by button clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch based on the action command
        switch(e.getActionCommand()) {
            case "Insert Doctor":
                // Navigate to the insert doctor form
                form.goInsert();
                break;
            case "Search Doctor":
                // Navigate to the search doctor form
                form.goSearch();
                break;
            case "Update Doctor":
                // Navigate to the update doctor form
                form.goUpdate();
                break;
            case "Delete Doctor":
                // Navigate to the delete doctor form
                form.goDelete();
                break;
            case "Exit":
                // Dispose of the current window
                form.dispose();
                break;
        }
    }

}
