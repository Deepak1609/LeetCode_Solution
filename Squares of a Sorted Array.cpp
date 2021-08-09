class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
      for(auto &val:nums)
            val=val*val;
        sort(nums.begin(),nums.end());
        return nums;  
        
    }
};
