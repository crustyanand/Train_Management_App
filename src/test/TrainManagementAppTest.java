import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.Iterator;

public class TrainManagementAppTest {

    @Test
    public void testLinkedHashSetBehavior() {
        Set<String> formation = TrainManagementApp.getOrderedUniqueFormation();

        // 1. Verify uniqueness (Size should be 4, not 5)
        assertEquals(4, formation.size(), "LinkedHashSet should have ignored the duplicate 'Sleeper'.");

        // 2. Verify insertion order preservation
        Iterator<String> iterator = formation.iterator();
        assertEquals("Engine", iterator.next());
        assertEquals("Sleeper", iterator.next());
        assertEquals("Cargo", iterator.next());
        assertEquals("Guard", iterator.next());

        // 3. Verify specific content
        assertTrue(formation.contains("Cargo"), "Formation must contain 'Cargo'.");
        assertFalse(formation.isEmpty());
    }
}