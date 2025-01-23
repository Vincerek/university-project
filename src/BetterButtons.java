import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BetterButtons extends JButton {
    // Static list to store all button instances
    private static List<BetterButtons> btnList = new ArrayList<>();

    // Constructor
    public BetterButtons(String text) {
        super(text); // Call the parent JButton constructor
        btnList.add(this); // Add this button to the list
    }

    // Method to get the list of buttons
    public static List<BetterButtons> getButtonList() {
        return btnList;
    }

    public static void main(String[] args) {

        // Print the buttons in the list
        for (BetterButtons button : BetterButtons.getButtonList()) {
            System.out.println(button.getText());
        }
    }
}
