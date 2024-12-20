//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int n, int k) {
        
        // Write your code here
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<k;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 1;i<dict.length;i++)
        {
            String s1 = dict[i-1];
            String s2 = dict[i];
            int len = s1.length()>s2.length() ? s2.length() : s1.length();
            for(int j = 0; j<len ;j++)
            {
                if(s1.charAt(j) != s2.charAt(j))
                {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }//completion of adjaceny list
        
        
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> st = new LinkedList<>();
        //indegree aPPOinting
        int indegree[] = new int[k];
        for(int i = 0;i<k;i++)
        {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        for(int i =0;i<k;i++)
        {
            if(indegree[i] == 0)
            st.add(i);
        }
        //putting indegree with 0 in queue
        while(!st.isEmpty())
        {
            int node = st.poll();
            topo.add(node);
            for(int it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                st.add(it);
            }
        }
    
       
        if (topo.size() != k) {
            return "";  
        }

        
        StringBuilder answer = new StringBuilder();
        for (int it : topo) {
            answer.append((char) (it + 'a'));  
        }

        return answer.toString();
    }
}