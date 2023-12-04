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

public class Nodes {
    public static void main(String args[])
    {
        // Base Stack = {}, Heap = {}
        
        DualList list = new DualList();             // O1; Stack = {(list, O1)}

        // Var Set: {list}; Ref Set: {O1}
        
        list.head1 = new Node(5);               // O2; Stack = {(list, O1)}; Heap = {(O1, head1, O2)}

        // Var Set: {list}; Ref Set: {O1, O2, O2_data}
        
        PrintList1(list);                           // Call 1, Stack = {(list, O1)}; Heap = {(O1, head1, O2)}

        // Var Set: {list}; Ref Set: {O1, O2, O2_data}
        
        list.head3 = new Node(3);               // O3; Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3)}

        // Var Set: {list}; Ref Set: {O1, O3, O3_data, O2, O2_data}
        
        PrintList1(list);                           // Call 2, Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3)}
        
        // Var Set: {list}; Ref Set: {O1, O3, O3_data}

        list.head2 = new Node(2);               // O4; Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}

        // Var Set: {list}; Ref Set: {O1, O3, O3_data, O4, O4_data}
        
        PrintList2(list);                           // Call 3, Stack = {(list, O1)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}

        // Var Set: {list}; Ref Set: {03, O1, O3_data}
        
        Node currNode = list.head3;                 // Stack = {(list, O1), (currNode, O3)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}
        // list = null; Death of O1 here !!! 

        // Var Set: {curNode}; Ref Set: {O3_data, O3} 

        System.out.println(currNode.data);          // Stack = {(list, O1), (currNode, O3)}; Heap = {(O1, head1, O2), (O1, head3, O3), (O1, head2, O4)}

        //Var Set: {}; Ref Set: {}
    }

    public static void PrintList1(DualList ll)
    {
        // Base Stack = {(ll, O1)}
        
        Node currNode = ll.head1;                 // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}
        
        System.out.println(currNode.data); 
    }

    public static void PrintList2(DualList ll)
    {
        // Base Stack = {(ll, O1)}

        Node currNode = ll.head2;                 // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head2, O2)}
        // ll.head2 = null;
        
        System.out.println(currNode.data);  // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head2, O2)}
    }
}

/*

Call Site 3:
    Mapping = {(list -> ll), (O1 -> O1), (O4 -> O2)}

    public static void PrintList2(DualList ll)
    {
        // Base Stack = {(ll, O1)}

        // Var Set: (ll);, Ref Set: (O1, map(O3, O3_data), O2, O2_data)

        Node currNode = ll.head2;                 // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head2, O2)}
        
        // Var Set: {ll, currNode}; Ref Set: {O1, map(O3, O3_data), O2, O2_data}

        System.out.println(currNode.data);  // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head2, O2), (O2, data, O2_data)}
        // Death of O2 or map(O4) here !!!

        // Var Set: {map(list)}; Ref Set: {map(O1), map(O3, O3_data)} 
    }


Call Site 2:
    Mapping = {(list -> ll), (O1 -> O1), (O2 -> O2)}

    public static void PrintList1(DualList ll)
    {
        // Base Stack = {(ll, O1)}

        // Var Set: (ll);, Ref Set: (O1, map(O3, O3_data), O2, O2_data)
        
        Node currNode = ll.head1;                 // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}

        // Var Set: {ll, currNode}; Ref Set: {O1, map(O3, O3_data), O2, O2_data}
        
        System.out.println(currNode.data); 
        // Death of O2 or map(O2) here !!!

        // Var Set: {ll}; Ref Set: {O1, map(O3, O3_data)}
    }

Call Site 1:
    Mapping = {(list -> ll), (O1 -> O1), (O2 -> O2)}

    public static void PrintList1(DualList ll)
    {
        // Base Stack = {(ll, O1)}

        // Var Set: (ll);, Ref Set: (O1, map(O3, O3_data), O2, O2_data)
        
        Node currNode = ll.head1;                 // Stack = {(ll, O1), (currNode, O2)}; Heap = {(O1, head1, O2)}

        // Var Set: {ll, currNode}; Ref Set: {O1, map(O3, O3_data), O2, O2_data}
        
        System.out.println(currNode.data); 

        // Var Set: {ll}; Ref Set: {O1, map(O3, O3_data), map(O2), map(O2_data)}
    }
 */