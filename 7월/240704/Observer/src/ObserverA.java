import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        String str = (String) arg;
        System.out.println("ObserverA 입니다. 알림받았음 : "+ str );
    }

}
