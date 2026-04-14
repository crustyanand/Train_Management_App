import java.util.ArrayList;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 10: Count Total Seats in Train (reduce)
 * Description:
 * This class uses Stream reduction to aggregate individual
 * bogie capacities into a single total value.
 */
public class TrainManagementApp {

    // Inner Bogie class (Reused from previous UCs)
    public static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("=======================================\n");

        // 1. Initialize the list
        List<Bogie> bogies = getBogieList();

        System.out.println("Current Train Consist:");
        bogies.forEach(System.out::println);

        // 2. Aggregate using Stream (Map + Reduce)
        int totalSeats = calculateTotalSeats(bogies);

        // 3. Display Result
        System.out.println("\n---------------------------------------");
        System.out.println(" TOTAL SEATING CAPACITY : " + totalSeats);
        System.out.println("---------------------------------------");

        System.out.println("\nUC10 aggregation analytics completed...");
    }

    /**
     * Logic: map() extracts capacity, reduce() sums them up.
     */
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity) // Transform Bogie object to Integer
                .reduce(0, Integer::sum); // Aggregate using sum
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