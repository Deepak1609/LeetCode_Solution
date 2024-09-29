class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int n = nums.size();
        // double max = numeric_limits<double>::lowest();
        // for (int i = 0; i < n; i++) {
        //     double sum = 0;
        //     int count = 0;

        //     for (int j = i; j < i + k && j < n; j++) {
        //         sum += nums[j];
        //         count++;
        //     }

        //     if (count == k) {
        //         double avg = sum / k;
        //         max = std::max(avg, max);
        //     }
        // }

        // return max;

        double sum=0;
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        double ans=sum;
        for(int i=k;i<n;i++)
        {
            sum=sum-nums[i-k]+nums[i];
            ans=max(ans,sum);
        }
        return ans/k;

    }
};