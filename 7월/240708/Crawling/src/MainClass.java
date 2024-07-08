import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainClass {

    /*
    * Crawling(Scripting) : 웹 페이지를 그대로 읽어와서 데이터를 추출해내는 처리
    *
    * Jsoup : java
    * BeautifulSoup : python
    * */
    /*
    * <div class="box-contents">
                        <a href="/movies/detail-view/?midx=88267">
                            <strong class="title">탈주</strong>
                        </a>

                        <div class="score">
                            <strong class="percent">예매율<span>14.3%</span></strong>
                            <!-- 2020.05.07 개봉전 프리에그 노출, 개봉후 골든에그지수 노출변경 (적용 범위1~ 3위)-->
                            <div class='egg-gage small'>
                                            <span class='egg great'></span>
                                            <span class='percent'>92%</span>
                                        </div>
                        </div>
    * */
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.cgv.co.kr/movies/?lt=1&ft=0").get();
        Elements percents = doc.select("div.box-contents div.score strong.percent span");
        Elements titles = doc.select("div.box-contents strong.title");


       for (int i = 0; i < titles.size(); i++) {
           Element title = titles.get(i);
           Element percent = percents.get(i);

           System.out.println(title.text()+" : "+percent.text());
       }

    }


}
