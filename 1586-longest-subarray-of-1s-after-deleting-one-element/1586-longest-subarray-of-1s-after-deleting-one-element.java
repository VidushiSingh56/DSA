// class Solution {
//     public int longestSubarray(int[] nums) 
//     {
//         int zeropos = 0, countzero = 0, i, j = 0, win_size = 0, max_win_size = 0;
//         while(i<=j)
//         {
//             if(nums[j] == 0)
//             {
//                 countzero++;
//                 i = countzero > 1 ? zerpos + 1 : i;
//                 zeropos = j;
                
//                 win_size = (j-i-1) > 0 ? (j-i-1) : 0;
//                 max_win_size = Math.max(win_size, max_win_size);

//                 countzero = countzero>1 ? countzero-1 : countzero;
//             }
//             j++;

//         }
//     }
// }

class Solution {
    public int longestSubarray(int[] nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;
        
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
                          
            // Shrink the window until the count of zero's
            // is less than or equal to 1.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
              
            longestWindow = Math.max(longestWindow, i - start);
            System.out.println(longestWindow + " " + i);
        }

        return longestWindow;
    }
}