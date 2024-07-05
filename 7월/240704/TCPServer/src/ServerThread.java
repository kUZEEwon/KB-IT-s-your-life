import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {

    private Socket socket;
    private List<Socket> list = new ArrayList<Socket>();

    public ServerThread(Socket socket, List<Socket> list) {
        this.socket = socket;
        this.list = list;
    }

    @Override
    public void run() {
        super.run();

        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // recv
                String message = in.readLine();
                System.out.println("클라이언트로부터 받은 메시지:" + message);

                // send
                PrintWriter out = null;
                out = new PrintWriter(socket.getOutputStream());

                out.println(message);
                out.flush();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
