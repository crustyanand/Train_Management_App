import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;

public class TrainManagementAppTest {

    @Test
    public void testUniqueBogieIDs() {
        Set<String> bogies = TrainManagementApp.getUniqueBogies();

        // 1. Verify that the size is 4 (even though 6 adds were attempted)
        assertEquals(4, bogies.size(), "HashSet should have removed the 2 duplicate IDs.");

        // 2. Verify all expected IDs are present
        assertTrue(bogies.contains("B6101"));
        assertTrue(bogies.contains("B6102"));
        assertTrue(bogies.contains("B6103"));
        assertTrue(bogies.contains("B6104"));

        // 3. Verify that adding a duplicate manually still results in 'false'
        boolean addedDuplicate = bogies.add("B6101");
        assertFalse(addedDuplicate, "HashSet should return false when adding an existing element.");
    }
}