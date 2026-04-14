import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class TrainManagementAppTest {

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        // Threshold 70: Should return Sleeper(72) and General(90)
        List<TrainManagementApp.Bogie> result = TrainManagementApp.filterHighCapacityBogies(bogies, 70);
        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        // Threshold 72: Should NOT include Sleeper (since we use > not >=)
        List<TrainManagementApp.Bogie> result = TrainManagementApp.filterHighCapacityBogies(bogies, 72);
        // Only General(90) remains
        assertEquals(1, result.size());
        assertEquals("General", result.get(0).name);
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        List<TrainManagementApp.Bogie> result = TrainManagementApp.filterHighCapacityBogies(bogies, 100);
        assertTrue(result.isEmpty(), "List should be empty for threshold higher than all capacities.");
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        List<TrainManagementApp.Bogie> result = TrainManagementApp.filterHighCapacityBogies(bogies, 150);
        assertEquals(0, result.size());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        List<TrainManagementApp.Bogie> result = TrainManagementApp.filterHighCapacityBogies(bogies, 10);
        assertEquals(bogies.size(), result.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<TrainManagementApp.Bogie> emptyList = new ArrayList<>();
        List<TrainManagementApp.Bogie> result = TrainManagementApp.filterHighCapacityBogies(emptyList, 50);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        int originalSize = bogies.size();

        TrainManagementApp.filterHighCapacityBogies(bogies, 60);

        assertEquals(originalSize, bogies.size(), "Original list should not be modified by the stream.");
    }
}