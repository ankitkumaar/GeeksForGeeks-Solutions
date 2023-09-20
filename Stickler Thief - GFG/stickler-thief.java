//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // If there are no house
        if (arr.length == 0)
            return 0;
            
        // If there is only one house
        if (arr.length == 1)
            return arr[0];
            
        // If there are only two houses
        if (arr.length == 2)
            return (Math.max(arr[0], arr[1]));
        
        // create an array dp 
        // to store the maximum stolen money 
        // from each house.
        int[] dp = new int[n];
        
        // Initialize the first two elements of the dp array.
        dp[0] = Math.max(0, arr[0]);
        dp[1] = Math.max(arr[0], arr[1]);
        
        // Loop through the remaining houses
        for(int i=2; i<n; i++)
        {
            // Calculate the maximum stolen money for the current house
            // either taking that house in consideration
            // or not taking
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
        }
        
        // The final element in the dp array contains the maximum stolen money
        // that the thief can get.
        return dp[n-1];
    }
}
