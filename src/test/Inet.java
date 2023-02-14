package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet {
    public static void main(String[] args) {
        //java.net.InetAddress Ŭ���� ��� �׽�Ʈ
        //ip �ּ� : ��ǻ�͸��� �ο��� ��Ʈ��ũ �󿡼��� �ĺ���ȣ

        //�� ��ǻ���� ip �ּ� ��ȸ
        try {
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println("ip : " + ip1.getHostAddress());
            System.out.println("host name : " + ip1.getHostName());

            //�ٸ� ȣ��Ʈ �̸�(�� �����θ� �ش� ��)�� ������ ip ��ȸ
            InetAddress naverIP = InetAddress.getByName("www.naver.com");
            System.out.println("���̹� IP : " + naverIP.getHostAddress());
            System.out.println("���̹� : " + naverIP.getHostName());

            System.out.println("naver ���� ip ���� :");

            InetAddress googleIP = InetAddress.getByName("www.google.com");
            System.out.println("���� IP : " + googleIP.getHostAddress());
            System.out.println("���� : " +googleIP.getHostName());

            //���������� ������ ������ ���� �� �ִ��� Ȯ��
            InetAddress[] nips = InetAddress.getAllByName("www.naver.com");
            System.out.println("naver ���� ���� : " + nips.length);
            for(InetAddress ip : nips) {
                System.out.println(ip);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
