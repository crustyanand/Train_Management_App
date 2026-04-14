import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class TrainManagementAppTest {

    @Test
    public void testLinkedListOperations() {
        LinkedList<String> consist = TrainManagementApp.getFinalConsist();

        // 1. Check that the first and last elements were removed
        // (Initial: Engine, Guard. Final should start with Sleeper and end with Cargo)
        assertEquals("Sleeper", consist.getFirst(), "First element should be Sleeper.");
        assertEquals("Cargo", consist.getLast(), "Last element should be Cargo.");

        // 2. Check the position of 'Pantry Car'
        // After adding at index 2, and removing the first element, it should now be at
        // index 1
        assertEquals("Pantry Car", consist.get(1), "Pantry Car should be at index 1 after removals.");

        // 3. Check final size
        // 5 initial + 1 added - 2 removed = 4
        assertEquals(4, consist.size(), "The final consist should have 4 bogies.");
    }
}