import java.util.HashMap;
import java.util.Map;

/**
 * =======================================================
 * MAIN CLASS - UseCase6TrainConsistMgmnt
 * =======================================================
 * Use Case 6: Map Bogie to Capacity
 * Description:
 * This class associates each bogie with its seating or
 * load capacity using a key-value mapping structure (HashMap).
 */
public class TrainManagementApp {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("=======================================\n");

        // HashMap stores data in key -> value format
        Map<String, Integer> capacityMap = getBogieCapacities();

        System.out.println("Bogie Capacity Details:");

        // Iterating through map entries using entrySet()
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }

    /**
     * Helper method to initialize and return the capacity map.
     * Used for both the main application and JUnit testing.
     */
    public static Map<String, Integer> getBogieCapacities() {
        Map<String, Integer> capacities = new HashMap<>();

        // ---- Insert bogie capacities ----
        capacities.put("Sleeper", 72);
        capacities.put("AC Chair", 56);
        capacities.put("First Class", 24);
        capacities.put("Cargo", 120);

        return capacities;
    }
}