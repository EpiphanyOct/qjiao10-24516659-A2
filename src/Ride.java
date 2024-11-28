import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    private String rideName;
    private Queue<Visitor> queue = new LinkedList<>();
    private Employee operator;

    public Ride() {
    }

    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Queue<Visitor> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Visitor> queue) {
        this.queue = queue;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }
}