// class Solution 
// {
    
//     public int climbStairs(int n) 
//     {
//         List<Integer> dp = new ArrayList<Integer>();
//         for(int i=0;i<n+1;i++)
//         {
//             dp.add(i,-1);
//         }
//         return stairs(n, dp);
//     }
//     public int stairs(int n, List<Integer> dp)
//     {
//         if(n==0)
//         {
//             dp.add(0,1);
//             return dp.get(0);
//         }
        
//         if(n==1)
//         {
//             dp.add(1,1);
//             return dp.get(1);
//         }
//         if(dp.get(n) != -1) return dp.get(n);
//         int left = stairs(n-1, dp);
//         int right = stairs(n-2, dp);
//         return left+right;
//     }
// }
import java.util.ArrayList;
import java.util.List;

class Solution 
{
    public int climbStairs(int n) 
    {
        List<Integer> dp = new ArrayList<>();
        
        // Initialize dp with -1 for all values
        for (int i = 0; i < n + 1; i++) 
        {
            dp.add(-1);
        }

        return stairs(n, dp);
    }

    public int stairs(int n, List<Integer> dp)
    {
        if (n == 0)
        {
            dp.set(0, 1);
            return 1;
        }
        
        if (n == 1)
        {
            dp.set(1, 1);
            return 1;
        }

        // If already calculated, return the stored value
        if (dp.get(n) != -1) return dp.get(n);

        // Recursively calculate the value
        int left = stairs(n - 1, dp);
        int right = stairs(n - 2, dp);
        
        dp.set(n, left + right);
        return dp.get(n);
    }
}
