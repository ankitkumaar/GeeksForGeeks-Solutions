//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    int numberOfEnclaves(int[][] grid) 
    {
        // Store length of row and column of grid
        int n = grid.length;
        int m = grid[0].length;
        
        // Visited array to keep track of visited land cells
        int[][] visited = new int[n][m];
        
        // Created 2 queues for breadth-first search 
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        // Loop through the grid to find land cells on the boundaries
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                // Check if the current cell is on the boundary 
                // And contains land
                if ((i == 0 || i == n-1 || j == 0 || j == m-1) && (grid[i][j] == 1))
                {
                    // Add coordinates to the queues
                    q1.add(i);
                    q2.add(j);
                    
                    // Mark cell as visited
                    visited[i][j] = 1;
                }
            }
        }
        
        // Define directions for exploring neighboring cells
        int[] dir_row = new int[]{-1, 0, +1, 0};
        int[] dir_col = new int[]{0, +1, 0, -1};
        
        // Perform breadth-first search
        // Starting from boundary land cells
        while(q1.isEmpty() != true && q2.isEmpty() !=true)
        {
            int row = q1.poll();
            int col = q2.poll();
            
            // Explore the four neighboring cells
            for(int k=0; k<4; k++)
            {
                int new_row = row + dir_row[k];
                int new_col = col + dir_col[k];
                
                // Check if the neighbors are within the grid boundaries and is land,
                // and has not been visited yet
                if (new_row >=0 && new_row <= n-1 && new_col >= 0 && new_col <= m-1 && grid[new_row][new_col] == 1 && visited[new_row][new_col] == 0)
                {
                    // Add the neighbor to the queues
                    q1.add(new_row);
                    q2.add(new_col);
                    
                    // Mark the neighbor as visited
                    visited[new_row][new_col] = 1;
                }
            }
        }
        
        int count = 0;
        // Count the number of unvisited land cells (enclaves)
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                // Check if the cell is land cell and is not visited
                if (grid[i][j] == 1 && visited[i][j] == 0)
                    count++;
            }
        }
        // Return count of unvisited cell
        // and is a land cell
        return count;
    }
}