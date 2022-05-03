class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
    int n=nums.size();
    int left=-1, right=-1;     // store left & right index of unordered list
    int mini=INT_MAX, maxi=INT_MIN;  // stores max & min in nums
    for(int i=0;i<n;i++){
        maxi=max(maxi,nums[i]);
        if(maxi>nums[i])
            right=i;
    }

    for(int i=n-1;i>=0;i--){
        mini=min(mini,nums[i]);
        if(mini<nums[i])
            left=i;
    }
    
    if(left==right)    return 0;   // sorted
    return right-left+1;        
    }
};
