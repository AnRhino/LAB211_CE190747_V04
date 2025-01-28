/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletedoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PeterNguyen
 */
public class DeleteListener implements ActionListener {
    
    private final DeleteForm form;
    private database.Doctor doctor;
    
    public DeleteListener(DeleteForm form) {
        this.form = form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Find":
                String code = form.getCodeFromTextField();
                doctor = database.DoctorDatabase.findByCode(code);
                if (doctor == null) {
                    JOptionPane.showMessageDialog(null, "Code not found!");
                } else {
                    form.showInformation(doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability() + "");
                }
                break;
            case "Delete":
                String confirm = JOptionPane.showInputDialog(null, "To confirm, type \"" + doctor.getCode() + "\" in the box below");
                if (confirm.equals(doctor.getCode())) {
                    database.DoctorDatabase.deleteDoctor(doctor.getCode());
                    JOptionPane.showMessageDialog(null, "Deleted successfully!");
                    form.goMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Deletion failed!");
                }
                break;
            case "Menu":
                form.goMenu();
                break;
        }
    }
    
}
