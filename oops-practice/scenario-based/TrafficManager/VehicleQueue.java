public class VehicleQueue {

    private String[] queue;
    private int front = 0;
    private int rear = -1;
    private int size;

    VehicleQueue(int capacity) {
        queue = new String[capacity];
        size = capacity;
    }

    public void enqueue(String vehicle) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow! Vehicle must wait.");
            return;
        }
        queue[++rear] = vehicle;
        System.out.println("Vehicle waiting: " + vehicle);
    }

    public String dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        return queue[front++];
    }

    public boolean isEmpty() {
        return front > rear;
    }
}
