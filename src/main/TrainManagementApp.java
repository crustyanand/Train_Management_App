import java.util.Arrays;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 19: Binary Search for Bogie ID (Optimized)
 * Description:
 * Implements an O(log n) search algorithm on sorted bogie
 * data to ensure high-speed lookups in large consists.
 */
public class TrainManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC19 - Binary Search (Optimized) ");
        System.out.println("=======================================\n");

        // Unsorted input IDs
        String[] bogieIDs = { "BG309", "BG101", "BG550", "BG205", "BG412" };
        String searchKey = "BG205";

        // 1. Precondition: Data must be sorted for Binary Search
        Arrays.sort(bogieIDs);
        System.out.println("Sorted Consist: " + Arrays.toString(bogieIDs));
        System.out.println("Searching for: " + searchKey);

        // 2. Execute Binary Search
        boolean found = binarySearch(bogieIDs, searchKey);

        // 3. Display Result
        System.out.println("\nResult: " + (found ? "Bogie Found!" : "Bogie Not Found."));

        System.out.println("\nUC19 optimized search completed.");
    }

    /**
     * Logic: Divide and Conquer.
     * Repeatedly halves the search range based on lexicographical comparison.
     */
    public static boolean binarySearch(String[] array, String key) {
        if (array == null || array.length == 0 || key == null) {
            return false;
        }

        // Precaution: Ensure array is sorted (requirement for Binary Search)
        Arrays.sort(array);

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(array[mid]);

            if (comparison == 0) {
                return true; // Key found
            } else if (comparison > 0) {
                low = mid + 1; // Look in the right half
            } else {
                high = mid - 1; // Look in the left half
            }
        }

        return false; // Key not found
    }
}