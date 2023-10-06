//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/

class Solution
{
    // Helper method to reverse a linked list
    public static Node reverse(Node head)
    {
        // Initialize Prev and curr Nodes
        Node prev = null;
        Node curr = head;
        
        // Iterate curr
        while(curr != null)
        {
            Node next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    // Method to rearrange the linked list as per the problem statement
    public static void rearrange(Node head)
    {
        Node odd = head;
        // Initialize odd and even Nodes
        // Initialize first_even to keep track of even Node
        Node even = head.next;
        Node first_even = head.next;
        
        // Iterate even and odd
        while(even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
        }
        // Reverse the second part and link it to the first part
        odd.next = reverse(first_even);
    }
}
