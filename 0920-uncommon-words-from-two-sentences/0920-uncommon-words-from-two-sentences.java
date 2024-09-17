class Solution {
    public String[] uncommonFromSentences(String s1, String s2) 
    {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        HashMap<String, Integer> hash = new HashMap<>();
        for (String word : words1) 
        {
            hash.put(word, hash.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) 
        {
            hash.put(word, hash.getOrDefault(word, 0) + 1);
        }
        ArrayList<String> result = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : hash.entrySet()) 
        {
            if (entry.getValue() == 1) 
            {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }
}
