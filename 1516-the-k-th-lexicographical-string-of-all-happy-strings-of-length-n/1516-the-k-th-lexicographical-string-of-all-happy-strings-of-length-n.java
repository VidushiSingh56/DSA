class Solution {
    public String getHappyString(int n, int k) {
        // Calculate total possible strings
        int total = 3 * (1 << (n-1));  // More efficient than Math.pow
        if (k > total) return "";
        
        StringBuilder sb = new StringBuilder();
        // First character
        if (k <= total/3) sb.append('a');
        else if (k <= 2*total/3) {
            sb.append('b');
            k -= total/3;
        } else {
            sb.append('c');
            k -= 2*total/3;
        }
        
        // Generate remaining characters
        total /= 3;
        for (int i = 1; i < n; i++) {
            total /= 2;
            char last = sb.charAt(sb.length()-1);
            if (last == 'a') {
                if (k <= total) sb.append('b');
                else {
                    sb.append('c');
                    k -= total;
                }
            } else if (last == 'b') {
                if (k <= total) sb.append('a');
                else {
                    sb.append('c');
                    k -= total;
                }
            } else {  // last == 'c'
                if (k <= total) sb.append('a');
                else {
                    sb.append('b');
                    k -= total;
                }
            }
        }
        
        return sb.toString();
    }
}

// class Solution {
//     public String getHappyString(int n, int k) 
//     {
//         List<String> happyString = new ArrayList<>();

//         String currentString = "";
//         getHappy(currentString, n, k, happyString);
//         String s = "";
//         if(happyString.size()<k)
//         return "";
//         // Collections.sort(happyString);
//         return happyString.get(k-1);
//     }
//     public void getHappy(String cur, int n, int k, List<String> happy)
//     {
//         if(cur.length() == n)
//         {
//             happy.add(cur);
//             return;
//         }


//         for(char i = 'a'; i<='c';i++)
//         {
//             if(cur.length()>0 && cur.charAt(cur.length()-1) == i)
//             {
//                 continue;
//             }

//             getHappy(cur+i, n, k, happy);
//         }
//     }
// }