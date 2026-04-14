import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 11: Validate Train ID & Cargo Codes (Regex)
 * Description:
 * This class uses Regular Expressions to enforce data
 * integrity by validating input formats for Train IDs
 * and Cargo Codes.
 */
public class TrainManagementApp {

    // Regex Patterns
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC11 - Regex Format Validation ");
        System.out.println("=======================================\n");

        // Example Inputs
        String trainID = "TRN-1234";
        String cargoCode = "PET-AB";

        // Validate Train ID
        boolean isTrainValid = validateInput(trainID, TRAIN_ID_REGEX);
        System.out.println("Train ID: " + trainID + " -> " + (isTrainValid ? "VALID" : "INVALID"));

        // Validate Cargo Code
        boolean isCargoValid = validateInput(cargoCode, CARGO_CODE_REGEX);
        System.out.println("Cargo Code: " + cargoCode + " -> " + (isCargoValid ? "VALID" : "INVALID"));

        System.out.println("\nUC11 regex validation completed...");
    }

    /**
     * Logic: Compiles pattern and uses Matcher to check if
     * the entire input string matches the regex.
     */
    public static boolean validateInput(String input, String regex) {
        if (input == null)
            return false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}