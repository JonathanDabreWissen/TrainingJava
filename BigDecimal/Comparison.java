// package BigDecimal;

import java.math.BigDecimal;

public class Comparison {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("2.0");
        BigDecimal b = new BigDecimal("2.01");

        System.out.println(a.equals(b)); // True or False
        System.out.println(a.compareTo(b)); // Numeric Difference
        System.out.println(b.compareTo(a));
    }   
}
