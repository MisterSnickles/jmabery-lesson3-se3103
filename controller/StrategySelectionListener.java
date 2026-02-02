package controller;

import java.awt.event.ActionListener;

import model.PlayStrategy;
import view.AppWindow;

import java.awt.event.ActionEvent;

public class StrategySelectionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case AppWindow.highLowAction:
                App.game.setStrategy(PlayStrategy.HighLow);
                break;
            case AppWindow.closeAwayAction:
                App.game.setStrategy(PlayStrategy.CloseAway);
                break;   
        }
    }
}
