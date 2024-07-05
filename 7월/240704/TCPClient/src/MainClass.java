import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IOException {
        //  IP, Port
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 2000);

        Socket socket = new Socket();
        socket.connect(socketAddress);

        Scanner scanner = new Scanner(System.in);
        // 접속 정보
        InetAddress address;

        if( (address = socket.getInetAddress())!= null){
            System.out.println("연결 : "+address);
        }else{
            System.out.println("연결 실패");
        }

        //패킷을 받는 스레드
        new clientThread(socket).start();

        while(true){
            // Send
            System.out.print("메시지 입력 >> ");

            String message = scanner.next();
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(message);
            out.flush();

            // recv
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String str =in.readLine();
//            System.out.println("서버로부터 받은 메시지 : "+str);

//            in.close();
        }

    }
}
