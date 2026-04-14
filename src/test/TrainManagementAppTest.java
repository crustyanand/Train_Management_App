import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    public void testCargo_SafeAssignment() {
        TrainManagementApp.GoodsBogie bogie = new TrainManagementApp.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo, "Cargo should be assigned correctly for Cylindrical bogies.");
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        TrainManagementApp.GoodsBogie bogie = new TrainManagementApp.GoodsBogie("Rectangular");
        // This method handles the exception internally via try-catch
        bogie.assignCargo("Petroleum");

        assertNotEquals("Petroleum", bogie.cargo, "Cargo should NOT be updated if safety violation occurs.");
        assertEquals("Empty", bogie.cargo);
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        TrainManagementApp.GoodsBogie bogie = new TrainManagementApp.GoodsBogie("Rectangular");

        // Attempt bad assignment
        bogie.assignCargo("Petroleum");

        // Attempt good assignment immediately after
        bogie.assignCargo("Coal");

        assertEquals("Coal", bogie.cargo, "System should recover and allow valid assignments after a failure.");
    }
}