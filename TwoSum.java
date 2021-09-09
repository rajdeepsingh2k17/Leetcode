class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> set=new HashMap<Integer,Integer>();
        int [] res=new int[2];
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            int t=target-nums[i];
            if(set.containsKey(t)){
                res[0]=i;
                res[1]=set.get(t);
            }
            set.put(nums[i],i);
        }
        return res;
    }
}
