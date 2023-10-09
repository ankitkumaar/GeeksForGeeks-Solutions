//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution
{
    static int minJumps(int[] arr)
    {
        int n = arr.length;
        if (n <= 1)
            return 0;

        int start = 0, end = 0, jump = 0, max = 0;
        
        // Iterate array till last index
        while (start < n - 1) 
        {
            // compute max jumps
            max = Math.max(max, start + arr[start]);
            
            // Check if start pointer ie equal to end pointer
            if (start == end) 
            {
                // Check if max is equal to end pointer
                // Assign jump = -1
                // Break out the loop
                if (max == end)
                {
                    jump = -1;
                    break;
                }
                // Increment jump by 1
                jump += 1;
                end = max;
            }
            // Increment start pointer
            start += 1;
        }
        return jump;
    }
}