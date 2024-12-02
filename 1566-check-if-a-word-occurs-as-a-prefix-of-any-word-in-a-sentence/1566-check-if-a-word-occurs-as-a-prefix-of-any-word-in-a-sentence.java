// class Solution 
// {
//     public int isPrefixOfWord(String sentence, String searchWord) 
//     {
//         int n = sentence.length();
//         int start = 0,word = 0;
//         for(int i = 0;i<n;i++)
//         {
//             char ch = sentence.charAt(i);
//             if(ch == " ")
//             {
//                 if(check(start, searchWord, sentence))
//                 return word+1;

//                 word++;
//                 start=i+1;
//             }
//         }
//         return -1;
//     }
//     public boolean check(int start, String search, String sen)
//     {
//         if(search.length() > sen.length())
//         return false;

//         int i=0;
//         while(i<search.length())
//         {
//             char s = search.charAt(i);
//             char h = sen.charAt(start);

//             if(s==h)
//             {
//                 i++;start++;
//                 continue;
//             }
//             else
//             {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");               
        int n=arr.length;
        
        for(int i=0; i<n; i++){
            if(arr[i].startsWith(searchWord)){                
                return i+1;
            }
        }

        return -1;
    }
}