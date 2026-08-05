class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] freq = new int[26];

            // Count frequency of each character
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Build a unique key from the frequency array
            StringBuilder key = new StringBuilder();

            for (int count : freq) {
                key.append(count).append("#");
            }

            String k = key.toString();

            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }

            map.get(k).add(str);
        }

        return new ArrayList<>(map.values());
    }
}