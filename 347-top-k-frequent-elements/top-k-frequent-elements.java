class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();


        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+ 1);
        }

        int[][] result = new int[freq.size()][2];

        int i = 0;

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }
        
        Arrays.sort(result, (a, b) -> Integer.compare(b[1], a[1]));

         int[] ans = new int[k];

        for (i = 0; i < k; i++) {
            ans[i] = result[i][0];
        }

        return ans;
    }
}