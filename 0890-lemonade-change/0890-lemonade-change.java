class Solution 
{
    public boolean lemonadeChange(int[] bills) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        // int change=0;
            map.put(5,0);
            map.put(10,0);
            // map.put(20,0);
        for(int i = 0;i<bills.length;i++)
        {
            int j = bills[i];
            map.put(j, map.getOrDefault(j, 0) + 1);
            int change = bills[i] - 5;
            if(change == 5)
            {
                if(map.get(5) <= 0)
                {   
                    return false;
                }
                else
                map.put(5, map.get(5)-1);
            }
            else if(change == 15)
            {
                if(map.get(5) >= 1 && map.get(10) >= 1)
                {
                    map.put(5,map.get(5)-1);
                    map.put(10,map.get(10)-1);
                }
                else if(map.get(5) >= 3)
                map.put(5, map.get(5)-3);
                
                else
                {System.out.println("I");
                    return false;}
            }
        }
        return true;
    }
}