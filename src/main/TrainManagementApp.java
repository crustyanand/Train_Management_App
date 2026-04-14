import java.util.LinkedList;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - UseCase4TrainConsistMgmnt
 * =======================================================
 * Use Case 4: Maintain Ordered Bogie Consist
 * * Description:
 * This class models the physical chaining of train bogies
 * using LinkedList for ordered operations.
 */
public class TrainManagementApp {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("=======================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts/removals
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add initial bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // Insert 'Pantry Car' at position 2
        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        trainConsist.add(2, "Pantry Car");
        System.out.println(trainConsist);

        // Remove First and Last Bogie
        System.out.println("\nAfter Removing First and Last Bogie:");
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println(trainConsist);

        System.out.println("\nUC4 ordered consist operations completed...");
    }

    // Helper method for testing the logic
    public static LinkedList<String> getFinalConsist() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Engine");
        list.add("Sleeper");
        list.add("AC");
        list.add("Cargo");
        list.add("Guard");
        list.add(2, "Pantry Car");
        list.removeFirst();
        list.removeLast();
        return list;
    }
}