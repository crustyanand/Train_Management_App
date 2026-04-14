import java.util.Arrays;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 16: Sort Passenger Bogies by Capacity (Bubble Sort)
 * Description:
 * Implements a manual sorting algorithm to organize bogie
 * capacities without using built-in library methods.
 */
public class TrainManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC16 - Manual Sorting (Bubble Sort) ");
        System.out.println("=======================================\n");

        // 1. Initial capacity data
        int[] capacities = { 72, 56, 24, 70, 60 };

        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        // 2. Perform Bubble Sort
        bubbleSort(capacities);

        // 3. Display Result
        System.out.println("Sorted Capacities  : " + Arrays.toString(capacities));

        System.out.println("\nUC16 algorithmic sorting completed successfully.");
    }

    /**
     * Logic: Bubble Sort Algorithm
     * Compares adjacent elements and swaps them if they are in descending order.
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap logic using a temporary variable
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}