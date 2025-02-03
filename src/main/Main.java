/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 * V04 - Doctor management program
 *
 * This class serves as the main entry point for the Doctor management program,
 * which handles the initialization and execution of the application.
 *
 * @author Nguyen Ho Phuoc An - CE190747
 * 
 *         Last modified: 3/2/2025
 */
public class Main {

    /**
     * Main method to run the application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Create and run the menu form
        menu.MenuForm form = new menu.MenuForm();
        form.run();
    }
}
