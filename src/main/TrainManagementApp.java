import java.util.Arrays;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 20: Exception Handling During Search Operations
 * Description:
 * Implements state validation to prevent searching empty
 * train consists using IllegalStateException.
 */
public class TrainManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC20 - Defensive Search Validation ");
        System.out.println("=======================================\n");

        // Case 1: Searching an empty train
        String[] emptyConsist = {};
        try {
            System.out.println("Attempting search on empty consist...");
            safeSearch(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
        }

        // Case 2: Searching a valid train
        String[] validConsist = { "BG101", "BG205", "BG309" };
        try {
            System.out.println("\nAttempting search on valid consist...");
            boolean found = safeSearch(validConsist, "BG205");
            System.out.println("Result: " + (found ? "Bogie Found!" : "Bogie Not Found."));
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nUC20 defensive logic completed.");
    }

    /**
     * Logic: Validates state before searching.
     * 
     * @throws IllegalStateException if the array is null or empty.
     */
    public static boolean safeSearch(String[] bogieIDs, String key) {
        // 1. Fail-Fast Validation
        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException("Search failed: No bogies available in the train consist.");
        }

        // 2. Proceed with search logic if state is valid
        Arrays.sort(bogieIDs); // Precondition for binary search
        int index = Arrays.binarySearch(bogieIDs, key);

        return index >= 0;
    }
}