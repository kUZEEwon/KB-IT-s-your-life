import java.io.*;

public class MainClass {
    public static void main(String[] args) {
        /*
        * 저장 매체 : Database, file
        *
        * server : session, cash
        *
        * client : localhost
        *
        * *.txt
        *
        * jpg     png     bmp     gif     tga     tiff
        *
        * */

        // 파일 목록
        /*File fileDir = new File("c:\\");
        String[] files = fileDir.list();

        for (String fileName : files) {
            System.out.println(fileName);
        }*/

        /*File fileDir = new File("c:\\");
        File[] files = fileDir.listFiles();

        for(File file : files) {

            if(file.isFile()) {
                System.out.println("[파일]" + file.getName());
            }
            else if(file.isDirectory()) {
                System.out.println("[폴더]" + file.getName());
            }

        }*/

        // 파일 생성
        String fileStr = "C:\\Users\\koo\\Documents\\KB-IT-s-your-life\\6월\\240627\\tmp\\newfile.txt";
        File newfile = new File(fileStr);

        try {
            if(newfile.createNewFile()){
                System.out.println("File success created");
            }
            else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 파일의 존재 여부
        if(newfile.exists()){
            System.out.println("File already exists");
        }

        // 파일 읽기 가능
        if(newfile.canRead()){
            System.out.println("File readable");
        }

        // 읽기 전용 설정
        newfile.setReadOnly();

        // 파일 쓰기 가능
        if (newfile.canWrite()){
            System.out.println("File writable");
        }

        newfile.delete();


        // 파일 쓰기
        File file = new File("C:\\Users\\koo\\Documents\\KB-IT-s-your-life\\6월\\240627\\tmp\\newfile.txt");

        // 한문자씩 쓰기
        try {
            FileWriter fw = new FileWriter(file);
            fw.write("This is a TEST" +"\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 추가 쓰기
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write("This is a ADDTEST" +"\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 문장으로 쓰기
        /*try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("This is a 문장으로 쓰기" +"\n");
            pw.println("안녕하세요" +"\n");
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/

        // 파일 읽기
        try {
            FileReader fr = new FileReader(file);

            // 한문자씩 읽어온다.
            /*int c = fr.read();
            while (c != -1){
                System.out.println((char)c);
                c=fr.read();
            }
            fr.close();*/
            // 문장으로 읽어온다.

            BufferedReader br = new BufferedReader(fr);
            String str= "";
            while((str=br.readLine())!=null){
                System.out.println(str);
            }

            br.close();
            fr.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
