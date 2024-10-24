import java.util.ArrayList;
import java.util.List;

// History class for undo operations using Memento
class BalanceHistory {
    private final List<BalanceMemento> history = new ArrayList<>();

    public void saveState(BalanceTracker tracker) {
        history.add(tracker.save());
    }

    public void undo(BalanceTracker tracker) {
        if (!history.isEmpty()) {
            BalanceMemento memento = history.remove(history.size() - 1);
            tracker.restore(memento);
        } else {
            System.out.println("History is empty, undo not possible.");
        }
    }
}