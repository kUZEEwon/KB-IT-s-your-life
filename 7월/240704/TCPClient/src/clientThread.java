import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class clientThread extends Thread {
    private Socket socket;

    public clientThread(Socket socket){
        this.socket = socket;
    }

    public void run(){

        super.run();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true){
                String str =in.readLine();
                System.out.println("서버로부터 받은 메시지 : "+str);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
