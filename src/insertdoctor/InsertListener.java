/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertdoctor;

import database.DoctorDatabase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PeterNguyen
 */
class InsertListener implements ActionListener {

    private final InsertForm form;

    public InsertListener(InsertForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Insert":
                String code = form.getCodeFromTextField();
                String name = form.getNameFromTextField();
                String specialization = form.getSpecializationFromTextField();
                String availability = form.getAvailabilityFromTextField();
                String error = DoctorDatabase.checkAllValid(code, name, specialization, availability);
                if (error != null) {
                    JOptionPane.showMessageDialog(null, error);
                } else {
                    DoctorDatabase.addDoctor(code, name, specialization, availability);
                    JOptionPane.showMessageDialog(null, "Inserted successfully!");
                    form.goMenu();
                }
                break;
            case "Menu":
                form.goMenu();
                break;
        }
    }

}
