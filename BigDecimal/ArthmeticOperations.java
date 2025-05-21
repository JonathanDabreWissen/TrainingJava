import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArthmeticOperations{
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("10.15");
        BigDecimal b = new BigDecimal("5.25");

        BigDecimal result = a.add(b);
        System.out.println("Result: " + result);
        System.out.println("Sum: " + a.add(b));
        System.out.println("Subtraction: " + a.subtract(b));
        System.out.println("Product: " + a.multiply(b));
        
        BigDecimal divResult = a.divide(b, 4, RoundingMode.HALF_UP);
        System.out.println("Division: " +divResult);

        //Setting scale
        BigDecimal number = new BigDecimal("10.12345");
        BigDecimal scaled = number.setScale(3, RoundingMode.HALF_UP);
        System.out.println("Set scaled number: " +scaled);
        
    }
}