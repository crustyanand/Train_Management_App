import java.util.LinkedHashSet;
import java.util.Set;

/**
 * =======================================================
 * MAIN CLASS - UseCase5TrainConsistMgmnt
 * =======================================================
 * Use Case 5: Preserve Insertion Order of Bogies
 * Description:
 * This class maintains the exact attachment order of bogies
 * while preventing duplicate entries using LinkedHashSet.
 */
public class TrainManagementApp {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("=======================================\n");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = getOrderedUniqueFormation();

        // Display final formation
        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }

    // Helper method to simulate the logic for the assignment and testing
    public static Set<String> getOrderedUniqueFormation() {
        Set<String> formation = new LinkedHashSet<>();

        // Attaching bogies in order
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Intentional duplicate attempt
        formation.add("Sleeper");

        return formation;
    }
}