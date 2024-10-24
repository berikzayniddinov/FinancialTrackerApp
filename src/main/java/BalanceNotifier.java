import java.util.ArrayList;
import java.util.List;

//Notifier class to track significant balance changes
class BalanceNotifier implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    private int balance;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(balance);
        }
    }

    public void setBalance(int newBalance) {
        if (Math.abs(newBalance - this.balance) > 1000) {
            this.balance = newBalance;
            notifyObservers();
        }
        this.balance = newBalance;
    }
}