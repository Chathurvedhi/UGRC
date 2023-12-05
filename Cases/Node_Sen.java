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

public class Node_Sen {
    public static void main(String args[])
    {   
        // Base Stack = {}, Heap = {}

        DualList list = new DualList();         // O1; Stack = {(list, O1)}   
                
        list.head1 = new Node(5);           // O2; Stack = {(list, O1)}; Heap = {(O1, head1, O2)} 
                
        // Call 1:
        PrintList1(list);                       // Stack = {(list, O1)}; Heap = {(O1, head1, O2)}                
        
        // Call 2:
        AddList3(list);                         // Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3)}                                      
        
        // Call 3:
        PrintList1(list);                       // Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3)}         
        
        list.head2 = new Node(2);           // O4; Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}        
                
        // Call 4:
        PrintList2(list);                       // Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)} 
                
        Node currNode = list.head3;             // Stack = {(list, O1), (currNode, O3)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}       
        
        System.out.println(currNode.data);      // Stack = {(list, O1), (currNode, O3)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}
        
        // Var Set: {}; Ref Set: {}
    }

    public static void PrintList1(DualList ll)
    {   
        Node currNode = ll.head1;               
        System.out.println(currNode.data);      
    }

    public static void PrintList2(DualList ll)
    {
        Node currNode = ll.head2;                                 
        System.out.println(currNode.data);      
    }

    public static void AddList3(DualList ll)
    {
        Node currNode = new Node(7);        
        ll.head3 = currNode;                    
    }
}

/* Call 1:
We create mapping for the formal and actual parameters only for variables not references
    public static void PrintList1(DualList ll)
    {   
        // Base Stack = {ll, O1}, Heap = {(O1, head1, O2)}

        Node currNode = ll.head1;           // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}    

        System.out.println(currNode.data);  // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}    
    
    }

*/

/* Call 2:
    public static void AddList3(DualList ll)
    {
        // Base Stack = {ll, O1}, Heap = {(O1, head1, O2)}

        Node currNode = new Node(7);        // O3; Stack = {(ll, O1), (currNode, O3)}; Heap = {(O1, head1, O2)}

        ll.head3 = currNode;                // Stack = {(ll, O1), (currNode, O3)}; Heap = {(O1, head1, O2), (O1, head3, O3)}

    }

*/

/* Call 3:
    public static void PrintList1(DualList ll)
    {   
        // Base Stack = {ll, O1}, Heap = {(O1, head1, O2), (O1, head3, O3)}

        Node currNode = ll.head1;           // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2), (O1, head3, O3)}    

        System.out.println(currNode.data);  // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2), (O1, head3, O3)}    
    
    }

*/

/* Call 4:
    public static void PrintList2(DualList ll)
    {
        // Base Stack = {ll, O1}, Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}

        Node currNode = ll.head2;           // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}    

        System.out.println(currNode.data);  // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}    
    
    }

*/



