public class MainClass {
    public static void main(String[] args) {
        // interface를 사용하지 않은 경우

        NameCard nac = new NameCard("kujiwon","1230-432","pink7519@icloud.com");

        nac.setPrintNameCard(new PrintNameCard());
        nac.print();

        System.out.println();
        nac.setPrintNamePhoneCard(new PrintNamePhoneCard());
        nac.printPhone();
    }
}
