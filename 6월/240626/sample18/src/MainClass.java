public class MainClass {

    public static void main(String[] args) {
        /*
        * Thread
        *
        *
        * */

        Thread thread1 = new ThreadEx("home");
        Thread thread2 = new ThreadEx("집");
        Thread thread3 = new ThreadEx("자고싶어!!");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}


class ThreadEx extends Thread {
    String msg;

    public ThreadEx(String msg) {
        this.msg = msg;
    }

    @Override       // annotation : 주석문, 지시문
    public void run() {
        super.run();

        for (int i = 0; i <10; i++) {
            System.out.println("ThreadEx: " + msg);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
