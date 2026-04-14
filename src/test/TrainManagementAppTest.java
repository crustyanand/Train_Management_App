import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class TrainManagementAppTest {

    @Test
    public void testBogieCapacityMapping() {
        Map<String, Integer> capacities = TrainManagementApp.getBogieCapacities();

        // 1. Verify all 4 bogie types are present
        assertEquals(4, capacities.size(), "There should be exactly 4 bogie mappings.");

        // 2. Verify specific capacity values
        assertEquals(72, capacities.get("Sleeper"), "Sleeper capacity should be 72.");
        assertEquals(56, capacities.get("AC Chair"), "AC Chair capacity should be 56.");
        assertEquals(24, capacities.get("First Class"), "First Class capacity should be 24.");
        assertEquals(120, capacities.get("Cargo"), "Cargo capacity should be 120.");

        // 3. Verify existence of keys
        assertTrue(capacities.containsKey("Sleeper"));
        assertFalse(capacities.containsKey("Engine"), "Engine was not added to the capacity map.");
    }
}