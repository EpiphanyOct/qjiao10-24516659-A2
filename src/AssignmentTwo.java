public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partOne();
        assignmentTwo.partTwo();
        assignmentTwo.partThree();
        assignmentTwo.partFourA();
        assignmentTwo.partFourB();
        assignmentTwo.partFive();
        assignmentTwo.partSix();
        assignmentTwo.partSeven();
    }

    public void partOne() {
        System.out.println("Part 1 - Classes and Inheritance");
        Person person = new Person("John Doe", 30, "ID001");
        Employee employee = new Employee("John Doe", 30, "ID001", "E001", "Rides");
        Visitor visitor = new Visitor("Visitor1", 25, "V001", "V001", "Regular");
        Ride ride = new Ride("Roller Coaster", employee);

        System.out.println("Person Name: " + person.getName());
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Visitor ID: " + visitor.getVisitorId());
        System.out.println("Ride Name: " + ride.getRideName());
    }

    public void partTwo() {
        System.out.println("\nPart 2 - Abstract class and interface");
        // This part is demonstrated in the class definitions of Person, Ride, and RideInterface
    }

    public void partThree() {
        System.out.println("\nPart 3 - Queue Interface");
        Ride ride = new Ride("Roller Coaster", new Employee("John Doe", 30, "ID001", "E001", "Rides"));
        for (int i = 0; i < 5; i++) {
            Visitor visitor = new Visitor("Visitor" + (i + 1), 20 + i, "V" + (i + 1), "V" + (i + 1), "Regular");
            ride.addVisitorToQueue(visitor);
        }

        System.out.println("Visitors in Queue:");
        ride.printQueue();

        ride.removeVisitorFromQueue(new Visitor("Visitor2", 22, "V2", "V2", "Regular"));
        System.out.println("Visitors in Queue after removal:");
        ride.printQueue();
    }

    public void partFourA() {
        System.out.println("\nPart 4A - Collection class (LinkedList)");
        Ride ride = new Ride("Roller Coaster", new Employee("John Doe", 30, "ID001", "E001", "Rides"));
        for (int i = 0; i < 5; i++) {
            Visitor visitor = new Visitor("Visitor" + (i + 1), 20 + i, "V" + (i + 1), "V" + (i + 1), "Regular");
            ride.addVisitorToHistory(visitor);
        }

        System.out.println("Visitors in Ride History:");
        ride.printRideHistory();

        System.out.println("Number of Visitors in Ride History: " + ride.numberOfVisitors());
    }

    public void partFourB() {
        System.out.println("\nPart 4B - Sorting the collection");
        Ride ride = new Ride("Roller Coaster", new Employee("John Doe", 30, "ID001", "E001", "Rides"));
        for (int i = 0; i < 5; i++) {
            Visitor visitor = new Visitor("Visitor" + (9 - i), 20 + i, "V" + (9 - i), "V" + (9 - i), "Regular");
            ride.addVisitorToHistory(visitor);
        }

        System.out.println("Visitors in Ride History before sorting:");
        ride.printRideHistory();

        ride.sortRideHistory();
        System.out.println("Visitors in Ride History after sorting:");
        ride.printSortedRideHistory();
    }

    public void partFive() {
        System.out.println("\nPart 5 - Run a ride cycle");
        Ride ride = new Ride("Roller Coaster", new Employee("John Doe", 30, "ID001", "E001", "Rides"));
        for (int i = 0; i < 10; i++) {
            Visitor visitor = new Visitor("Visitor" + (i + 1), 20 + i, "V" + (i + 1), "V" + (i + 1), "Regular");
            ride.addVisitorToQueue(visitor);
        }

        System.out.println("Visitors before running the ride:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("Visitors after running one cycle:");
        ride.printQueue();

        System.out.println("Ride history after one cycle:");
        ride.printRideHistory();
    }

    public void partSix() {
        System.out.println("\nPart 6 - Writing to a file");
        Ride ride = new Ride("Roller Coaster", new Employee("John Doe", 30, "ID001", "E001", "Rides"));
        for (int i = 0; i < 5; i++) {
            Visitor visitor = new Visitor("Visitor" + (i + 1), 20 + i, "V" + (i + 1), "V" + (i + 1), "Regular");
            ride.addVisitorToHistory(visitor);
        }

        ride.exportRideHistory();
    }

    public void partSeven() {
        System.out.println("\nPart 7 - Reading from a file");
        Ride ride = new Ride("Roller Coaster", new Employee("John Doe", 30, "ID001", "E001", "Rides"));
        ride.importRideHistory();

        System.out.println("Number of Visitors in the LinkedList: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
}