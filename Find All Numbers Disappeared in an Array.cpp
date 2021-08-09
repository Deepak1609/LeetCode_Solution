class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
//         for(int i=0;i<nums.size();i++)
//         {
//             int ele=abs(nums[i]);
//             if(nums[ele-1]>0)
//             {
//                 nums[ele-1]=-nums[ele-1];
//             }
//         }
//         vector<int> ans;
//         for(int i=0;i<nums.size();i++)
//         {
//             if(nums[i]>0)
//             {
//                 ans.push_back(i+1);
//             }
//         }
        
//         return ans;
        
         int n;
        vector<int>ans;
        int c = -1;
        
        for(int i=0; i<nums.size(); i++)
        {
            n = nums[i];
            
            if(nums[i] < 0)
                n = nums[i]*-1;
            
            if(nums[n-1] > 0)
                nums[n-1] = nums[n-1]*-1;
        }
        
        for(int i=0;i<nums.size();i++){
            if(nums[i]>0){
                ans.push_back(i+1);
            }
        }
        return ans;
        
    }
};
