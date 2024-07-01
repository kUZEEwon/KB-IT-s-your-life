public class Smartphone extends Move {
    private int cameraResolution;
    public Smartphone(int batteryCapacity, String color, int cameraResolution) {
        super(batteryCapacity, color);
        this.cameraResolution = cameraResolution;
    }



    public int getCameraResolution() {
        return cameraResolution;
    }
    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "cameraResolution=" + cameraResolution +
                ", batteryCapacity=" + batteryCapacity +
                '}' + super.toString();
    }
}
