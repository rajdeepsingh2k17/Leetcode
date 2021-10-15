Solution 1: brute force 
class Solution {
    public ArrayList<Integer>ans;
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ans=new ArrayList<>();
        int n=nums1.length, m=nums2.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums2[j]==nums1[i]){
                    Util(nums2,j);
                }
            }
        }
        int[] v=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            v[i]=ans.get(i);
        }
        return v;
    }
        
//     util function is created to find the next greater element   
    public void Util(int[] v, int i){
        int temp=v[i];
        for(int j=i;j<v.length;j++){
            if(v[j]>temp){
                ans.add(v[j]);
                return ;
            }
        }
        ans.add(-1);
        return ;
    }
}
The above solution can be optimised using a HashMap to keep track of elements of the nums2, of we can get positon of nums1 ele in nums2 in O(1) time;

Solution 2: Brute force optimised using a hashmap 
class Solution {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        HashMap<Integer, Integer>mp=new HashMap<>();
        for(int i=0;i<m;i++){
            mp.put(nums2[i],i);
        }
        int [] ans=new int[n];
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=mp.get(nums1[i])+1;j<m;j++){
                if(nums2[j]>nums1[i]){
                    ans[i]=nums2[j];
                    flag=true;
                    break;
                }
            }
            if(flag==false)ans[i]=-1;
        }
        return ans;
    }
}
