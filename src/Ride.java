import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ride implements RideInterface {
    private String rideName;
    private Employee operator;
    private Queue<Visitor> queue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();
    private int maxRider;
    private int numOfCycles;

    public Ride() {}

    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
        this.maxRider = 7;
        this.numOfCycles = 0;
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
        for (int i = 0; i < maxRider && !queue.isEmpty(); i++) {
            Visitor visitor = queue.poll();
            addVisitorToHistory(visitor);
        }
        numOfCycles++;
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

    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
    }

    public void printSortedRideHistory() {
        System.out.println("Sorted Ride History:");
        sortRideHistory();
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName() + ", Age: " + visitor.getAge());
        }
    }

    class VisitorComparator implements Comparator<Visitor> {
        @Override
        public int compare(Visitor v1, Visitor v2) {
            int nameCompare = v1.getName().compareTo(v2.getName());
            if (nameCompare != 0) {
                return nameCompare;
            }
            return Integer.compare(v1.getAge(), v2.getAge());
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

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    public void exportRideHistory() {
        try (PrintWriter out = new PrintWriter("rideHistory.csv")) {
            for (Visitor visitor : rideHistory) {
                out.println(visitor.getName() + "," + visitor.getAge() + "," + visitor.getId() + "," + visitor.getVisitorId() + "," + visitor.getTicketType());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void importRideHistory() {
        try (Scanner scanner = new Scanner(new java.io.File("rideHistory.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                String visitorId = data[3];
                String ticketType = data[4];
                Visitor visitor = new Visitor(name, age, id, visitorId, ticketType);
                rideHistory.add(visitor);
            }
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}