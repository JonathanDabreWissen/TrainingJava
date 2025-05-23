import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> messagSupplier = ()-> "Hello Bro, What's Up?";
        System.out.println(messagSupplier.get());
    }    
}
