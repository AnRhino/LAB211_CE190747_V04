/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertdoctor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PeterNguyen
 */
public class InsertForm extends JFrame {

    private final JPanel centerPanel = new JPanel();

    private final JLabel lbCode = new JLabel("Code: ");
    private final JLabel lbName = new JLabel("Name: ");
    private final JLabel lbSpecialization = new JLabel("Specialization: ");
    private final JLabel lbAvailability = new JLabel("Availability: ");
    private final JPanel lablePanel = new JPanel();

    private final JTextField tfCode = new JTextField(15);
    private final JTextField tfName = new JTextField(15);
    private final JTextField tfSpecialization = new JTextField(15);
    private final JTextField tfAvailability = new JTextField(15);
    private final JPanel textFieldPanel = new JPanel();

    private final InsertListener insertListener = new InsertListener(this);
    private final JButton btnMenu = new JButton("Menu");
    private final JButton btnInsert = new JButton("Insert");
    private final JPanel buttonPanel = new JPanel();

    private void setupWindow() {
        this.setTitle("Insert Doctor");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        addLablesAndTextFields();
        addButtons();
        this.pack();
        this.setSize(320, this.getHeight());
    }

    private void addLablesAndTextFields() {
        addLabels();
        addTextFields();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(lablePanel);
        centerPanel.add(textFieldPanel);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    private void addLabels() {
        lablePanel.setLayout(new GridLayout(4, 1));
        lablePanel.add(lbCode);
        lablePanel.add(lbName);
        lablePanel.add(lbSpecialization);
        lablePanel.add(lbAvailability);
    }

    private void addTextFields() {
        textFieldPanel.setLayout(new GridLayout(4, 1));
        textFieldPanel.add(tfCode);
        textFieldPanel.add(tfName);
        textFieldPanel.add(tfSpecialization);
        textFieldPanel.add(tfAvailability);
    }

    private void addButtons() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        btnMenu.addActionListener(insertListener);
        btnInsert.addActionListener(insertListener);
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnInsert);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    void goMenu() {
        this.dispose();
        menu.MenuForm menuForm = new menu.MenuForm();
        menuForm.run();
    }

    public void run() {
        setupWindow();
        this.setVisible(true);
    }

    String getCodeFromTextField() {
        return tfCode.getText();
    }

    String getNameFromTextField() {
        return tfName.getText();
    }

    String getSpecializationFromTextField() {
        return tfSpecialization.getText();
    }

    String getAvailabilityFromTextField() {
        return tfAvailability.getText();
    }
}
