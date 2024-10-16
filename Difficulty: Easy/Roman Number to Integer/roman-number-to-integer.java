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

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        
        // code here
        //I = 1
        //1 to 3 = I
        //5 = V
        // 4-8 = both V and I
        //10
        //9-49 = X V I
        //50 = L
        //51 - 99 = L X V I
        //100
        //101-499 = 
        //500
        //501 - 999
        //1000 = M
        
        //create an arraylist
        // if its equal to any of this then directly tell
        
        //create an array with all of these values I, V, X, L, C, D, M
        //arr[] = { I, V, X, L, C, D, M }   ;
        // some rules : V L D are never repeated, you cannot repeat anything more than 3
        //if smaller comes before the larger one, then subtract 
        //if smaller comes after, add
        // example 65 = LXV
        //III = 3
        //MMM = 1000 + 1000 + 1000 = 3000
        //VV =  
        //IV = 4
        //VI = 6
        
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ans = map.get(str.charAt(0));
        char prev = str.charAt(0);
        for(int i = 1;i < str.length();i++)
        {
            char ch = str.charAt(i);
            if(map.get(ch) <= map.get(prev))
            ans = ans + map.get(ch);
            
            // else if(map.get(ch) < map.get(prev))
            // ans = ans + map.get(ch);
            
            else
            ans = ans + map.get(ch) - 2*map.get(prev);
            
            prev = ch;
        }
        return ans;
    }
}