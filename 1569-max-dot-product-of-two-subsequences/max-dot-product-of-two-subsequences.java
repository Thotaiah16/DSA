class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        //with very small values
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int product = nums1[i - 1] * nums2[j - 1];

                // Take current pair alone OR extend previous subsequence
                int take = Math.max(product,
                        dp[i - 1][j - 1] == Integer.MIN_VALUE
                                ? product
                                : dp[i - 1][j - 1] + product);

                // Skip one element
                int skip = Math.max(dp[i - 1][j], dp[i][j - 1]);

                dp[i][j] = Math.max(take, skip);
            }
        }

        return dp[n][m];
    }
}
