//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) 
    {
        // Create HashMap to store integer equivalent of roman
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // If length of string is equal to 1
        if(str.length() == 1)
            return map.get(str.charAt(0));
        
        int sum = 0;
        char ch1 = 0, ch2 = 0;
        // Iterate loop till second last element of array
        for(int i=0; i<str.length()-1; i++)
        {
            // Extract character at index i and i+1
            ch1 = str.charAt(i);
            ch2 = str.charAt(i+1);
            
            // If character at index i is greater than character at index i+1
            // Add its value to sum
            if (map.get(ch1) >= map.get(ch2))
            {
                sum += map.get(ch1);
            }
            // Else if character at index i is smaller than character at index i+1
            // Substract its value form sum
            else
            {
                sum -= map.get(ch1);
            }
        }
        // Handle sum for last element of array
        sum = sum + map.get(ch2);
        // Return desired sum
        return sum;
    }
}