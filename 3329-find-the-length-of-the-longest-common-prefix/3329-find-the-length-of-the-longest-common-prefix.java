// class Solution {
//     public int longestCommonPrefix(int[] arr1, int[] arr2) 
//     {
        
//         int len=0, max =0;
//         for(int i=0;i<arr1.length;i++)
//         {
//             for(int j = 0;j<arr2.length;j++)
//             {
//                 len = canMatch(Integer.toString(arr1[i]), Integer.toString(arr2[j]));
//                 max = max<len ? len : max;
//             }
//         }
//         return max;
//     }
//     public int canMatch(String a, String b)
//     {
//         int n1 = a.length();
//         int n2 = b.length();
//         if(n1>n2)
//         return canMatch(b,a);

//         int count =0;
//         int i =0,j=0;
//         while(i<n1 && j<n2)
//         {
//             if(a.charAt(i) != b.charAt(j))
//             break;

//             count++;
//             i++;
//             j++;
//         }
//         return count;
//     }
// }

import java.util.HashMap;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String, Integer> prefixMap = new HashMap<>();
        
        // Step 1: Build the prefix map for arr1
        for (int num : arr1) {
            String strNum = Integer.toString(num);
            String prefix = "";
            for (char ch : strNum.toCharArray()) {
                prefix += ch;
                prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check for common prefixes in arr2
        for (int num : arr2) {
            String strNum = Integer.toString(num);
            String prefix = "";
            for (char ch : strNum.toCharArray()) {
                prefix += ch;
                if (prefixMap.containsKey(prefix)) {
                    maxLength = Math.max(maxLength, prefix.length());
                }
            }
        }
        
        return maxLength;
    }
}