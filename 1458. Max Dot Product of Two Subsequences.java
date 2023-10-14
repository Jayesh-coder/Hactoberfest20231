class Solution {
    int[][] memo;
    private int min(int[] arr){
        int min = arr[0];
        for(int i=0; i<arr.length; i++) { 
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
    private int max(int[] arr){
        int max = arr[0];
        for(int i=0; i<arr.length; i++) { 
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    private int LCS(int i,int j,int n,int m,int[] nums1, int[] nums2){
        if(i == n || j == m) return 0;
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        memo[i][j] = Math.max(LCS(i+1,j+1,n,m,nums1,nums2) + nums1[i] * nums2[j],Math.max(LCS(i+1,j,n,m,nums1,nums2),LCS(i,j+1,n,m,nums1,nums2)));
        return memo[i][j];
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][nums2.length];
        int res = LCS(0,0,nums1.length,nums2.length,nums1,nums2);
        
        if(res > 0)
           return res;
        
        return Math.max(min(nums1)*max(nums2),max(nums1)*min(nums2));

    }
}
