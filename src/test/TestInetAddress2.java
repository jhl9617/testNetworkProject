package test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestInetAddress2 {
    //InetAddress 사용 실습
    public static void main(String[] args) {
        try {
            displayHostIP();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }


    private static void displayHostIP() throws UnknownHostException {
        //키보드로 호스트 명을 입력받아, 해당 호스트의 ip 주소를 전부 다 조회해서 출력되게 처리
        //해당 호스트의 ip 주소를 전부 다 조회 해서 출력되게 처리
        //반복 실행되게 함 => "none" 입력시 반복 종료됨
        //예외처리 try catch 사용함
        Scanner scanner = new Scanner(System.in);
        while(true){
            String st = scanner.next();
            try {
                if(st.equals("none")) break;
                InetAddress[] ips = InetAddress.getAllByName(st);

                for(InetAddress ip : ips) {
                    System.out.println(ip);
                }
            } catch (UnknownHostException e ){
                System.out.println(st + " 라는 호스트는 없습니다.");
            }
        }






    }
}
