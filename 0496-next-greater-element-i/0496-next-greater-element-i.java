class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        // int ar[]=new int[nums2.length];
       HashMap<Integer, Integer> ar = new HashMap<>();
        int ans[]=new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =nums2.length-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                stack.push(nums2[i]);
                ar.put(nums2[i], -1);
            }
            else if(!stack.isEmpty() && stack.peek()>nums2[i])
            {
                ar.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
            else 
            {
                while(!stack.isEmpty() && stack.peek()<=nums2[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    stack.push(nums2[i]);
                    ar.put(nums2[i], -1); continue;
                }
                ar.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
            
        }

        for(int i =0;i<nums1.length;i++)
        {
            ans[i] = ar.get(nums1[i]);
        }
        return ans;    
    }
}