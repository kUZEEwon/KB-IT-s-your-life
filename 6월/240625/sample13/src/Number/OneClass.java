package Number;

public class OneClass {
    private int one;

    // 생성자
    public OneClass(){ // 기본 생성자
        System.out.println("OneClass OneClass()");
    }

    public OneClass(int one) {
        System.out.println("OneClass OneClass(int one)");
        this.one = one;
    }
}
