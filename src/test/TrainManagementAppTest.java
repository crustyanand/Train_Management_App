import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class TrainManagementAppTest {

    @Test
    public void testReduce_TotalSeatCalculation() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        // 72 + 56 + 24 + 90 = 242
        int total = TrainManagementApp.calculateTotalSeats(bogies);
        assertEquals(242, total, "Total seat count should be 242.");
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<TrainManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainManagementApp.Bogie("Sleeper", 72));

        int total = TrainManagementApp.calculateTotalSeats(list);
        assertEquals(72, total, "Total should equal the single bogie's capacity.");
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<TrainManagementApp.Bogie> emptyList = new ArrayList<>();
        int total = TrainManagementApp.calculateTotalSeats(emptyList);
        assertEquals(0, total, "Empty list should result in 0 seats (identity value).");
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();
        int originalSize = bogies.size();

        TrainManagementApp.calculateTotalSeats(bogies);

        assertEquals(originalSize, bogies.size(), "The stream operation must not modify the original list.");
    }
}