//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int isPerfectNumber(long N) 
    {
        if (N <= 1)
            return 0;
        
        long sum_of_factors = 0;
        
        // Iterate from 2 to sqrt(N)
        for (long i=2; i<= Math.sqrt(N); i++)
        {
            // Adds all factors of N
            if (N % i == 0)
            sum_of_factors += i + (N/i);
        }
        
        // Check if the sum of factors equals N
        // Returns 1 or 0
        if (sum_of_factors == N-1)
            return 1;
        else
            return 0;
    }
};