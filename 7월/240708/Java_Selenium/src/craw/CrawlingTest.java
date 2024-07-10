package craw;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrawlingTest {

    public static void main(String[] args) {
        // 1. WebDriver와 ChromeDriver 설정
        // 프로젝트 폴더 기준으로 chromedirver.exe 파일의 위치를 작성
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // 2. 웹 페이지 접속
        String baseUrl = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query=%EC%98%81%ED%99%94+%EC%88%9C%ED%9C%98&oquery=%EC%98%81%ED%99%94&tqi=ioXbElqVN8ossQ0UA4wsssssspG-024846";
        // String searchTerm = "Java";
        // String url = baseUrl + "/wiki/" + searchTerm;

        driver.get(baseUrl);


        // 3. 데이터 추출
        ArrayList<Movie> movie_data = new ArrayList<>();

        WebElement movie_container = driver.findElement(By.cssSelector(".list_movieranking"));

        List<WebElement> movie_links = movie_container.findElements(By.cssSelector(".tit_item>a"));

        for(int i= 0; i < movie_links.size(); i++) {
            String link = movie_links.get(i).getAttribute("href");
            // links.add(link);
            driver.get(link);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            String title = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[1]/h3/span[1]")).getText();
            String start = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[1]/dl[1]/dd")).getText();
            String star = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[2]/dl[1]/dd")).getText();
            String learning_time = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div[1]/dl[5]/dd")).getText();
            String content = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[2]/div[1]/div/div/div")).getText();

            Movie movie = new Movie(title, start, star, learning_time, content);

            System.out.println((i+1)+". "+ title + " (" + star + ")");

            movie_data.add(movie);

            driver.navigate().back();
            // System.out.println(link);
        }

        // 4. WebDriver 종료
        driver.quit();
    }

}