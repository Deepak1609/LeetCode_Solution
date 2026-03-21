class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       int n = nums.length;
       HashSet<Integer> set = new HashSet<>();
       for(int i = 0; i < n; i++) {

        // if element present in current set then return true
        if(set.contains(nums[i])){
            return true;
        }

        // if set is empty or element is not present then add element into the set

        set.add(nums[i]);

        // if always update the window and main size k

        if(set.size() > k) {
            set.remove(nums[i - k]);
        }
       }
        return false;        
    }
}