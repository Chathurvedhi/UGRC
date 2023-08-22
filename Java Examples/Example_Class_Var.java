/*

Class Variable Example Base

 */

public class Example_Class_Var {
    private static Object classObject; // Class variable

    public static void main(String[] args) {
        F1();
    }

    public static void F1() {
        System.out.println("F1: Calling F2");
        F2();
        // F1 uses the class variable until the end
        System.out.println("F1: Finished using the class variable");
    }

    public static void F2() {
        System.out.println("F2: Calling F3");
        F3();
        // F2 doesn't use the class variable itself
    }

    public static void F3() {
        System.out.println("F3: Calling F4");
        F4();
        // F3 uses the class variable
        System.out.println("F3: Using the class variable: " + classObject.toString());
    }

    public static void F4() {
        System.out.println("F4: Calling F5");
        F5();
        // F4 doesn't use the class variable itself
    }

    public static void F5() {
        System.out.println("F5: Creating an object and setting the class variable");
        classObject = new Object(); // Setting the class variable
        System.out.println("F5: Finished");
    }
}

