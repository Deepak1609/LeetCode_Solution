import java.util.*;

class Solution {

    int[][] stMax;
    int[][] stMin;
    int[] log;

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        build(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) ->
                        Long.compare(b.val, a.val));

        // best interval for each l
        for(int l = 0; l < n; l++) {

            long value = query(l, n - 1);

            pq.offer(new Node(value, l, n - 1));
        }

        long ans = 0;

        while(k-- > 0) {

            Node cur = pq.poll();

            ans += cur.val;

            int l = cur.l;
            int r = cur.r;

            // next candidate
            if(r - 1 >= l) {

                long next = query(l, r - 1);

                pq.offer(new Node(next, l, r - 1));
            }
        }

        return ans;
    }

    private void build(int[] nums) {

        int n = nums.length;

        log = new int[n + 1];

        for(int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        stMax = new int[n][K];
        stMin = new int[n][K];

        for(int i = 0; i < n; i++) {

            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }

        for(int j = 1; j < K; j++) {

            for(int i = 0; i + (1 << j) <= n; i++) {

                stMax[i][j] = Math.max(
                        stMax[i][j - 1],
                        stMax[i + (1 << (j - 1))][j - 1]
                );

                stMin[i][j] = Math.min(
                        stMin[i][j - 1],
                        stMin[i + (1 << (j - 1))][j - 1]
                );
            }
        }
    }

    private long query(int l, int r) {

        int len = r - l + 1;

        int j = log[len];

        int mx = Math.max(
                stMax[l][j],
                stMax[r - (1 << j) + 1][j]
        );

        int mn = Math.min(
                stMin[l][j],
                stMin[r - (1 << j) + 1][j]
        );

        return (long)mx - mn;
    }

    static class Node {

        long val;
        int l;
        int r;

        Node(long val, int l, int r) {

            this.val = val;
            this.l = l;
            this.r = r;
        }
    }
}