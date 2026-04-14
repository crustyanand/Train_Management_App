import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 9: Group Bogies by Type
 * Description:
 * This class uses Stream collectors to group bogies into
 * categories based on their name/type.
 */
public class TrainManagementApp {

    // Inner Bogie class (Same as UC7 & UC8)
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
        System.out.println(" UC9 - Group Bogies by Type (Streams) ");
        System.out.println("=======================================\n");

        // 1. Initialize the list with some duplicate types for grouping
        List<Bogie> bogies = getBogieList();

        System.out.println("Original Bogie List:");
        bogies.forEach(System.out::println);

        // 2. Group Bogies using groupingBy
        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        // 3. Display the grouped results
        System.out.println("\nGrouped Bogies by Type:");
        groupedBogies.forEach((type, list) -> {
            System.out.println(type + " -> " + list);
        });

        System.out.println("\nUC9 data aggregation completed successfully...");
    }

    /**
     * Groups bogies by their name using the groupingBy collector.
     */
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    public static List<Bogie> getBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 72)); // Added second sleeper for grouping demo
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        return bogies;
    }
}