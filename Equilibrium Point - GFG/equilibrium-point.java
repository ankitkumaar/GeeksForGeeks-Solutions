//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution 
{
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) 
    {
        // If array is of length 1
        if (arr.length == 1)
            return 1;
        
        // If array is of length 2
        if (arr.length == 2)
            return -1;
            
        int index = 0; long sum = 0;
        // Calculating the sum of all elements in the array
        for(long ele : arr)
            sum += ele;
        
        long left_sum = 0, right_sum = 0;
        // Calculating the left sum & right sum of array
        for(int i=1; i<n-1; i++)
        {
            left_sum += arr[i-1];
            right_sum = sum - (arr[i] + left_sum);
            
            // Checking if the left sum is equal to the right sum
            if (left_sum == right_sum)
            {
                index = i;
                break;
            }
        }
        
        // If Equilibrium point does not exists in an array
        // If point exists : Return index+1
        if (index == 0)
            return -1;
        return index+1;
    }
}
