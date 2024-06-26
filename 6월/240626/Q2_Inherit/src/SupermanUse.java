public class SupermanUse
{
    Superman superman;

    public SupermanUse(Superman superman) {
        this.superman = superman;
    }

    public static void main(String[] args) {
        Superman sMan = new Superman("클라크 켄트",30 ,1000, true);
        sMan.eat();
        sMan.run();
        sMan.space();
        System.out.println(sMan.toString());
    }
}
