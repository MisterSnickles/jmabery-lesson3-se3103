package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.App;
import controller.ExitButtonListener;
import controller.NewGameButtonListener;
import controller.NumberEnterListener;
import controller.ShowKeyButtonListener;
import controller.StrategySelectionListener;

public class AppWindow extends JFrame {

    public static final String highLowAction = "High/Low";
    public static final String closeAwayAction = "Close/Away";

    private AppCanvas canvas;

    private JTextField numberField;
    private JRadioButton highLowButton;
    private JRadioButton closeAwayButton;

    private JCheckBox showKeyButton;
    private JButton newGameButton;
    private JButton exitButton;
    
    public void init() {
        var cp = getContentPane();
        canvas = new AppCanvas();
        cp.add(canvas, BorderLayout.CENTER);


        // south panel for showkey, newgame, exit
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 1));
        cp.add(southPanel, BorderLayout.SOUTH);


        // number panel
        JPanel numberPanel = new JPanel();
        southPanel.add(numberPanel);
        numberPanel.setBorder(new TitledBorder("Your guess"));
        numberPanel.add(new JLabel("Enter (0 ~ 100)"));
        numberField = new JTextField(10);
        numberPanel.add(numberField);
        numberField.addActionListener(new NumberEnterListener());

        JPanel strategyPanel = new JPanel();
        southPanel.add(strategyPanel); 
        strategyPanel.setBorder(new TitledBorder("Select strategy")); 
        highLowButton = new JRadioButton(highLowAction, App.game.getStrategy() == model.PlayStrategy.HighLow);
        closeAwayButton = new JRadioButton(closeAwayAction, App.game.getStrategy() == model.PlayStrategy.CloseAway);
        strategyPanel.add(highLowButton);
        strategyPanel.add(closeAwayButton);
        StrategySelectionListener strategyListener = new StrategySelectionListener();
        highLowButton.addActionListener(strategyListener);
        closeAwayButton.addActionListener(strategyListener);

        ButtonGroup strategyGroup = new ButtonGroup();
        strategyGroup.add(highLowButton);
        strategyGroup.add(closeAwayButton);

        JPanel actionPanel = new JPanel();
        southPanel.add(actionPanel);
        actionPanel.setBorder(new TitledBorder("Actions"));
        southPanel.add(actionPanel);
        showKeyButton = new JCheckBox("Show Key");
        newGameButton = new JButton("New Game");
        exitButton = new JButton("Exit");
        actionPanel.add(showKeyButton);
        showKeyButton.addItemListener(new ShowKeyButtonListener());
        actionPanel.add(newGameButton);
        newGameButton.addActionListener(new NewGameButtonListener());
        actionPanel.add(exitButton);
        // exitButton.addActionListener(new ExitButtonListener());
        exitButton.addActionListener((e) -> { System.exit(0); });

        updateWindow();

    }

    public void updateWindow() {
        switch (App.game.getState()) {
            case INIT:
                newGameButton.setEnabled(true);
                numberField.setEnabled(false);
                highLowButton.setEnabled(true);
                closeAwayButton.setEnabled(true);
                showKeyButton.setEnabled(true);
                break;
            case PLAYING:
                newGameButton.setEnabled(false);
                numberField.setEnabled(true);
                highLowButton.setEnabled(false);
                closeAwayButton.setEnabled(false);
                showKeyButton.setEnabled(true);
                break;
            case OVER:
                newGameButton.setEnabled(true);
                numberField.setEnabled(false);
                highLowButton.setEnabled(true);
                closeAwayButton.setEnabled(true);
                showKeyButton.setEnabled(false);
                break;
        }

        canvas.repaint();
        
    }
}
