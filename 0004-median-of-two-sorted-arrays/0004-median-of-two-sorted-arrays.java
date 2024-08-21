class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n1=nums1.length;
        int n2=nums2.length;
        int N=n1+n2;
         int arr[]=new int[N];
         int t=0;
        double ans=0.0;
        int p=0;
        int q=0;
        while(p<n1 && q<n2)
        {
            if(nums1[p]<=nums2[q])
            {
                arr[t]=nums1[p];
                t++;
                p++;
            }
            else
            {
                arr[t]=nums2[q];
                t++;
                q++;
            }
        }
        while(p<n1)
        {
            arr[t]=nums1[p];
            t++;
            p++;
        }
        while(q<n2)
        {
            arr[t]=nums2[q];
            t++;
            q++;
        }
        for(int i=0;i<N;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        if((N)%2 != 0)
        {
            int q1=(N)/2;
            System.out.println(q1);
            ans= (double)arr[q1];
        }
        else{
            int q1=(N)/2;
            System.out.println(q1);
            ans= (double)(arr[q1-1]+arr[q1])/2;
        }
        
        return ans;
    }
}