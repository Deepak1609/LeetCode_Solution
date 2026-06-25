// class Solution {
//     public int countMajoritySubarrays(int[] nums, int target) {
        
//     }
// }

class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;

            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }

            return sum;
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        int offset = n + 2;
        Fenwick bit = new Fenwick(2 * n + 10);

        long ans = 0;

        int prefix = 0;

        bit.update(offset, 1);

        for (int num : nums) {

            if (num == target)
                prefix++;
            else
                prefix--;

            ans += bit.query(prefix + offset - 1);

            bit.update(prefix + offset, 1);
        }

        return (int)ans;
    }
}