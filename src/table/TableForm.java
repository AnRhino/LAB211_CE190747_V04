/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author PeterNguyen
 */
public class TableForm extends JFrame {

    private final JTable jTable;
    private final JScrollPane jScrollPane;

    private final JButton btnMenu = new JButton("Menu");
    private final JButton btnSearchAgain = new JButton("Search again");
    private final JPanel buttonPanel = new JPanel();

    private final TableListener tableListener = new TableListener(this);

    public TableForm(String[][] data, String[] header) {
        jTable = new JTable(data, header);
        jScrollPane = new JScrollPane(jTable);
    }

    private void addButtons() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        btnMenu.addActionListener(tableListener);
        btnSearchAgain.addActionListener(tableListener);
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnSearchAgain);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupWindow() {
        this.setTitle("Table Doctor");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(jScrollPane, BorderLayout.CENTER);
        addButtons();
        this.pack();
        this.setSize(Math.max(315, this.getWidth()), this.getHeight());
    }

    public void run() {
        setupWindow();
        this.setVisible(true);
    }

    void goSearch() {
        this.dispose();
        searchdoctor.SearchForm searchForm = new searchdoctor.SearchForm();
        searchForm.run();
    }

    void goMenu() {
        this.dispose();
        menu.MenuForm menuForm = new menu.MenuForm();
        menuForm.run();
    }
}
