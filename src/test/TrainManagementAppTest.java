import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import java.util.List;

public class TrainManagementAppTest {

    @Test
    public void testBogieSortingByCapacity() {
        List<TrainManagementApp.Bogie> bogies = TrainManagementApp.getBogieList();

        // Perform sorting
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // Verify the order: First Class (24), AC Chair (56), Sleeper (72), General (90)
        assertEquals("First Class", bogies.get(0).name);
        assertEquals(24, bogies.get(0).capacity);

        assertEquals("AC Chair", bogies.get(1).name);
        assertEquals(56, bogies.get(1).capacity);

        assertEquals("Sleeper", bogies.get(2).name);
        assertEquals(72, bogies.get(2).capacity);

        assertEquals("General", bogies.get(3).name);
        assertEquals(90, bogies.get(3).capacity);
    }
}