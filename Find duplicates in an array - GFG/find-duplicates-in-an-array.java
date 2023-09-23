//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public static ArrayList<Integer> duplicates(int arr[], int n) 
    {
        // Create ArrayList to store repeating numbers
        // In ascending order
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int index = 0, sum = 0;
        // Iterate loop till n to compute sum and index
        for(int i=0; i<n; i++)
        {
            // Store each element of an array 
            // To its index with adding element already present in that index
            index = arr[i] % n;
            arr[index] += n;
        }
        
        // Iterate loop till n
        // To check number is repeated or not
        for(int i=0; i<n; i++)
        {
            if ((arr[i] / n) >= 2)
                list.add(i);
        }
        
        // Return list of numbers repeated
        if (list.isEmpty())
            list.add(-1);
        return list;
    }
}
