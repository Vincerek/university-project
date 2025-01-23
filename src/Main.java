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
    public static JLabel label4;
    public static JLabel label5;

    public static BetterButtons b1;
    public static BetterButtons b2;
    public static BetterButtons b3;
    public static BetterButtons b4;
    public static BetterButtons b5;
    public static BetterButtons b6;
    public static BetterButtons b7;
    public static BetterButtons b8;
    public static BetterButtons b9;

    public static String actionState = "mainMenu";


    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("PlaceHolder na tytuł gry Filipa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(2, 3));

        // Create a panel for labels
        JPanel labelPanel = new JPanel(new GridLayout(5, 1));
        label1 = new JLabel("Witaj w grze", SwingConstants.CENTER);
        label2 = new JLabel("Witaj w grze", SwingConstants.CENTER);
        label3 = new JLabel("Witaj w grze", SwingConstants.CENTER);
        label4 = new JLabel("Witaj w grze", SwingConstants.CENTER);
        label5 = new JLabel("Witaj w grze", SwingConstants.CENTER);

        // Add labels to the panel
        labelPanel.add(label1);
        labelPanel.add(label2);
        labelPanel.add(label3);
        labelPanel.add(label4);
        labelPanel.add(label5);
        // Add the label panel to the top of the frame
        frame.add(labelPanel, BorderLayout.NORTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3));

        // Create buttons

        b1 = new BetterButtons("Ekwipunek");
        b2 = new BetterButtons("Góry");
        b3 = new BetterButtons("Wczytaj");
        b4 = new BetterButtons("Las");
        b5 = new BetterButtons("B5");
        b6 = new BetterButtons("Rzeka");
        b7 = new BetterButtons("Dziennik");
        b8 = new BetterButtons("Kopalnia");
        b9 = new BetterButtons("Zapis");

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
            Combat.setCombatButtonsNames();
            setCombatActions(BetterButtons.getButtonList(), combatActions);
            Combat.fight(Player.listaStworzen.get(0),Player.listaStworzen.get(1));

        };
        originalActions[2] = e -> {
            System.out.println("B3 original action");
            //setCombatActions(new JButton[]{b1, b2, b3, b4}, combatActions);
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[3] = e -> {
            System.out.println("Walka w lesie");
            setCombatActions(BetterButtons.getButtonList(), combatActions);
            Combat.fight(Player.listaStworzen.get(0),Player.listaStworzen.get(1));
        };
        originalActions[4] = e -> {
            System.out.println("B4 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[5] = e -> {
            System.out.println("Walka w rzece");
            setCombatActions(BetterButtons.getButtonList(), combatActions);
            Combat.fight(Player.listaStworzen.get(0),Player.listaStworzen.get(1));
        };
        originalActions[6] = e -> {
            System.out.println("B6 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };
        originalActions[7] = e -> {
            System.out.println("Walka w kopalni");
            setCombatActions(BetterButtons.getButtonList(), combatActions);
            Combat.fight(Player.listaStworzen.get(0),Player.listaStworzen.get(1));
        };
        originalActions[8] = e -> {
            System.out.println("B8 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions);
        };



        // Define temporary actions
        tempActions[0] = e -> {

        };
        tempActions[1] = e -> {

            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[2] = e -> {
            System.out.println("Odpocznij");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[3] = e -> {
            System.out.println("Kula ognia");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[4] = e -> {
            System.out.println("");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[5] = e -> {
            System.out.println("Medytuj");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[6] = e -> {
            System.out.println("Zwiększ siłę");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[7] = e -> {
            System.out.println("Zwiększ inteligencję");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };
        tempActions[8] = e -> {
            System.out.println("Uciekaj");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions);
        };


        combatActions[0] = e -> {
            System.out.println("Atak wręcz użyty");
            Combat.meleeAttack(Player.listaStworzen.get(0),Player.listaStworzen.get(1));
        };
        combatActions[1] = e -> {
            System.out.println("Aura miecz użyta");
            Combat.swordAura(Player.listaStworzen.get(0));
        };
        combatActions[2] = e -> {
            System.out.println("Odpocznij");
            Combat.rest(Player.listaStworzen.get(0));
        };
        combatActions[3] = e -> {
            System.out.println("Kula ognia");
            Combat.fireball(Player.listaStworzen.get(0),Player.listaStworzen.get(1));
        };
        combatActions[4] = e -> {
            System.out.println("");

        };
        combatActions[5] = e -> {
            System.out.println("Medytuj");
            Combat.meditate(Player.listaStworzen.get(0));
        };
        combatActions[6] = e -> {
            System.out.println("Zwiększ siłę");
            Combat.increaseStrength(Player.listaStworzen.get(0));
        };
        combatActions[7] = e -> {
            System.out.println("Zwiększ inteligencję");
            Combat.increaseIntelligence(Player.listaStworzen.get(0));
        };
        combatActions[8] = e -> {
            System.out.println("Uciekaj");
            Combat.flee(Player.listaStworzen.get(0));
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
