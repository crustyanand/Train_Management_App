import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TrainManagementAppTest {

    @Test
    public void testTrainInitialization() {
        // Get the initial consist from the app
        List<String> consist = TrainManagementApp.getInitialConsist();

        // Verify the list is not null
        assertNotNull(consist, "Train consist list should be initialized.");

        // Verify the initial count is 0
        assertEquals(0, consist.size(), "Initial bogie count should be 0.");

        // Verify the list is empty
        assertTrue(consist.isEmpty(), "Train consist should be empty on startup.");
    }
}