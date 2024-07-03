public class MainClass {

    public static void main(String[] args) {
        // interface를 사용한 경우

        NameCard nameCard = new NameCard("성춘향", "234-5943","ABC@nate.net");
        nameCard.setPrintNameCard(new PrintNameCardOne());
        nameCard.print();


        nameCard.setPrintNameCard(new PrintNameCardTwo());
        nameCard.print();

    }
}
