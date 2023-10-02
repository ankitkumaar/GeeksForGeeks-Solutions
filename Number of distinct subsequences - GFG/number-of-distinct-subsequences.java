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
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int distinctSubsequences(String S) 
    {
        int mod = 1000000007;
        int n = S.length();
        
        // Create a HashMap to store last index 
        // of each character of string
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        // Itterate through each character of string
        for(int i=1; i<=n; i++)
        {
            char ch = S.charAt(i-1);
            dp[i] = (2 * dp[i-1]) % mod;
            
            // Check if the character is already present in HashMap or not
            if (map.containsKey(ch))
            {
                // Store index of that character
                int index = map.get(ch);
                // Modify dp[i] according to the occurence of that character
                dp[i] = (dp[i] - dp[index - 1] + mod) % mod;
            }
            // Update last index of current character
            map.put(ch, i);
        }
        // Return last element of dp
        // Represents total number of distinct subsequence
        return dp[n];
    }
}