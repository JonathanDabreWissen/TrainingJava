// package Streams;

import java.util.List;
import java.util.stream.Stream;

public class PeekDemo {
    public static void main(String[] args) {
        List<Integer> collect = Stream.iterate(0, x-> x+1)
            .limit(101)
            .skip(1)
            .peek(x-> System.out.println(x))
            .filter(x -> x% 2 == 0)
            .map(x -> x/ 10)
            .distinct()
            .sorted()
            .peek(x -> System.out.println(x))
            .toList();

        System.out.println("-------------------------------");
        int max = Stream.iterate(0, x->x+1)
            .limit(101)
            .map(x->x/20)
            .distinct()
            .max((a, b)->(a-b))
            .get();
        System.out.println(max);
    }   
}
