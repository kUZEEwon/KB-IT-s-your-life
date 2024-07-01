public class ArrayStack {

    private int maxSize;
    private int top;

    private Object[] stackArray;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new Object[maxSize];
        top = -1;
    }

    // 스택 공간이 비어있는지?
    public boolean isEmpty() {
        return top == -1;
    }

    // 스택 공간이 가득차 있는지?
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 공간에 추가
    public void push(Object obj) {
        if (isFull()) {
            System.out.println("Stack is full");
        }else{
            stackArray[++top] = obj;
        }
    }

    // 공간에서 삭제
    public Object pop() {
        Object obj = peek();
        top--;
        return obj;
    }

    // 제일 위에 있는 data
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        return stackArray[top];
    }
}
