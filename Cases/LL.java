class DualList
{
    Node head1;
    Node head2;
}

class Node
{
    int data;
    Node next;
    Node(int item)
    {
        data = item;
        next = null;
    }
}

public class LL {
    public static void main(String args[])
    {
        DualList list = new DualList();             // O1; Stack = {(list, O1)}

        list.head1 = new Node(5);               // O2; Stack = {(list, O1)}; Heap = {(O1, head1, O2)}
        list.head1.next = new Node(10);         // O3; Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O2, next, O3)}
        list.head1.next.next = new Node(15);    // O4; Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O2, next, O3), (O3, next, O4)}

        PrintList1(list);                           // Call 1, Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O2, next, O3), (O3, next, O4)}
        
        PrintList1(list);  
        
        list.head2 = new Node(2);
        list.head2.next = new Node(3);

        PrintList2(list);
    }

    public static void PrintList1_Diff(DualList list)
    {
        Node currNode = list.head1;                 // Stack = {(list, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}
        System.out.print("List 1: ");       

        // while (currNode != null) {              
        //     System.out.print(currNode.data + " ");
        //     currNode = currNode.next;
        // }

        System.out.println(currNode.data + " ");
    }

    public static void PrintList1(DualList list)
    {
        Node currNode = list.head1;                 // Stack = {(list, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}
        System.out.print("List 1: ");

        // while (currNode != null) {
        //     System.out.print(currNode.data + " ");
        //     currNode = currNode.next;
        // }

        System.out.println(currNode.data + " "); 
    }

    public static void PrintList2(DualList list)
    {
        Node currNode = list.head2;                 // Stack = {(list, O1), (currNode, O2)}; Heap = {(O1, head2, O2)}
        System.out.print("List 2: ");

        // while (currNode != null) {
        //     System.out.print(currNode.data + " ");
        //     currNode = currNode.next;
        // }

        System.out.println(currNode.data + " "); 
    }
}
