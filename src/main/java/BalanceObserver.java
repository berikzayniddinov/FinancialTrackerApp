// Class for channels observing balance changes
class BalanceObserver implements Observer {
    private String name;

    public BalanceObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int newBalance) {
        System.out.println(name + " received notification: Balance changed to " + newBalance);
    }
}