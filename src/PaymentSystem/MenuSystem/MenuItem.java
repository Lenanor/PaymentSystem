package PaymentSystem.MenuSystem;

public class MenuItem {

    /**The text that will explain the option**/
    private final String label;
    private final int inputChoice;
    private final Runnable action;

    public int getInputChoice() {
        return inputChoice;
    }

    public String getLabel() {
        return label;
    }

    public Runnable getAction() {
        return action;
    }

    public MenuItem(String label, int inputChoice, Runnable action) {
        if (action == null)
            throw new IllegalArgumentException();

        this.label = label;
        this.inputChoice = inputChoice;
        this.action = action;
    }
}