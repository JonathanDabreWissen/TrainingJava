import java.util.List;
import java.util.function.Predicate;

public class FilteringList {
    public static void main(String[] args) {
        List<String> names = List.of("Jonathan", "Simona", "Swapnil", "Ayushi", "Madhav", "Amani", "Karan", "Sanat");
        Predicate<String> startsWithS = name -> name.startsWith("S");
        Predicate<String> startsWithA = name -> name.startsWith("A");

        Predicate<String> combined = startsWithA.or(startsWithS);

        List<String> filteredNames = names.stream()
            .filter(combined)
            .toList();

        System.out.println(filteredNames);
    }
}
