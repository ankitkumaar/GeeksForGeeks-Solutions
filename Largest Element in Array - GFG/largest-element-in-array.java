//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.largest(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

public class Compute 
{
    public int largest(int arr[], int n)
    {
        /*
        * initilize max variable with arr[0]
        * traverse the given array
        * comapare each array elements with max & store in max
        * return max
        */
        
        int max = arr[0];
        for (int i=0; i<n-1; i++)
        {
            max = Math.max(max, arr[i+1]);
        }
        return max;
    }
}