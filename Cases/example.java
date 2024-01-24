class DualNode
{
    Node head1;
    Node head2;    
};

class Node
{
    int data;
    Node(int item)
    {
        data = item;
    }
};

public class example {
    public static void main(String Args)
    {
        DualNode dual = new DualNode();

        dual.head1 = new Node(5);
        dual.head2 = new Node(10);

        PrintList1(dual);

        PrintList2(dual);
    }


public static void PrintList1(DualNode dual)
{
    Node currNode = dual.head1;
    System.out.println(currNode.data);
}

public static void PrintList2(DualNode dual)
{
    Node currNode = dual.head2;
    System.out.println(currNode.data);
}

};
