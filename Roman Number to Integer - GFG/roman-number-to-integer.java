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
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        if(str.length() == 1)
            return map.get(str.charAt(0));
            
        int sum = 0;
        char ch1 = 0, ch2 = 0;
        for(int i=0; i<str.length()-1; i++)
        {
            ch1 = str.charAt(i);
            ch2 = str.charAt(i+1);
            
            if (map.get(ch1) >= map.get(ch2))
            {
                sum += map.get(ch1);
            }
            else
            {
                sum -= map.get(ch1);
            }
        }
        sum = sum + map.get(ch2);
        return sum;
    }
}