class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//       method 1: O(n) time complexity and O(n) space complexity
//       =====================================================
//         int[] res=new int[m+n];
//         int i=0,j=0;
//         while(i<m&& j<n){
//             if(nums1[i]<=nums2[j]){
//                 res[i+j]=nums1[i++];
//             }
//             else{
//                 res[i+j]=nums2[j++];
//             }
//         }
//         while(i<m){
//             res[i+j]=nums1[i++];
//         }
//         while(j<n){
//             res[i+j]=nums2[j++];
//         }
        
//         for( i=0;i<n+m;i++){
//             nums1[i]=res[i];
//         }
//       ==========================================
//       method2: time complexity O(n), space O(1)
//       ============================================
      int end1=m-1,end2=n-1,f=n+m-1;
        while(end1>=0&&end2>=0){
            nums1[f--]=nums1[end1]>nums2[end2]?nums1[end1--]:nums2[end2--];
        }
        while(end2>=0){
            nums1[f--]=nums2[end2--];
        }
    }
}
