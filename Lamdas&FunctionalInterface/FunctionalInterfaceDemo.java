// package Lamdas&FunctionalInterface;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        
    }
}

@FunctionalInterface
interface MyInterface{
    public void sayHello();
    // public void sayBye(); // Only one abstract method allowed in functional interface.

    default void sayBye(){

    };

    public static void sayOk(){

    };
}
