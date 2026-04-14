import java.util.ArrayList;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - TrainManagementApp
 * =======================================================
 * Use Case 12: Safety Compliance Check for Goods Bogies
 * Description:
 * Enforces safety rules using allMatch() and lambda expressions.
 * Rule: Cylindrical bogies MUST carry Petroleum.
 */
public class TrainManagementApp {

    public static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "[" + type + " | Cargo: " + cargo + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" UC12 - Safety Compliance Check ");
        System.out.println("=======================================\n");

        // 1. Prepare list of goods bogies
        List<GoodsBogie> goodsConsist = getGoodsBogies();

        System.out.println("Inspecting Goods Consist:");
        goodsConsist.forEach(System.out::println);

        // 2. Perform Safety Check
        boolean isSafe = checkSafetyCompliance(goodsConsist);

        // 3. Display Result
        System.out.println("\n---------------------------------------");
        if (isSafe) {
            System.out.println(" STATUS: SAFETY COMPLIANT (Green Signal) ");
        } else {
            System.out.println(" STATUS: SAFETY VIOLATION DETECTED (Red Signal) ");
        }
        System.out.println("---------------------------------------");
    }

    /**
     * Logic: allMatch() ensures every bogie satisfies the predicate.
     * Predicate logic: If it's Cylindrical, cargo must be Petroleum.
     * Otherwise, any cargo is fine.
     */
    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b -> {
            if (b.type.equalsIgnoreCase("Cylindrical")) {
                return b.cargo.equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies are always safe in this rule
        });
    }

    public static List<GoodsBogie> getGoodsBogies() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Rectangular", "Coal"));
        list.add(new GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new GoodsBogie("Box", "Electronics"));
        return list;
    }
}