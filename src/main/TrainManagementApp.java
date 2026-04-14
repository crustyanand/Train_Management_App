import java.util.ArrayList;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 * Description:
 * Enforces business rules during object creation.
 */
public class TrainManagementApp {

    public static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " [" + capacity + " seats]";
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC14 - Custom Exception Handling ");
        System.out.println("=======================================\n");

        // 1. Attempt to create a valid bogie
        try {
            Bogie validBogie = new Bogie("Sleeper", 72);
            System.out.println("SUCCESS: Created " + validBogie);
        } catch (InvalidCapacityException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        // 2. Attempt to create an invalid bogie (Zero Capacity)
        try {
            System.out.println("\nAttempting to create bogie with 0 capacity...");
            Bogie invalidBogie = new Bogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        // 3. Attempt to create an invalid bogie (Negative Capacity)
        try {
            System.out.println("\nAttempting to create bogie with -10 capacity...");
            Bogie invalidBogie = new Bogie("First Class", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        System.out.println("\nUC14 validation logic completed...");
    }
}