class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char ch1[]=s.toCharArray();
        char ch2[]=t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }
}
/* class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int freq[]=new int[26]
        for(char ch:s.toCharArray){
        freq[ch-'a']++;
        }
        for(char ch:t.toCharArray){
        freq[ch-'a']--;

        }
        for(int num:freq){
        if(num>0)
        return false;
        }
        return true;
        }
        }

 */