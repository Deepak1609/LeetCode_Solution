class Solution {

    static class Node {
        int len;

        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int max;

        Node() {}

        Node(char c) {
            len = 1;
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            max = 1;
        }
    }

    private Node[] tree;
    private char[] s;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        this.s = s.toCharArray();

        int n = s.length();
        int k = queryIndices.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            this.s[index] = ch;

            update(1, 0, n - 1, index, ch);

            answer[i] = tree[1].max;
        }

        return answer;
    }

    private void build(int node, int left, int right) {

        if (left == right) {
            tree[node] = new Node(s[left]);
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(
            int node,
            int left,
            int right,
            int index,
            char ch) {

        if (left == right) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node left, Node right) {

        Node result = new Node();

        result.len = left.len + right.len;

        result.leftChar = left.leftChar;
        result.rightChar = right.rightChar;

        // Prefix
        result.prefix = left.prefix;

        if (left.prefix == left.len &&
                left.rightChar == right.leftChar) {

            result.prefix = left.len + right.prefix;
        }

        // Suffix
        result.suffix = right.suffix;

        if (right.suffix == right.len &&
                left.rightChar == right.leftChar) {

            result.suffix = right.len + left.suffix;
        }

        // Maximum
        result.max = Math.max(left.max, right.max);

        if (left.rightChar == right.leftChar) {
            result.max = Math.max(
                    result.max,
                    left.suffix + right.prefix
            );
        }

        return result;
    }
}