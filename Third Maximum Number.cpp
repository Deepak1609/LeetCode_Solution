class Solution {
public:
    int thirdMax(vector<int>& nums) {
//         nums.erase(unique(nums.begin(),nums.end()),nums.end());
//         sort(nums.begin(),nums.end(),greater<int>());
//         if(nums.size() == 1)
//         {
//             return nums[0];
//         }
//         else if(nums.size()==2)
//         {
//             return nums[1];
//         }
//         else{ 
//             return nums[2];
//         }
        
        sort(nums.begin(),nums.end());
		// SORT THE ELEMENTS
        auto it = unique(nums.begin(),nums.end()); 
		// RETURN THE ENDING ITERATOR OF THE VECTOR  AFTER REMOVING THE DUPLICATE ELEMENTS
        nums.resize(distance(nums.begin(),it));
		// RESIZE THE VECTOR REMOVING THE DUPLICATE ELEMETS
        int s= nums.size();
		
        if(s==2 || s==1)
           return nums[s-1];
        else
           return nums[s-3];
        
        return -1;
        
    }
};
