import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class NaverCrawl {
    public static void main(String[] args) throws Exception {
        /*
        * 회사이름
        * 회사코드
        * 현재가
        * 어제와의 차이
        * 증감비율
        * -----------------------------------------
        * */
        String url = "https://finance.naver.com/sise/lastsearch2.naver";
        String folderPath = "C:\\Users\\koo\\Documents\\KB-IT-s-your-life\\7월\\240708\\Q2_Crawl\\company_info";

        // 1. 페이지 로드
        Document doc = Jsoup.connect(url).get();

        // 2. 테이블 추출
        Elements rows = doc.select("tr:has(td.no)");


        for (Element row : rows) {



                String companyName = row.select("a.tltle").text();

                String href = row.select("a.tltle").attr("href");
                String companyCode = href.substring(href.lastIndexOf("=") + 1);
                String currentPrice = row.select("td.number").get(1).text();

                Element changeCell = row.select("td.number").get(2);
                changeCell.select("em").remove(); // em 태그 제거
                String changeFromYesterday = changeCell.text().trim();

                String changeRate = row.select("td.number").get(3).text().trim();
                System.out.println(companyName + "\t" + companyCode + "\t" + currentPrice + "\t" + changeFromYesterday + "\t" + changeRate);
                // String text = col.text();
                String write = "회사 이름 : " +companyName +
                        "\n회사 코드  : "+companyCode +
                       "\n현재가 : " + currentPrice +
                        "\n어제와의 차이 : "+changeFromYesterday +
                        "\n증감비율 : " + changeRate +
                        "\n-----------------------------------------";
                    String fileName = companyName+".txt";
                 PrintWriter writer = new PrintWriter(new FileWriter(folderPath + File.separator + fileName));

                writer.println(write);  writer.close();

        }

    }
}
