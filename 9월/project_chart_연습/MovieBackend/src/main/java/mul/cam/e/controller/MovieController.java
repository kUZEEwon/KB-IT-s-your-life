package mul.cam.e.controller;

import mul.cam.e.dto.MovieDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
/*
 <div class="box-contents">
    <a href="/movies/detail-view/?midx=88488">
         <strong class="title">베테랑2</strong>
                        </a>

                        <div class="score">
                            <strong class="percent">예매율<span>55.6%</span></strong>
*/

    @GetMapping("getMovie")
    public List<MovieDto> getMovie() throws IOException {
        Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();

        Elements titles = doc.select("div.box-contents strong.title");

        Elements percents = doc.select("div.box-contents div.score strong.percent span");

        List<MovieDto> movie = new ArrayList<>();

        for(int i=0; i<titles.size(); i++) {
            Element title = titles.get(i);
            Element percent = percents.get(i);

            String name = title.text();
            double y = Double.parseDouble(percent.text().replace("%", ""));
            movie.add(new MovieDto(name, y));

            //System.out.println(title.text() + ":" + percent.text());
        }

        return movie;
    }
}
