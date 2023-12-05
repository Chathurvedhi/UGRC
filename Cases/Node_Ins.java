class DualList
{
    Node head1;
    Node head2;
    Node head3;
}

class Node
{
    int data;
    Node(int item)
    {
        data = item;
    }
}

public class Node_Ins {
    public static void main(String args[])
    {   
        // Base Stack = {}, Heap = {}

        DualList list = new DualList();         // O1; Stack = {(list, O1)}          
                
        list.head1 = new Node(5);               // O2; Stack = {(list, O1)}; Heap = {(O1, head1, O2)}    
                
        AddList3(list);                         // Not sure how to do mapping and edit heap here from context insensitive analysis.                       
        
        PrintList1(list);                       
        
        PrintList1(list);                                   
        
        list.head2 = new Node(2);               
                
        PrintList2(list);                           
                
        Node currNode = list.head3;                         
        
        System.out.println(currNode.data);          
    }

    public static void PrintList1(DualList ll)
    {   
        // Base Stack = {ll, O1}, Heap = {}

        Node currNode = ll.head1;               // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}    
                          
        System.out.println(currNode.data);      // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}
    }

    public static void PrintList2(DualList ll)
    {
        // Base Stack = {ll, O1}, Heap = {}
        
        Node currNode = ll.head2;               // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head2, O2)}

        System.out.println(currNode.data);      // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head2, O2)}
    }

    public static void AddList3(DualList ll)
    {
        // Base Stack = {ll, O1}, Heap = {}

        Node currNode = new Node(7);            // O3; Stack = {(ll, O1), (currNode, O3)}; Heap = {}
        
        ll.head3 = currNode;                    // Stack = {(ll, O1), (currNode, O3)}; Heap = {(O1, head3, O3)}
    }
}
