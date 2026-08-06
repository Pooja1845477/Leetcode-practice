class Solution {

    int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();
        parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        // Build connected components
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            map.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        char[] ans = s.toCharArray();

        for (List<Integer> indices : map.values()) {

            List<Character> chars = new ArrayList<>();

            for (int idx : indices)
                chars.add(s.charAt(idx));

            Collections.sort(indices);
            Collections.sort(chars);

            for (int i = 0; i < indices.size(); i++) {
                ans[indices.get(i)] = chars.get(i);
            }
        }

        return new String(ans);
    }

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py)
            parent[py] = px;
    }
}