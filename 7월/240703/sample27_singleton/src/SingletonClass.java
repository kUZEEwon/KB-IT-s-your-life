public class SingletonClass {

    private static SingletonClass sc = null;

    public int number;
    public String name;

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        if (sc == null) {   // 무조건 1번만 실행된다.
            sc = new SingletonClass();
        }
        return sc;
    }
}
