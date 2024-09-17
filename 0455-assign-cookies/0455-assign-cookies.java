class Solution {
    public int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(s);
        Arrays.sort(g);
        int ss = s.length;
        int gg = g.length;
        int i=0, j=0;
        while(i<ss && j<gg)
        {
            if(s[i] >= g[j])
            {
                j++;
            }
            i++;
        }
        return j;
    }
}