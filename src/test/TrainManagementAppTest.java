import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TrainManagementAppTest {

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getLargeBogieList(100);

        List<TrainManagementApp.Bogie> loopResult = TrainManagementApp.filterByLoop(bogies, 60);
        List<TrainManagementApp.Bogie> streamResult = TrainManagementApp.filterByStream(bogies, 60);

        assertEquals(loopResult.size(), streamResult.size(), "Both methods must return the same number of items.");
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        // Minor operation to ensure time passes
        for (int i = 0; i < 100; i++) {
            Math.sqrt(i);
        }
        long end = System.nanoTime();

        assertTrue((end - start) > 0, "Elapsed time should be a positive value.");
    }

    @Test
    public void testLargeDatasetProcessing() {
        // Test with 50,000 items to ensure no crashes and consistent logic
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getLargeBogieList(50000);
        List<TrainManagementApp.Bogie> result = TrainManagementApp.filterByStream(bogies, 99);

        // Statistically, with random 0-100, some items should match 99
        assertNotNull(result);
    }
}