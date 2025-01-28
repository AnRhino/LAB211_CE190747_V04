/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatedoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PeterNguyen
 */
public class UpdateListener implements ActionListener {

    private final UpdateForm form;
    private database.Doctor doctor;

    public UpdateListener(UpdateForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Find":
                doctor = database.DoctorDatabase.findByCode(form.getCodeFromTextField());
                if (doctor == null) {
                    JOptionPane.showMessageDialog(null, "Code not found!");
                } else {
                    form.showInformation(doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability() + "");
                }
                break;
            case "Update":
                String code = doctor.getCode();
                String name = form.getNameFromTextField();
                String specialization = form.getSpecializationFromTextField();
                String availability = form.getAvailabilityFromTextField();
                database.DoctorDatabase.updateDoctor(code, name, specialization, availability);
                JOptionPane.showMessageDialog(null, "Updated successfully!");
                form.goMenu();
                break;
            case "Menu":
                form.goMenu();
                break;
        }
    }

}
