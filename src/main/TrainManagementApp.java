import java.util.ArrayList;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 * Description:
 * Handles dynamic cargo assignment with runtime safety checks.
 */
public class TrainManagementApp {

    public static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type) {
            this.type = type;
            this.cargo = "Empty";
        }

        /**
         * Logic: Throws Runtime Exception if Petroleum is assigned to Rectangular
         * bogie.
         */
        public void assignCargo(String newCargo) {
            System.out.println("\n>>> Attempting to assign [" + newCargo + "] to [" + type + "] bogie...");

            try {
                if (type.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException(
                            "CRITICAL SAFETY VIOLATION: Petroleum cannot be carried in a Rectangular bogie!");
                }
                this.cargo = newCargo;
                System.out.println("SUCCESS: Cargo assigned successfully.");
            } catch (CargoSafetyException e) {
                System.out.println("CATCH BLOCK: " + e.getMessage());
            } finally {
                System.out.println("FINALLY BLOCK: Assignment process completed for this bogie.");
            }
        }

        @Override
        public String toString() {
            return type + " Bogie (Cargo: " + cargo + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC15 - Safe Cargo Assignment (try-catch-finally) ");
        System.out.println("=======================================\n");

        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        GoodsBogie g2 = new GoodsBogie("Rectangular");

        // 1. Safe Assignment
        g1.assignCargo("Petroleum");

        // 2. Unsafe Assignment (Will trigger catch and finally)
        g2.assignCargo("Petroleum");

        // 3. System continues running
        g2.assignCargo("Coal");

        System.out.println("\nFinal Train Status:");
        System.out.println(g1);
        System.out.println(g2);

        System.out.println("\nUC15 runtime safety management completed.");
    }
}