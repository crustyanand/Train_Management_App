import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 8: Filter Passenger Bogies Using Streams
 * Description:
 * This class demonstrates the use of Stream API to filter
 * bogies based on seating capacity threshold.
 */
public class TrainManagementApp {

    // Inner Bogie class (Reused from UC7)
    public static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC8 - Filter Passenger Bogies (Streams) ");
        System.out.println("=======================================\n");

        // 1. Initialize the list
        List<Bogie> bogies = getBogieList();

        System.out.println("Before Filtering:");
        bogies.forEach(System.out::println);

        // 2. Apply Stream Filtering (Threshold > 60)
        List<Bogie> highCapacityBogies = filterHighCapacityBogies(bogies, 60);

        System.out.println("\nAfter Filtering (Capacity > 60):");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies found matching the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        System.out.println("\nUC8 stream filtering completed successfully...");
    }

    /**
     * Logic: Converts list to stream, filters by capacity, and collects to new
     * list.
     */
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static List<Bogie> getBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        return bogies;
    }
}