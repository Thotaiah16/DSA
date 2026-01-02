class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (count.containsKey(num)) {
                return num;
            }
            count.put(num, 1);
        }
        return -1;
    }
}