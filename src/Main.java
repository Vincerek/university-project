import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;

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
        JButton b1 = new JButton("Ekwipunek");
        JButton b2 = new JButton("Góry");
        JButton b3 = new JButton("Zapis");
        JButton b4 = new JButton("Las");
        JButton b5 = new JButton("B5");
        JButton b6 = new JButton("Rzeka");
        JButton b7 = new JButton("Dziennik");
        JButton b8 = new JButton("Jaskinia");
        JButton b9 = new JButton("B9");

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
        boolean[] isTemporaryState = {false}; // Shared state for all buttons

        // Placeholder for temporary actions
        ActionListener[] tempActions = new ActionListener[4];
        ActionListener[] originalActions = new ActionListener[4];

        // Define original actions
        originalActions[0] = e -> {
            System.out.println("B1 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions, isTemporaryState);
        };
        originalActions[1] = e -> {
            System.out.println("B2 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions, isTemporaryState);
        };
        originalActions[2] = e -> {
            System.out.println("B3 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions, isTemporaryState);
        };
        originalActions[3] = e -> {
            System.out.println("B4 original action");
            setTemporaryActions(new JButton[]{b1, b2, b3, b4}, tempActions, isTemporaryState);
        };

        // Define temporary actions
        tempActions[0] = e -> {
            System.out.println("B1 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions, isTemporaryState);
        };
        tempActions[1] = e -> {
            System.out.println("B2 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions, isTemporaryState);
        };
        tempActions[2] = e -> {
            System.out.println("B3 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions, isTemporaryState);
        };
        tempActions[3] = e -> {
            System.out.println("B4 temporary action");
            resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions, isTemporaryState);
        };

        // Set original actions initially
        resetToOriginal(new JButton[]{b1, b2, b3, b4}, originalActions, isTemporaryState);

        frame.setVisible(true);
    }

    private static void resetToOriginal(JButton[] buttons, ActionListener[] originalActions, boolean[] isTemporaryState) {
        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            // Remove all existing listeners
            for (ActionListener al : button.getActionListeners()) {
                button.removeActionListener(al);
            }
            // Add the original action
            button.addActionListener(originalActions[i]);
        }
        isTemporaryState[0] = false; // Update state
    }

    private static void setTemporaryActions(JButton[] buttons, ActionListener[] tempActions, boolean[] isTemporaryState) {
        if (isTemporaryState[0]) return; // Prevent re-setting if already in temporary state

        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            // Remove all existing listeners
            for (ActionListener al : button.getActionListeners()) {
                button.removeActionListener(al);
            }
            // Add the temporary action
            button.addActionListener(tempActions[i]);
        }
        isTemporaryState[0] = true; // Update state
    }
}
