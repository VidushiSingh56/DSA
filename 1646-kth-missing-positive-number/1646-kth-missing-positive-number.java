class Solution {
    public int findKthPositive(int[] arr, int k) 
    {
        int count=0;
        int x=1;
      while(count<k)
      {
        if(!search(arr, x))
        {
            count++;
        }
        x++;


      }
      return x-1;
      
    }
    public boolean search(int arr[], int x)
    {
        int min=0, max=arr.length-1;
        while(min<=max)
        {
            int mid=(min+max)/2;
            if(arr[mid]==x)
            return true;

            else if(arr[mid]>x)
            {
                max=mid-1;
            }
            else
            {
                min = mid+1;
            }
        }
        return false;
    }
}