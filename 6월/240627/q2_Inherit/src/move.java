public class Move {
    public int batteryCapacity;
    private String color;

    public Move(int batteryCapacity, String color) {
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return " Move{" +
                "batteryCapacity=" + batteryCapacity +
                ", color='" + color + '\'' +
                "} ";
    }
}
