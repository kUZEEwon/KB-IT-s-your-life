package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        // WebDriverManager를 사용하여 ChromeDriver 설정
        WebDriverManager.chromedriver().setup();

        // ChromeDriver 객체 생성
        WebDriver driver = new ChromeDriver();

        try {
            // Google로 이동
            driver.get("https://www.google.com");

            // 검색 입력란 찾기
            WebElement searchBox = driver.findElement(By.name("q"));

            // 검색어 입력
            searchBox.sendKeys("Selenium WebDriver");

            // 검색 실행
            searchBox.submit();

            // 검색 결과가 로드될 때까지 잠시 대기
            Thread.sleep(2000);

            // 검색 결과 가져오기
            List<WebElement> results = driver.findElements(By.cssSelector("h3"));

            // 각 결과 출력
            for (WebElement result : results) {
                System.out.println(result.getText());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 브라우저 종료
            driver.quit();
        }
    }
}
