import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] input = { "Sleeper", "AC Chair", "First Class", "General", "Luxury" };
        String[] expected = { "AC Chair", "First Class", "General", "Luxury", "Sleeper" };

        TrainManagementApp.sortNames(input);
        assertArrayEquals(expected, input, "The names should be in alphabetical order.");
    }

    @Test
    public void testSort_UnsortedInput() {
        String[] input = { "Luxury", "General", "Sleeper", "AC Chair" };
        String[] expected = { "AC Chair", "General", "Luxury", "Sleeper" };

        TrainManagementApp.sortNames(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_AlreadySortedArray() {
        String[] input = { "AC Chair", "First Class", "General" };
        String[] expected = { "AC Chair", "First Class", "General" };

        TrainManagementApp.sortNames(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_DuplicateBogieNames() {
        String[] input = { "Sleeper", "AC Chair", "Sleeper", "General" };
        String[] expected = { "AC Chair", "General", "Sleeper", "Sleeper" };

        TrainManagementApp.sortNames(input);
        assertArrayEquals(expected, input, "Duplicate names should stay together in the sorted list.");
    }

    @Test
    public void testSort_SingleElementArray() {
        String[] input = { "Sleeper" };
        String[] expected = { "Sleeper" };

        TrainManagementApp.sortNames(input);
        assertArrayEquals(expected, input);
    }
}