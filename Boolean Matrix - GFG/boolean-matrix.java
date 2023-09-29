//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        // Initialize length of row and column of matrix
        int r = matrix.length;
        int c = matrix[0].length;
        
        // Create row and col arrays
        // To keep track of index of row and column
        int[] row = new int[r];
        int[] col = new int[c];
        
        // Iterate row of matrix
        for(int i=0; i<r; i++)
        {
            // Iterate column of matrix
            for(int j=0; j<c; j++)
            {
                // Check if matrix[i][j] contains 1
                if (matrix[i][j] == 1)
                {
                    // Store matrix row and col index to
                    // row array and col array
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        // Iterate row of matrix
        for(int i=0; i<r; i++)
        {
            // Iterate column of matrix
            for(int j=0; j<c; j++)
            {
                // Check if row array or col array contains 1
                if (row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 1;
            }
        }
    }
}