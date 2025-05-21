// package BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Methods {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("2.12345467");
        BigDecimal b = new BigDecimal("3.123456");

        System.out.println(a.remainder(b));
        System.out.println(b.pow(3));
        System.out.println(a.negate());

        System.out.println("Comparison Operators");
        System.out.println(a.compareTo(b));
        System.out.println(a.equals(b));
        System.out.println(a.min(b));
        System.out.println(a.max(b));
        System.out.println(a.signum());

        System.out.println("Scale & Rounding");
        // System.out.println(a.setScale(5)); //default HALF_UP
        System.out.println(a.setScale(5, RoundingMode.HALF_UP ));
        System.out.println(b.setScale(5, RoundingMode.HALF_UP ));

    }
}