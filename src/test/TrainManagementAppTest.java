import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementAppTest {

    private final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(TrainManagementApp.validateInput("TRN-1234", TRAIN_ID_REGEX));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainManagementApp.validateInput("TRAIN12", TRAIN_ID_REGEX));
        assertFalse(TrainManagementApp.validateInput("1234-TRN", TRAIN_ID_REGEX));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainManagementApp.validateInput("TRN-123", TRAIN_ID_REGEX), "Too short");
        assertFalse(TrainManagementApp.validateInput("TRN-12345", TRAIN_ID_REGEX), "Too long");
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(TrainManagementApp.validateInput("PET-AB", CARGO_CODE_REGEX));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainManagementApp.validateInput("PET-12", CARGO_CODE_REGEX));
        assertFalse(TrainManagementApp.validateInput("AB-PET", CARGO_CODE_REGEX));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainManagementApp.validateInput("PET-ab", CARGO_CODE_REGEX), "Lowercase rejected");
        assertFalse(TrainManagementApp.validateInput("PET-Ab", CARGO_CODE_REGEX), "Mixed case rejected");
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(TrainManagementApp.validateInput("", TRAIN_ID_REGEX));
        assertFalse(TrainManagementApp.validateInput(null, TRAIN_ID_REGEX));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(TrainManagementApp.validateInput("TRN-1234Extra", TRAIN_ID_REGEX), "Partial match rejected");
    }
}