class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        // int n = nums.size() - 1;
        // for(int i =0; i<n;)
        // {
        //     if(nums[i]%2 !=  0)
        //     {
        //         swap(nums[i],nums[n]);
        //         n--;
        //     }
        //     else{
        //         i++;
        //     }
        // }
        // return nums;
        
        int i = 0;
        int j = nums.size()-1;
        while(i!=j){
            int temp;
            if(nums[i]%2==1 && nums[j]%2==0){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            else if(nums[i]%2==0){
                i++;
            }
            else if(nums[j]%2==1){
                j--;
            }
        }
        return nums;
    }
};
