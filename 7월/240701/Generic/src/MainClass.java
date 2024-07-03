public class MainClass {
    public static void main(String[] args) {
        /*
        * Generic == template(형태)
        * : 자료형의 변수
        * : 계산기( 정수 * 실수, 실수 * 실수 )
        * : 동일한 클래스에서 다양한 자료형을 사용하고 싶은 경우. 사용하는 요소
        */

        // 다양한 자료형을 사용할 수 있다.
        Box<Integer> box= new Box<Integer>(333);
        System.out.println(box.getTemp());

        Box<String> sBox = new Box<>("hello");
        System.out.println(sBox.getTemp());

        Box2<Integer, String> box2 = new Box2<>(324, "jiwon hello!");
        System.out.println(box2.getValue());
        System.out.println(box2.getKey());

        Box2<String, Integer> box3 = new Box2<>("hello", 32324);
        System.out.println(box3.getValue());
        System.out.println(box3.getKey());

    }
}


class Box<T> {  // Template
    T temp;

    public Box(T temp) {
        this.temp = temp;
    }

    public T getTemp() {
        return temp;
    }

    public void setTemp(T temp) {
        this.temp = temp;
    }
}

class Box2<Key, Value> {
    Key key;
    Value value;

    public Box2(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}