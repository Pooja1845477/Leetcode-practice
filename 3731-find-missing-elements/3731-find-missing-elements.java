class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            int curr=nums[i-1]+1;
            
            while(curr<nums[i]){
                ans.add(curr);
                curr++;
            }
        }
        return ans;
    }
}