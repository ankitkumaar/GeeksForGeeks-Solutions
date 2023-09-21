//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // First binary search to find the leftmost occurrence of x
        int low = 0, high = n-1, pos = -1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            
            if (arr[mid] > x)
                high = mid - 1;
                
            else if (arr[mid] < x)
                low = mid + 1;
                
            else
            {
                pos = mid;
                high = mid - 1;
            }
        }
        
        // Add the leftmost position of x to the list
        list.add(pos);
        
        // Second binary search to find the rightmost occurrence of x
        low = 0; high = n-1; pos = -1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            
            if (arr[mid] > x)
                high = mid - 1;
                
            else if (arr[mid] < x)
                low = mid + 1;
                
            else
            {
                pos = mid;
                low = mid + 1;
            }
        }
        
        // Add the rightmost position of x to the list
        list.add(pos);
        
        return list;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends