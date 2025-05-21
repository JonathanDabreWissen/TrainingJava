// package BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingModes {
    public static void main(String[] args) {
        // roundAndPrint(new BigDecimal("2.545"));
        // System.out.println();
        roundAndPrint(new BigDecimal("2.554"));
        System.out.println();
        roundAndPrint(new BigDecimal("2.555"));
        System.out.println();
        roundAndPrint(new BigDecimal("2.556"));
        System.out.println();
        // roundAndPrint(new BigDecimal("-2.555"));
        // System.out.println();  
    }

    public static void roundAndPrint(BigDecimal value) {
        System.out.println("Oringinal value: " + value);

        System.out.println("HALF_UP: " + value.setScale(2, RoundingMode.HALF_UP));
        System.out.println("HALF_DOWN: " + value.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println("HALF_EVEN: " + value.setScale(2, RoundingMode.HALF_EVEN));
        System.out.println("UP: " + value.setScale(2, RoundingMode.UP));
        System.out.println("DOWN: " + value.setScale(2, RoundingMode.DOWN));
        System.out.println("CEILING: " + value.setScale(2, RoundingMode.CEILING));
        System.out.println("FLOOR: " + value.setScale(2, RoundingMode.FLOOR));
        
    }
}
