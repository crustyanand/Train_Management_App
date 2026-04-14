import java.util.Arrays;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 18: Linear Search for Bogie ID (Array-Based)
 * Description:
 * Implements a sequential search to locate a specific bogie
 * ID within the train consist.
 */
public class TrainManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("=======================================\n");

        // 1. Array of bogie IDs
        String[] bogieIDs = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        String searchKey = "BG309";

        System.out.println("Train Consist IDs: " + Arrays.toString(bogieIDs));
        System.out.println("Searching for Bogie ID: " + searchKey);

        // 2. Execute Linear Search
        boolean found = linearSearch(bogieIDs, searchKey);

        // 3. Display Result
        if (found) {
            System.out.println("\nSUCCESS: Bogie " + searchKey + " identified in the consist.");
        } else {
            System.out.println("\nFAILED: Bogie " + searchKey + " not found.");
        }

        System.out.println("\nUC18 searching logic completed.");
    }

    /**
     * Logic: Sequentially checks each element.
     * Returns true if match found, false otherwise.
     */
    public static boolean linearSearch(String[] array, String key) {
        if (array == null || key == null)
            return false;

        for (String id : array) {
            if (id.equals(key)) {
                return true; // Early termination
            }
        }
        return false; // Traversed entire list without a match
    }
}