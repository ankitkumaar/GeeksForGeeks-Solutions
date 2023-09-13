//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static String findLargest(int Num, int Sum)
    {
        if (Sum == 0)
            return (Num == 1) ? "0" : "-1";
        
        if (Sum > (9*Num))
            return "-1";
        
        String result = "";
        for (int i=0; i<Num; i++)
        {
            if (Sum > 9)
            {
                result += '9';
                Sum -= 9;
            }
            else
            {
                result += Integer.toString(Sum);
                Sum -= Sum;
            }
        }
        return result;
    }
}