// package Optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> name = getName(2);

        name.ifPresent(x -> System.out.println(x.toUpperCase()));
        //name.get(); // Returns value inside the optional.
    }
    
    private static Optional<String> getName(int id){
        String name = null;
        // return Optional.of(name); //Will Throw null pointer exception if null
        // return Optional.empty();  //Returns null
        return Optional.ofNullable(name); //Safeguards from null pointer exception.
    }
}
