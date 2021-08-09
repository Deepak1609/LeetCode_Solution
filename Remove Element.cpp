class Solution {
public:
    int removeElement(vector<int>& nums, int val) {

        // int j = nums.size()-1, i = 0;
        // while (i <= j) {
        //     if (nums[j] != val) {
        //         int temp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = temp;
        //         i++;
        //     }
        //     else j--;
        // }
        // return i;
        
        // nums.erase(remove(nums.begin(), nums.end(), val), nums.end());
        // return nums.size();
        
        int n=nums.size();
        int count =0;
        for(int i=0;i<n;i++){
            if(nums[i]!=val){
                count++;
            }
        }
        remove(nums.begin(),nums.end(),val);
        return count;
    }
};
