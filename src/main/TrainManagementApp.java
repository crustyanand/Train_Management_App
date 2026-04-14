import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 13: Performance Comparison (Loops vs Streams)
 * Description:
 * Benchmarks the execution time of traditional loops
 * versus Stream API for filtering operations.
 */
public class TrainManagementApp {

    public static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC13 - Performance Comparison ");
        System.out.println("=======================================\n");

        List<Bogie> bogies = getLargeBogieList(10000);

        // 1. Benchmark Loop
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopResult = filterByLoop(bogies, 60);
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // 2. Benchmark Stream
        long startTimeStream = System.nanoTime();
        List<Bogie> streamResult = filterByStream(bogies, 60);
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // 3. Display Comparison
        System.out.println("Dataset Size: " + bogies.size() + " bogies");
        System.out.println("Loop Time   : " + durationLoop + " ns");
        System.out.println("Stream Time : " + durationStream + " ns");
        System.out.println("\nResults Match: " + (loopResult.size() == streamResult.size()));

        System.out.println("\nUC13 performance benchmarking completed...");
    }

    // Imperative Approach (Traditional Loop)
    public static List<Bogie> filterByLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    // Declarative Approach (Stream API)
    public static List<Bogie> filterByStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static List<Bogie> getLargeBogieList(int size) {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Bogie("Bogie-" + i, (int) (Math.random() * 100)));
        }
        return list;
    }
}