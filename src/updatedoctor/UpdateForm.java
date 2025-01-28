/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatedoctor;

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
public class UpdateForm extends JFrame {

    private final JLabel lbCode = new JLabel("Code: ");
    private final JTextField tfCode = new JTextField();
    private final JPanel codePanel = new JPanel();

    private final JLabel lbName = new JLabel("Name: ");
    private final JTextField tfName = new JTextField();
    private final JPanel namePanel = new JPanel();

    private final JLabel lbSpecialization = new JLabel("Specialization: ");
    private final JTextField tfSpecialization = new JTextField();
    private final JPanel specializationPanel = new JPanel();

    private final JLabel lbAvailability = new JLabel("Availability: ");
    private final JTextField tfAvailability = new JTextField();
    private final JPanel availabilityPanel = new JPanel();

    private final JButton btnMenu = new JButton("Menu");
    private final JButton btnFind = new JButton("Find");
    private final JButton btnUpdate = new JButton("Update");
    private final JPanel buttonPanel = new JPanel();

    private void addCodePanel() {
        codePanel.setLayout(new GridLayout(1, 2));
        codePanel.add(lbCode);
        codePanel.add(tfCode);
        this.add(codePanel);
    }

    private void addNamePanel(String name) {
        namePanel.setLayout(new GridLayout(1, 2));
        namePanel.add(lbName);
        namePanel.add(tfName);
        tfName.setText(name);
        this.add(namePanel);
    }

    private void addSpecializationPanel(String specialization) {
        specializationPanel.setLayout(new GridLayout(1, 2));
        specializationPanel.add(lbSpecialization);
        specializationPanel.add(tfSpecialization);
        tfSpecialization.setText(specialization);
        this.add(specializationPanel);
    }

    private void addAvailabilityPanel(String availability) {
        availabilityPanel.setLayout(new GridLayout(1, 2));
        availabilityPanel.add(lbAvailability);
        availabilityPanel.add(tfAvailability);
        tfAvailability.setText(availability);
        this.add(availabilityPanel);
    }

    private void addButtonPanel() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnFind);
        this.add(buttonPanel);
    }

    private void addUpdateListener(UpdateListener listener) {
        btnFind.addActionListener(listener);
        btnMenu.addActionListener(listener);
        btnUpdate.addActionListener(listener);
    }

    private void setupWindow() {
        this.setTitle("Update Doctor");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1, 0, 10));
        addCodePanel();
        addButtonPanel();
        addUpdateListener(new UpdateListener(this));
        this.pack();
        this.setSize(330, this.getHeight());
    }

    public void run() {
        setupWindow();
        this.setVisible(true);
    }

    void showInformation(String code, String name, String specialization, String availability) {
        codePanel.remove(tfCode);
        codePanel.add(new JLabel(code));
        this.remove(buttonPanel);
        addNamePanel(name);
        addSpecializationPanel(specialization);
        addAvailabilityPanel(availability);
        buttonPanel.remove(btnFind);
        buttonPanel.add(btnUpdate);
        this.add(buttonPanel);
        this.setVisible(true);
    }

    void goMenu() {
        this.dispose();
        menu.MenuForm menuForm = new menu.MenuForm();
        menuForm.run();
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
