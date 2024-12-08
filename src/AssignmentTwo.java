public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partFive(); 
        
    }

    public void partFive() {
        Ride ride = new Ride("Roller Coaster", new Employee("John Doe", 30, "ID001", "E001", "Rides"));
        ride.setMaxRider(7); 

    
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

}