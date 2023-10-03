//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName(long n)
    {
        // Initialize string
         String str = "";
        
        // Iterate loop
        while(n > 0)
        {
            // Compute remainder of N
            long rem = (n % 26);
            
            // If remainder is equal to 0
            if (rem == 0)
            {
                // Append 'Z'
                str = 'Z' + str;
                n = (n / 26) - 1;
            }
            // Else if remainder is not equal to 0
            else
            {
                // Add characters left in front of string
                str = (char)((rem - 1) + 'A') + str;
                n = (n / 26);
            }
        }
        // Return string
        return str;
    }
}