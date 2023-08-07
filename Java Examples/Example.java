public class Example {
    public static void main(String[] args) {
        F1();
    }

    public static void F1() {
        System.out.println("F1: Calling F2");
        Object obj = F2();
        // F1 uses the object until F3
        System.out.println("F1: Finished using the object");
    }

    public static Object F2() {
        System.out.println("F2: Calling F3");
        Object obj = F3();
        System.out.println("F2: Received object from F3");
        // F2 doesn't use the object itself but returns it
        return obj;
    }

    public static Object F3() {
        System.out.println("F3: Calling F4");
        Object obj = F4();
        System.out.println("F3: Received object from F4");
        // F3 uses the object until F3
        System.out.println("F3: Printing a certain element from the object: " + obj.toString());
        return obj;
    }

    public static Object F4() {
        System.out.println("F4: Calling F5");
        Object obj = F5();
        System.out.println("F4: Received object from F5");
        // F4 doesn't use the object itself but returns it
        return obj;
    }

    public static Object F5() {
        System.out.println("F5: Creating an object");
        Object obj = new Object();
        System.out.println("F5: Finished");
        return obj;
    }
}
