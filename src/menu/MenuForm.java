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
 *
 * @author PeterNguyen
 */
public class MenuForm extends JFrame {

    private final JButton btnInsertDoctor = new JButton("Insert Doctor");
    private final JButton btnSearchDoctor = new JButton("Search Doctor");
    private final JButton btnUpdateDoctor = new JButton("Update Doctor");
    private final JButton btnDeleteDoctor = new JButton("Delete Doctor");
    private final JButton btnExit = new JButton("Exit");
    private final MenuListener menuListener = new MenuListener(this);

    private void setupWindow() {
        this.setTitle("Doctor Management");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1, 0, 10));
        addButtons();
        this.pack();
        this.setSize(370, this.getHeight());
    }

    private void addButtons() {
        this.add(btnInsertDoctor);
        btnInsertDoctor.addActionListener(menuListener);
        this.add(btnSearchDoctor);
        btnSearchDoctor.addActionListener(menuListener);
        this.add(btnUpdateDoctor);
        btnUpdateDoctor.addActionListener(menuListener);
        this.add(btnDeleteDoctor);
        btnDeleteDoctor.addActionListener(menuListener);
        this.add(btnExit);
        btnExit.addActionListener(menuListener);
    }

    void goInsert() {
        this.dispose();
        insertdoctor.InsertForm insertForm = new insertdoctor.InsertForm();
        insertForm.run();
    }

    void goSearch() {
        this.dispose();
        searchdoctor.SearchForm searchForm = new searchdoctor.SearchForm();
        searchForm.run();
    }

    void goUpdate() {
        this.dispose();;
        updatedoctor.UpdateForm updateForm = new updatedoctor.UpdateForm();
        updateForm.run();
    }

    void goDelete() {
        this.dispose();;
        deletedoctor.DeleteForm deleteForm = new deletedoctor.DeleteForm();
        deleteForm.run();
    }

    public void run() {
        setupWindow();
        this.setVisible(true);
    }
}
