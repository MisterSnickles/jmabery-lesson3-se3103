package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class ShowKeyButtonListener implements ItemListener{

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox check = (JCheckBox) e.getSource();
        boolean selected = check.isSelected();
        App.game.setShowKeyOn(selected);
        App.win.updateWindow();
    }
}
