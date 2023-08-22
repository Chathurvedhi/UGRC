
class bar
{
    private int bar_int;
    private String bar_str;

    public bar(int x, String y)
    {
        this.bar_int = x;
        this.bar_str = y;
    }

    public void print_bar()
    {
        System.out.println("Bar data : ");
        System.out.println(bar_str);
        System.out.println(bar_int);
    }
}

class foo
{
    private bar foo_bar_1;
    private bar foo_bar_2;

    public void initiate_1(bar x)
    {
        foo_bar_1 = x;
    }

    public void initiate_2(bar x)
    {
        foo_bar_2 = x;
    }

    public void print_foo()
    {
        System.out.println("Foo data : ");
        foo_bar_1.print_bar();
        foo_bar_2.print_bar();
    }
}

public class Example_Ext_Obj {

    public static foo class_foo;
    public static void main(String[] args)
    {
        class_foo = new foo();
        F1();
    }

    public static void F1()
    {
        bar F1_bar_1 = new bar(1, "bar_1");      
        bar F1_bar_2 = new bar(2, "bar_2");
        F1_bar_1.print_bar();
        F1_bar_2.print_bar();
        class_foo.initiate_1(F1_bar_1);             // Now aliveness of F1_bar_1 is attached class_foo
        F2();
    }

    public static void F2()
    {
        bar F2_bar_1 = new bar(1, "bar_1");      
        bar F2_bar_2 = new bar(2, "bar_2");
        F2_bar_1.print_bar();
        F2_bar_2.print_bar();
        class_foo.initiate_1(F2_bar_1);             // Now aliveness of F2_bar_2 is attached class_foo
    } 
}
