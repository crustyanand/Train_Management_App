import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class TrainManagementAppTest {

    @Test
    public void testSafety_AllBogiesValid() {
        List<TrainManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new TrainManagementApp.GoodsBogie("Rectangular", "Grain"));

        assertTrue(TrainManagementApp.checkSafetyCompliance(list));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<TrainManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainManagementApp.GoodsBogie("Cylindrical", "Coal")); // VIOLATION

        assertFalse(TrainManagementApp.checkSafetyCompliance(list));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainManagementApp.GoodsBogie("Box", "AnyCargo"));

        assertTrue(TrainManagementApp.checkSafetyCompliance(list));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<TrainManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainManagementApp.GoodsBogie("Rectangular", "Coal"));
        list.add(new TrainManagementApp.GoodsBogie("Cylindrical", "Water")); // VIOLATION

        assertFalse(TrainManagementApp.checkSafetyCompliance(list));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<TrainManagementApp.GoodsBogie> emptyList = new ArrayList<>();
        // All elements in an empty list satisfy any predicate (vacuous truth)
        assertTrue(TrainManagementApp.checkSafetyCompliance(emptyList));
    }
}