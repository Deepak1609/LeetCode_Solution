class Solution {
public:
    void combinationSum3Util(int k, int n, int start, vector<vector<int>> &ans, vector<int> &values)
    {
        // Base Cases
        if (k < 0 || n < 0)
        {
            return;
            // if at any point our n (leftover sum ) becomes less than 0 , that means we were not able to reach n (probably reached beyond it )
            // so simply return back (backtrack )
        }
        if ((k == 0) && (n == 0))
        {
            ans.push_back(values);
            // if somehow k comes down to 0 and also n==0 (that means we have k numbers and 0 leftover sum )
            // all those values at this points are our answer
            return;
        }

        for (int i = start; i <= 9; i++)
        {
            values.push_back(i);
            // just take the start value  , this start keeps on changing as after , picking something we can just pick all no ahead of it
            combinationSum3Util(k - 1, n - i, i + 1, ans, values);
            // most important recuurence relation
            // suppose we chose particular 'i' , , our k reudce by 1 ,a s we have made it part of values array, sum reduce by i , as now we need n-i (leftover sum required )
            //  our start in next round will start from 1 more number
            values.pop_back();
            // after the whole recursion is , we pop it back to test for some other ones
        }
    }
    vector<vector<int>> combinationSum3(int k, int n)
    {
        vector<vector<int>> ans;
        // a 2-D vector to store the ans
        vector<int> values;
        // an array to store all the value that adds to the n
        combinationSum3Util(k, n, 1, ans, values);
        // call the fn
        return ans;
        // return whatever is stored in the ans
    }
};
