// package Optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalOrElse {
    public static void main(String[] args) {
        Optional<String> name = getName(2);


        String nameToBeUsed = name.orElse("NA");
        System.out.println(nameToBeUsed);

        //Supplier -> doesn't take any parameter just returns something.
        String nameToBeUsed2 = name.orElseGet(()->"NA");
        System.out.println(nameToBeUsed2);

        String nameToBeUsed3 = name.orElseGet(()->{
            String s = "N";
            s = s + "A";

            return s;
        });

        System.out.println(nameToBeUsed3);

        String nameToBeUsed4 = name.orElseThrow(()-> new NoSuchElementException());
        
    }
    
    private static Optional<String> getName(int id){
        // String name = "Shyam";
        String name = null;
        
        return Optional.ofNullable(name); 
    }
}
