import java.util.Arrays;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * Description:
 * Replaces manual algorithms with Java's optimized built-in
 * sorting utilities for production-ready performance.
 */
public class TrainManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC17 - Optimized Sorting (Arrays.sort) ");
        System.out.println("=======================================\n");

        // 1. Array of bogie type names
        String[] bogieNames = { "Sleeper", "AC Chair", "First Class", "General", "Luxury" };

        System.out.println("Unsorted Bogie Names: " + Arrays.toString(bogieNames));

        // 2. Perform Optimized Sort
        // This uses natural ordering (alphabetical for Strings)
        Arrays.sort(bogieNames);

        // 3. Display Result
        System.out.println("Sorted Bogie Names  : " + Arrays.toString(bogieNames));

        System.out.println("\nUC17 optimized library sorting completed.");
    }

    /**
     * Helper method for testing purposes
     */
    public static String[] sortNames(String[] names) {
        if (names != null) {
            Arrays.sort(names);
        }
        return names;
    }
}