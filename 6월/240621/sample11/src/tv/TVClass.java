package tv;

public class TVClass {

    boolean power;
    int channel;
    int volume;

    // Member method
    public void setTV(boolean pow, int ch, int vol) {
        power = pow;
        channel = ch;
        volume = vol;
    }

    public void tvInfo(){
        System.out.println(power + " " + channel + " " + volume);
    }
}
