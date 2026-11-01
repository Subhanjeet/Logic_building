class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Create frequency map
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 2. Min Heap based on frequency
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // 3. Process elements
        for (int key : countMap.keySet()) {

            int freq = countMap.get(key);
            minHeap.offer(new int[]{freq, key});

            // Keep heap size = k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 4. Extract result
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[1];
        }

        return result;
    }
}