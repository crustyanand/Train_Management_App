import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrainManagementAppTest {

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        Map<String, List<TrainManagementApp.Bogie>> grouped = TrainManagementApp.groupBogiesByType(bogies);

        // Verify keys exist
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        Map<String, List<TrainManagementApp.Bogie>> grouped = TrainManagementApp.groupBogiesByType(bogies);

        // Verify that Sleeper group has 2 bogies
        assertEquals(2, grouped.get("Sleeper").size(), "Sleeper group should contain 2 bogies.");
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<TrainManagementApp.Bogie> emptyList = new ArrayList<>();
        Map<String, List<TrainManagementApp.Bogie>> result = TrainManagementApp.groupBogiesByType(emptyList);
        assertTrue(result.isEmpty(), "Grouping an empty list should return an empty map.");
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<TrainManagementApp.Bogie> singleList = new ArrayList<>();
        singleList.add(new TrainManagementApp.Bogie("Cargo", 100));

        Map<String, List<TrainManagementApp.Bogie>> result = TrainManagementApp.groupBogiesByType(singleList);
        assertEquals(1, result.size());
        assertEquals(1, result.get("Cargo").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        int originalSize = bogies.size();

        TrainManagementApp.groupBogiesByType(bogies);

        assertEquals(originalSize, bogies.size(), "Original list must remain unchanged after grouping.");
    }
}