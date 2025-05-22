// package Optional;

import java.util.Optional;

public class MapVsFlatMap {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Jonathan");

        Optional<Optional<Integer>> result = name.map(s -> Optional.of(s.length()));

        Optional<Integer> result2 = name.flatMap(s -> Optional.of(s.length()));

    }
}
