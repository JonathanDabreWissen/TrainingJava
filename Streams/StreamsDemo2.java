// package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 4322, 9, 0, 5, 44, 23, 433, 1, 2, 4, 6);
        
        List<Integer> filteredList = list.stream().filter(n-> n%2 ==0).collect(Collectors.toList());
        System.out.println(filteredList);

        List<Integer> mappedList = filteredList.stream().map(n->n/2).toList();
        System.out.println(mappedList);

        List<Integer> newList = list.stream()
            .filter(n->n%2 == 0)
            .map(n->n/2)
            .distinct()
            .sorted()
            .toList();

        System.out.println(newList);

        List<Integer> descendingList = list.stream()
            .filter(n->n%2 == 0)
            .map(n->n/2)
            .distinct()
            .sorted((a, b)->(b-a))
            .toList();
        System.out.println(descendingList);

        List<Integer> limitedDescendingList = list.stream()
            .filter(n->n%2 == 0)
            .map(n->n/2)
            .distinct()
            .sorted((a, b)->(b-a))
            .limit(2)
            .toList();
        System.out.println(limitedDescendingList);

        List<Integer> skipElementFromStart = list.stream()
            .filter(n->n%2==0)
            .map(n->n/2)
            .distinct()
            .sorted((a, b)->(b-a))
            .skip(1)
            .limit(2)
            .toList();
        System.out.println(skipElementFromStart);

        List<Integer> skipAfterLimit = list.stream()
            .filter(n->n%2==0)
            .map(n->n/2)
            .distinct()
            .sorted((a, b)->(b-a))
            .limit(2)
            .skip(1)
            .toList();
        System.out.println(skipAfterLimit);


    }
}
