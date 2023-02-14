package test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestInetAddress2 {
    //InetAddress ��� �ǽ�
    public static void main(String[] args) {
        try {
            displayHostIP();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }


    private static void displayHostIP() throws UnknownHostException {
        //Ű����� ȣ��Ʈ ���� �Է¹޾�, �ش� ȣ��Ʈ�� ip �ּҸ� ���� �� ��ȸ�ؼ� ��µǰ� ó��
        //�ش� ȣ��Ʈ�� ip �ּҸ� ���� �� ��ȸ �ؼ� ��µǰ� ó��
        //�ݺ� ����ǰ� �� => "none" �Է½� �ݺ� �����
        //����ó�� try catch �����
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
                System.out.println(st + " ��� ȣ��Ʈ�� �����ϴ�.");
            }
        }






    }
}
