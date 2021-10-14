class Solution {
    
    // O(N**2) solution
    public boolean canAttendMeetings(int[][] v) {
        int n=v.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(overlap(v[i],v[j]))return false;
            }    
        }
        return true;
    }
    
  
//   overlapping condition 1: 
//     public boolean overlap(int []a, int []b){
//         return (a[0]<=b[0] && a[1]>b[0])||(a[0]>=b[0] && a[0]<b[1]);
//     } 
  
  
//   better overlapping condition:   the min of endpoins is greater than the max of start point.
    public boolean overlap(int []a, int []b){
        return (Math.min(a[1], b[1]) >
            Math.max(a[0], b[0]));
    } 
}




// other solution of by sorting the whole array based on start point, and check whether any meeting starts before the end of last meeting.
  
  Arrays.sort(v,(int []a,int[] b)->Integer.compare(a[0],b[0]));
         for (int i = 0; i < v.length - 1; i++) {
            if (v[i][1] > v[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
    
