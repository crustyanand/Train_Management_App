import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    public void testBinarySearch_BogieFound() {
        String[] consist = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        assertTrue(TrainManagementApp.binarySearch(consist, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        String[] consist = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        assertFalse(TrainManagementApp.binarySearch(consist, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        String[] consist = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        assertTrue(TrainManagementApp.binarySearch(consist, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        String[] consist = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        assertTrue(TrainManagementApp.binarySearch(consist, "BG550"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] empty = {};
        assertFalse(TrainManagementApp.binarySearch(empty, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        // The binarySearch method sorts the input internally to maintain the
        // precondition
        String[] unsorted = { "BG309", "BG101", "BG550", "BG205", "BG412" };
        assertTrue(TrainManagementApp.binarySearch(unsorted, "BG205"));
    }
}