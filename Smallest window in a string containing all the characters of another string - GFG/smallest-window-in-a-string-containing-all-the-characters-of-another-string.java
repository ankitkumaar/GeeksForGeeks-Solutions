//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String str, String word)
    {
        // Lengths of the input string and word
        int len1 = str.length();
        int len2 = word.length();
        
        // If the input string is shorter than the word
        if (len1 < len2)
            return "-1";
        
        // Initialize arrays to store character frequencies 
        // For both the input string and word.
        int[] str_freq = new int[256];
        int[] word_freq = new int[256];
        
        // Calculate the frequency of each character in the word
        for(int i=0; i<len2; i++)
            word_freq[word.charAt(i)]++;
        
        int count = 0;
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
        
        // Iterate through the input string
        for(int j=0; j<len1; j++)
        {
            // Update the character frequency in the input string
            str_freq[str.charAt(j)]++;
            
            // Check if the character is part of the word 
            // Increment the count
            if ((str_freq[str.charAt(j)]) <= (word_freq[str.charAt(j)]))
            count++;
            
            // If all characters of the word are present in the current window
            if (count == len2)
            {
                // Shrink the window from the beginning to remove unnecessary characters
                while((str_freq[str.charAt(start)]) > (word_freq[str.charAt(start)]) || (word_freq[str.charAt(start)]) == 0)
                {
                    if ((str_freq[str.charAt(start)]) > (word_freq[str.charAt(start)]))
                        str_freq[str.charAt(start)]--;
                            
                    start++;
                }
                
                // Calculate the length of the current window
                int win_len = j - start + 1;
                // Update the minimum length and 
                // Start index if a smaller window is found
                if (min_len > win_len) 
                {
                    min_len = win_len;
                    start_index = start;
                }
            }
        }
        // If no valid window is found, return "-1"
        if(start_index == -1)
            return "-1";
        return str.substring(start_index, start_index + min_len);
    }
}