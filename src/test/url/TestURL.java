package test.url;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class TestURL {
    public static void main(String[] args) {
        //java.net.URL Ŭ���� ��� �׽�Ʈ
        String str = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC+osi+7%EA%B3%84%EC%B8%B5&oquery=sdsddd&tqi=h%2BW4swprvh8ssvSevP4ssssstWK-172183";
        try {
            URL url = new URL(str);

            System.out.println("�������� : " + url.getProtocol());
            System.out.println("��Ʈ��ȣ : " + url.getPort());
            System.out.println("ȣ��Ʈ�� : " + url.getHost());
            System.out.println("���ϰ�� : " + url.getFile());
            System.out.println("��ü��� : " + url.toExternalForm());
            System.out.println("������Ʈ�� :" + url.getQuery());


            InetAddress[] ip = InetAddress.getAllByName(url.getHost());

            for(InetAddress searchIP : ip) {
                System.out.println("ip : " + searchIP);
            }

            //������Ʈ���� �и��ؼ� '&' ���ڸ� �����ڷ� �� ������ ������ ���ڹ迭�� �и���
            //"���� = ��" �̹Ƿ� '=' �����ڷ� �и��ؼ� hashMap�� ���� ó���� : ������ key, ���� value


            HashMap hashMap = new HashMap();
            Iterator<Map<String, String>> iterator;

            String[] sts = url.getQuery().split("&");

            for(int i = 0; i < sts.length;i++){
                String[] tmp = sts[i].split("=");
                hashMap.put(tmp[0], tmp[1]);
            }
            System.out.println(hashMap);
            Iterator<Map.Entry<String,String>> iters = hashMap.entrySet().iterator();
            System.out.println("iter");
            while (iters.hasNext()){
                Map.Entry<String, String> ent = iters.next();
                System.out.println("Ű : " + ent.getKey());
                System.out.println("�� : " + ent.getValue());
            }
            //���ڵ� �� ����(ascii ����)�� ���ڵ� ó��
            System.out.println(URLDecoder.decode((String) hashMap.get("query"), StandardCharsets.UTF_8.toString()));


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
