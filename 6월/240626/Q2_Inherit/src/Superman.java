public class Superman extends Man {
    boolean sky;

    public Superman(String name, int age, int power, boolean sky) {
        super(name, age, power);
        this.sky = sky;
    }

    @Override
    public void run(){
        System.out.println(name +"(이)가 빠르게 달립니다.");
    }

    public void space(){

        System.out.println(name +"(이)가 우주를 날아갑니다.");
    }

    @Override
    public String toString() {
        return "수퍼맨 [name=" + name + ", age=" + age + ", power=" + power + ", sky=" + sky + "]";
    }
}