/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchdoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PeterNguyen
 */
class SearchListener implements ActionListener {

    private final SearchForm form;

    public SearchListener(SearchForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Search":
                form.goTable();
                break;
            case "Menu":
                form.goMenu();
                break;
        }
    }

}
