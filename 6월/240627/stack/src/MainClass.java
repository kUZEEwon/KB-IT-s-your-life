public class MainClass {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        // push
        String name = "홍길동";
        stack.push(name);

        String peek = (String) stack.peek();
        System.out.println("현재 top의 데이터 : " + peek);

        // push
        stack.push("성춘향");
        System.out.println("현재 top의 데이터 : " + (String) stack.peek());

        String pop = (String) stack.pop();
        System.out.println("삭제된 데이터: " + pop);
        System.out.println("현재 top의 데이터 : " + (String) stack.peek());

    }
}
