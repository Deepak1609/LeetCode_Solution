class Solution {
public:
    void sortColors(vector<int>& nums) {
//         int n = nums.size();
//         int low = 0, high = n-1, mid = 0;
//         while(mid<=high)
//         {
//             if(nums[mid]==0)
//                 swap(nums[mid++], nums[low++]);
//             else if(nums[mid]==1)
//                 mid++;
//             else
//                 swap(nums[mid],nums[high--]);
//         }
        int lo = 0; 
        int hi = nums.size() - 1; 
        int mid = 0; 

        while (mid <= hi) { 
            switch (nums[mid]) { 

            // If the element is 0 
            case 0: 
                swap(nums[lo++], nums[mid++]); 
                break; 

            // If the element is 1 . 
            case 1: 
                mid++; 
                break; 

            // If the element is 2 
            case 2: 
                swap(nums[mid], nums[hi--]); 
                break; 
            }
        }
        
    }
};