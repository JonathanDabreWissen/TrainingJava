import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> isLongName = name -> name.length()>5;

        Predicate<Integer> canVote = age -> age>=18;

        System.out.println(isLongName.test("Jonathan"));
        System.out.println(canVote.test(21));
    }
}
