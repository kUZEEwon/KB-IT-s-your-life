import java.net.Socket;

public class TopClient4 {
    public static void main(String[] args) throws Exception{
        for (int i =0;i<100;i++){
            Socket socket = new Socket("127.0.0.1",9100);
            System.out.println("클라이언트"+i+": 서버와 연결 성공!");
        }
    }
}
