class Solution {
    public boolean uniformArray(int[] nums) {
        Arrays.sort(nums);

        int min = nums[0];
        int oddBefore = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 != 0) {
                // Odd element needs a smaller odd element
                if (min % 2 == 0 && oddBefore == 0 && nums[i] != min)
                    return false;

                oddBefore++;
            }
        }

        return true;
    }
}