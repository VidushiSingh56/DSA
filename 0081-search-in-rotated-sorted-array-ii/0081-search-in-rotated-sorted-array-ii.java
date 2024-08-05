// class Solution {
//     public boolean search(int[] nums, int target) 
//     {
//         int min=0, max=nums.length-1;
//         int pivot= pivotfind(nums, min,max);
//         boolean search=true;
//         if(target<=nums[max] && target>=nums[pivot])
//         {
//             search= numbersearch(nums, pivot, max, target);
//             return search;
//         }
//         else{
//             search= numbersearch(nums, min, pivot-1, target);
//             return search;
//         }
        
//     }
//     public int pivotfind(int nums[], int min, int max)
//     {
//         while(min<=max)
//         {
//             int mid=(min+max)/2;
//             if(nums[mid]>=nums[0])
//             {
//                 min=mid+1;
//             }
//             else{
//                 max=mid;
//             }
//         }
//         System.out.println(min);
//         return min;
//     }
//     public boolean numbersearch(int nums[], int min, int max, int target)
//     {
//         while(min<max)
//         {
//             int mid=(min+max)/2;
//             if(target==nums[mid])
//             {
//             return true;
//             }
//             else if(target > nums[mid])
//             {
//                 min= mid+1;
//             }
//             else{
//                 max=mid-1;
//             }
//         }
//         return false;
//     }
// }


class Solution {
    public boolean search(int[] nums, int target) {
        int min = 0, max = nums.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;  // Avoid potential overflow

            if (nums[mid] == target) {
                return true;  // Target found
            }

            // Handle duplicates by adjusting the bounds
            if (nums[min] == nums[mid] && nums[mid] == nums[max]) {
                min++;
                max--;
            }
            // Check if left part is sorted
            else if (nums[min] <= nums[mid]) {
                if (target >= nums[min] && target < nums[mid]) {
                    max = mid - 1;  // Target is in the left part
                } else {
                    min = mid + 1;  // Target is in the right part
                }
            }
            // Right part must be sorted
            else {
                if (target > nums[mid] && target <= nums[max]) {
                    min = mid + 1;  // Target is in the right part
                } else {
                    max = mid - 1;  // Target is in the left part
                }
            }
        }

        return false;  // Target not found
    }
}
