// Class to manage balance with Memento pattern
class BalanceTracker {
    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
        System.out.println("Balance set: " + balance);
    }

    public int getBalance() {
        return balance;
    }

    public BalanceMemento save() {
        System.out.println("Saving state...");
        return new BalanceMemento(balance);
    }

    public void restore(BalanceMemento memento) {
        this.balance = memento.getSavedBalance();
        System.out.println("State restored to: " + balance);
    }
}