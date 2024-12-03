import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private Employee operator;
    private Queue<Visitor> queue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

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
        System.out.println("Current Queue:");
        queue.forEach(visitor -> System.out.println(visitor.getName()));
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Cannot run the ride: No operator assigned.");
            return;
        }
        if (queue.isEmpty()) {
            System.out.println("Cannot run the ride: No visitors in the queue.");
            return;
        }
        System.out.println("Running one cycle of " + rideName);
        // Assuming maxRider is set to the maximum number of riders for one cycle
        int maxRider = 4; // This value should be set according to the specific ride
        for (int i = 0; i < maxRider && !queue.isEmpty(); i++) {
            Visitor visitor = queue.poll();
            addVisitorToHistory(visitor);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History:");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(visitor.getName());
        }
    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public Queue<Visitor> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Visitor> queue) {
        this.queue = queue;
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(LinkedList<Visitor> rideHistory) {
        this.rideHistory = rideHistory;
    }
}