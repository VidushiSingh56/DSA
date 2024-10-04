class Solution {
    public long dividePlayers(int[] skill) 
    {
        Arrays.sort(skill);
        int i = 0, j=skill.length-1;
        int sum = skill[i]+skill[j];
        long ans=0;
        while(i<j)
        {
            int s=skill[i]+skill[j];
            if(s!=sum)
            {
                return -1;
            }
            ans = ans + skill[i]*skill[j];
            i++;j--;
        }
        return ans;
    }
}