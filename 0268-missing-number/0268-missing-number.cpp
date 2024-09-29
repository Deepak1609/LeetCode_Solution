class Solution {
public:
    int missingNumber(vector<int>& nums) {

        // int n = nums.size();
        // int temp = n * (n+1)/2;
        // for(int i = 0; i < n; i++) {
		//     temp -= nums[i];
	    //  }
	    //  return temp;   

        int n = nums.size();
        int temp = n * (n+1)/2;
        for(int i =0; i<n; i++)
        {
            temp -= nums[i];
        }
        return temp;
        
        
    }
};