import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws IOException {
        /*
            TCP : Transmission Control Protocol
                    전송         제어    통신규약

            종단 시스템 : host
                        네트워드상에서 더 연장되지 않는기기

            Router : hardware
                        host간에 상호 데이터를 교환할 수 있도록 하는 장비

            Inter + Net = 포괄적인 망

            Protocol - 통신규약
            TCP : Transmission Control Protocol
            UDP : User Datagram Protocol

            7 layer(계층)
            1계층 - Physical layer        물리
            2계층 - Data Link layer       주소를 헤더에 첨부
            3계층 - Network layer         네트워크 ip
            4계층 - Transport layer       네트워크 port
            5계층 - Session layer         세션을 동기화
            6계층 - Presentation layer    보안 압축 확장
            7계층 - Application layer     프로그램

            TCP
            신사적인 프로토콜 == 연결형
            전화의 경우
            데이터의 경계가 없다
            1 대 1

            UDP
            비연결형
            편지, 지상파방송
            데이터의 경계가 있다
            1 대 1 (unicast)
            1 대 다 (broadcast)
            다 대 다 (multicast)

            Packet(묶음)
            제어정보, 데이터등의 결합된 형태로 전송도는 데이터
            IP, Port, 문자열, Object

            IP : Internet Protocol -> 주소
            0 ~ 255
            IPv4 : xxx.xxx.xxx.xxx
            IPv6 : xxx.xxx.xxx.xxx.xxx.xxx

            127.0.0.1 -> 자기 자신을 접속하는 IP

            Port Number
            IP 주소는 인터넷에 존재하는 호스트(PC)를 식별할 수 있으나
            최종 주체인 process(프로그램)를 식별하지 못하기 때문에
            프로세스를 구별하기 위한 수치(0 ~ 1024: sys)

            Socket
            통신을 위한 Object
            IP, TCP/UDP

            통신순서

                    Server              Client
            1.    socket 버전확인        socket 버전확인
            2.    binding -> ip,port
            3.    listen
            4.    accept  <------------ connect
            5.    데이터의 송수신
                  recv    <------------ send
                  send    ------------> recv
       */

        // 문지기 소켓
        ServerSocket serverSocket = new ServerSocket(2000);

        List<Socket> sockets = new ArrayList<Socket>();

        while(true) {

            System.out.println("접속 대기중...");
            Socket clientSocket = serverSocket.accept();

            System.out.println("클라이언트 IP : " + clientSocket.getInetAddress()
                    + " Port : " + clientSocket.getPort());

            sockets.add(clientSocket);

            new ServerThread(clientSocket, sockets).start();
            /*
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // recv
            String message = in.readLine();
            System.out.println("클라이언트로부터 받은 메시지:" + message);

            // send
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            out.println(message);
            out.flush();
            */

        }

    }
}








