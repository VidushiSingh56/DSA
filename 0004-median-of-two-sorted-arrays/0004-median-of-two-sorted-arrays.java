class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n1=nums1.length;
        int n2=nums2.length;
        int N=n1+n2;
        int t=0;
        double ans=0.0;
        int p=0;
        int q=0;
        int flag=0;
        int index1=0,index2=0;
        if(N%2==0)
        {                           
            index1= N/2;
            index2=index1-1;
        }
        else{
            index1=N/2;
        }
        int x=0,y=0;
        while(p<n1 && q<n2 )
        {
            
            if(nums1[p]<=nums2[q])
            {

            if(t==index2)
            {
                x= nums1[p];
            }
            if(t==index1)
            {
                y=nums1[p];
                flag=1;
                break;
            }
                t++;
                p++;
                
            }
            else
            {
            if(t==index2)
            {
                x= nums2[q];
            }
            if(t==index1)
            {
                y=nums2[q];
                flag=1;
                break;
            }
                t++;
                q++;
                
            }
        }
        while(p<n1 && flag==0)
        {
            if(t==index2)
            {
                x= nums1[p];
            }
            if(t==index1)
            {
                y=nums1[p];break;
            }
            t++;
            p++;
        }
        while(q<n2 && flag==0)
        {
            if(t==index2)
            {
                x= nums2[q];
            }
            if(t==index1)
            {
                y=nums2[q];break;
            }
            t++;
            q++;
        }
        // for(int i=0;i<N;i++)
        // {
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();
        if((N)%2 != 0)
        {
           
            ans= (double)y;
        }
        else{
           
            ans= (double)((double )x + (double)y)/2;
        }
        
        return ans;
    }
}