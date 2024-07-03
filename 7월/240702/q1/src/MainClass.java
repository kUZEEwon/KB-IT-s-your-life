public class MainClass {

 public static void main(String[] args) {
    AppleComputer apple = new AppleComputer();
     System.out.println("애플 컴퓨터 -----------------------------------");
    apple.start();
    apple.shutdown();
    apple.restart();

     System.out.println("바나나 컴퓨터 -----------------------------------");
     BananaComputer banana = new BananaComputer();
     banana.start();
     banana.shutdown();
     banana.restart();


 }
}

