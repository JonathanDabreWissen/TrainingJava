// package BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AssignmentProblem {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("12345.12345467");
        BigDecimal b = new BigDecimal("12345.123456");

        System.out.println(truncateBigDecimal(a));
        System.out.println(truncateBigDecimal(b));
    }

    private static BigDecimal truncateBigDecimal(BigDecimal value){
        return value.setScale(5, RoundingMode.HALF_UP);
    }
}

/*

We need to do rouding of numbers so that we can store them in Table Column with specific Precision and scale, without silent rounding.
    
    Use BigDecimal
    Given Column (p, s) = (25, 5)
    
    e.g. 
    "12345.12345|467" => "12345.12345"
    "12345.123456" => "12345.12346"
    
    2. After rouding print the resulted number
    
    3. Compare resulted number with expected number and print result.
 */