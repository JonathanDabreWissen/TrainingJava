// package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        Stream<String> myStream = list.stream();

        String[] array = {"apple", "banana", "cherry"};
        Stream<String> stream = Arrays.stream(array);

        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        Stream<Integer> limit = Stream.iterate(0, n->n+1 ).limit(100);

        Stream<Integer> limit2 = Stream.generate(()->(int) Math.random()*100).limit(5);
        limit2.forEach(System.out::println);        
    }
}
