//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        long m = 1000000007;
        long a = 1, b = 2, c = 4, sum = 0;
        
        if (n == 0)
            return c;
            
        if (n == 1)
            return a;
            
        if (n == 2)
            return b;
            
        if (n == 3)
            return c;
        
        if (n > 3)
        {
            for(long i=4; i<=n; i++)
            {
                sum = (a%m) + (b%m) + (c%m);
                a = b;
                b = c;
                c = sum;
            }
        }
        return sum%m;
    }
    
}

