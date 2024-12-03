public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partThree();
        // Other parts can be called here
    }

    public void partThree() {
        Ride ride = new Ride("Roller Coaster", new Employee("John Doe", 30, "ID001", "E001", "Rides"));
        Visitor v1 = new Visitor("Alice", 25, "V001", "V001", "Regular");
        Visitor v2 = new Visitor("Bob", 20, "V002", "V002", "Regular");
        Visitor v3 = new Visitor("Charlie", 35, "V003", "V003", "Regular");
        Visitor v4 = new Visitor("David", 40, "V004", "V004", "Regular");
        Visitor v5 = new Visitor("Eve", 22, "V005", "V005", "Regular");

        // Add visitors to the queue
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        // Print all visitors in the queue
        System.out.println("Visitors before running the ride:");
        ride.printQueue();

        // Run one cycle of the ride
        ride.runOneCycle();

        // Print all visitors in the queue after one cycle
        System.out.println("Visitors after running one cycle:");
        ride.printQueue();

        // Print ride history
        System.out.println("Ride history after one cycle:");
        ride.printRideHistory();
    }

    public void partFourA() {
        // Implementation for Part 4A
    }

    public void partFourB() {
        // Implementation for Part 4B
    }

    public void partFive() {
        // Implementation for Part 5
    }

    public void partSix() {
        // Implementation for Part 6
    }

    public void partSeven() {
        // Implementation for Part 7
    }
}