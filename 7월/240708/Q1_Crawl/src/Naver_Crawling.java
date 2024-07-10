import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Naver_Crawling {
    public static void main(String[] args) throws Exception {


        String site = "https://finance.naver.com/item/main.naver?code=005930";

        Connection con = Jsoup.connect(site);
        System.out.println("1. 사이트 연결 성공");

        Document doc = con.get();
        System.out.println("2. 연결된 사이트에서 문서를 다 가지고 오기 성공.");
        System.out.println("3. 내용===============================");
        System.out.println(doc);

        System.out.println("4. 전체문서 중에서 원하는 정보를 추출");

        // pipe 연산
       // System.out.println(doc.select("p.no_today").text());
       // System.out.println(doc.select("td.first").text());

        // code
        String code = doc.select("div#middle div.h_company div.wrap_company div.description span.code").text();
        String fileString = "code : "+ code;


        // Company name
        String Name = doc.select("div#middle div.h_company div.wrap_company a").text();
        fileString = fileString + "\nCompany Name : "+Name;
       // System.out.println("Company Name : "+Name);

        // Open Price
        // dl.blind 클래스 선택
        Element dlElement = doc.select("dl.blind").first();

        // dd 태그들 선택
        Elements ddElements = dlElement.select("dd");
        // dd 태그들을 반복하여 시가 정보를 찾기
        for (Element ddElement : ddElements) {
            if (ddElement.text().startsWith("시가")) {
                String openPrice = ddElement.text().substring(3).trim();  // "시가 " 이후의 텍스트를 추출
                fileString = fileString + "\nOpen Price : "+openPrice;
                //System.out.println("시가: " + openPrice);
                break;
            }

        }

        for (Element ddElement : ddElements) {
            if(ddElement.text().startsWith("고가")){
                String HighPrice = ddElement.text().substring(3).trim();
              //  System.out.println("고가 : " + HighPrice);
                fileString = fileString + "\n고가 : "+HighPrice;

            }
        }
        System.out.println(fileString);


        //  file 저장
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stock_info.txt"))) {
            writer.write(fileString);
            System.out.println("파일 저장 완료:"+"stock_info.txt");
        }
    }
}
