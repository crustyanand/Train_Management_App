import java.util.ArrayList;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - UseCase2TrainConsistMgmnt
 * =======================================================
 * Use Case 2: Add Passenger Bogies to Train
 * * Description:
 * This class demonstrates how passenger bogies can be
 * managed dynamically using ArrayList operations.
 */
public class TrainManagementApp {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("=======================================\n");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ---- CREATE (Add bogies) ----
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies);

        // ---- DELETE (Remove bogie) ----
        System.out.println("\nAfter Removing 'AC Chair':");
        passengerBogies.remove("AC Chair");
        System.out.println("Passenger Bogies : " + passengerBogies);

        // ---- READ (Check existence) ----
        System.out.println("\nChecking if 'Sleeper' exists:");
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Contains Sleeper? : " + hasSleeper);

        // Final State
        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully...");
    }

    // Helper method for Junit testing
    public static List<String> getProcessedBogies() {
        List<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");
        bogies.remove("AC Chair");
        return bogies;
    }
}