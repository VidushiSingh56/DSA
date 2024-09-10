class Solution {
    public int trap(int[] height) 
    {
        int n = height.length;
        int total = 0;
        int leftMax = height[0];
        int right[] = new int[n];
        right[n-1]=height[n-1];
        int rightMax;
        for(int i=n-2;i>=0;i--)
        {
            right[i]= Math.max(right[i+1], height[i]);
        }
        for(int i =0;i<n;i++)
        {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = right[i];
            if(height[i]<leftMax && height[i]<rightMax)
            total += Math.min(leftMax, rightMax) - height[i];
        }   
        return total; 
    }
}