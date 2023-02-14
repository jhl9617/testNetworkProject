package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet {
    public static void main(String[] args) {
        //java.net.InetAddress 클래스 사용 테스트
        //ip 주소 : 컴퓨터마다 부여된 네트워크 상에서의 식별번호

        //내 컴퓨터의 ip 주소 조회
        try {
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println("ip : " + ip1.getHostAddress());
            System.out.println("host name : " + ip1.getHostName());

            //다른 호스트 이름(웹 도메인명도 해당 됨)을 가지고 ip 조회
            InetAddress naverIP = InetAddress.getByName("www.naver.com");
            System.out.println("네이버 IP : " + naverIP.getHostAddress());
            System.out.println("네이버 : " + naverIP.getHostName());

            System.out.println("naver 서버 ip 갯수 :");

            InetAddress googleIP = InetAddress.getByName("www.google.com");
            System.out.println("구글 IP : " + googleIP.getHostAddress());
            System.out.println("구글 : " +googleIP.getHostName());

            //도메인으로 설정된 서버가 여러 대 있는지 확인
            InetAddress[] nips = InetAddress.getAllByName("www.naver.com");
            System.out.println("naver 서버 갯수 : " + nips.length);
            for(InetAddress ip : nips) {
                System.out.println(ip);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
