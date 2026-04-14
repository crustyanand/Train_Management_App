import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    public void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyArray = {};
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            TrainManagementApp.safeSearch(emptyArray, "BG101");
        });

        assertEquals("Search failed: No bogies available in the train consist.", exception.getMessage());
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        String[] consist = { "BG101", "BG205" };
        assertDoesNotThrow(() -> {
            TrainManagementApp.safeSearch(consist, "BG101");
        });
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        String[] consist = { "BG101", "BG205", "BG309" };
        assertTrue(TrainManagementApp.safeSearch(consist, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        String[] consist = { "BG101", "BG205", "BG309" };
        assertFalse(TrainManagementApp.safeSearch(consist, "BG999"));
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        String[] consist = { "BG101" };
        assertTrue(TrainManagementApp.safeSearch(consist, "BG101"));
    }
}