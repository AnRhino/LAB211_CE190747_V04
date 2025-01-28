/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletedoctor;

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
public class DeleteForm extends JFrame {

    private final JTextField tfCode = new JTextField();
    private final JPanel infoPanel = new JPanel();

    private final JButton btnMenu = new JButton("Menu");
    private final JButton btnFind = new JButton("Find");
    private final JButton btnDelete = new JButton("Delete");
    private final JPanel buttonPanel = new JPanel();

    private void setupWindow() {
        this.setTitle("Update Doctor");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        addInfoPanel();
        addButtonPanel();
        addDeleteListener(new DeleteListener(this));
        customeSize();
    }

    private void customeSize() {
        this.pack();
        this.setSize(330, this.getHeight());
    }

    private void addInfoPanel() {
        infoPanel.setLayout(new GridLayout(1, 2));
        infoPanel.add(new JLabel("Code: "));
        infoPanel.add(tfCode);
        this.add(infoPanel, BorderLayout.CENTER);
    }

    private void addButtonPanel() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnFind);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addDeleteListener(DeleteListener listener) {
        btnDelete.addActionListener(listener);
        btnFind.addActionListener(listener);
        btnMenu.addActionListener(listener);
    }

    public void run() {
        setupWindow();
        this.setVisible(true);
    }

    void showInformation(String code, String name, String specialization, String availability) {
        infoPanel.setLayout(new GridLayout(5, 2, 0, 5));
        infoPanel.remove(tfCode);
        infoPanel.add(new JLabel(code));
        infoPanel.add(new JLabel("Name: "));
        infoPanel.add(new JLabel(name));
        infoPanel.add(new JLabel("Specialization: "));
        infoPanel.add(new JLabel(specialization));
        infoPanel.add(new JLabel("Availability: "));
        infoPanel.add(new JLabel(availability));
        buttonPanel.remove(btnFind);
        buttonPanel.add(btnDelete);
        customeSize();
        this.setVisible(true);
    }

    String getCodeFromTextField() {
        return tfCode.getText();
    }

    void goMenu() {
        this.dispose();
        menu.MenuForm menuForm = new menu.MenuForm();
        menuForm.run();
    }
}
