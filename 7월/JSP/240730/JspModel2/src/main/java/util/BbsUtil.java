package util;

public class BbsUtil {

    public static String dot3(String title) {
        String str = "";

        if (title.length() > 35) {
            str = title.substring(0, 35);
            str += "...";
        }else{
            str = title.trim();
        }
        return str;
    }

}
