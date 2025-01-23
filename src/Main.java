import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;

    public static String actionState = "mainMenu";


    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("PlaceHolder na tytuł gry Filipa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(2, 3));

        // Create a panel for labels
        JPanel labelPanel = new JPanel(new GridLayout(3, 1));
        label1 = new JLabel("Witaj w grze", SwingConstants.CENTER);
        label2 = new JLabel("Witaj w grze", SwingConstants.CENTER);
        label3 = new JLabel("Witaj w grze", SwingConstants.CENTER);

        // Add labels to the panel
        labelPanel.add(label1);
        labelPanel.add(label2);
        labelPanel.add(label3);

        // Add the label panel to the top of the frame
        frame.add(labelPanel, BorderLayout.NORTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3));

        // Create buttons

        BetterButtons b1 = new BetterButtons("Ekwipunek");
        BetterButtons b2 = new BetterButtons("Góry");
        BetterButtons b3 = new BetterButtons("Zapis");
        BetterButtons b4 = new BetterButtons("Las");
        BetterButtons b5 = new BetterButtons("B5");
        BetterButtons b6 = new BetterButtons("Rzeka");
        BetterButtons b7 = new BetterButtons("Dziennik");
        BetterButtons b8 = new BetterButtons("Jaskinia");
        BetterButtons b9 = new BetterButtons("B9");

        // Add buttons to the panel
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);

        // Add the button panel to the center of the frame
        frame.add(buttonPanel, BorderLayout.CENTER);

        // State tracking for buttons

        // Placeholder for temporary actions
        ActionListener[] originalActions = new ActionListener[9];
        ActionListener[] tempActions = new ActionListener[9];
        ActionListener[] combatActions = new ActionListener[9];


        // Define original actions
        originalActions[0] = e -> {
            System.out.println("B1 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[1] = e -> {
            System.out.println("Walka w górach");
            setCombatActions(BetterButtons.getButtonList(), combatActions);
            Combat.fight(Player.listaStworzen.get(0),Player.listaStworzen.get(1));

        };
        originalActions[2] = e -> {
            System.out.println("B3 original action");
            //setCombatActions(new JButton[]{b1, b2, b3, b4}, combatActions);
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[3] = e -> {
            System.out.println("B4 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[4] = e -> {
            System.out.println("B4 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[5] = e -> {
            System.out.println("B5 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[6] = e -> {
            System.out.println("B6 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[7] = e -> {
            System.out.println("B7 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[8] = e -> {
            System.out.println("B8 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };



        // Define temporary actions
        tempActions[0] = e -> {
            System.out.println("B1 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[1] = e -> {
            System.out.println("B2 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[2] = e -> {
            System.out.println("B3 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[3] = e -> {
            System.out.println("B4 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[4] = e -> {
            System.out.println("B5 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[5] = e -> {
            System.out.println("B6 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[6] = e -> {
            System.out.println("B7 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[7] = e -> {
            System.out.println("B8 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[8] = e -> {
            System.out.println("B9 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };


        combatActions[0] = e -> {
            System.out.println("B1 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        combatActions[1] = e -> {
            System.out.println("B2 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        combatActions[2] = e -> {
            System.out.println("B3 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        combatActions[3] = e -> {
            System.out.println("B4 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        combatActions[4] = e -> {
            System.out.println("B5 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        combatActions[5] = e -> {
            System.out.println("B6 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        combatActions[6] = e -> {
            System.out.println("B7 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        combatActions[7] = e -> {
            System.out.println("B8 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        combatActions[8] = e -> {
            System.out.println("B9 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };


        // Set original actions initially
        resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);

        frame.setVisible(true);


        // nowe dodane
        createCharacters();
    }

    private static void resetToOriginal(JButton[] buttons, ActionListener[] originalActions) {
        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            // Remove all existing listeners
            for (ActionListener al : button.getActionListeners()) {
                button.removeActionListener(al);
            }
            // Add the original action
            button.addActionListener(originalActions[i]);
        }
        actionState = "mainMenu";
    }

    private static void setTemporaryActions(JButton[] buttons, ActionListener[] tempActions) {
        //if (isTemporaryState[0]) return; // Prevent re-setting if already in temporary state

        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            // Remove all existing listeners
            for (ActionListener al : button.getActionListeners()) {
                button.removeActionListener(al);
            }
            // Add the temporary action
            button.addActionListener(tempActions[i]);
        }
        //isTemporaryState[0] = true; // Update state
        actionState = "tempActions";

    }
    private static void setCombatActions(List<BetterButtons> buttons, ActionListener[] combActions) {
        if (buttons.size() != combActions.length) {
            throw new IllegalArgumentException("Mismatch between buttons and combActions length");
        }

        for (int i = 0; i < buttons.size(); i++) {
            BetterButtons button = buttons.get(i);

            // Remove all existing listeners
            for (ActionListener al : button.getActionListeners()) {
                button.removeActionListener(al);
            }

            // Add the temporary action
            button.addActionListener(combActions[i]);
        }

        actionState = "tempActions";
    }


    private static void createCharacters(){
        new Player();
        new Player();
    }
}
