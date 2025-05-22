// package Optional;

import java.util.Optional;

public class OptionalMap {
     public static void main(String[] args) {
        Optional<String> optional = getName(2);

        Optional<String> optionalMapped = optional.map(x -> x.toUpperCase());

        optionalMapped.ifPresent(x -> System.out.println(x));

        Optional<Integer> length = optional.map(x->x.length());
        length.ifPresent(System.out::println);
        
    }
    
    private static Optional<String> getName(int id){
        String name = "Shyam";
        // return Optional.of(name); //Will Throw null pointer exception if null
        // return Optional.empty();  //Returns null
        return Optional.ofNullable(name); //Safeguards from null pointer exception.
    }
}
