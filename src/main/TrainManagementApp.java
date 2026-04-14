import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 * Description:
 * This class sorts passenger bogies based on seating
 * capacity using a custom Comparator.
 */
public class TrainManagementApp {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("=======================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = getBogieList();

        System.out.println("Before Sorting:");
        bogies.forEach(System.out::println);

        // Sort using Comparator logic (Ascending order)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        bogies.forEach(System.out::println);

        System.out.println("\nUC7 sorting completed...");
    }

    /**
     * Helper method to initialize the bogie list.
     */
    public static List<Bogie> getBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        return bogies;
    }
}