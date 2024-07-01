public class ArrayQueue {

    private int front;
    private int rear;

    private int maxSize;

    private Object[] queueArray;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new Object[maxSize];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return (front == rear+1);
    }

    public boolean isFull() {
        return (front == maxSize - 1);
    }

    public void push(Object obj) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        else{
            queueArray[++rear] = obj;

        }
    }

    public Object pop() {
        Object obj = peek();
        front++;
        return obj;
    }

    // queue의 시작 부분에서 개체를 삭제하지 않고 반환함
    public Object peek() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }else{
            return queueArray[front];
        }
        //return queueArray[front];
    }
}
