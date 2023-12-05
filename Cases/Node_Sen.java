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
                
        // Var Set: {list}; Ref Set: {O1}
        
        list.head1 = new Node(5);           // O2; Stack = {(list, O1)}; Heap = {(O1, head1, O2)} 
                
        // Var Set: {list}; Ref Set: {O1, O2, O2_data}
        
        // Call 1:
        PrintList1(list);                       // Stack = {(list, O1)}; Heap = {(O1, head1, O2)}                
        
        // Var Set: {list}; Ref Set: {O1, O2, O2_data}
        
        // Call 2:
        AddList3(list);                         // Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3)}                                      
        
        // Var Set: {list}; Ref Set: {O1, O3, O3_data, O2, O2_data}
        
        // Call 3:
        PrintList1(list);                       // Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3)}         
        
        // Var Set: {list}; Ref Set: {O1, O3, O3_data}
        
        list.head2 = new Node(2);           // O4; Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}        
                
        // Var Set: {list}; Ref Set: {O1, O3, O3_data, O4, O4_data}
        
        // Call 4:
        PrintList2(list);                       // Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)} 
                
        // Var Set: {list}; Ref Set: {O1, O3, O3_data}
        
        Node currNode = list.head3;             // Stack = {(list, O1), (currNode, O3)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}  
        // ---------- O1 dies here !!!     
        
        // Var Set: {currNode}; Ref Set: {O3, O3_data}

        System.out.println(currNode.data);      // Stack = {(list, O1), (currNode, O3)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}
        // ---------- O3 dies here !!!
        
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

        // Var Set: {ll}; Ref Set: {O1, O2, O2_data}

        Node currNode = ll.head1;           // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}    

        // Var Set: {ll, currNode}; Ref Set: {O1, O2, O2_data}

        System.out.println(currNode.data);  // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}    
    
        // Var Set: {ll}; Ref Set: {O1, O2, O2_data}
    }

    Mapping : (list - ll)
*/

/* Call 2:
    public static void AddList3(DualList ll)
    {
        // Base Stack = {ll, O1}, Heap = {(O1, head1, O2)}

        // Var Set: {ll}; Ref Set: {O1, O2, O2_data}

        Node currNode = new Node(7);        // O3; Stack = {(ll, O1), (currNode, O3)}; Heap = {(O1, head1, O2)}

        // Var Set: {ll, currNode}; Ref Set: {O1, O3, O3_data, O2, O2_data}
        
        ll.head3 = currNode;                // Stack = {(ll, O1), (currNode, O3)}; Heap = {(O1, head1, O2), (O1, head3, O3)}

        // Var Set: {ll}; Ref Set: {O1, O3, O3_data, O2, O2_data}
    }

    Mapping : (list - ll)
*/

/* Call 3:
    public static void PrintList1(DualList ll)
    {   
        // Base Stack = {ll, O1}, Heap = {(O1, head1, O2), (O1, head3, O3)}

        // Var Set: {ll}; Ref Set: {O1, O3, O3_data, O2, O2_data}
        
        Node currNode = ll.head1;           // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2), (O1, head3, O3)}    

        // Var Set: {ll, currNode}; Ref Set: {O1, O3, O3_data, O2, O2_data}
        
        System.out.println(currNode.data);  // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2), (O1, head3, O3)}    
        // ---------- O2 dies here !!!

        // Var Set: {ll}; Ref Set: {O1, O3, O3_data}
    }

    Mapping : (list - ll)
*/

/* Call 4:
    public static void PrintList2(DualList ll)
    {
        // Base Stack = {ll, O1}, Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}

        // Var Set: {ll}; Ref Set: {O1, O3, O3_data, O4, O4_data}

        Node currNode = ll.head2;           // Stack = {(ll, O1), (currNode, O4)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}    

        // Var Set: {ll, currNode}; Ref Set: {O1, O3, O3_data, O4, O4_data}

        System.out.println(currNode.data);  // Stack = {(ll, O1), (currNode, O4)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}    
        // ---------- O4 dies here !!!
    
        Var Set: {ll}; Ref Set: {O1, O3, O3_data}
    }

    Mapping : (list - ll)
*/



