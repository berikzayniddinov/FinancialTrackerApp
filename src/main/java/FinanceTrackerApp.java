import java.util.Scanner;

// Main application class
public class FinanceTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Interpreter pattern for expression evaluation
        System.out.println("Enter an expression to evaluate (e.g., '1000 + 500 - 300'): ");
        String expression = scanner.nextLine();
        int result = Interpreter.evaluate(expression);
        System.out.println("Expression result: " + result);

        // Memento pattern for balance state management
        BalanceTracker balanceTracker = new BalanceTracker();
        BalanceHistory history = new BalanceHistory();
        balanceTracker.setBalance(result);
        history.saveState(balanceTracker);

        // Observer pattern to monitor balance changes
        BalanceNotifier notifier = new BalanceNotifier();
        BalanceObserver observer1 = new BalanceObserver("Channel 1");
        BalanceObserver observer2 = new BalanceObserver("Channel 2");

        notifier.addObserver(observer1);
        notifier.addObserver(observer2);

        String command;
        do {
            System.out.println("Enter a new transaction (e.g., '+ 500' or '- 300'), 'undo' to revert, 'exit' to quit:");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("undo")) {
                history.undo(balanceTracker);
                notifier.setBalance(balanceTracker.getBalance());
            } else if (!command.equalsIgnoreCase("exit")) {
                result = Interpreter.evaluate(balanceTracker.getBalance() + " " + command);
                balanceTracker.setBalance(result);
                notifier.setBalance(result);
                history.saveState(balanceTracker);
            }

        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}