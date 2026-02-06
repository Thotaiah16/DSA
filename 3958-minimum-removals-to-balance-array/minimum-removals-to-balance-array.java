class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        if(n == 1) return 0;

        int removeNo = 0;
        int maxLen = 0;
        int min = 0;
        for(int max = 0; max < n; max++){
           

            while((long)nums[max] > (long)nums[min] * k) {
                min++;
            }
            maxLen = Math.max(maxLen, max - min + 1);
        }

        return n - maxLen;
    }
}