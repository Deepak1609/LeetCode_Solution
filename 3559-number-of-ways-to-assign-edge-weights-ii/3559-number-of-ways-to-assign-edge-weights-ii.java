import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;
    static final int LOG = 17 + 1;

    List<Integer>[] graph;
    int[][] parent;
    int[] depth;
    long[] pow2;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges) {

            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        parent = new int[LOG][n + 1];
        depth = new int[n + 1];

        dfs(1, 0);

        // binary lifting
        for(int k = 1; k < LOG; k++) {

            for(int v = 1; v <= n; v++) {

                parent[k][v] =
                        parent[k - 1][ parent[k - 1][v] ];
            }
        }

        // powers of 2
        pow2 = new long[n + 1];

        pow2[0] = 1;

        for(int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lca(u, v);

            int dist =
                    depth[u] + depth[v] - 2 * depth[lca];

            if(dist == 0) {
                ans[i] = 0;
            }
            else {
                ans[i] = (int)pow2[dist - 1];
            }
        }

        return ans;
    }

    private void dfs(int node, int par) {

        parent[0][node] = par;

        for(int nei : graph[node]) {

            if(nei == par) continue;

            depth[nei] = depth[node] + 1;

            dfs(nei, node);
        }
    }

    private int lca(int u, int v) {

        if(depth[u] < depth[v]) {

            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for(int k = 0; k < LOG; k++) {

            if(((diff >> k) & 1) == 1) {
                u = parent[k][u];
            }
        }

        if(u == v) return u;

        for(int k = LOG - 1; k >= 0; k--) {

            if(parent[k][u] != parent[k][v]) {

                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];
    }
}