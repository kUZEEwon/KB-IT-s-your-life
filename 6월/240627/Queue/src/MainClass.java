public class MainClass {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(5);

        // push
        queue.push("Hello");

        String peek = (String)queue.peek();
        System.out.println(peek);

        // push
        queue.push("World");

        System.out.println((String)queue.peek());

        String pop = (String) queue.pop();
        System.out.println(pop);

        System.out.println((String)queue.peek());
    }
}
