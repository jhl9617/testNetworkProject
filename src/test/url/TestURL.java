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
        //java.net.URL 클래스 사용 테스트
        String str = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC+osi+7%EA%B3%84%EC%B8%B5&oquery=sdsddd&tqi=h%2BW4swprvh8ssvSevP4ssssstWK-172183";
        try {
            URL url = new URL(str);

            System.out.println("프로토콜 : " + url.getProtocol());
            System.out.println("포트번호 : " + url.getPort());
            System.out.println("호스트명 : " + url.getHost());
            System.out.println("파일경로 : " + url.getFile());
            System.out.println("전체경로 : " + url.toExternalForm());
            System.out.println("쿼리스트링 :" + url.getQuery());


            InetAddress[] ip = InetAddress.getAllByName(url.getHost());

            for(InetAddress searchIP : ip) {
                System.out.println("ip : " + searchIP);
            }

            //쿼리스트링만 분리해서 '&' 문자를 구분자로 각 변수와 값들을 문자배열로 분리함
            //"변수 = 값" 이므로 '=' 구분자로 분리해서 hashMap에 저장 처리함 : 변수는 key, 값은 value


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
                System.out.println("키 : " + ent.getKey());
                System.out.println("값 : " + ent.getValue());
            }
            //인코딩 된 글자(ascii 문자)를 디코딩 처리
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
