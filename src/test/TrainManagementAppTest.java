import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TrainManagementAppTest {

    @Test
    public void testPassengerBogieOperations() {
        List<String> bogies = TrainManagementApp.getProcessedBogies();

        // 1. Verify 'AC Chair' was successfully removed
        assertFalse(bogies.contains("AC Chair"), "AC Chair should have been removed.");

        // 2. Verify 'Sleeper' and 'First Class' still exist
        assertTrue(bogies.contains("Sleeper"), "Sleeper should exist in the consist.");
        assertTrue(bogies.contains("First Class"), "First Class should exist in the consist.");

        // 3. Verify final size is 2
        assertEquals(2, bogies.size(), "The final bogie count should be 2.");
    }
}