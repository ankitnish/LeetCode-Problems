class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int MOD = 1_000_000_007; 
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;

        for (int i = 1; i < n; i++) {
            power[i] = (int) ((2L * power[i - 1]) % MOD);
        }

        int l = 0;
        int r = n - 1;
        long result = 0;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                result = (result + power[r - l]) % MOD;
                l++;
            } else {
                r--;
            }
        }
        return (int)result;
    }
}