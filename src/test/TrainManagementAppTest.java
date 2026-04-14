import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    private final String[] consist = { "BG101", "BG205", "BG309", "BG412", "BG550" };

    @Test
    public void testSearch_BogieFound() {
        assertTrue(TrainManagementApp.linearSearch(consist, "BG309"),
                "Search should find an existing ID in the middle of the array.");
    }

    @Test
    public void testSearch_BogieNotFound() {
        assertFalse(TrainManagementApp.linearSearch(consist, "BG999"),
                "Search should return false if the ID does not exist.");
    }

    @Test
    public void testSearch_FirstElementMatch() {
        assertTrue(TrainManagementApp.linearSearch(consist, "BG101"),
                "Search should correctly identify the first element.");
    }

    @Test
    public void testSearch_LastElementMatch() {
        assertTrue(TrainManagementApp.linearSearch(consist, "BG550"),
                "Search should correctly identify the last element.");
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] single = { "BG101" };
        assertTrue(TrainManagementApp.linearSearch(single, "BG101"));
        assertFalse(TrainManagementApp.linearSearch(single, "BG202"));
    }
}