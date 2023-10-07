//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution 
{
    Node sortedInsert(Node head, int key) 
    {
        // Check if linkedlist is empty
        if (head == null)
        {
            // Create a new node with the given key
            // Return it the new head
            Node newdata = new Node(key);
            return newdata;
        }
        
        // Initialize a current Node
        Node curr = head;
        // Traverse linked list
        while(curr != null)
        {
            Node next = curr.next;
            // Create new node with the given key
            Node newdata = new Node(key);
            
            // Check if the curr node's data is greater than the key
            if (curr.data >= key)
            {
                // Insert the new node before the current node
                // Return it as the new head
                newdata.next = curr;
                return newdata;
            }
            
            // Check if the current node's data is less than the key
            // The next node is null
            if (curr.data <= key && next == null)
            {
                // Insert the new node after the current node
                // Break from the loop
                curr.next = newdata;
                newdata.next = next;
                break;
            }
            
            // Check if the current node's data is less than the key
            // The next node's data is greater than the key
            if (curr.data < key && next.data >= key)
            {
                // Insert the new node between the current node and the next node,
                // Break from the loop
                curr.next = newdata;
                newdata.next = next;
                break;
            }
            // Move to the next node in linkedlist
            curr = curr.next;
        }
        // Return the head of sorted linkedlist
        return head;
    }
}