public class Tablet  extends Move{
    private boolean isConnected;

    public Tablet(int batteryCapacity, String color, boolean isConnected) {
        super(batteryCapacity, color);
        this.isConnected = isConnected;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "isConnected=" + isConnected +
                "} "+super.toString();
    }
}
