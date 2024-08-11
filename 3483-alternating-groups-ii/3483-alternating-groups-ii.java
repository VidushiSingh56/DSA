class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) 
    {
        int i=0, ans=0;
        int n=colors.length;

        if(k > n) return 0;
        int d=0;
        while(i<n)    // 0  3
        {
            int count =1, flag=0;
            for(int j=i;j<2*n-1;j++)  //0 3
            {
                // if(j==n-1 && count==n && (colors[0] != colors[n-1]))
                // {
                //     System.out.println(j);
                //     flag++;
                //     d=j;
                //     break;
                // }
                
                if(colors[j%n] != colors[(j+1)%n])
                {
                    count++;   // 7
                }
                else{
                 flag++;     //  1
                 d=j;         // 9
                 break;
                }
            }
            System.out.println(count + "p"+d);
            if(d>n-1 && ans>0 && count>=k)
            {
                int co= d-n+1;
                ans = co>=k?(ans-(co-k+1)):ans;
                
            }
             System.out.println(ans+"k"+d);
            if(count >= k)     // 7>6   
            {   
                ans +=  1+(count-k);      //2
                
            }
            
            System.out.println(ans+"m"+d);
            
            if(flag==1)   i=d+1;  //  3 10
            else{
                return n;
            }
        }
        return ans;
    }
}