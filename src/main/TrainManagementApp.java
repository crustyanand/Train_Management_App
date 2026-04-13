import java.util.HashSet;
import java.util.Set;

/**
 * =======================================================
 * MAIN CLASS - UseCase3TrainConsistMgmnt
 * =======================================================
 * Use Case 3: Track Unique Bogie IDs
 * * Description:
 * This class ensures that duplicate bogie IDs are not
 * added into the train formation using HashSet.
 */
public class TrainManagementApp {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("=======================================\n");

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogies = getUniqueBogies();

        // Display the results
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 uniqueness validation completed...");
    }

    // Helper method for logic and testing
    public static Set<String> getUniqueBogies() {
        Set<String> bogies = new HashSet<>();

        // ---- ADD IDs (including duplicates) ----
        // add() inserts bogie IDs into the set
        bogies.add("B6101");
        bogies.add("B6102");
        bogies.add("B6103");
        bogies.add("B6104");

        // Duplicate entries will be ignored internally by HashSet
        bogies.add("B6101"); // Duplicate entry
        bogies.add("B6102"); // Duplicate entry

        return bogies;
    }
}