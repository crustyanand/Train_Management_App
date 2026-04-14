import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    @Test
    public void testSort_BasicSorting() {
        int[] input = { 72, 56, 24, 70, 60 };
        int[] expected = { 24, 56, 60, 70, 72 };

        TrainManagementApp.bubbleSort(input);
        assertArrayEquals(expected, input, "Array should be sorted in ascending order.");
    }

    @Test
    public void testSort_AlreadySortedArray() {
        int[] input = { 10, 20, 30 };
        int[] expected = { 10, 20, 30 };

        TrainManagementApp.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_DuplicateValues() {
        int[] input = { 50, 20, 50, 10 };
        int[] expected = { 10, 20, 50, 50 };

        TrainManagementApp.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_SingleElementArray() {
        int[] input = { 100 };
        int[] expected = { 100 };

        TrainManagementApp.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSort_AllEqualValues() {
        int[] input = { 40, 40, 40 };
        int[] expected = { 40, 40, 40 };

        TrainManagementApp.bubbleSort(input);
        assertArrayEquals(expected, input);
    }
}