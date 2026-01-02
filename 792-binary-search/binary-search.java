class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
     }
     private int searchHelper(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target ) {
            return searchHelper(arr, target, s, mid - 1);
        }
        return searchHelper(arr, target, mid + 1, e);
     }

}