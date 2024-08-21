package mul.cam.e.util;

public class BbsUtil {
     // 제목이 긴 경우 ... 으로 처리하는 함수
    public static String TitleDot(String title) {
        String newTitle = "";

        if (title.length() >  40) {
            newTitle = title.trim().substring(0, 40); // 0 ~ 39 까지
            newTitle += "...";
        }else {
            newTitle = title.trim();
        }
        return newTitle;
    }

    // 답글의 화살표 함수
    public static String arrow(int depth) {
        String img = "<img src='../images/a0.png' width='15px' height='15px' />";
        String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;"; // 공백

        String ts = "";
        for (int i = 0; i < depth; i++) {
            ts += nbsp;
        }
        return depth==0 ? "" : ts + img;
    }

}
