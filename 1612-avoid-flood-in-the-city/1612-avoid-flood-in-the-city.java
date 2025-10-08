class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        List<Integer> st = new ArrayList<>(); // stores indices of dry days
        Map<Integer, Integer> mp = new HashMap<>(); // last filled day of each lake

        for (int i = 0; i < n; ++i) {
            if (rains[i] == 0) {
                st.add(i); // store dry day
            } else {
                ans[i] = -1;

                if (mp.containsKey(rains[i])) {
                    int lastRainDay = mp.get(rains[i]);
                    Integer chosen = null;

                    // simulate TreeSet.ceiling(lastRainDay)
                    for (int dryDay : st) {
                        if (dryDay > lastRainDay) {
                            chosen = dryDay;
                            break; // first dry day after lastRainDay
                        }
                    }

                    if (chosen == null) {
                        return new int[0]; // flood, no dry day available
                    }

                    ans[chosen] = rains[i]; // dry that lake
                    st.remove(chosen); // remove dry day
                }

                mp.put(rains[i], i); // mark this lake filled today
            }
        }
        return ans;
    }
}
