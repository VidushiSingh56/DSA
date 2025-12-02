class Solution {
public:
    bool canJump(vector<int>& jumps) {
        int max_reach = 0;

    for (int i = 0; i < jumps.size(); ++i) {
        if (i > max_reach) return false;
        max_reach = max(max_reach, i + jumps[i]);
    }

    return true;
    }
};