
class PairList
{
    Pair pair1;
    Pair pair2;
}

class Pair
{
    Node left;
    Node right;
}

class Node
{
    int data;
    Node(int item)
    {
        data = item;
    }
}

public class If_Case_2 {
    public static void main(String args[])
    {   
        // Base Stack = {}, Heap = {}

        PairList mainlist = new PairList();             // O1; Stack = {(mainlist, O1)}, Heap = {}

        int n = 0;

        // Call 1: 
        AllocPair1(mainlist, n);    // Stack = {mainlist, O1)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4)}

        // Call 2:
        PrintPair1(mainlist);       // Stack = {mainlist, O1)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4)}

        // Call 3:
        PrintPair2(mainlist);       // Stack = {mainlist, O1)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4)}

        // Call 4:
        PrintPair1(mainlist);       // Stack = {mainlist, O1)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4)}

        // Call 5:
        Modify(mainlist);           // Stack = {mainlist, O1)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4)}

        // Call 6:
        PrintPair1(mainlist);       // Stack = {mainlist, O1)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4)}

        // Var Set: {}; Ref Set: {}
    }

    public static void AllocPair1(PairList ml, int n)
    {
        Node node1 = new Node(1);
        
        Node node2 = new Node(2);
        
        Node node3 = new Node(3);

        Pair p1 = new Pair();
        
        p1.left = node1;
        
        p1.right = node2;

        Pair p2 = new Pair();
        
        p2.left = node2;
        
        p2.right = node3;

        if (n == 0)
        {
            ml.pair1 = p1;
        }
        else
        {
            ml.pair1 = p2;
        }

        ml.pair2 = p1;
    }
    
    public static void Modify(PairList ml)
    {
        Pair p = ml.pair1;

        Node temp = new Node(5);

        p.left = temp;
    }

    public static void PrintPair1(PairList ml)
    {
        Pair p = ml.pair1;
        Node l = p.left;
        Node r = p.right;
        System.out.println(l.data);
        System.out.println(r.data);
    }

    public static void PrintPair2(PairList ml)
    {
        Pair p = ml.pair2;
        Node l = p.left;
        Node r = p.right;
        System.out.println(l.data);
        System.out.println(r.data);
    }
}

/*
Call 1:

    public static void AllocPair1(PairList ml, int n)
    {
        // Base Stack = {(ml, O1)}, Heap = {}

        Node node1 = new Node(1);           // O2; Stack = {(ml, O1), (node1, O2)}, Heap = {}
        
        Node node2 = new Node(2);           // O3; Stack = {(ml, O1), (node1, O2), (node2, O3)}, Heap = {}
        
        Node node3 = new Node(3);           // O4; Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4)}, Heap = {}

        Pair p1 = new Pair();               // O5; Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5)}, Heap = {}
        
        p1.left = node1;                    // Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5)}, Heap = {(O5, left, O2)}
        
        p1.right = node2;                   // Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5)}, Heap = {(O5, left, O2), (O5, right, O3)}

        Pair p2 = new Pair();               // O6; Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5), (p2, O6)}, Heap = {(O5, left, O2), (O5, right, O3)}
        
        p2.left = node2;                    // Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5), (p2, O6)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3)}
        
        p2.right = node3;                   // Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5), (p2, O6)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4)}

        if (n == 0)
        {
            ml.pair1 = p1;                  // Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5), (p2, O6)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5)}
        }
        else
        {
            ml.pair1 = p2;                  // Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5), (p2, O6)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O6)}
        }

        ml.pair2 = p1;                      // Stack = {(ml, O1), (node1, O2), (node2, O3), (node3, O4), (p1, O5), (p2, O6)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
    }   
 
 */

/*
Call 2: 

    public static void PrintPair1(PairList ml)
    {
        // Base Stack = {(ml, O1)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}

        Pair p = ml.pair1;  // Stack = {(ml, O1), (p, O5,O6)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        Node l = p.left;    // Stack = {(ml, O1), (p, O5,O6), (l, O2,O3)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        Node r = p.right;   // Stack = {(ml, O1), (p, O5,O6), (l, O2,O3), (r, O3,O4)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        System.out.println(l.data); // Stack = {(ml, O1), (p, O5,O6), (l, O2,O3), (r, O3,O4)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        System.out.println(r.data); // Stack = {(ml, O1), (p, O5,O6), (l, O2,O3), (r, O3,O4)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
    }
 */

/*
Call 3:

    public static void PrintPair2(PairList ml)
    {
        // Base Stack = {(ml, O1)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        Pair p = ml.pair2;  // Stack = {(ml, O1), (p, O5)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        Node l = p.left;    // Stack = {(ml, O1), (p, O5), (l, O2)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        Node r = p.right;   // Stack = {(ml, O1), (p, O5), (l, O2), (r, O3)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        System.out.println(l.data);     // Stack = {(ml, O1), (p, O5), (l, O2), (r, O3)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        System.out.println(r.data);     // Stack = {(ml, O1), (p, O5), (l, O2), (r, O3)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
    
    }
 */

/*
Call 4:

    public static void PrintPair1(PairList ml)
    {
        // Base Stack = {(ml, O1)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}

        Pair p = ml.pair1;  // Stack = {(ml, O1), (p, O5,O6)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        Node l = p.left;    // Stack = {(ml, O1), (p, O5,O6), (l, O2,O3)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        Node r = p.right;   // Stack = {(ml, O1), (p, O5,O6), (l, O2,O3), (r, O3,O4)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        System.out.println(l.data); // Stack = {(ml, O1), (p, O5,O6), (l, O2,O3), (r, O3,O4)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
        
        System.out.println(r.data); // Stack = {(ml, O1), (p, O5,O6), (l, O2,O3), (r, O3,O4)}, Heap = {(O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4), (O1, pair1, O5,O6), (O1, pair2, O5)}
    }
 */

 /*
Call 5:

    public static void Modify(PairList ml)
    {
        / Stack = {ml, O1)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4)}
        
        Pair p = ml.pair1;  // Stack = {(ml, O1), (p, O5,O6)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4)}

        Node temp = new Node(5);    // O7; // Stack = {(ml, O1), (p, O5,O6), (t, O7)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2), (O5, right, O3), (O6, left, O3), (O6, right, O4)}

        p.left = temp;  // Stack = {(ml, O1), (p, O5,O6), (temp, O7)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5)(O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4), (O7, data, 5)}
    }
*/

/*
Call 6:

    public static void PrintPair1(PairList ml)
    {
        // Base Stack = {(ml, O1)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4)}
        
        Pair p = ml.pair1;  // Stack = {(ml, O1), (p, O5,O6)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4)}
        
        Node l = p.left;    // Stack = {(ml, O1), (p, O5,O6), (l, O2,O7)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4)}
        
        Node r = p.right;   // Stack = {(ml, O1), (p, O5,O6), (l, O2,O7), (r, O3,O4)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4)}
        
        System.out.println(l.data); // Stack = {(ml, O1), (p, O5,O6), (l, O2,O7), (r, O3,O4)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4)}
        
        // Var Set: {r}; Ref Set: {}
        
        System.out.println(r.data); // Stack = {(ml, O1), (p, O5,O6), (l, O2,O7), (r, O3,O4)}, Heap = {(O1, pair1, O5,O6), (O1, pair2, O5), (O5, left, O2,O7), (O5, right, O3), (O6, left, O3,O7), (O6, right, O4)}
    
        // Var Set: {}; Ref Set: {}
    }
*/

