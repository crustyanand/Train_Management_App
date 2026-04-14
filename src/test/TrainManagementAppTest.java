import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    public void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            new TrainManagementApp.Bogie("Sleeper", 72);
        });
    }

    @Test
    public void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new TrainManagementApp.Bogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ZeroCapacityThrowsException() {
        assertThrows(InvalidCapacityException.class, () -> {
            new TrainManagementApp.Bogie("Sleeper", 0);
        });
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        TrainManagementApp.Bogie bogie = new TrainManagementApp.Bogie("General", 90);
        assertEquals("General", bogie.name);
        assertEquals(90, bogie.capacity);
    }
}