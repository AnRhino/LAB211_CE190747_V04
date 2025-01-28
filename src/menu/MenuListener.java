/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PeterNguyen
 */
class MenuListener implements ActionListener {

    private final MenuForm form;

    public MenuListener(MenuForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Insert Doctor":
                form.goInsert();
                break;
            case "Search Doctor":
                form.goSearch();
                break;
            case "Update Doctor":
                form.goUpdate();
                break;
            case "Delete Doctor":
                form.goDelete();
                break;
            case "Exit":
                form.dispose();
                break;
        }
    }

}
