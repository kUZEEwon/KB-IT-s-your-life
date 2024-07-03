import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPServer {

    public static void main(String[] args) throws Exception{
        // Socket이 2개 필요
        // 클라이언트 연결 승인용 : ServerSocket
        // 데이터 전달용: Socket
        // 예외 처리: 외부의 자원을 연결하는 경우

        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("TCP 서버 소켓 시작됨 ...");
        System.out.println("클라이언트의 연결을 기다리는 중...");

        int count = 0;

        while (true){
            Socket socket = serverSocket.accept();
            count++;
            System.out.println("서버가 "+count+"개의 클라이언트 요청을 승인함.");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String date = String.valueOf(new Date());
            out.println(date);
            out.close();
            socket.close();
        }
    }
}
