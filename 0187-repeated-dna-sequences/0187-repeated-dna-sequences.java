class Solution {
    public List<String> findRepeatedDnaSequences(String st) 
    {
        //i'm going with the bit manipulation

        Set<Integer> seenOnce = new HashSet<>();
        Set<Integer> repeated = new HashSet<>();
        List<String> answer = new ArrayList<>();
        int i =0, j = 0, hash = 0;

        while(j < st.length() && i<=j)
        {
           hash <<= 2;
            hash |= encode(st.charAt(j));
            hash &= ((1<<20)-1);

            if(j>=9)
            {
                if(!seenOnce.contains(hash))
                {
                    seenOnce.add(hash);
                }
                else if(!repeated.contains(hash))
                {
                    repeated.add(hash);
                    answer.add(st.substring(i,j+1));
                }
            }

            j++;
            if(j>=10)i++;
            
        }

        return answer;
    }


    public int encode(char a)
    {
        switch(a)
        {
            case 'A' : return 0;
            case 'C' : return 1;
            case 'G' : return 2;
            case 'T' : return 3;
        }
        return -1; 
    }
}