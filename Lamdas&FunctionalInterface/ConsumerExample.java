import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> greet = s -> System.out.println("Hello " + s);

        greet.accept("Jonathan");
    }
}
