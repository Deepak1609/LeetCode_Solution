class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        
        // int n = nums.size();
        // vector <int> tp(n+1 , 0);
        // for(auto x: nums)
        // {
        //     tp[x]++;
        //     if(tp[x]>1)
        //     {
        //         return x;
        //     }
        // }
        // return -1;
        
        if (nums.size() > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
};