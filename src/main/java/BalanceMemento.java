// Memento class to store the balance state
class BalanceMemento {
    private final int balance;

    public BalanceMemento(int balance) {
        this.balance = balance;
    }

    public int getSavedBalance() {
        return balance;
    }
}