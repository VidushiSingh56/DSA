class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {

        if(m==0 && n!=0)
        {
           for(int i=0;i<nums1.length;i++)
           {
                nums1[i]=nums2[i];
           }
        }
        else if(n==0)
        {
            return;
        }
        else
        {
        int left= m-1;
        int right= 0;
        while(left>=0 && right<n)
        {
            if(nums2[right]<nums1[left])
            {
                int temp= nums2[right];
                nums2[right]=nums1[left];
                nums1[left]=temp;
                left--;right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(nums1,0,m);
        Arrays.sort(nums2);
        int j=0;
        for(int i=m;i<nums1.length;i++)
        {
            nums1[i]=nums2[j];
            j++;
        }
        }
        
    }
}