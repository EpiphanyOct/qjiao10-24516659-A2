import java.util.LinkedList;
import java.util.Queue;

public abstract class Ride implements RideInterface {
    private String rideName;
    private Employee operator;
    private Queue<Visitor> queue = new LinkedList<>();

    public Ride() {
    }

    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.offer(visitor);
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        queue.remove(visitor);
    }

    @Override
    public void printQueue() {
        queue.forEach(visitor -> System.out.println(visitor.getName()));
    }

    // Other methods from RideInterface

    public String getRideName() {
        return rideName;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public Employee getOperator() {
        return operator;
    }

    public Queue<Visitor> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Visitor> queue) {
        this.queue = queue;
    }
}