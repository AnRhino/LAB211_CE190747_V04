/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PeterNguyen
 */
public class TableListener implements ActionListener {

    private final TableForm form;

    public TableListener(TableForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Search again":
                form.goSearch();
                break;
            case "Menu":
                form.goMenu();
                break;
        }
    }
}