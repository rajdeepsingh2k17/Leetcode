// method 1
class Solution {
    public void dfs(int[] v, List<Integer> ds, Set<Integer> vis, List<List<Integer>> ans){
        if(ds.size()==v.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<v.length;i++){
            if(!vis.contains(v[i]))
            {
                ds.add(v[i]);
                vis.add(v[i]);
                dfs(v,ds,vis,ans);
                vis.remove(v[i]);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        Set<Integer> vis=new HashSet<>();
        dfs(nums,ds,vis,ans);
        return ans;
    }
}
